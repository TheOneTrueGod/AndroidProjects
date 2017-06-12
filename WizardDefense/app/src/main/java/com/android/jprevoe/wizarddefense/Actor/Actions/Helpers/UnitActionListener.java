package com.android.jprevoe.wizarddefense.Actor.Actions.Helpers;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListenable;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 8/2/15.
 */
public class UnitActionListener {
    private final UnitActionListenable mAction;
    private final Unit mUnit;

    public UnitActionListener(UnitActionListenable action, Unit unit) {
        mAction = action;
        mUnit = unit;
    }

    public void doCallback(int timeType) {
        mAction.animationCallback(timeType, mUnit);
    }
}
