package com.android.jprevoe.wizarddefense.Actor.Actions.Movement;

import com.android.jprevoe.wizarddefense.Actor.Actions.UnitAction;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Unit;

/**
 * Created by jprevoe on 8/29/15.
 */
public class SpawnAction extends UnitAction {
    private boolean mSpawned = false;

    public static SpawnAction GetSpawnAction() {
        return new SpawnAction();
    }

    private SpawnAction() {

    }

    @Override
    public void doAction(Unit unit) {
        mSpawned = true;
    }

    @Override
    public boolean ActionComplete() {
        return mSpawned;
    }

    @Override
    public float getPriority() {
        return UnitAction.MAX_PRIORITY;
    }

    @Override
    public UnitAnimation getAnimation(Unit unit) {
        return unit.getUnitStats().getSpawnAnimation();
    }
}
