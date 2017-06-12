package com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionBasicAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionSmartMove;
import com.android.jprevoe.wizarddefense.Actor.Animation.DeathAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.KnightKnockdownAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitSpriteCreator;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 11/14/15.
 */
public class KnightUnit extends UnitStats {
    private static final float HAT_FALLING_OFF_DURATION = 600;

    @Override
    public void initialize(Unit unit) {
        super.initialize(unit);
        unit.addAction(new UnitActionSmartMove(1));
        unit.addAction(new UnitActionBasicAttack());

        mAnimations.put(CharacterAnimation.IDLE, new String[]{"character_armored_1"});
        mAnimations.put(CharacterAnimation.MELEE_ATTACK, new String[]{
            "character_armored_5", "character_armored_6",
        });
        mAnimations.put(CharacterAnimation.MELEE_RETREAT, new String[]{
            "character_armored_6", "character_armored_7"
        });
        mAnimations.put(CharacterAnimation.MELEE_AIM, new String[]{"character_armored_4"});
        mAnimations.put(CharacterAnimation.WALK, new String[]{
            "character_armored_2", "character_armored_1", "character_armored_3", "character_armored_1",
            "character_armored_2", "character_armored_1", "character_armored_3",
        });
        mAnimations.put(CharacterAnimation.DYING, new String[]{
            "character_melee_9", "character_melee_10"
        });
        mAnimations.put(CharacterAnimation.DEAD, new String[]{
            "character_melee_10"
        });
    }

    @Override
    public void onDeathTrigger() {
        UnitStats stats = new MeleeUnit();
        mUnit.setUnitStats(stats);
        mUnit.playAnimation(KnightKnockdownAnimation.getKnightKnockdownAnimation(mUnit.getAnimationPosition()));

        Projectile projectile = Projectile.create(mUnit.getAnimationPosition(),
                mUnit.getAnimationPosition(),
                new ProjectileAnimations.HatFallingOffAnimation(),
                HAT_FALLING_OFF_DURATION);

        mUnit.getAttackHandler().addProjectile(projectile);
    }

    @Override
    protected float GetStatHealth() {
        return 1;
    }

    @Override
    public float getImageScale() {
        return (float)(40.0 / 32.0);
    }
}
