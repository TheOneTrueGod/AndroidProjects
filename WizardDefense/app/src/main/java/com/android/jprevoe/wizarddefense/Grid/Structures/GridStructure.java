package com.android.jprevoe.wizarddefense.Grid.Structures;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;

import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitEffects.SlowEffect;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.R;
import com.android.jprevoe.wizarddefense.UI.SpriteLoader;

/**
 * Created by jprevoe on 7/26/15.
 */
public class GridStructure {
    protected boolean mInvalidated;
    protected int mUnitSlowdown = 0;
    protected int mResourceId = 0;
    private Rect mRect = null;

    public final void drawOnCanvas(Canvas canvas, Context context, float x, float y) {
        drawMe(canvas, context, x, y);
        mInvalidated = false;
    }

    protected void drawMe(Canvas canvas, Context context, float x, float y) {
        if (mResourceId != 0) {

            Bitmap grass = SpriteLoader.getScaledBitmap(mResourceId, BattleGrid.SQUARESIZE_X / 32);
            if (mRect == null) {
                int rectX = 0;
                int rectY = (int)Math.floor(Math.random() * getSheetHeight());
                int w = (int)BattleGrid.SQUARESIZE_X;
                int h = (int)BattleGrid.SQUARESIZE_Y;

                mRect = new Rect(rectX * w, rectY * w, (rectX + 1) * w, (rectY + 1) * h);
            }
            GridDrawer.drawSubImage(
                    canvas,
                    grass,
                    (float)(x), (float)(y + (getSheetHeight() - 1) / 2),
                    null,
                    BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y,
                    mRect
            );
        } else {
            drawSquareOnCanvas(canvas, context, x, y, R.color.white);
        }
    }

    protected double getSheetHeight() {
        return 1;
    }

    protected void drawSquareOnCanvas(Canvas canvas, Context context, float x, float y, int color) {
        Paint paintToUse = new Paint();
        paintToUse.setColor(context.getResources().getColor(color));
        GridDrawer.drawRect(canvas,
                x, y,
                paintToUse,
                BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y,
                BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y);
    }

    public boolean canWalkOn(Unit unit) {
        return true;
    }

    public boolean isDestructible() {
        return false;
    }

    public void applyStructureEffect(BattleGrid.GridStructureEffect effect, float amount) {
        mInvalidated = true;
    }

    public boolean isInvalidated() {
        return mInvalidated;
    }

    public boolean ReadyToDestroy() {
        return false;
    }

    public GridStructure getStructureUnderneath() {
        return null;
    }

    public boolean protectsUnitFromAttack() {
        return false;
    }

    public void unitEntering(Unit unit) {
        if (mUnitSlowdown > 0) {
            unit.addEffect(new SlowEffect(mUnitSlowdown));
        }
    }

    public void unitLeaving(Unit unit) {

    }
}
