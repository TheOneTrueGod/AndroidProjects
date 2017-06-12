package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.StrikeAnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 7/24/15.
 */
public class WalkAnimation extends UnitAnimation {
    private Position mWalkOffset;

    private WalkAnimation() {}

    private WalkAnimation(Position position) {
        super();
        mWalkOffset = position;
        mAnimTime = 400;
    }

    public static WalkAnimation getWalkAnimation(Position position) {
        return new WalkAnimation(position);
    }

    public SpriteState getSpriteState(float currTime) {
        return new SpriteState(CharacterAnimation.WALK, (currTime / mAnimTime));
    }

    protected void doAnimationBehaviour(float timePct, Unit unit) {
        unit.setAnimationOffset(mWalkOffset.multiplyScalar(1 - timePct));
    }
}
