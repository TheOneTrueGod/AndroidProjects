package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.HoldPositionAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.TurnAnimation;

/**
 * Created by jprevoe on 2/13/16.
 */
public class KnightKnockdownAnimation extends UnitAnimation {
    private final long ANIMATION_TIME = 1000;

    public static final Double FALLING_DOWN_END = 0.25;
    public static final Double LYING_DOWN_END = 0.75;
    public static final Double STAND_UP_END = 1.0;

    private KnightKnockdownAnimation(Position unitPosition) {
        super();
        mStartTime = (long)TurnAnimation.getCurrAnimationTime();
        mAnimTime = mStartTime + ANIMATION_TIME;

        Position moveTarget = unitPosition.addPosition(0, (float)-0.3);

        mAnimationComponents.add(new StrikeAnimationComponent(FALLING_DOWN_END, moveTarget));
        mAnimationComponents.add(new HoldPositionAnimationComponent(LYING_DOWN_END, moveTarget));
        mAnimationComponents.add(new RetreatAnimationComponent(STAND_UP_END, moveTarget));
    }

    public SpriteState getSpriteState(float currTime) {
        currTime = currTime - mStartTime;
        float endTime = mAnimTime - mStartTime;

        double fall_time = endTime * FALLING_DOWN_END;

        if (currTime < fall_time) {
            return new SpriteState(CharacterAnimation.KNOCKDOWN, (float)(currTime / fall_time));
        }

        currTime -= fall_time;
        double lie_time = endTime * LYING_DOWN_END - fall_time;
        if (currTime < lie_time) {
            return new SpriteState(CharacterAnimation.LYING_DOWN, (float)(currTime / lie_time));
        }

        currTime -= lie_time;
        double getup_time = endTime * STAND_UP_END - fall_time - lie_time;
        if (currTime < getup_time) {
            return new SpriteState(CharacterAnimation.STANDUP, (float)(currTime / getup_time));
        }

        return new SpriteState(CharacterAnimation.IDLE, 1);
    }

    public SpriteState getBetweenTurnSpriteState() {
        return new SpriteState(CharacterAnimation.IDLE, 1);
    }

    public static UnitAnimation getKnightKnockdownAnimation(Position unitPosition) {
        return new KnightKnockdownAnimation(unitPosition);
    }
}
