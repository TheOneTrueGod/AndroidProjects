package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks;

import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;

/**
 * Created by jprevoe on 12/24/15.
 */
public class AimAnimation extends UnitAnimation {
    private final CharacterAnimation mAnimation;

    public AimAnimation(CharacterAnimation animation) {
        mAnimation = animation;
    }

    public SpriteState getBetweenTurnSpriteState() {
        return new SpriteState(mAnimation, 0);
    }

    public static AimAnimation getAimAttackAnimation(CharacterAnimation animation) {
        return new AimAnimation(animation);
    }
}
