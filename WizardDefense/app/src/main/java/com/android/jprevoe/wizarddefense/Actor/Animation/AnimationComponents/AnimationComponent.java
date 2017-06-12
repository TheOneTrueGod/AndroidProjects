package com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 11/7/15.
 */
public class AnimationComponent {
    protected double mEndTimePct;

    public AnimationComponent(double endTimePct) {
        this.mEndTimePct = endTimePct;
    }

    public double getEndTimePct() {
        return mEndTimePct;
    }

    public void doAnimationBehaviour(float timePct, Unit unit) {

    }
}
