package com.android.jprevoe.wizarddefense.Grid;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 7/26/15.
 */
public class UnitMoveHandler {
    private BattleGrid mBattleGrid;

    public UnitMoveHandler() {
        mBattleGrid = BattleGrid.GetBattleGrid();
    }

    public void handleUnitMovement(Unit unit, float x, float y, float deltaX, float deltaY) {
        mBattleGrid.removeObjectFromGrid(unit, Position.create(x, y));
        mBattleGrid.addObjectToGrid(unit, Position.create(x + deltaX, y + deltaY));
        unit.move(deltaX, deltaY);
    }

    public boolean canUnitWalkOnSquare(Unit unit, float x, float y) {
        BattleGrid.Grid.GridColumn.GridSquare gridSquare = mBattleGrid.getGridSquare(x, y);
        if (gridSquare == null) {
            return false;
        }
        // Is there a unit where I'm trying to walk?
        if (gridSquare.getGridObjects().size() > 0) {
            return false;
        }
        // Is there a wall where I'm trying to walk?
        if (gridSquare.getGridStructure() != null &&
            !gridSquare.getGridStructure().canWalkOn(unit)) {
            return false;
        }
        return true;
    }

    public boolean isFriendInSquare(Unit unit, float x, float y) {
        BattleGrid.Grid.GridColumn.GridSquare gridSquare = mBattleGrid.getGridSquare(x, y);
        if (gridSquare == null) {
            return false;
        }
        // Is there a unit where I'm trying to walk?
        if (gridSquare.getGridObjects().size() > 0) {
            for (Object gridObject : gridSquare.getGridObjects()) {
                if (gridObject instanceof Unit) {
                    if (((Unit)gridObject).getUnitTeam() == unit.getUnitTeam()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
