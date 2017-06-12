package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters.BasicActionTargetter;
import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters.LineTargetter;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/2/15.
 */
public class UnitActionRangedAttack extends UnitActionAttack {
    public static final int PROJECTILE_TIME_PER_SQUARE = 100;
    private final ProjectileTypes mProjectileType;
    private int mDamage;

    public static enum ProjectileTypes {
        SHURIKEN, ARROW
    }

    public UnitActionRangedAttack() {
        this(2, 1, ProjectileTypes.SHURIKEN);
    }

    public UnitActionRangedAttack(int windupTurns, int damage, ProjectileTypes projectileType) {
        super();
        mDamage = damage;
        mWindupTurns = windupTurns;
        mActionTargetter = new LineTargetter(4);
        mProjectileType = projectileType;
        mMoveDuringAttack = false;
    }

    protected ProjectileAnimations.ProjectileAnimation getProjectileAnimation() {
        switch (mProjectileType) {
            case ARROW:
                return new ProjectileAnimations.ArrowAnimation(true);
            case SHURIKEN:
            default:
                return new ProjectileAnimations.ShurikenWithSlash();
        }
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        Projectile projectile = Projectile.create(unit.getPosition(),
            mTarget,
            this.getProjectileAnimation(),
            PROJECTILE_TIME_PER_SQUARE * Math.max(
                Math.abs(mTarget.y - unit.getPositionY()),
                Math.abs(mTarget.x - unit.getPositionX())
            )
        );
        projectile.addListener(new Callable() {
            @Override
            public Object call() throws Exception {
            unit.getAttackHandler().attackSquare(mTarget, Unit.UnitTeam.PLAYER, mDamage);
            return null;
            }
        });

        unit.getAttackHandler().addProjectile(projectile);
    }
}
