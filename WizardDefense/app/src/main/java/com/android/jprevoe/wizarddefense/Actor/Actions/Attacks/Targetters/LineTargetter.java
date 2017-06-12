package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

import java.util.ArrayList;

/**
 * Created by jprevoe on 2/19/16.
 */
public class LineTargetter extends ActionTargetter {

    private final int mRange;

    public LineTargetter(int range) {
        super();
        mRange = range;
    }

    @Override
    protected ArrayList<Position> createTargetList(Unit unit) {
        for (int dist = 1; dist < mRange; dist++) {
            float x = unit.getPositionX();
            float y = unit.getPositionY();

            mCachedTargetList.add(Position.create(x + dist, y));
            mCachedTargetList.add(Position.create(x - dist, y));
            mCachedTargetList.add(Position.create(x, y + dist));
            mCachedTargetList.add(Position.create(x, y - dist));
        }
        return null;
    }
}
