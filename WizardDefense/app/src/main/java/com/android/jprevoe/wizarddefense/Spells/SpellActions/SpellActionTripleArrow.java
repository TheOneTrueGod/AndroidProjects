package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.SquareTargetable;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 11/10/15.
 */
public class SpellActionTripleArrow extends SpellActionShuriken {
    public SpellActionTripleArrow(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -6, 3, 4);
        mDamage = 2;
    }

    protected ProjectileAnimations.ProjectileAnimation getProjectileAnimation() {
        return new ProjectileAnimations.ArrowAnimation(false);
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);

        for (int x : new int[]{-1, 0, 1}) {
            Position target = mTarget.addPosition(x, Math.abs(x));
            Projectile projectile = Projectile.create(unit.getAnimationPosition(),
                    target, getProjectileAnimation(),
                    PROJECTILE_TIME_PER_SQUARE * Math.abs(target.y - unit.getPositionY()));
            projectile.addListener(getProjectileAttackCallback(unit, target));

            unit.getAttackHandler().addProjectile(projectile);
        }
    }

    @Override
    protected Callable getProjectileAttackCallback(final Unit unit, final Position target) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                unit.getAttackHandler().attackSquare(target, Unit.UnitTeam.ENEMIES, 1);
                return null;
            }
        };
    }

}
