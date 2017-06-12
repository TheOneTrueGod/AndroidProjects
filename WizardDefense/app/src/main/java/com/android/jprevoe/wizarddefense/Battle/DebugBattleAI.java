package com.android.jprevoe.wizarddefense.Battle;

import com.android.jprevoe.wizarddefense.Actor.UnitFactory;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

/**
 * Created by jprevoe on 12/13/15.
 */
public class DebugBattleAI extends BattleAI {
    public DebugBattleAI(UnitList unitList) {
        super(unitList);
        mSpawnQueue = new DebugSpawnQueue(unitList);
    }

    private class DebugSpawnQueue extends SpawnQueue {
        public DebugSpawnQueue(UnitList unitList) {
            super(unitList);
        }

        public void restockSpawnQueue() {
            if (mWavesLeft > 0) {
                mWavesLeft -= 1;
            } else {
                return;
            }
            mWaveCooldown = 10;
            //addSpawnPoint(4, 5, 2);
            addSpawnPoint(5, 5, UnitFactory.UnitType.ARCHER);
            //addSpawnPoint(6, 5, 2);
        }
    }
}
