package com.android.jprevoe.wizarddefense.Battle;

import android.view.MotionEvent;

import com.android.jprevoe.wizarddefense.Actor.Position;

/**
 * Created by jprevoe on 11/14/15.
 */
public class WizardDefenseMotionEvent {
    private MotionEvent mMotionEvent;
    private Position mOffset;

    public WizardDefenseMotionEvent() {}

    public void setEvent(MotionEvent event) {
        mMotionEvent = event;
    }


    public float getX() {
        return mMotionEvent.getX() - mOffset.x;
    }

    public float getY() {
        return mMotionEvent.getY() - mOffset.y;
    }

    public void setOffset(Position offset) {
        mOffset = offset;
    }

    public int getActionMasked() {
        return mMotionEvent.getActionMasked();
    }

    public MotionEvent getMotionEvent() {
        return mMotionEvent;
    }
}
