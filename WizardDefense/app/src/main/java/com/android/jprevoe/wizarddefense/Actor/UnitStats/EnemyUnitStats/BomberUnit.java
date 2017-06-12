package com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.UnitActionBomberAttack;
import com.android.jprevoe.wizarddefense.Actor.Actions.Movement.UnitActionMoveAroundAllies;
import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;

/**
 * Created by jprevoe on 11/14/15.
 */
public class BomberUnit extends UnitStats {
    @Override
    public void initialize(Unit unit) {
        super.initialize(unit);
        unit.addAction(new UnitActionMoveAroundAllies(2));
        unit.addAction(new UnitActionBomberAttack());
    }

    @Override
    protected String getCurrentAnimationFrame(SpriteState spriteState) {
        return "character_bomber";
    }

    @Override
    protected float GetStatHealth() {
        return 2;
    }
}
