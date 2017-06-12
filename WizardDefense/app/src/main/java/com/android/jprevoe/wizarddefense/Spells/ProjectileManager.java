package com.android.jprevoe.wizarddefense.Spells;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by jprevoe on 8/14/15.
 */
public class ProjectileManager extends ArrayList<Projectile> {
    private static ProjectileManager mProjectileMgr;

    private ProjectileManager() {
    }

    public static ProjectileManager get() {
        if (mProjectileMgr == null) {
            mProjectileMgr = new ProjectileManager();
        }
        return mProjectileMgr;
    }

    @Override
    public boolean add(Projectile object) {
        return super.add(object);
    }

    public void drawOnCanvas(Canvas drawingCanvas, Context context) {
        for (Projectile projectile : this) {
            projectile.drawOnCanvas(drawingCanvas, context);
        }
    }

    public void animate(float currTime) {
        Collection<Projectile> toDelete = new ArrayList<>();
        Projectile projectile;
        for (int i = 0; i < this.size(); i++) {
            projectile = this.get(i);
            projectile.animate(currTime);
            if (projectile.isDone()) {
                toDelete.add(projectile);
            }
        }
        this.removeAll(toDelete);
    }

    public long getTimeLeftInAnimation(long currTime) {
        long timeLeft = 0;
        Projectile projectile;
        for (int i = 0; i < this.size(); i++) {
            projectile = this.get(i);
            timeLeft = Math.max(projectile.getTimeLeftInAnimation(currTime), timeLeft);
        }
        return timeLeft;
    }

    public static void onDestroy() {
        mProjectileMgr = null;
    }

    public void turnEnding() {
        this.clear();
    }
}
