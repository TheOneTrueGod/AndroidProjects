package com.android.jprevoe.wizarddefense.Battle;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import android.view.animation.Animation;

import com.android.jprevoe.wizarddefense.EffectAnimation;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

/**
 * Created by jprevoe on 3/22/16.
 */
public class BattleEffects {
    private static BattleEffects mBattleEffects;
    private final Canvas mDrawingCanvas;
    private final Bitmap mDrawingBitmap;
    private final EffectAnimation mAnimationTimer;

    public static BattleEffects GetBattleEffects(View view) {
        if (mBattleEffects == null) {
            mBattleEffects = new BattleEffects(view);
        }
        return mBattleEffects;
    }

    private BattleEffects(View view) {
        mDrawingBitmap = Bitmap.createBitmap(
                (int) (BattleGrid.GRIDSIZE_X * BattleGrid.SQUARESIZE_X),
                (int) (BattleGrid.GRIDSIZE_Y * BattleGrid.SQUARESIZE_Y),
                Bitmap.Config.ARGB_8888);
        mDrawingCanvas = new Canvas(mDrawingBitmap);

        mAnimationTimer = new EffectAnimation(view);
        mAnimationTimer.setAnimationListener(new AnimationTimerListener());
        mAnimationTimer.setDuration(1000);
        mAnimationTimer.setRepeatMode(1);
    }

    private class AnimationTimerListener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            mAnimationTimer.incrementIteration();
            mAnimationTimer.reset();
            mAnimationTimer.setDuration(1000);
            mAnimationTimer.start();
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }
    }

    public void drawOnCanvas(Canvas canvas, Context context) {
        canvas.drawBitmap(mDrawingBitmap, 0, 0, null);
    }

}
