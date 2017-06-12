package com.android.jprevoe.wizarddefense.Grid.Structures;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 7/26/15.
 */
public class CastleMoat extends GridStructure {
    public CastleMoat() {
        super();
        mUnitSlowdown = 3;
        mResourceId = R.drawable.terrain_water;
    }

    @Override
    protected double getSheetHeight() {
        return 3;
    }

    @Override
    public boolean canWalkOn(Unit unit) {
        return false;
    }
}
