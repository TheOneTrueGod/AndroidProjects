package com.android.jprevoe.wizarddefense.Actor.Actions.Movement;

import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 10/31/15.
 */
public class TargetSquare {
    private final Unit mUnit;
    private final float mTargetX;
    private final float mTargetY;

    public static TargetSquare getTargetSquare(Unit unit, float targetX, float targetY) {
        return new TargetSquare(unit, targetX, targetY);
    }

    private TargetSquare(Unit unit, float targetX, float targetY) {
        mUnit = unit;
        mTargetX = targetX;
        mTargetY = targetY;
    }



    public void free() {

    }
}
