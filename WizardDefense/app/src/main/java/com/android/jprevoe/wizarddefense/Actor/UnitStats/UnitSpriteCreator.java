package com.android.jprevoe.wizarddefense.Actor.UnitStats;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.ArrayMap;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jprevoe on 8/13/15.
 */
public class UnitSpriteCreator {
    private static UnitSpriteCreator mUnitSpriteCreator;
    private static Resources mResources;
    private static Context mContext;


    public static UnitSpriteCreator get() {
        if (mResources == null) {
            Log.e("UnitSpriteCreatorError", "Resources not initialized.  Please call UnitSpriteCreator.setResources in the fragment or view creator");
            return null;
        }
        if (mUnitSpriteCreator == null) {
            mUnitSpriteCreator = new UnitSpriteCreator();
        }
        return mUnitSpriteCreator;
    }

    public static void setResources(Resources resources) {
        mResources = resources;
    }
    public static void setContext(Context context) {
        mContext = context;
    }

    private Map<Object, Bitmap> mBitmaps;

    private UnitSpriteCreator() {
        mBitmaps = new HashMap<>();
    }

    public Bitmap create(int feet, int body, int hands, int eyes, int accessory) {
        int key = feet * 10000 + body * 1000 + hands * 100 + eyes * 10 + accessory;
        if (!mBitmaps.containsKey(key)) {
            Bitmap bitmap = Bitmap.createBitmap(
                    (int)BattleGrid.SQUARESIZE_X, (int)BattleGrid.SQUARESIZE_Y,
                    Bitmap.Config.ARGB_8888);
            Canvas drawingCanvas = new Canvas(bitmap);
            drawResourceOnCanvas(drawingCanvas, R.drawable.sprite_part_body_1);
            drawResourceOnCanvas(drawingCanvas, R.drawable.sprite_part_foot_1);
            drawResourceOnCanvas(drawingCanvas, R.drawable.sprite_part_eyes_1);
            if (accessory == 1) {
                drawResourceOnCanvas(drawingCanvas, R.drawable.sprite_part_accessory_1);
            }
            drawResourceOnCanvas(drawingCanvas, R.drawable.sprite_part_hands_1);

            mBitmaps.put(key, bitmap);
        }
        return mBitmaps.get(key);
    }

    public Bitmap createFromFullImage(String imageName) {
        return createFromFullImage(imageName, 1);
    }

    public Bitmap createFromFullImage(String imageName, float scale) {
        if (!mBitmaps.containsKey(imageName)) {
            Bitmap bitmap = Bitmap.createBitmap(
                    (int)(BattleGrid.SQUARESIZE_X * scale), (int)(BattleGrid.SQUARESIZE_Y * scale),
                    Bitmap.Config.ARGB_8888);
            Canvas drawingCanvas = new Canvas(bitmap);
            drawResourceOnCanvas(drawingCanvas,
                    mResources.getIdentifier(imageName, "drawable", mContext.getPackageName()),
                    scale);

            Bitmap scaled = Bitmap.createScaledBitmap(bitmap,
                (int)(BattleGrid.SQUARESIZE_X * scale), (int)(BattleGrid.SQUARESIZE_Y * scale),
                    false);

            mBitmaps.put(imageName, bitmap);
        }
        return mBitmaps.get(imageName);
    }

    public void drawResourceOnCanvas(Canvas canvas, int r) {
        drawResourceOnCanvas(canvas, r, 1);
    }

    public void drawResourceOnCanvas(Canvas canvas, int r, float scale) {
        Drawable drawable = mResources.getDrawable(r);
        drawable.setBounds(0, 0,
                (int)(BattleGrid.SQUARESIZE_X * scale), (int)(BattleGrid.SQUARESIZE_Y * scale));
        drawable.draw(canvas);
    }
}
