package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters.ActionTargetter;
import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Actions.UnitAction;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.NoAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.R;

import java.util.ArrayList;

/**
 * Created by jprevoe on 7/27/15.
 */
public abstract class UnitActionAttack extends UnitAction {
    protected static final int ANIMATION_TIME = 400;
    protected Position mTarget;
    protected ActionTargetter mActionTargetter;
    protected boolean mMoveDuringAttack;

    public UnitActionAttack() {
        mMoveDuringAttack = true;
    }

    public void pickTarget(Unit unit) {
        super.pickTarget(unit);
        mTarget = null;

        if (mTurnsBeforeUse > 0) {
            return;
        }

        ArrayList<Position> targets = mActionTargetter.getTargetPositions(unit);
        for (Position target : targets) {
            if (unit.getAttackHandler().canUnitAttackSquare(
                    this, target.x, target.y)) {
                mTarget = Position.create(target.x, target.y);
                break;
            }
        }
    }

    @Override
    public float getPriority() {
        if (mTarget != null) {
            return UnitAction.HIGH_PRIORITY;
        }
        return UnitAction.NO_PRIORITY;
    }

    @Override
    public UnitAnimation getAnimation(Unit unit) {
        UnitAnimation anim = getAimAnimation();
        if (mTurnsSpentActing == mWindupTurns - 1) {
            anim = BasicAttackAnimation.getBasicAttackAnimation(
                mTarget,
                unit.getPosition(),
                ANIMATION_TIME,
                mMoveDuringAttack
            );
            anim.addAnimationListener(
                BasicAttackAnimation.ATTACK_CONNECTED,
                new UnitActionListener(this, unit)
            );
        }
        return anim;
    }

    protected UnitAnimation getAimAnimation() {
        return AimAnimation.getAimAttackAnimation(CharacterAnimation.MELEE_AIM);
    }

    @Override
    public void animationCallback(int timeType, Unit unit) {
        super.animationCallback(timeType, unit);
        unit.getAttackHandler().attackSquare(mTarget, Unit.UnitTeam.PLAYER);
    }

    public void doAction(Unit unit) {
        super.doAction(unit);
    }

    @Override
    public void drawOnCanvas(Canvas canvas, Context context, Unit unit) {
        if (mTurnsSpentActing < mWindupTurns) {
            Paint paint = new Paint();

            GridDrawer.TargetSeverity severity = GridDrawer.TargetSeverity.DANGER;
            if (mWindupTurns - mTurnsSpentActing >= 4) {
                severity = GridDrawer.TargetSeverity.CAUTION;
            } else if (mWindupTurns - mTurnsSpentActing >= 3) {
                severity = GridDrawer.TargetSeverity.WARNING;
            }

            GridDrawer.drawTarget(canvas,
                    mTarget.x, mTarget.y,
                    paint,
                    BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y,
                    severity);
        }
    }
}
