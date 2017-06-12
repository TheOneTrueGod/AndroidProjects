package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.SquareTargetable;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/7/15.
 */
public class SpellActionShuriken extends SpellAction {
    public static final int ANIMATION_TIME = 100;
    public static final int PROJECTILE_TIME_PER_SQUARE = 100;
    protected int mDamage = 1;

    public SpellActionShuriken(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -4, 3, 4);
    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        BasicAttackAnimation anim =
                BasicAttackAnimation.getBasicAttackAnimation(
                        mTarget,
                        player.getPosition(),
                        ANIMATION_TIME,
                        true);
        anim.addAnimationListener(BasicAttackAnimation.ATTACK_CONNECTED,
                new UnitActionListener(this, player));
        return anim;
    }


    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);

        Projectile projectile = Projectile.create(unit.getAnimationPosition(),
                        mTarget, getProjectileAnimation(),
                PROJECTILE_TIME_PER_SQUARE * Math.abs(mTarget.y - unit.getPositionY()));
        projectile.addListener(getProjectileAttackCallback(unit, mTarget));

        unit.getAttackHandler().addProjectile(projectile);
    }

    protected Callable getProjectileAttackCallback(final Unit unit, final Position target) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                unit.getAttackHandler().attackSquare(target, Unit.UnitTeam.ENEMIES, mDamage);
                return null;
            }
        };
    }

    protected ProjectileAnimations.ProjectileAnimation getProjectileAnimation() {
        return new ProjectileAnimations.ShurikenWithSlash();
    }

    @Override
    public long getAnimationTime(Player player) {
        return  (int) (ANIMATION_TIME);
    }
}
