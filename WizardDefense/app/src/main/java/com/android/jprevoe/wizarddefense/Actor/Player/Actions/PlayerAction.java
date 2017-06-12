package com.android.jprevoe.wizarddefense.Actor.Player.Actions;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListenable;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.ModifiablePosition;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.TargettableSquares;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.ArrayList;

/**
 * Created by jprevoe on 8/1/15.
 */
public abstract class PlayerAction implements UnitActionListenable {
    protected boolean mDone = false;
    protected int mDuration = 1;
    protected int mTurnsSpentUsing = 0;
    protected Position mTarget;
    protected TargettableSquares mTargettableSquares;
    protected boolean mCostPaid = false;
    private SpellDefiner.SpellDef mSpellDef;

    public void advanceTurn() {
        mTurnsSpentUsing += 1;
    }

    public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {
        if (mTargettableSquares == null) {
            return;
        }

        mTargettableSquares.reset();
        while (mTargettableSquares.hasNext()) {
            ModifiablePosition target = mTargettableSquares.getNext();
            if (mTargettableSquares.isValidTarget(player, (int)target.x, (int)target.y)) {
                GridDrawer.drawTargettingReticule(drawingCanvas, context,
                        player.getPositionX() + target.x, player.getPositionY() + target.y
                );
            }
        }
    }

    protected enum Direction {UP, DOWN, LEFT, RIGHT, NONE};

    public PlayerAction(SpellDefiner.SpellDef spellDef) {
        mSpellDef = spellDef;
        if (spellDef != null) {
            mDuration = spellDef.getCastTime() + 1;
        } else {
            mDuration = 1;
        }

    }

    public void doAction(Player player) {}
    public final UnitAnimation getAnimation(Player player) {
        if (mTurnsSpentUsing < mDuration - 1) {
            return null;
        }
        return this.getChildAnimation(player);
    }

    protected abstract UnitAnimation getChildAnimation(Player player);

    public boolean IsDone() {
        return mTurnsSpentUsing >= mDuration;
    }

    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        if (mTargettableSquares == null) {
            return false;
        }
        int deltaX = (int)(eventCoord.x - player.getPositionX());
        int deltaY = (int)(eventCoord.y - player.getPositionY());
        return mTargettableSquares.isValidTarget(player, deltaX, deltaY);
    }

    public void setTarget(Player player, Position target) {
        mTarget = target;
    }

    public void payCost(Player player) {
        if (mCostPaid) {
            return;
        }
        mCostPaid = true;
        if (mSpellDef != null) {
            player.getUnitStats().payCost(mSpellDef.getSpellCosts());
        }
    }

    public void restart() {
        mTurnsSpentUsing = 0;
        mCostPaid = false;
    }

    @Override
    public void animationCallback(int timeType, Unit unit) {}

    public abstract long getAnimationTime(Player player);
}
