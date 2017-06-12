package com.android.jprevoe.wizarddefense.Actor.Actions.Helpers;

import com.android.jprevoe.wizarddefense.Actor.Actions.UnitAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Spells.ProjectileManager;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;

/**
 * Created by jprevoe on 7/31/15.
 */
public class UnitAttackHandler {

    private final BattleGrid mBattleGrid;
    private ProjectileManager mProjectileMgr;

    public UnitAttackHandler() {
        mBattleGrid = BattleGrid.GetBattleGrid();
        mProjectileMgr = ProjectileManager.get();
    }

    public void attackSquare(Position target, Unit.UnitTeam hitBitmap) {
        attackSquare(target, hitBitmap, 1);
    }

    public void attackSquare(Position target, Unit.UnitTeam hitBitmap, float damage) {
        this.attackSquare(target, hitBitmap, damage, false);
    }

    public void attackSquare(Position target, Unit.UnitTeam hitBitmap, float damage, boolean pierce) {
        BattleGrid.Grid.GridColumn.GridSquare gridSquare =
                mBattleGrid.getGridSquare(target.x, target.y);
        if (gridSquare == null) {
            return;
        }

        if (gridSquare.protectsUnitFromAttack()) {
            mBattleGrid.applyStructureEffect((int)target.x, (int)target.y,
                    BattleGrid.GridStructureEffect.DAMAGE, damage);
            if (!pierce) {
                return;
            }
        }

        boolean unitHit = false;
        for (Object gridObject : gridSquare.getGridObjects()) {
            if (gridObject instanceof Unit &&
                ((Unit)gridObject).isOnTeam(hitBitmap.getValue())) {
                Unit unit = (Unit)gridObject;
                unit.damage(damage);
                unitHit = true;
            }
        }
        if (unitHit) {
            return;
        }

        mBattleGrid.applyStructureEffect((int)target.x, (int)target.y,
                BattleGrid.GridStructureEffect.DAMAGE, damage);
    }

    public boolean canUnitAttackSquare(UnitAction ability, float x, float y) {
        BattleGrid.Grid.GridColumn.GridSquare gridSquare = mBattleGrid.getGridSquare(x, y);
        if (gridSquare == null) {
            return false;
        }
        return canUnitAttackUnit(ability, gridSquare) ||
                canUnitAttackStructure(ability, gridSquare);
    }

    private boolean canUnitAttackUnit(UnitAction ability,
                                       BattleGrid.Grid.GridColumn.GridSquare gridSquare) {
        if (gridSquare.getGridObjects().size() == 0) {
            return false;
        }
        for (Object gridObject : gridSquare.getGridObjects()) {
            if (ability.canHitUnit(gridObject)) {
                return true;
            }
        }
        return false;
    }

    private boolean canUnitAttackStructure(UnitAction ability,
                                        BattleGrid.Grid.GridColumn.GridSquare gridSquare) {
        // Is there a castle wall here?
        if (gridSquare.getGridStructure() == null) {
            return false;
        }
        if(!gridSquare.getGridStructure().isDestructible()) {
            return false;
        }
        return true;
    }

    public void addProjectile(Projectile projectile) {
        mProjectileMgr.add(projectile);
    }
}
