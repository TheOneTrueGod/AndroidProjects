package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Position;

/**
 * Created by jprevoe on 2/15/16.
 */
public class DoubleAttackAnimation extends UnitAnimation {
    public static final int ATTACK_STARTED = 0;
    public static final int ATTACK_CONNECTED = 1;
    public static final int ATTACK_CONNECTED_2 = 2;
    public static final int ATTACK_FINISHED = 3;

    public static final Double CONNECTED_TIME = 0.25;
    public static final Double CONNECTED_TIME_2 = 0.75;

    private Position mTarget;

    protected DoubleAttackAnimation(Position target, int duration) {
        super();
        mTarget = target;
        mAnimTime = duration;
        mAnimationComponents.add(new StrikeAnimationComponent(0.25, mTarget));
        mAnimationComponents.add(new RetreatAnimationComponent(0.5, mTarget));
        mAnimationComponents.add(new StrikeAnimationComponent(0.75, mTarget));
        mAnimationComponents.add(new RetreatAnimationComponent(1, mTarget));

        mAnimationCallbackTimes.add(new AnimationCallbackTime(0, ATTACK_STARTED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(CONNECTED_TIME, ATTACK_CONNECTED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(CONNECTED_TIME_2, ATTACK_CONNECTED_2));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(1, ATTACK_FINISHED));
    }

    public static DoubleAttackAnimation getAnimation(Position target, Position playerPosition, int duration) {
        return new DoubleAttackAnimation(
                target.capDistanceAt(0.8, playerPosition.x, playerPosition.y),
                duration);
    }
}
