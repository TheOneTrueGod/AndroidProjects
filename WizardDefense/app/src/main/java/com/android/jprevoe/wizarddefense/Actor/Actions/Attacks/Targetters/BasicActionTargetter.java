package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters;

import android.util.ArrayMap;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jprevoe on 8/28/15.
 */
public class BasicActionTargetter extends ActionTargetter {
    private int mAttackRange;

    public BasicActionTargetter(int range) {
        super();
        mAttackRange = range;
    }

    @Override
    protected ArrayList<Position> createTargetList(Unit unit) {
        Map<Float, Boolean> targetsMap = new HashMap<>();
        targetsMap.put(getKeyForPosition(unit.getPositionX(), unit.getPositionY()), true);
        for (int y = -mAttackRange; y <= mAttackRange; y++) {
            for (int x = -mAttackRange; x <= mAttackRange; x++) {
                float targX = unit.getPositionX() + x;
                float targY = unit.getPositionY() + y;
                if (!targetsMap.containsKey(getKeyForPosition(targX, targY))) {
                    mCachedTargetList.add(Position.create(targX, targY));
                    targetsMap.put(getKeyForPosition(targX, targY), true);
                }
            }
        }
        return mCachedTargetList;
    }

    protected float getKeyForPosition(float x, float y) {
        return x * 10000 + y; // A big number, the size of which I don't think the grid will ever reach
    }
}
