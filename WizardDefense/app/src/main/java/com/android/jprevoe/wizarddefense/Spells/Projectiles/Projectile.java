package com.android.jprevoe.wizarddefense.Spells.Projectiles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.R;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/14/15.
 */
public class Projectile {
    private final Position mSource;
    private final Position mTarget;
    private final ProjectileAnimations.ProjectileAnimation mProjectileAnimation;
    private boolean mInitialized;
    private float mDuration;
    private float mStartTime;
    private float mAnimationOffsetX;
    private float mAnimationOffsetY;


    private boolean mDone;
    private ArrayList<Callable> mListeners;
    private float mPctDone = 0;
    private boolean mCollided;

    private Projectile(Position source, Position target,
                       ProjectileAnimations.ProjectileAnimation animation,
                       float duration) {
        mSource = source;
        mTarget = target;
        mProjectileAnimation = animation;
        mDuration = duration;
        mInitialized = false;
        mListeners = new ArrayList<Callable>();
    }

    public static Projectile create(Position source, Position target,
                                    ProjectileAnimations.ProjectileAnimation animation,
                                    float duration) {
        return new Projectile(source, target, animation, duration);
    }

    public void drawOnCanvas(Canvas drawingCanvas, Context context) {
        if (mDone) {
            return;
        }

        mProjectileAnimation.drawOnCanvas(
            mSource.x, mSource.y,
            mTarget.x, mTarget.y,
            mPctDone, mDuration,
            drawingCanvas, context
            );
    }

    public void animate(float currTime) {
        if (!mInitialized) {
            mStartTime = currTime;
            mInitialized = true;
            mCollided = false;
        }
        mPctDone = Math.max(
                Math.min(
                        (currTime - mStartTime) / mDuration
                        , 1),
                0);
        mAnimationOffsetX = (mTarget.x - mSource.x) * mPctDone;
        mAnimationOffsetY = (mTarget.y - mSource.y) * mPctDone;

        if (mPctDone >= mProjectileAnimation.getCollisionPct() && !mCollided) {
            mCollided = true;
            for (Callable c : mListeners) {
                try {
                    c.call();
                } catch (Exception e) {

                }
            }
        }

        if (mPctDone >= 1) {
            mDone = true;
        }
    }

    public boolean isDone() {
        return mDone;
    }

    public void addListener(Callable callable) {
        mListeners.add(callable);
    }

    public long getTimeLeftInAnimation(long currTime) {
        return (long)(mDuration - (currTime - mStartTime));
    }
}
