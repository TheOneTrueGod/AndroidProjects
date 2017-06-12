package com.android.jprevoe.wizarddefense.Actor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.ArrayMap;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.R;

import java.lang.reflect.Array;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jprevoe on 8/17/15.
 */
public class HealthBarDrawer {
    private static int HEALTH_BAR_HEIGHT = 13;
    private static int HEALTH_PER_HEART = 1;
    private static Context mContext;
    private static Map<Integer, Bitmap> mHealthImages;

    public static void drawHealthBar(
                                     float left, float top,
                                     int squares,
                                     float health, float maxHealth,
                                     Canvas canvas, Context context) {
        if (mContext == null) {
            mContext = context;
        }
        Paint paint = new Paint();
        Bitmap healthImage = getHealthImage(1);

        int heartWidth = healthImage.getWidth() + 1;
        float heartsAcross = squares * 4 - 1;
        double heartsWidth = Math.min(
                Math.ceil(maxHealth / 2.0) * heartWidth +
                    ((maxHealth + 1) % 2) * heartWidth / 2.0,
                heartsAcross * heartWidth);
        left += (BattleGrid.SQUARESIZE_X -
                (heartsWidth)) / 2;

        for (int i = 0; i < heartsAcross; i++) {
            healthImage = getHealthImage(getHeart(
                    i, false,
                    health, maxHealth,
                    (int)(heartsAcross * 2 - 1)));
            if (healthImage != null) {
                canvas.drawBitmap(
                        healthImage,
                        left + heartWidth * i + 1,
                        top,
                        paint
                        );
            } else {
                break;
            }
        }
        for (int i = 0; i < heartsAcross - 1; i++) {
            healthImage = getHealthImage(getHeart(
                    i, true,
                    health, maxHealth,
                    (int)(heartsAcross * 2 - 1)));
            if (healthImage != null) {
                canvas.drawBitmap(
                        healthImage,
                        left + heartWidth * i + heartWidth / 2 + 1,
                        top + heartWidth / 3,
                        paint
                );
            } else {
                break;
            }
        }
    }

    private static int getHeart(int position, boolean secondRow,
                                float health, float maxHealth,
                                int maxHearts) {
        position = position * 2;
        if (secondRow) {
            position += 1;
        }

        if (position >= maxHealth) {
            return -1;
        }
        int base = (int) (health / maxHearts);
        if (position < health % maxHearts) {
            return base + 1;
        }

        return base;
    }

    private static Bitmap getHealthImage(float i) {
        if (i == -1) {
            return null;
        }
        if (mHealthImages == null) {
            mHealthImages = new HashMap<>();
        }
        int heartRes = getHeartRes(i);
        if (!mHealthImages.containsKey(heartRes)) {
            Bitmap heartBitmap = BitmapFactory.decodeResource(
                    mContext.getResources(), heartRes);
            heartBitmap =
                    Bitmap.createScaledBitmap(
                            heartBitmap,
                            heartBitmap.getWidth() / 2,
                            heartBitmap.getHeight() / 2,
                            false);
            mHealthImages.put(heartRes,
                heartBitmap
            );
        }
        return mHealthImages.get(heartRes);
    }

    private static int getHeartRes(float i) {
        if (i == 0) {
            return R.drawable.heart_01;
        }
        if (i == 1) {
            return R.drawable.heart_05;
        }
        if (i == 2) {
            return R.drawable.heart_06;
        }
        if (i == 3) {
            return R.drawable.heart_07;
        }
        if (i == 4) {
            return R.drawable.heart_08;
        }
        if (i == 5) {
            return R.drawable.heart_09;
        }
        if (i == 6) {
            return R.drawable.heart_10;
        }
        if (i >= 7) {
            return R.drawable.heart_11;
        }
        return R.drawable.heart_00;
    }

    private static void drawHealthBarAsBar(float left, float top,
                                           float width,
                                           float health, float maxHealth,
                                           Canvas canvas, Context context) {

        Paint paint = new Paint();
        paint.setColor(context.getResources().getColor(R.color.black));
        canvas.drawRect(new Rect(
                (int) (left),
                (int) (top),
                (int) (left + width),
                (int) (top + HEALTH_BAR_HEIGHT))
                , paint);

        paint.setColor(context.getResources().getColor(R.color.red));
        double healthPct = Math.min(Math.max(health / Math.max(maxHealth, 0.01), 0), 1);
        canvas.drawRect(new Rect(
                        (int) (left + 1),
                        (int) (top + 1),
                        (int) (left + width * healthPct - 2),
                        (int) (top + HEALTH_BAR_HEIGHT - 2)),
                paint);
    }

    public static void drawHealthBar(Unit unit,
                                     float health, float maxHealth,
                                     Canvas canvas, Context context) {

        float y = (unit.getPositionY() + 1
                + unit.getAnimationOffset().y)
                * BattleGrid.SQUARESIZE_Y +
                - HEALTH_BAR_HEIGHT;

        float x = (unit.getPositionX()
                + unit.getAnimationOffset().x)
                * BattleGrid.SQUARESIZE_X;

        drawHealthBar(
                x,
                y,
                1,
                health, maxHealth,
                canvas, context);
    }
}
