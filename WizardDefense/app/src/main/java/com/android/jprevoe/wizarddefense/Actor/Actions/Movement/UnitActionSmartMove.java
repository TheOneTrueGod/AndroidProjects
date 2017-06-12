package com.android.jprevoe.wizarddefense.Actor.Actions.Movement;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jprevoe on 7/27/15.
 */
public class UnitActionSmartMove extends UnitActionMove {
    public UnitActionSmartMove(int cooldown) {
        super(cooldown);
    }
    @Override
    public int getCooldownTurns() {
        return mCooldownDuration;
    }

    @Override
    public void pickTarget(Unit unit) {
        super.pickTarget(unit);
        mTarget = null;

        if (mTurnsBeforeUse > 0) {
            return;
        }

        // TODO: Use a priority system to figure out where to move
        /*ArrayList<TargetSquare> targets = new ArrayList();
        for (int deltaX : new int[]{-1, 0, 1}) {
            targets.add(TargetSquare.getTargetSquare(
                    unit,
                    unit.getPositionX() + deltaX,
                    unit.getPositionY()
            ));
        }*/

        this.pickTargetWalkAroundWorldObjects(unit);
    }

    private void pickTargetWalkAroundWorldObjects(Unit unit) {
        /*if (isFriendInSquare(unit, 0, 1)) {
            return;
        }*/
        pickTargetWalkAroundEverything(unit);
    }

    protected ArrayList<Position> getPossibleMoveTargets(Unit unit) {

        Position heartPos = BattleGrid.GetBattleGrid().getHeartPosition();
        if (heartPos == null) {
            return super.getPossibleMoveTargets(unit);
        }


        ArrayList<Position> al = new ArrayList<Position>();
        al.add(Position.create(0, 1));
        if (heartPos.x > unit.getPositionX()) {
            al.add(Position.create(1, 0));
        } else {
            al.add(Position.create(-1, 0));
        }

        return al;
    }
}
