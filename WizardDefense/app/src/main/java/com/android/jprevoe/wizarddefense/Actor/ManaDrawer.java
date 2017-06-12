package com.android.jprevoe.wizarddefense.Actor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;

import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.R;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jprevoe on 11/8/15.
 */
public class ManaDrawer {
    private static Context mContext;
    private static Map<Integer, Bitmap> mCrystalImages;

    private static int CRYSTAL_IMAGES = 4;

    public static void setContext(Context context) {
        mContext = context;
    }

    public static void drawManaBar(
            float left, float top,
            ManaAmount manaAmounts,
            Canvas canvas, Context context) {

        if (mContext == null) {
            mContext = context;
        }
        Paint paint = new Paint();
        Bitmap crystalImage = getCrystalImage(0, ManaAmount.ManaType.FIRE);
        float width = 0;
        float gap = 3;
        for (ManaAmount.ManaType mt : ManaAmount.ManaType.values()) {
            width += Math.max(manaAmounts.get(mt), 1) * crystalImage.getWidth();
            width += gap;
        }

        float currLeft = left - width / 2;
        for (ManaAmount.ManaType mt : ManaAmount.ManaType.values()) {
            int maxMana = Math.max(manaAmounts.get(mt), 1);
            for (int i = 0; i < maxMana; i++) {
                crystalImage = getCrystalImage(getCrystalForSpot(i, manaAmounts.get(mt)), mt);

                canvas.drawBitmap(
                        crystalImage,
                        currLeft,
                        top,
                        paint
                );

                currLeft += crystalImage.getWidth() + 1;
            }
            currLeft += gap;
        }
    }

    public static int getCrystalForSpot(int i, float mana) {
        if (i < mana) {
            return 1;
        }
        return 0;
    }

    private static Bitmap getCrystalImage(float i, ManaAmount.ManaType manaType) {
        if (i == -1) {
            return null;
        }
        if (mCrystalImages == null) {
            mCrystalImages = new HashMap<>();
        }
        int crystalRes = getCrystalRes((int)i, manaType);
        if (!mCrystalImages.containsKey(crystalRes)) {
            Bitmap crystalBitmap = BitmapFactory.decodeResource(
                    mContext.getResources(), crystalRes);
            crystalBitmap =
                    Bitmap.createScaledBitmap(
                            crystalBitmap,
                            crystalBitmap.getWidth() / 2,
                            crystalBitmap.getHeight() / 2,
                            false);
            mCrystalImages.put(crystalRes,
                    crystalBitmap
            );
        }
        return mCrystalImages.get(crystalRes);
    }

    public static int getCrystalRes(int i, ManaAmount.ManaType manaType) {
        String resourceType = "blank_";
        switch (manaType) {
            case PHYSICAL:
                resourceType = "physical_";
                break;
            case FIRE:
                resourceType = "fire_";
                break;
            default:
                break;
        }
        String resourceName = "crystal_" + resourceType + String.valueOf(i);
        int id = mContext.getResources().getIdentifier(resourceName, "drawable", mContext.getPackageName());
        return id;
    }
}
