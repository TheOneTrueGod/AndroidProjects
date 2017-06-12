package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.TurnAnimation;

/**
 * Created by jprevoe on 2/13/16.
 */
public class DeathAnimation extends UnitAnimation {
    private final long ANIMATION_TIME = 400;
    private final long NUM_FLASHES = 3;

    public static final Double MOVEMENT_FINISHED_TIME = 0.5;

    private DeathAnimation(Position unitPosition) {
        super();
        mStartTime = (long)TurnAnimation.getCurrAnimationTime();
        mAnimTime = mStartTime + (long)(ANIMATION_TIME * (Math.random() * 0.1 + 0.9));

        Position moveTarget = unitPosition.addPosition(0, (float)-0.3);
        mAnimationComponents.add(new StrikeAnimationComponent(MOVEMENT_FINISHED_TIME, moveTarget));
    }

    public SpriteState getSpriteState(float currTime) {
        currTime = currTime - mStartTime;
        float endTime = mAnimTime - mStartTime;
        double movement_finished_at = endTime * MOVEMENT_FINISHED_TIME;

        if ((currTime) < movement_finished_at) {
            return new SpriteState(CharacterAnimation.DYING, (float)(currTime / movement_finished_at));
        }

        if ((int)((currTime - movement_finished_at) / (endTime - movement_finished_at) * (NUM_FLASHES * 2)) % 2 == 1) {
            return new SpriteState(CharacterAnimation.DEAD, 1);
        } else {
            return new SpriteState(CharacterAnimation.INVISIBLE, 1);
        }
    }

    public SpriteState getBetweenTurnSpriteState() {
        return new SpriteState(CharacterAnimation.INVISIBLE, 1);
    }

    public static UnitAnimation getDeathAnimation(Position unitPosition) {
        return new DeathAnimation(unitPosition);
    }
}
