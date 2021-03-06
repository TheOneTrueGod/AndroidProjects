package com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 11/7/15.
 */
public class RetreatAnimationComponent extends AnimationComponent {
    protected final Position mTarget;

    public RetreatAnimationComponent(double endTimePct, Position target) {
        super(endTimePct);
        mTarget = target;
    }

    @Override
    public void doAnimationBehaviour(float timePct, Unit unit) {
        Position target = Position.create(
                (mTarget.x - unit.getPositionX()) * (1 - timePct),
                (mTarget.y - unit.getPositionY()) * (1 - timePct));
        unit.setAnimationOffset(target);
    }
}
