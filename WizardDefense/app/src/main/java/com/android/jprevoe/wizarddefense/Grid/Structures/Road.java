package com.android.jprevoe.wizarddefense.Grid.Structures;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 7/26/15.
 */
public class Road extends GridStructure {
    public Road() {
        super();
        mResourceId = R.drawable.terrain_dirt;
    }

    @Override
    protected double getSheetHeight() {
        return 2;
    }
}
