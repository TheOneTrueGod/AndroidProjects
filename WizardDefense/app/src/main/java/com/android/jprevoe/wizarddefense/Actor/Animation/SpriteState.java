package com.android.jprevoe.wizarddefense.Actor.Animation;

import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;

/**
 * Created by jprevoe on 12/12/15.
 */
public class SpriteState {
    private CharacterAnimation mAnimation;
    private final float mPctDone;

    public SpriteState(CharacterAnimation animation, float pctDone) {
        mAnimation = animation;
        mPctDone = pctDone;
    }

    public float getPctDone() {
        return mPctDone;
    }

    public CharacterAnimation getAnimation() {
        return mAnimation;
    }

    public void setAnimation(CharacterAnimation animation) {
        mAnimation = animation;
    }
}
