package com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting;

import com.android.jprevoe.wizarddefense.Actor.ModifiablePosition;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by jprevoe on 3/4/16.
 */
public class TargettableList extends TargettableSquares {
    ArrayList<Position> mTargets;
    public TargettableList(ArrayList<Position> targets) {
        mTargets = targets;
        mSquares = mTargets.size() * 4;
        mPosition = new ModifiablePosition();
    }

    @Override
    protected void setOffsetForIteratorIndex(int index) {
        int direction = index / mTargets.size();
        Position currTarget = mTargets.get(index % mTargets.size());
        switch (direction) {
            case 0: // Down
                mPosition.x = currTarget.x;
                mPosition.y = currTarget.y;
                break;
            case 1: // Left
                mPosition.x = -currTarget.y;
                mPosition.y = currTarget.x;
                break;
            case 2: // Up
                mPosition.x = -currTarget.x;
                mPosition.y = -currTarget.y;
                break;
            case 3: // Right
                mPosition.x = currTarget.y;
                mPosition.y = -currTarget.x;
                break;
        }
    }

    @Override
    public boolean isValidTarget(Unit unit, int deltaX, int deltaY) {
        for (int i = 0; i < mSquares; i++) {
            setOffsetForIteratorIndex(i);
            if (mPosition.x == deltaX && mPosition.y == deltaY) {
                return super.isValidTarget(unit, deltaX, deltaY);
            }
        }
        return false;
    }
}
