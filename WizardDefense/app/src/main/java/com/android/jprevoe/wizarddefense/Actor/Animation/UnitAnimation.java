package com.android.jprevoe.wizarddefense.Actor.Animation;

import android.support.v4.util.SimpleArrayMap;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.AnimationComponents.AnimationComponent;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jprevoe on 7/24/15.
 */
public class UnitAnimation {
    protected long mAnimTime;
    protected long mStartTime;
    protected SimpleArrayMap<Integer, List<UnitActionListener>> mActionListeners;
    protected ArrayList<AnimationComponent> mAnimationComponents;
    private int mCurrAnimationComponent = 0;
    protected ArrayList<AnimationCallbackTime> mAnimationCallbackTimes;
    protected float mPreviousAnimationTime = 0;

    protected class AnimationCallbackTime {
        private final double mTimePct;
        private final int mEventType;

        public AnimationCallbackTime(double timePct, int eventType) {
            mTimePct = timePct;
            mEventType = eventType;
        }

        public double getTimePct() {
            return mTimePct;
        }

        public int getEventType() {
            return mEventType;
        }
    }

    public UnitAnimation() {
        mActionListeners = new SimpleArrayMap<Integer, List<UnitActionListener>>();
        mAnimationCallbackTimes = new ArrayList<AnimationCallbackTime>();
        mAnimationComponents = new ArrayList<AnimationComponent>();
        mStartTime = 0;
    }

    public void animate(float currTime, Unit unit) {
        float timePct = 1;
        if (currTime < mAnimTime) {
            timePct = (currTime - mStartTime ) / (mAnimTime - mStartTime);
        }
        doAnimationBehaviour(timePct, unit);
    }

    protected void doAnimationBehaviour(float timePct, Unit unit) {
        if (mAnimationComponents == null) {
            return;
        }
        for (AnimationCallbackTime callback : mAnimationCallbackTimes) {
            if (mPreviousAnimationTime < callback.getTimePct() &&
                    callback.getTimePct() <= timePct) {
                doAnimationCallbacks(callback.getEventType());
            }
        }

        while (mAnimationComponents.size() > mCurrAnimationComponent) {
            AnimationComponent anim = mAnimationComponents.get(mCurrAnimationComponent);
            if (anim.getEndTimePct() < timePct) {
                anim.doAnimationBehaviour(1, unit);
                mCurrAnimationComponent++;
                continue;
            }
            double previousTimePct = 0;
            if (mCurrAnimationComponent != 0) {
                previousTimePct = mAnimationComponents
                        .get(mCurrAnimationComponent - 1)
                        .getEndTimePct();
            }
            double animPct =
                Math.max(0,
                    Math.min(1,
                            (timePct - previousTimePct) / (anim.getEndTimePct() - previousTimePct)
                    )
                );
            anim.doAnimationBehaviour((float)animPct, unit);
            break;
        }

        mPreviousAnimationTime = timePct;
    }

    public long getAnimationTime() {
        return mAnimTime;
    }

    public SpriteState getSpriteState(float currTime) {
        return new SpriteState(CharacterAnimation.IDLE, (currTime - mStartTime) / (mAnimTime - mStartTime));
    }

    public SpriteState getBetweenTurnSpriteState() {
        return new SpriteState(CharacterAnimation.IDLE, 0);
    }

    public void addAnimationListener(int timeType, UnitActionListener actionListener) {
        List<UnitActionListener> actionList = mActionListeners.get(timeType);
        if (actionList == null) {
            actionList = new ArrayList<UnitActionListener>();
        }
        actionList.add(actionListener);
        mActionListeners.put(timeType, actionList);
    }

    protected void doAnimationCallbacks(int timeType) {
        List<UnitActionListener> actionList = mActionListeners.get(timeType);
        if (actionList == null) {
            return;
        }
        for (UnitActionListener listener : actionList) {
            listener.doCallback(timeType);
        }
    }
}
