package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.FirestormAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.SquareTargetable;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/23/15.
 */
public class SpellActionFirestorm extends PlayerAction {
    public static final int ANIMATION_TIME = 800;
    public static final int PROJECTILE_TIME = 600;

    public SpellActionFirestorm(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -4, 3, 3);
    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        FirestormAttackAnimation anim =
                FirestormAttackAnimation.getFirestormAttackAnimation(
                        mTarget,
                        player.getPosition(),
                        ANIMATION_TIME, 8);
        anim.addAnimationListener(FirestormAttackAnimation.ATTACK_CONNECTED,
                new UnitActionListener(this, player));
        return anim;
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);

        int r = (int)(Math.random() * 5) - 2;
        final Position target = mTarget.addPosition(r % 2, r / 2);
        Projectile projectile = Projectile.create(
                unit.getAnimationPosition(), target,
                new ProjectileAnimations.FireballWithExplosion(),
                PROJECTILE_TIME);
        projectile.addListener(new Callable() {
            @Override
            public Object call() throws Exception {
                unit.getAttackHandler().attackSquare(target, Unit.UnitTeam.ENEMIES);
                return null;
            }
        });
        unit.getAttackHandler().addProjectile(projectile);
    }

    @Override
    public long getAnimationTime(Player player) {
        return (int) (ANIMATION_TIME + PROJECTILE_TIME);
    }
}
