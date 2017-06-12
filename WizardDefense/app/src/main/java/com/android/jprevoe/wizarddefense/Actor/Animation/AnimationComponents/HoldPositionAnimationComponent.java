package com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 2/15/16.
 */
public class HoldPositionAnimationComponent extends AnimationComponent {
    protected final Position mTarget;

    public HoldPositionAnimationComponent(double endTimePct, Position target) {
        super(endTimePct);
        mTarget = target;
    }

    @Override
    public void doAnimationBehaviour(float timePct, Unit unit) {
        Position target = Position.create(
                (mTarget.x - unit.getPositionX()),
                (mTarget.y - unit.getPositionY()));
        unit.setAnimationOffset(target);
    }
}
