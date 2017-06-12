package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

import java.util.ArrayList;

/**
 * Created by jprevoe on 8/28/15.
 */
public abstract class ActionTargetter {
    ArrayList<Position> mCachedTargetList = new ArrayList();
    Position mLastTarget = null;

    public ArrayList<Position> getTargetPositions(Unit unit) {
        if (mLastTarget != null &&
                mLastTarget.x == unit.getPositionX() &&
                mLastTarget.y == unit.getPositionY()) {
            return mCachedTargetList;
        }

        mLastTarget = unit.getPosition();
        mCachedTargetList.clear();
        createTargetList(unit);
        return mCachedTargetList;
    }

    protected abstract ArrayList<Position> createTargetList(Unit unit);
}
