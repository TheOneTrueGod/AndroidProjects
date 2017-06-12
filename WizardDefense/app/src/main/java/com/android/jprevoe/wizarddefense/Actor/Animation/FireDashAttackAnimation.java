package com.android.jprevoe.wizarddefense.Actor.Animation;

import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 8/2/15.
 */
public class FireDashAttackAnimation extends UnitAnimation {
    public static final int ATTACK_STARTED = 0;
    public static final int DASH_FINISHED = 1;
    public static final int EXPLOSION_START = 2;
    public static final int ATTACK_FINISHED = 3;

    public static final Double EXPLOSION_START_TIME = 0.8;
    private int mHitsDone = 0;
    private int mActionFired;
    private Position mTarget;

    private FireDashAttackAnimation(Position target, Position playerPosition, int duration) {
        super();
        mTarget = target;
        mAnimTime = duration;
        mActionFired = -1;
        mHitsDone = 0;

        Position retreatTarget = mTarget.capDistanceAt(-1, playerPosition.x, playerPosition.y);
        Position finalTarget = mTarget;

        mAnimationCallbackTimes.add(new AnimationCallbackTime(0, ATTACK_STARTED));
        mAnimationComponents.add(new StrikeAnimationComponent(0.5, retreatTarget));
        mAnimationComponents.add(new RetreatAnimationComponent(0.52, retreatTarget));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(0.6, DASH_FINISHED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(EXPLOSION_START_TIME, EXPLOSION_START));

        mAnimationCallbackTimes.add(new AnimationCallbackTime(1, ATTACK_FINISHED));
    }

    public static FireDashAttackAnimation getFiredashAttackAnimation(
            Position target,
            Position playerPosition,
            int duration
    ) {
        return new FireDashAttackAnimation(target, playerPosition, duration);
    }

}
