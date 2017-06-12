package com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionBasicAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionRangedAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionSmartMove;
import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitSpriteCreator;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 7/27/15.
 */
public class RangedUnit extends UnitStats {
    @Override
    public void initialize(Unit unit) {
        super.initialize(unit);
        unit.addAction(new UnitActionSmartMove(1));
        unit.addAction(new UnitActionRangedAttack());
        unit.addAction(new UnitActionBasicAttack());
    }


    @Override
    protected String getCurrentAnimationFrame(SpriteState spriteState) {
        return "character_ranged";
    }

    @Override
    protected float GetStatHealth() {
        return 1;
    }
}
