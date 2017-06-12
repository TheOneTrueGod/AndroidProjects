package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters.BasicActionTargetter;

/**
 * Created by jprevoe on 8/2/15.
 */
public class UnitActionBasicAttack extends UnitActionAttack {
    public UnitActionBasicAttack() {
        super();
        mWindupTurns = 2;
        mActionTargetter = new BasicActionTargetter(1);
    }
}
