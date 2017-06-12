package com.android.jprevoe.wizarddefense.Battle;

import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.UnitFactory;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;

import java.util.ArrayList;

/**
 * Created by jprevoe on 9/1/15.
 */
public class BattleAI {
    protected SpawnQueue mSpawnQueue;

    public BattleAI(UnitList unitList) {
        mSpawnQueue = new SpawnQueue(unitList);
    }

    public int advanceTurn(TurnHandler.TURN_TYPE turnType) {
        if (turnType == TurnHandler.TURN_TYPE.ENEMY) {
            return mSpawnQueue.spawnWave();
        }
        return 0;
    }

    public boolean areAllWavesComplete() {
        return mSpawnQueue.getWavesLeft() <= 0;
    }

    class SpawnQueue {
        private UnitList mUnitList;
        private ArrayList<SpawnPoint> mSpawnPoints;
        int mWaveCooldown = 0;
        int mWavesLeft = 10;

        public SpawnQueue(UnitList unitList) {
            mUnitList = unitList;
            mSpawnPoints = new ArrayList();
        }

        public int getWavesLeft() {
            return mWavesLeft;
        }

        public void restockSpawnQueue() {
            if (mWavesLeft > 0) {
                mWavesLeft -= 1;
            } else {
                return;
            }
            mWaveCooldown = 5;
            int waveLength = (int)Math.floor(Math.random() * 3) + 2;
            int spawnLeft = (int)Math.floor(Math.random() * (BattleGrid.GRIDSIZE_X - waveLength));
            int spawnRight = spawnLeft + waveLength;
            for (int y = 0; y < 2; y++) {
                for (int x = 0; x < BattleGrid.GRIDSIZE_X; x++) {
                    if (x < spawnLeft || x >= spawnRight || y >= 2) {

                    } else {
                        if (y == 0) {
                            addSpawnPoint(x, y, UnitFactory.UnitType.ARCHER);
                        } else {
                            if (x > spawnLeft && x < spawnRight - 1) {
                                addSpawnPoint(x, y, UnitFactory.UnitType.KNIGHT);
                            } else {
                                addSpawnPoint(x, y, UnitFactory.UnitType.MELEE);
                            }
                        }
                    }
                }
            }
        }

        protected void addSpawnPoint(int x, int y, UnitFactory.UnitType type) {
            mSpawnPoints.add(new SpawnPoint(Position.create(x, y), type));
        }

        public int spawnWave() {
            if (mWaveCooldown > 0) {
                mWaveCooldown -= 1;
            } else {
                restockSpawnQueue();
            }

            int maxAnimTime = 0;

            for (int i = 0; i < mSpawnPoints.size(); i++) {
                SpawnPoint sp = mSpawnPoints.get(i);
                int x = (int)sp.getTarget().x;
                int y = (int)sp.getTarget().y;
                if (BattleGrid.GetBattleGrid().getGridSquare(x, y).isEmpty()) {
                    int animTime = mUnitList.spawnUnit(x, y, sp.getUnitType());
                    maxAnimTime = Math.max(animTime, maxAnimTime);
                    mSpawnPoints.remove(i);
                    i--;
                }
            }
            return maxAnimTime;
        }

        private class SpawnPoint {
            private final Position mTarget;
            private final UnitFactory.UnitType mUnitType;

            public SpawnPoint(Position target, UnitFactory.UnitType unitType) {
                mTarget = target;
                mUnitType = unitType;
            }

            public Position getTarget() {
                return mTarget;
            }

            public UnitFactory.UnitType getUnitType() {
                return mUnitType;
            }
        }
    }
}
