package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.DoubleAttackAnimation;
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
 * Created by jprevoe on 2/15/16.
 */
public class SpellActionDoubleStrike extends PlayerAction {
    public static final int ANIMATION_TIME = 400;
    public static final int PROJECTILE_TIME = 300;

    public SpellActionDoubleStrike(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(0, -1, 1, 1);
    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        DoubleAttackAnimation anim =
                DoubleAttackAnimation.getAnimation(
                        mTarget,
                        player.getPosition(),
                        ANIMATION_TIME);
        anim.addAnimationListener(DoubleAttackAnimation.ATTACK_CONNECTED,
                new UnitActionListener(this, player));
        anim.addAnimationListener(DoubleAttackAnimation.ATTACK_CONNECTED_2,
                new UnitActionListener(this, player));
        return anim;
    }

    @Override
    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        return true;
    }

    @Override
    public void setTarget(Player player, Position target) {
        mTarget = player.getPosition().addPosition(0, -1);
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        ProjectileAnimations.ProjectileAnimation projectileAnimation =
            new ProjectileAnimations.SlashAnimation(timeType == DoubleAttackAnimation.ATTACK_CONNECTED_2);

        super.animationCallback(timeType, unit);
        Projectile projectile = Projectile.create(mTarget,
                mTarget, projectileAnimation,
                PROJECTILE_TIME);
        projectile.addListener(new Callable() {
            @Override
            public Object call() throws Exception {
                unit.getAttackHandler().attackSquare(mTarget, Unit.UnitTeam.ENEMIES);
                return null;
            }
        });

        unit.getAttackHandler().addProjectile(projectile);
    }

    @Override
    public long getAnimationTime(Player player) {
        return ANIMATION_TIME;
    }
}
