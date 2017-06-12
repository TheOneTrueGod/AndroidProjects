package com.android.jprevoe.wizarddefense.Actor.Actions.Movement;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

import java.util.ArrayList;

/**
 * Created by jprevoe on 7/27/15.
 */
public class UnitActionMoveAroundAllies extends UnitActionMove {
    public UnitActionMoveAroundAllies(int cooldown) {
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

        this.pickTargetWalkAroundEverything(unit);
    }

    @Override
    protected ArrayList<Position> getPossibleMoveTargets(Unit unit) {
        int randomizer = Math.random() < 0.5 ? -1 : 1;
        ArrayList<Position> al = new ArrayList<Position>();
        al.add(Position.create(0, 1));
        if (unit.getPositionX() < BattleGrid.GRIDSIZE_X / 2) {
            al.add(Position.create(-randomizer, 1));
            al.add(Position.create(randomizer, 1));
            al.add(Position.create(-randomizer, 0));
            al.add(Position.create(randomizer, 0));
        } else {
            al.add(Position.create(randomizer, 1));
            al.add(Position.create(-randomizer, 1));

            al.add(Position.create(randomizer, 0));
            al.add(Position.create(-randomizer, 0));
        }

        return al;
    }
}
