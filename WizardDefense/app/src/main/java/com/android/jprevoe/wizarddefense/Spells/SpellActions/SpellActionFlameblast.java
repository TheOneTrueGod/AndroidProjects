package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.ModifiablePosition;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.SquareTargetable;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/23/15.
 */
public class SpellActionFlameblast extends com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction {
    public static final int ANIMATION_TIME = 100;
    public static final int PROJECTILE_TIME = 500;

    public SpellActionFlameblast(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -2, 3, 2);
    }

    @Override
    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        return true;
    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        BasicAttackAnimation anim =
                BasicAttackAnimation.getBasicAttackAnimation(
                        mTarget.addPosition(0, -1),
                        player.getPosition(), ANIMATION_TIME,
                        true);
        anim.addAnimationListener(BasicAttackAnimation.ATTACK_CONNECTED,
                new UnitActionListener(this, player));
        return anim;
    }

    @Override
    public void setTarget(Player player, Position target) {
        mTarget = player.getPosition();
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);
        mTargettableSquares.reset();
        Random rand = new Random();
        while (mTargettableSquares.hasNext()) {
            ModifiablePosition target = mTargettableSquares.getNext();
            final Position targetPos = target.addPosition(unit.getPositionX(), unit.getPositionY()).getPosition();
            double r = rand.nextDouble() * 0.5 + 0.5;
            Projectile projectile = Projectile.create(
                    unit.getAnimationPosition(), targetPos,
                    new ProjectileAnimations.FireballWithExplosion(),
                    (int) (PROJECTILE_TIME * (r)));
            projectile.addListener(new Callable() {
                @Override
                public Object call() throws Exception {
                    unit.getAttackHandler().attackSquare(targetPos, Unit.UnitTeam.ENEMIES, 2);
                    return null;
                }
            });
            unit.getAttackHandler().addProjectile(projectile);
        }
    }

    @Override
    public long getAnimationTime(Player player) {
        return (int) (ANIMATION_TIME + PROJECTILE_TIME);
    }
}
