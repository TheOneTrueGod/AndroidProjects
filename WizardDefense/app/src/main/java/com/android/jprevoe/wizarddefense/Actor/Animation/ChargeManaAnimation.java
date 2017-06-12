package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Position;

/**
 * Created by jprevoe on 8/2/15.
 */
public class ChargeManaAnimation extends UnitAnimation {
    public static final int ATTACK_STARTED = 0;
    public static final int MOVEMENT_FINISHED = 1;
    public static final int EXPLOSION_START = 2;
    public static final int ATTACK_FINISHED = 3;

    public static final Double MOVEMENT_FINISHED_TIME = 0.8;
    private int mHitsDone = 0;
    private int mActionFired;
    private Position mTarget;

    private ChargeManaAnimation(Position target, Position playerPosition, long duration) {
        super();
        mTarget = target;
        mAnimTime = duration;
        mActionFired = -1;
        mHitsDone = 0;

        Position moveTarget = mTarget.addPosition(0, -1);

        mAnimationCallbackTimes.add(new AnimationCallbackTime(0, ATTACK_STARTED));

        mAnimationComponents.add(new StrikeAnimationComponent(MOVEMENT_FINISHED_TIME * 0.75, moveTarget));
        mAnimationComponents.add(new RetreatAnimationComponent(MOVEMENT_FINISHED_TIME, moveTarget));

        mAnimationCallbackTimes.add(new AnimationCallbackTime(MOVEMENT_FINISHED_TIME, MOVEMENT_FINISHED));

        mAnimationCallbackTimes.add(new AnimationCallbackTime(1, ATTACK_FINISHED));
    }

    public static ChargeManaAnimation getChargeManaAnimation(
            Position playerPosition,
            long duration
    ) {
        return new ChargeManaAnimation(playerPosition, playerPosition, duration);
    }

}
