package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks;

import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Position;

/**
 * Created by jprevoe on 12/26/15.
 */
public class RangedAttackAnimation extends BasicAttackAnimation {
    private RangedAttackAnimation(Position target, int duration, boolean motion) {
        super(target, duration, motion);
    }

}
