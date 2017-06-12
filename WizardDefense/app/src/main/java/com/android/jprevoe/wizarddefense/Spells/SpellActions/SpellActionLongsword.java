package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting.SquareTargetable;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/7/15.
 */
public class SpellActionLongsword extends SpellAction {
    public static final int ANIMATION_TIME = 100;
    public static final int PROJECTILE_TIME = 300;

    public SpellActionLongsword(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
        mTargettableSquares = new SquareTargetable(-1, -1, 3, 1);
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
        Projectile projectile = Projectile.create(mTarget,
                mTarget, new ProjectileAnimations.SlashAnimation(false),
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
        return (int) (ANIMATION_TIME + (PROJECTILE_TIME
                - ANIMATION_TIME * BasicAttackAnimation.CONNECTED_TIME));
    }
}