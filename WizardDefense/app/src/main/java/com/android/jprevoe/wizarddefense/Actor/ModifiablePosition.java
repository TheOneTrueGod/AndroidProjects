package com.android.jprevoe.wizarddefense.Actor;

/**
 * Created by jprevoe on 9/12/15.
 */
public class ModifiablePosition {
    public float x;
    public float y;

    public ModifiablePosition() { x = 0; y = 0;}

    public ModifiablePosition addPosition(float deltaX, float deltaY) {
        x += deltaX;
        y += deltaY;
        return this;
    }


    public Position getPosition() {
        return Position.create(this.x, this.y);
    }
}
