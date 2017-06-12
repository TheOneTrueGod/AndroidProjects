package com.android.jprevoe.wizarddefense.Actor;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.SpawnAction;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionDying;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionMove;
import com.android.jprevoe.wizarddefense.Actor.Actions.UnitAction;
import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitAttackHandler;
import com.android.jprevoe.wizarddefense.Actor.Animation.DeathAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.KnightKnockdownAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.NoAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.UnitEffects.UnitEffect;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jprevoe on 7/22/15.
 */
public class Unit {
    public enum UnitTeam {
        PLAYER(1),
        ALLIES(2),
        ENEMIES(4);
        private int mValue;
        UnitTeam(int value) {
            mValue = value;
        }

        public int getValue() {
            return mValue;
        }
    }

    private Position mPosition;
    protected UnitAnimation mCurrAnimation;
    private Position mAnimationOffset;
    private UnitMoveHandler mUnitMoveHandler;
    private List<UnitAction> mUnitActions;
    protected UnitStats mUnitStats;
    private UnitAttackHandler mAttackHandler;
    private UnitAction mCurrAction;
    private SpriteState mSpriteState;
    protected boolean mPlayingAnimationOutOfTurn;

    public Unit(Position position,
                UnitMoveHandler unitMoveHandler,
                UnitAttackHandler unitAttackHandler,
                UnitStats unitStats) {
        mPosition = position;
        mUnitMoveHandler = unitMoveHandler;
        mAttackHandler = unitAttackHandler;
        mCurrAnimation = null;
        mAnimationOffset = Position.create(0, 0);
        mUnitStats = unitStats;
        mUnitActions = new ArrayList<UnitAction>();
        mPlayingAnimationOutOfTurn = false;
    }

    public void addAction(UnitAction action) {
        mUnitActions.add(action);
    }

    public void drawOnCanvas(Canvas canvas, Context context, TurnHandler.TURN_TYPE currentTurnType) {
        if (mSpriteState != null && mSpriteState.getAnimation() == CharacterAnimation.INVISIBLE) {
            return;
        }
        mUnitStats.drawOnCanvas(canvas, context, mSpriteState);
        if (shouldDrawTargetter(currentTurnType)) {
            mCurrAction.drawOnCanvas(canvas, context, this);
        }
        mUnitStats.drawHealthOnCanvas(canvas, context);
        mUnitStats.drawManaOnCanvas(canvas, context);
    }

    private boolean shouldDrawTargetter(TurnHandler.TURN_TYPE currentTurnType) {
        if (mCurrAction == null) { return false; }
        if (mCurrAction.ActionComplete()) { return false; }
        if (mCurrAction.UsingThisTurn()) { return false; }
        return true;
    }

    public void doTurnActions() {
        UnitAction action = pickTurnAction();
        mCurrAction = action;
        if (action == null) {
            mCurrAnimation = NoAnimation.getNoAnimation();
        } else {
            action.doAction(this);
            mCurrAnimation = action.getAnimation(this);
        }
    }

    public void turnEnding(TurnHandler.TURN_TYPE currentTurnType) {
        mPlayingAnimationOutOfTurn = false;
        if (getTurnType() == currentTurnType) {
            for (UnitAction updateAction : mUnitActions) {
                updateAction.endTurn();
            }
        }
    }

    public void turnStarting(TurnHandler.TURN_TYPE currentTurnType) {
        mPlayingAnimationOutOfTurn = false;
        if (getTurnType() == currentTurnType) {
            for (UnitAction updateAction : mUnitActions) {
                updateAction.startTurn();
            }
        }
    }

    public void move(float deltaX, float deltaY) {
        mPosition = mPosition.addPosition(deltaX, deltaY);
        BattleGrid.GetBattleGrid().getGridSquare(mPosition.x, mPosition.y).unitEntering(this);
    }

    public void teleportTo(float targetX, float targetY) {
        BattleGrid.GetBattleGrid().removeObjectFromGrid(this, this.getPosition());
        BattleGrid.GetBattleGrid().addObjectToGrid(this, Position.create(targetX, targetY));
        BattleGrid.GetBattleGrid().getGridSquare(this.getPositionX(), this.getPositionY()).unitLeaving(this);
        BattleGrid.GetBattleGrid().getGridSquare(targetX, targetY).unitEntering(this);

        mPosition = mPosition.addPosition(targetX - mPosition.x, targetY - mPosition.y);
    }

    public void slow(int slowAmount) {
        for (UnitAction action : mUnitActions) {
            if (action instanceof UnitActionMove) {
                ((UnitActionMove)action).slow(slowAmount);
            }
        }
    }

    private UnitAction pickTurnAction() {
        if (mCurrAction != null && !mCurrAction.ActionComplete()) {
            return mCurrAction;
        }
        float hiPri = 0;
        UnitAction selectedAction = null;
        for (UnitAction action : mUnitActions) {
            action.pickTarget(this);
            float actionPriority = action.getPriority();
            if (actionPriority > hiPri && action.canBeUsed()) {
                hiPri = actionPriority;
                selectedAction = action;
            }
        }
        return selectedAction;
    }

    public long getAnimationTime() {
        if (mCurrAction == null) {
            return 0;
        }
        return mCurrAction.getAnimationTime(this);
    }

    public void animate(float currTime) {
        if (mCurrAnimation != null) {
            mCurrAnimation.animate(currTime, this);
            if (currTime >= mCurrAnimation.getAnimationTime()) {
                mSpriteState = mCurrAnimation.getBetweenTurnSpriteState();
            } else {
                mSpriteState = mCurrAnimation.getSpriteState(currTime);
            }
        } else {
            mSpriteState = NoAnimation.getNoAnimation().getSpriteState(currTime);
        }
    }

    public long getTimeLeftInTurnAnimation(long currTime, TurnHandler.TURN_TYPE turnType) {
        if (mCurrAnimation == null) {
            return 0;
        }
        if (turnType != this.getTurnType() &&
            !(mPlayingAnimationOutOfTurn)) {
            return 0;
        }
        return mCurrAnimation.getAnimationTime() - currTime;
    }

    public void addEffect(UnitEffect effect) {
        effect.doEffect(this);
    }

    public void doSpawnAction() {
        mCurrAction = SpawnAction.GetSpawnAction();
        this.doTurnActions();
    }

    public boolean isDead() {
        return mUnitStats.getHealth() <= 0;
    }

    public void setAnimationOffset(Position animationOffset) {
        mAnimationOffset = animationOffset;
    }

    public Position getPosition() {
        return Position.create(mPosition.x, mPosition.y);
    }
    public Position getAnimationPosition() {
        return Position.create(mPosition.x + mAnimationOffset.x, mPosition.y + mAnimationOffset.y);
    }

    public float getPositionX() {
        return mPosition.x;
    }

    public float getPositionY() {
        return mPosition.y;
    }

    public UnitMoveHandler getMoveHandler() {
        return mUnitMoveHandler;
    }

    public Position getAnimationOffset() {
        return mAnimationOffset;
    }

    public UnitAttackHandler getAttackHandler() {
        return mAttackHandler;
    }

    public float getHealth() {
        return mUnitStats.getHealth();
    }

    public float getMaxHealth() {
        return mUnitStats.getMaxHealth();
    }

    public TurnHandler.TURN_TYPE getTurnType() {
        return TurnHandler.TURN_TYPE.ENEMY;
    }

    public UnitTeam getUnitTeam() {
        return UnitTeam.ENEMIES;
    }

    public boolean isOnTeam(int hitBitmap) {
        return (getUnitTeam().getValue() & hitBitmap) != 0;
    }

    public void damage(float amount) {
        if (isDamageImmune()) {
            return;
        }
        mUnitStats.damage(amount);
        if (isDead()) {
            this.onDeathTrigger();
            if (isDead()) {
                this.playAnimation(DeathAnimation.getDeathAnimation(getAnimationPosition()));
            }
        }
    }

    private boolean isDamageImmune() {
        return isDead() || mCurrAnimation instanceof KnightKnockdownAnimation;
    }

    protected void onDeathTrigger() {
        this.getUnitStats().onDeathTrigger();
    }

    public UnitStats getUnitStats() {
        return mUnitStats;
    }

    public void setUnitStats(UnitStats unitStats) {
        if (mUnitStats != null) {
            mCurrAction = null;
            mUnitActions.clear();
        }
        mUnitStats = unitStats;
        unitStats.initialize(this);
    }

    public void addMana(ManaAmount manaAmount) {
        mUnitStats.addMana(manaAmount);
    }

    public UnitAnimation getCurrAnimation() {
        return mCurrAnimation;
    }

    public void playAnimation(UnitAnimation animation) {
        mCurrAnimation = animation;
        mPlayingAnimationOutOfTurn = true;
    }

    public boolean isPlayingAnimationOutOfTurn()     {
        return mPlayingAnimationOutOfTurn;
    }
}
