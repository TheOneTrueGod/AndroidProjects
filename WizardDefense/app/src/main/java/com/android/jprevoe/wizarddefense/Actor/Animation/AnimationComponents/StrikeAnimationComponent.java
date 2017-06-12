package com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 11/7/15.
 */
public class StrikeAnimationComponent extends AnimationComponent {
    protected final Position mTarget;

    public StrikeAnimationComponent(double endTimePct, Position target) {
        super(endTimePct);
        mTarget = target;
    }

    @Override
    public void doAnimationBehaviour(float timePct, Unit unit) {
        Position target = Position.create(
                (mTarget.x - unit.getPositionX()) * timePct,
                (mTarget.y - unit.getPositionY()) * timePct);
        unit.setAnimationOffset(target);
    }
}
