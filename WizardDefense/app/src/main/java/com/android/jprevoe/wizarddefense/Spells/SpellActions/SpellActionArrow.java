package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.SquareTargetable;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 11/10/15.
 */
public class SpellActionArrow extends SpellActionShuriken {
    public SpellActionArrow(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -6, 3, 4);
        mDamage = 2;
    }

    protected ProjectileAnimations.ProjectileAnimation getProjectileAnimation() {
        return new ProjectileAnimations.ArrowAnimation(false);
    }
}
