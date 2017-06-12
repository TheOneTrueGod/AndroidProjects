package com.android.jprevoe.wizarddefense;

import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Battle.UnitList;
import com.android.jprevoe.wizarddefense.Spells.ProjectileManager;
import com.android.jprevoe.wizarddefense.Turn.TurnAnimationListener;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;

import java.util.Vector;

/**
 * Created by jprevoe on 7/24/15.
 */
public class TurnAnimation extends android.view.animation.Animation {
    private final ProjectileManager mProjectileMgr;
    private View mView;
    private long mDurationMillis;
    private TurnHandler.TURN_TYPE mCurrentTurnType;
    private UnitList mUnitList;
    private long mElapsedTime;
    private static float mCurrTime;

    public TurnAnimation(UnitList unitList,
                         View view) {
        mUnitList = unitList;
        mView = view;
        mCurrentTurnType = TurnHandler.TURN_TYPE.ENEMY;
        mProjectileMgr = ProjectileManager.get();
    }

    @Override
    public void setDuration(long durationMillis) {
        super.setDuration(durationMillis);
        setInterpolator(new LinearInterpolator());
        mDurationMillis = durationMillis;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        animateForTurn(interpolatedTime);
    }

    public void animateForTurn(float interpolatedTime) {
        float currTime = (interpolatedTime * mDurationMillis) + mElapsedTime;
        TurnAnimation.mCurrTime = currTime;
        mUnitList.animate(currTime, mCurrentTurnType);
        mProjectileMgr.animate(currTime);
        mView.invalidate();
    }

    public void setCurrentTurnType(TurnHandler.TURN_TYPE currentTurnType) {
        mCurrentTurnType = currentTurnType;
    }

    public TurnHandler.TURN_TYPE getCurrentTurnType() {
        return mCurrentTurnType;
    }

    public void resetIteration() {
        mElapsedTime = 0;
    }

    public void incrementIteration() {
        mElapsedTime += mDurationMillis;
    }

    public long getEndTime() {
        return mDurationMillis + mElapsedTime;
    }

    public static float getCurrAnimationTime() {
        return mCurrTime;
    }

    public void invalidateView() {
        mView.invalidate();
    }
}
