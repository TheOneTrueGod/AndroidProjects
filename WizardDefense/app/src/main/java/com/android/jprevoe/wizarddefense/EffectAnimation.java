package com.android.jprevoe.wizarddefense;

import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;

import com.android.jprevoe.wizarddefense.Battle.UnitList;
import com.android.jprevoe.wizarddefense.Spells.ProjectileManager;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;

/**
 * Created by jprevoe on 7/24/15.
 */
public class EffectAnimation extends android.view.animation.Animation {
    private View mView;

    public EffectAnimation(View view) {
        mView = view;
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        doAnimation(interpolatedTime);
    }

    private void doAnimation(float interpolatedTime) {

    }

    public void invalidateView() {
        mView.invalidate();
    }

    public void incrementIteration() {

    }
}
