package com.android.jprevoe.wizarddefense.Actor.UnitStats;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.HealthBarDrawer;
import com.android.jprevoe.wizarddefense.Actor.ManaDrawer;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 7/31/15.
 */
public class PlayerStats extends UnitStats {
    @Override
    public void drawOnCanvas(Canvas canvas, Context context, SpriteState spriteState) {
        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.red));

        GridDrawer.drawRect(canvas,
                mUnit.getPosition().x + mUnit.getAnimationOffset().x,
                mUnit.getPosition().y + mUnit.getAnimationOffset().y,
                paint,
                BattleGrid.SQUARESIZE_X - 4, BattleGrid.SQUARESIZE_Y - 4,
                BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y);

        float healthPct = Math.min(Math.max(mUnit.getHealth() / mUnit.getMaxHealth(), 0), 1);
        if (healthPct > 0.5) {
            paint.setColor(context.getResources().getColor(R.color.blue));
        } else {
            paint.setColor(context.getResources().getColor(R.color.green));
        }

        // At health pct 1 we want a slightly smaller than max sized inner square.
        // At low health pct we want that square to be tiny
        GridDrawer.drawRect(canvas,
                mUnit.getPosition().x + mUnit.getAnimationOffset().x,
                mUnit.getPosition().y + mUnit.getAnimationOffset().y,
                paint,
                getInnerRectangleSize(BattleGrid.SQUARESIZE_X - 8, healthPct),
                getInnerRectangleSize(BattleGrid.SQUARESIZE_Y - 8, healthPct),
                BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y);
    }

    private float getInnerRectangleSize(float innerSquareSize, float healthPct) {
        return innerSquareSize - innerSquareSize * (1 - healthPct);
    }

    @Override
    public void drawHealthOnCanvas(Canvas canvas, Context context) {
        HealthBarDrawer.drawHealthBar(
                BattleGrid.SQUARESIZE_X,
                canvas.getHeight() - 20,
                2,
                getHealth(), getMaxHealth(),
                canvas, context);
    }

    @Override
    public void drawManaOnCanvas(Canvas canvas, Context context) {
        ManaDrawer.drawManaBar(
                canvas.getWidth() / 2,
                canvas.getHeight() - 20,
                mMana,
                canvas, context);
    }

    @Override
    protected float GetStatHealth() {
        return 10;
    }
}
