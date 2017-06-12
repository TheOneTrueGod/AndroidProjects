package com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats;

import android.support.v4.util.SimpleArrayMap;
import android.util.ArrayMap;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionBasicAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionRangedAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionSmartMove;
import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitSpriteCreator;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jprevoe on 11/14/15.
 */
public class MeleeUnit extends UnitStats {
    @Override
    public void initialize(Unit unit) {
        super.initialize(unit);
        unit.addAction(new UnitActionSmartMove(1));
        unit.addAction(new UnitActionBasicAttack());

        mAnimations.put(CharacterAnimation.MELEE_ATTACK, new String[]{
            "character_melee_5"
        });
        mAnimations.put(CharacterAnimation.MELEE_RETREAT, new String[]{
            "character_melee_6"
        });
        mAnimations.put(CharacterAnimation.MELEE_AIM, new String[]{"character_melee_4"});
        mAnimations.put(CharacterAnimation.WALK, new String[]{
            "character_melee_2", "character_melee_1", "character_melee_3", "character_melee_1",
            "character_melee_2", "character_melee_1", "character_melee_3",
        });
        mAnimations.put(CharacterAnimation.IDLE, new String[]{"character_melee_1"});
        mAnimations.put(CharacterAnimation.DYING, new String[]{
                "character_melee_9", "character_melee_10"
        });
        mAnimations.put(CharacterAnimation.DEAD, new String[]{
                "character_melee_10"
        });

        mAnimations.put(CharacterAnimation.KNOCKDOWN, new String[]{
                "character_melee_9", "character_melee_10"
        });

        mAnimations.put(CharacterAnimation.LYING_DOWN, new String[]{
                "character_melee_11"
        });

        mAnimations.put(CharacterAnimation.STANDUP, new String[]{
                "character_melee_12", "character_melee_13"
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
