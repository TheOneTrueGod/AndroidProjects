package com.android.jprevoe.wizarddefense.Actor.Animation;

import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 8/2/15.
 */
public class FirestormAttackAnimation extends UnitAnimation {
    public static final int ATTACK_STARTED = 0;
    public static final int ATTACK_CONNECTED = 1;
    public static final int ATTACK_FINISHED = 2;

    public static final Double CONNECTED_TIME = 0.0;
    private final int mNumHits;
    private int mHitsDone = 0;
    private int mActionFired;
    private Position mTarget;

    private FirestormAttackAnimation(Position target, int duration, int numHits) {
        super();
        mTarget = target;
        mAnimTime = duration;
        mActionFired = -1;
        mNumHits = numHits;
        mHitsDone = 0;

        float timePerHit = 1 / (float)numHits;
        mAnimationCallbackTimes.add(new AnimationCallbackTime(0, ATTACK_STARTED));
        for (int i = 1; i <= numHits; i++) {
            mAnimationComponents.add(new StrikeAnimationComponent(timePerHit * i - timePerHit / 2, mTarget));
            mAnimationComponents.add(new RetreatAnimationComponent(timePerHit * i, mTarget));
            mAnimationCallbackTimes.add(new AnimationCallbackTime(timePerHit * i - timePerHit / 2, ATTACK_CONNECTED));
        }
        mAnimationCallbackTimes.add(new AnimationCallbackTime(1, ATTACK_FINISHED));
    }

    public static FirestormAttackAnimation getFirestormAttackAnimation(
            Position target,
            Position playerPosition,
            int duration,
            int numHits
    ) {
        return new FirestormAttackAnimation(target.capDistanceAt(1, playerPosition.x, playerPosition.y), duration, numHits);
    }

}
