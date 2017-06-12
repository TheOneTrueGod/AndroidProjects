package com.android.jprevoe.wizarddefense.Actor;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitAttackHandler;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats.ArcherUnit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats.BomberUnit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats.KnightUnit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats.MeleeUnit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.PlayerStats;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.EnemyUnitStats.RangedUnit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;

/**
 * Created by jprevoe on 7/27/15.
 */
public class UnitFactory {
    public static enum UnitType {
        MELEE,
        NORMAL,
        RANGED,
        BOMBER,
        ARCHER,
        KNIGHT
    }

    public Unit createUnit(
            int x, int y,
            UnitMoveHandler unitMoveHandler, UnitAttackHandler unitAttackHandler,
            UnitType unitType) {
        Position position = Position.create(x, y);
        if (unitType != null) {
            UnitStats unitStats;
            switch (unitType) {
                case MELEE:
                    unitStats = new MeleeUnit();
                    break;
                case RANGED:
                    unitStats = new RangedUnit();
                    break;
                case BOMBER:
                    unitStats = new BomberUnit();
                    break;
                case ARCHER:
                    unitStats = new ArcherUnit();
                    break;
                case KNIGHT:
                    unitStats = new KnightUnit();
                    break;
                default:
                    return null;
            }
            Unit unit = new Unit(position, unitMoveHandler, unitAttackHandler, unitStats);
            unitStats.initialize(unit);
            unit.doSpawnAction();
            return unit;
        }
        return null;
    }

    public Player createYou(int x, int y,
                          UnitMoveHandler unitMoveHandler, UnitAttackHandler unitAttackHandler) {
        Position position = Position.create(x, y);
        UnitStats unitStats = new PlayerStats();
        Player unit = new Player(position, unitMoveHandler, unitAttackHandler, unitStats);
        unitStats.initialize(unit);
        return unit;
    }
}
