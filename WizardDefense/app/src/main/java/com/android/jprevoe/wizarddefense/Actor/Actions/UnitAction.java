package com.android.jprevoe.wizarddefense.Actor.Actions;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListenable;
import com.android.jprevoe.wizarddefense.Actor.Animation.NoAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;

/**
 * Created by jprevoe on 7/27/15.
 */
public class UnitAction implements UnitActionListenable {
    public static float MAX_PRIORITY = 99999999;
    public static float VERY_HIGH_PRIORITY = 10000;
    public static float HIGH_PRIORITY = 1000;
    public static float LOW_PRIORITY = 10;
    public static float NO_PRIORITY = -1;
    protected int mTurnsBeforeUse = 0;
    protected int mWindupTurns = 1;
    protected int mTurnsSpentActing = 999999;

    public int getCooldownTurns() {
        return 0;
    }

    public void pickTarget(Unit unit) {

    }

    public float getPriority() {
        return NO_PRIORITY;
    }

    public void doAction(Unit unit) {
        mTurnsBeforeUse = getCooldownTurns() + Math.max(mWindupTurns - 1, 0);
        if (mTurnsSpentActing >= mWindupTurns) {
            mTurnsSpentActing = 0;
        }
    }

    public UnitAnimation getAnimation(Unit unit) {
        return NoAnimation.getNoAnimation();
    }

    public void endTurn() {

    }

    public void startTurn() {
        if (mTurnsBeforeUse > 0) {
            mTurnsBeforeUse -= 1;
        }
        if (mTurnsSpentActing < mWindupTurns) {
            mTurnsSpentActing += 1;
        }
    }

    public boolean canBeUsed() {
        return mTurnsBeforeUse <= 0;
    }

    public void animationCallback(int timeType, Unit unit) {

    }

    public boolean ActionComplete() {
        return mTurnsSpentActing >= mWindupTurns;
    }

    public boolean UsingThisTurn() {
        return mTurnsSpentActing >= mWindupTurns - 1;
    }

    public void drawOnCanvas(Canvas canvas, Context context, Unit unit) {
    }

    public long getAnimationTime(Unit unit) {
        return (int) this.getAnimation(unit).getAnimationTime();
    }

    public boolean canHitUnit(Object gridObject) {
        if (gridObject instanceof Player) {
            return true;
        }
        return false;
    }
}
