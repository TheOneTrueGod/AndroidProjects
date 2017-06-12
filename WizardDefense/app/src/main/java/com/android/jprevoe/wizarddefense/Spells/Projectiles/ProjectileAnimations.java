package com.android.jprevoe.wizarddefense.Spells.Projectiles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jprevoe on 8/21/15.
 */
public class ProjectileAnimations {
    private static HashMap<Integer, Bitmap> mBitmaps = new HashMap<>();
    private static Resources mResources;

    public static void setResources(Resources mResources) {
        ProjectileAnimations.mResources = mResources;
    }

    private static Bitmap getBitmap(int resource) {
        if (!mBitmaps.containsKey(resource)) {
            mBitmaps.put(resource, BitmapFactory.decodeResource(mResources, resource));
        }
        return mBitmaps.get(resource);
    }

    public static class ProjectileAnimation {
        protected ArrayList<Bitmap> mImages = new ArrayList();
        protected ProjectileAnimation(Integer[] resourceIDs) {
            addResIDs(resourceIDs);
        }
        protected float mScaleX = 1;
        protected float mScaleY = 1;

        protected void addResIDs(Integer[] resourceIDs) {
            for (int resID : resourceIDs) {
                Bitmap bitmap = getBitmap(resID);
                mImages.add(bitmap);
            }
        }

        public void drawOnCanvas(
                float sourceX, float sourceY,
                float targX, float targY,
                float pctDone, float duration,
                Canvas drawingCanvas, Context context) {
            double offsetX = (targX - sourceX) * pctDone;
            double offsetY = (targY - sourceY) * pctDone;
            GridDrawer.drawImage(drawingCanvas, getFrame(pctDone, duration),
                    (float)(sourceX + offsetX), (float)(sourceY + offsetY),
                    null,
                    BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y,
                    mScaleX, mScaleY
            );
        }

        protected Bitmap getFrame(float pctDone, float duration) {
            return mImages.get(0);
        }

        public float getCollisionPct() {
            return 1;
        }
    }

    public static class ProjectileWithEffectAnimation extends ProjectileAnimation {
        private final ProjectileAnimation mPart1;
        private final ProjectileAnimation mPart2;
        private double mFollowUpPct;

        public ProjectileWithEffectAnimation(
                ProjectileAnimation part1,
                ProjectileAnimation part2,
                double followUpPct) {
            super(new Integer[]{});
            mPart1 = part1;
            mPart2 = part2;
            mFollowUpPct = followUpPct;
        }

        public float getCollisionPct() {
            return (float)(mFollowUpPct + (1 - mFollowUpPct) * 0.5);
        }

        public void drawOnCanvas(
                float sourceX, float sourceY,
                float destX, float destY,
                float pctDone, float duration,
                Canvas drawingCanvas, Context context) {
            double pct = (float) (pctDone / mFollowUpPct);
            if (pctDone < mFollowUpPct) {
                mPart1.drawOnCanvas(sourceX, sourceY, destX, destY, (float) pct, duration, drawingCanvas, context);
            } else {
                pct = (pctDone - mFollowUpPct) / (1 - mFollowUpPct);
                mPart2.drawOnCanvas(destX, destY, destX, destY, (float) pct, duration, drawingCanvas, context);
            }
        }
    }

    private static class LoopingAnimation extends ProjectileAnimation {
        protected LoopingAnimation(Integer[] resourceIDs) {
            super(resourceIDs);
        }

        protected Bitmap getFrame(float pctDone, float duration) {
            double frameOn = Math.floor(pctDone * duration % 40 / 40 * mImages.size());
            return mImages.get((int)frameOn);
        }
    }

    private static class SingleAnimation extends ProjectileAnimation {
        protected SingleAnimation(Integer[] resourceIDs) {
            super(resourceIDs);
        }
        @Override
        protected Bitmap getFrame(float pctDone, float duration) {
            double frameOn = Math.floor(pctDone * mImages.size());
            return mImages.get((int)frameOn);
        }
    }

    private static class InPlaceAnimation extends SingleAnimation {
        protected InPlaceAnimation(Integer[] resourceIDs) {
            super(resourceIDs);
        }

        public float getCollisionPct() {
            return (float)0.5;
        }
    }

    public static class ShurikenAnimation extends LoopingAnimation {
        public ShurikenAnimation() {
            super(  new Integer[]{
                R.drawable.shuriken_1,
                R.drawable.shuriken_2,
                R.drawable.shuriken_3,
                R.drawable.shuriken_4
            });
        }
    }

    public static class ArrowAnimation extends LoopingAnimation {
        public ArrowAnimation (boolean flipY) {
            super(  new Integer[]{
                R.drawable.arrow_1,
                R.drawable.arrow_2
            });
            if (flipY) {
                mScaleY = -1;
            }
        }
    }

    public static class SlashAnimation extends InPlaceAnimation {
        public SlashAnimation(boolean flipX) {
            super(  new Integer[]{
                R.drawable.slash_1,
                R.drawable.slash_2,
                R.drawable.slash_3,
                R.drawable.slash_4,
                R.drawable.slash_5,
                R.drawable.slash_6
            });
            if (flipX) {
                mScaleX = -1;
            }
        }
    }

    public static class FireballAnimation extends LoopingAnimation {
        public FireballAnimation() {
            super( new Integer[]{
                R.drawable.fireball_1,
                R.drawable.fireball_2,
                R.drawable.fireball_3,
                R.drawable.fireball_4,
                R.drawable.fireball_5
            });
        }
    }

    public static class ExplosionAnimation extends InPlaceAnimation {
        public ExplosionAnimation () {
            super( new Integer[]{
                R.drawable.explosion_1,
                R.drawable.explosion_2,
                R.drawable.explosion_3,
                R.drawable.explosion_4,
                R.drawable.explosion_5
            });
        }
    }

    public static class HatFallingOffAnimation extends ProjectileAnimation {
        public HatFallingOffAnimation() {
            super(new Integer[]{ R.drawable.character_armored_hat });
        }

        public void drawOnCanvas(
                float sourceX, float sourceY,
                float targX, float targY,
                float pctDone, float duration,
                Canvas drawingCanvas, Context context) {
            final int NUM_FLASHES = 4;
            if ((int)(pctDone * NUM_FLASHES * 2) % 2 == 0) {
                return;
            }

            double offset = pctDone * 0.2; // How far the shards should fly


            drawShard(sourceX - offset, sourceY - offset / 2.0, 0, 0, drawingCanvas);
            drawShard(sourceX + offset, sourceY - offset / 2.0, 1, 0, drawingCanvas);

            drawShard(sourceX - offset, sourceY + offset / 2.0, 0, 1, drawingCanvas);
            drawShard(sourceX + offset, sourceY + offset / 2.0, 1, 1, drawingCanvas);

        }

        private void drawShard(double x, double y, int shardX, int shardY, Canvas drawingCanvas) {
            Bitmap image = mImages.get(0);
            int shardSizeX = image.getWidth() / 2 * shardX;
            int shardSizeY = image.getHeight() / 2 * shardY;


            GridDrawer.drawSubImage(drawingCanvas, image,
                (float)(x + shardSizeX / BattleGrid.SQUARESIZE_X),
                (float) (y + shardSizeY / BattleGrid.SQUARESIZE_Y),
                null,
                BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y,
                new Rect(
                    shardSizeX,
                    shardSizeY,
                    image.getWidth() / 2 + shardSizeX,
                    image.getHeight() / 2 + shardSizeY
                )
            );
        }

        protected Bitmap getFrame(float pctDone, float duration) {
            return mImages.get(0);
        }

        public float getCollisionPct() {
                return 1;
            }

    }

    public static class FireballWithExplosion extends ProjectileWithEffectAnimation {
        public FireballWithExplosion() {
            super(new FireballAnimation(), new ExplosionAnimation(), 0.5);
        }
    }

    public static class ShurikenWithSlash extends ProjectileWithEffectAnimation {
        public ShurikenWithSlash() {
            super(new ShurikenAnimation(), new SlashAnimation(false), 0.75);
        }
    }

    public static class CrystalAnimation extends SingleAnimation {
        public CrystalAnimation(ManaAmount.ManaType manaType) {
            super( new Integer[]{ });
            switch (manaType) {
                case PHYSICAL:
                    addResIDs( new Integer[]{ R.drawable.crystal_physical_1});
                    break;
                case FIRE:
                default:
                    addResIDs( new Integer[]{ R.drawable.crystal_fire_1 });
                    break;
            }

        }
    }
}
