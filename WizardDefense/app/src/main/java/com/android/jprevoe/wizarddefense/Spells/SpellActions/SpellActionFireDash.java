package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.FireDashAttackAnimation;
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
public class SpellActionFireDash extends PlayerAction {
    public static final int ANIMATION_TIME = 800;
    public static final int PROJECTILE_TIME = 200;

    public SpellActionFireDash(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -4, 3, 4).canOnlyTargetWalkable();
    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        FireDashAttackAnimation anim =
                FireDashAttackAnimation.getFiredashAttackAnimation(
                        mTarget,
                        player.getPosition(),
                        ANIMATION_TIME);

        UnitActionListener actionListener = new UnitActionListener(this, player);
        anim.addAnimationListener(FireDashAttackAnimation.DASH_FINISHED, actionListener);
        anim.addAnimationListener(FireDashAttackAnimation.EXPLOSION_START, actionListener);
        return anim;
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);
        unit.setAnimationOffset(Position.create(0, 0));
        if (timeType == FireDashAttackAnimation.DASH_FINISHED) {
            float oldX = unit.getPositionX();
            float oldY = unit.getPositionY();
            unit.teleportTo(mTarget.x, mTarget.y);
            for (float y = oldY; y > mTarget.y; y--) {
                this.createExplosion(unit, Position.create(oldX, y));
            }
        } else if (timeType == FireDashAttackAnimation.EXPLOSION_START) {
            this.createExplosion(unit, mTarget.addPosition( 1, 0 ));
            this.createExplosion(unit, mTarget.addPosition( 1, -1));
            this.createExplosion(unit, mTarget.addPosition( 0, -1));
            this.createExplosion(unit, mTarget.addPosition(-1, -1));
            this.createExplosion(unit, mTarget.addPosition(-1, 0 ));
        }
    }

    protected void createExplosion(final Unit unit, final Position target) {
        Projectile projectile = Projectile.create(
                target, target,
                new ProjectileAnimations.ExplosionAnimation(),
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
        return (int) (ANIMATION_TIME +
                    PROJECTILE_TIME -
                    (ANIMATION_TIME - ANIMATION_TIME * FireDashAttackAnimation.EXPLOSION_START_TIME));
    }
}
