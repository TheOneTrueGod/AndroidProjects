package com.android.jprevoe.wizarddefense.Actor;

/**
 * Created by jprevoe on 7/22/15.
 */
public class Position {
    public final float y;
    public final float x;

    protected Position() { x = 0; y = 0;}
    protected Position(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Position addPosition(float deltaX, float deltaY) {
        return create(x + deltaX, y + deltaY);
    }

    public Position multiplyScalar(float scalar) {
        return create(x * scalar, y * scalar);
    }

    public Position capDistanceAt(double maxDist, float sourceX, float sourceY) {
        double angle = Math.atan2(this.y - sourceY, this.x - sourceX);
        double dist = Math.min(
            maxDist,
            Math.pow(Math.pow((sourceY - this.y), 2) + Math.pow((sourceX - this.x), 2), 0.5)
        );

        return new Position(sourceX + (float) (Math.cos(angle) * dist), sourceY + (float) (Math.sin(angle) * dist));
    }

    public static Position create(float x, float y) {
        return new Position(x, y);
    }
}
