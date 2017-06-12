package com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionRangedAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionSmartMove;
import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitSpriteCreator;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;

/**
 * Created by jprevoe on 11/15/15.
 */
public class ArcherUnit extends UnitStats {
    @Override
    public void initialize(Unit unit) {
        super.initialize(unit);
        unit.addAction(new UnitActionSmartMove(1));
        unit.addAction(new UnitActionRangedAttack(3, 2, UnitActionRangedAttack.ProjectileTypes.ARROW));

        mAnimations.put(CharacterAnimation.WALK, new String[]{
            "character_archer_2", "character_archer_1", "character_archer_3", "character_archer_1",
            "character_archer_2", "character_archer_1", "character_archer_3",
        });

        mAnimations.put(CharacterAnimation.IDLE, new String[]{"character_archer_1"});

        mAnimations.put(CharacterAnimation.MELEE_AIM, new String[]{"character_archer_4"});
        mAnimations.put(CharacterAnimation.MELEE_ATTACK, new String[]{"character_archer_5"});
        mAnimations.put(CharacterAnimation.MELEE_RETREAT, new String[]{"character_archer_6"});

        mAnimations.put(CharacterAnimation.DYING, new String[]{
                "character_archer_1", "character_archer_7", "character_archer_8"
        });
        mAnimations.put(CharacterAnimation.DEAD, new String[]{
                "character_archer_8"
        });
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
