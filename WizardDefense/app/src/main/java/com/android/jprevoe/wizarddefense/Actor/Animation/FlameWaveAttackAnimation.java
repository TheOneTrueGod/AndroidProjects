package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Position;

/**
 * Created by jprevoe on 8/2/15.
 */
public class FlameWaveAttackAnimation extends UnitAnimation {
    public static final int ATTACK_STARTED = 0;
    public static final int ATTACK_CONNECTED = 1;
    public static final int ATTACK_FINISHED = 2;

    public static final Double CONNECTED_TIME = 0.5;
    private int mActionFired;
    private Position mTarget;

    private FlameWaveAttackAnimation(Position target, int duration) {
        super();
        mTarget = target;
        mAnimTime = duration;
        mActionFired = -1;

        mAnimationComponents.add(new StrikeAnimationComponent(0.75, mTarget));
        mAnimationComponents.add(new RetreatAnimationComponent(1, mTarget));

        mAnimationCallbackTimes.add(new AnimationCallbackTime(0, ATTACK_STARTED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(CONNECTED_TIME, ATTACK_CONNECTED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(1, ATTACK_FINISHED));
    }

    public static FlameWaveAttackAnimation getFlameWaveAttackAnimation(Position playerPosition, int duration) {
        return new FlameWaveAttackAnimation(
                playerPosition.addPosition(0, -1),
                duration);
    }
}
