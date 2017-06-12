package com.android.jprevoe.wizarddefense.UI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

import java.util.HashMap;

/**
 * Created by jprevoe on 2/16/16.
 */
public class SpriteLoader {
    private static HashMap<Object, Bitmap> mBitmaps = new HashMap<>();
    private static Resources mResources;
    private static Context mContext;

    public static void setResources(Resources resources) {
        mResources = resources;
    }
    public static void setContext(Context context) {
        mContext = context;
    }

    public static Bitmap getBitmap(int resource) {
        if (!mBitmaps.containsKey(resource)) {
            mBitmaps.put(resource, BitmapFactory.decodeResource(mResources, resource));
        }
        return mBitmaps.get(resource);
    }

    public static Bitmap getScaledBitmap(int resID, float scale) {
        if (!mBitmaps.containsKey(resID)) {
            scale /= BattleGrid.DPI;
            Bitmap res = BitmapFactory.decodeResource(mResources, resID);
            res = Bitmap.createScaledBitmap(res, (int)(res.getWidth() * scale), (int)(res.getHeight() * scale), false);
            mBitmaps.put(resID, res);
        }
        return mBitmaps.get(resID);
    }

    public static void drawResourceOnCanvas(Canvas canvas, int r) {
        drawResourceOnCanvas(canvas, r, 1);
    }

    public static void drawResourceOnCanvas(Canvas canvas, int r, float scale) {
        Drawable drawable = mResources.getDrawable(r);
        drawable.setBounds(0, 0,
                (int)(BattleGrid.SQUARESIZE_X * scale), (int)(BattleGrid.SQUARESIZE_Y * scale));
        drawable.draw(canvas);
    }
}
