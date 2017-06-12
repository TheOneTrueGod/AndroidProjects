package com.android.jprevoe.wizarddefense.Grid.Structures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitSpriteCreator;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.R;
import com.android.jprevoe.wizarddefense.UI.SpriteLoader;

/**
 * Created by jprevoe on 7/31/15.
 */
public class CastleGrass extends GridStructure {
    public CastleGrass() {
        super();
        mUnitSlowdown = 0;
        mResourceId = R.drawable.terrain_grass;
    }

    @Override
    protected double getSheetHeight() {
        return 6;
    }

    @Override
    public boolean canWalkOn(Unit unit) {
        return true;
    }

    @Override
    public boolean isDestructible() {
        return false;
    }
}
