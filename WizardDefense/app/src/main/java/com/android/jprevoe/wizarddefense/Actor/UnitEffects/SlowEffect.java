package com.android.jprevoe.wizarddefense.Actor.UnitEffects;

import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 9/1/15.
 */
public class SlowEffect extends UnitEffect {
    private int mSlowAmount;

    public SlowEffect(int slowAmount) {
        super();
        mSlowAmount = slowAmount;
    }

    @Override
    public void doEffect(Unit unit) {
        unit.slow(mSlowAmount);
    }
}
