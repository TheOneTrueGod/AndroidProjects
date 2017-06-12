package com.android.jprevoe.wizarddefense.Actor.Animation;

import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.RetreatAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 8/2/15.
 */
public class BasicAttackAnimation extends UnitAnimation {
    public static final int ATTACK_STARTED = 0;
    public static final int ATTACK_CONNECTED = 1;
    public static final int ATTACK_DAMAGE_TRIGGER = 2;
    public static final int ATTACK_FINISHED = 3;

    public static final Double CONNECTED_TIME = 0.5;
    private Position mTarget;

    protected BasicAttackAnimation(Position target, int duration, boolean motion) {
        super();
        mTarget = target;
        mAnimTime = duration;
        if (motion) {
            mAnimationComponents.add(new StrikeAnimationComponent(0.5, mTarget));
            mAnimationComponents.add(new RetreatAnimationComponent(1, mTarget));
        }

        mAnimationCallbackTimes.add(new AnimationCallbackTime(0, ATTACK_STARTED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(CONNECTED_TIME, ATTACK_CONNECTED));
        mAnimationCallbackTimes.add(new AnimationCallbackTime(1, ATTACK_FINISHED));
    }

    public SpriteState getSpriteState(float currTime) {
        float animPct = (currTime / mAnimTime);
        if (animPct < CONNECTED_TIME) {
            return new SpriteState(CharacterAnimation.MELEE_ATTACK, (float) (animPct / CONNECTED_TIME));
        } else {
            return new SpriteState(CharacterAnimation.MELEE_RETREAT, (float) ((animPct - CONNECTED_TIME) / (1 - CONNECTED_TIME)));
        }
    }

    public static BasicAttackAnimation getBasicAttackAnimation(Position target, Position playerPosition, int duration, boolean motion) {
        return new BasicAttackAnimation(
                target.capDistanceAt(0.8, playerPosition.x, playerPosition.y),
                duration, motion);
    }
}
