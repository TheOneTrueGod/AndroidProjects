package com.android.jprevoe.wizarddefense.Battle;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitAttackHandler;
import com.android.jprevoe.wizarddefense.Actor.Animation.DeathAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitFactory;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;

/**
 * Created by jprevoe on 8/4/15.
 */
public class UnitList {
    private final UnitFactory mUnitFactory;
    private final UnitAttackHandler mUnitAttackHandler;
    private final UnitMoveHandler mUnitMoveHandler;
    private ArrayList<Unit> mUnitList;
    private BattleGrid mBattleGrid;

    public UnitList() {
        mBattleGrid = BattleGrid.GetBattleGrid();
        mUnitList = new ArrayList<Unit>();
        mUnitFactory = new UnitFactory();

        mUnitMoveHandler = new UnitMoveHandler();
        mUnitAttackHandler = new UnitAttackHandler();
    }

    public void initialize() {
        mUnitList.clear();
    }

    public Player spawnYou() {
        if (mUnitList == null || mBattleGrid == null) {
            Log.e("Dependency Error", "Units depend on Unit Array and BattleGrid");
        }
        int spawnX = mBattleGrid.getSizeX() / 2;
        int spawnY = mBattleGrid.getSizeY() - 2;
        Player player = mUnitFactory.createYou(spawnX, spawnY, mUnitMoveHandler, mUnitAttackHandler);
        mUnitList.add(player);
        mBattleGrid.addObjectToGrid(player, player.getPosition());
        return player;
    }

    public int spawnUnit(int spawnX, int spawnY, UnitFactory.UnitType unitType) {
        if (mBattleGrid.getGridSquare(spawnX, spawnY).getGridObjects().size() != 0) {
            return 0;
        }

        Unit unit = mUnitFactory.createUnit(
                spawnX, spawnY, mUnitMoveHandler, mUnitAttackHandler, unitType);
        if (unit != null) {
            mUnitList.add(unit);
            mBattleGrid.addObjectToGrid(unit, unit.getPosition());
        } else {
            Log.e("SpawnUnit", "ERROR: UNIT WOUND UP BEING NULL");
        }
        return (int)unit.getUnitStats().getSpawnAnimation().getAnimationTime();
    }

    public void drawOnCanvas(Canvas canvas, Context context, TurnHandler.TURN_TYPE currentTurnType) {
        for (Unit unit : mUnitList) {
            unit.drawOnCanvas(canvas, context, currentTurnType);
        }
    }

    public long doTurnActionsAndGetActionTime(TurnHandler.TURN_TYPE turnType) {
        long animationTime = 0;
        Collections.sort(mUnitList, new UnitComparator());
        for (Unit u: mUnitList) {
            if (u.getTurnType() == turnType) {
                u.doTurnActions();
                animationTime = Math.max(u.getAnimationTime(), animationTime);
            }
        }
        return animationTime;
    }

    public void animate(float currTime,
                        TurnHandler.TURN_TYPE currentTurnType) {
        for (Unit unit : mUnitList) {
            if (unit.getTurnType() == currentTurnType ||
                unit.isPlayingAnimationOutOfTurn()
            ) {
                unit.animate(currTime);
            }
        }
    }

    public void TurnEnding(TurnHandler.TURN_TYPE currentTurnType) {
        Vector<Unit> deadUnits = new Vector<Unit>();
        for (Unit unit : mUnitList) {
            unit.turnEnding(currentTurnType);
            if (unit.isDead()) {
                deadUnits.add(unit);
            }
        }
        for (Unit unit : deadUnits) {
            mBattleGrid.removeObjectFromGrid(unit, unit.getPosition());
            mUnitList.remove(unit);
        }
    }

    public long getTimeLeftInTurnAnimation(long currTime, TurnHandler.TURN_TYPE turnType) {
        long timeLeft = 0;
        for (Unit unit : mUnitList) {
            timeLeft = Math.max(timeLeft, unit.getTimeLeftInTurnAnimation(currTime, turnType));
        }
        return timeLeft;
    }

    public void TurnStarting(TurnHandler.TURN_TYPE currentTurnType) {
        Vector<Unit> deadUnits = new Vector<Unit>();
        for (Unit unit : mUnitList) {
            unit.turnStarting(currentTurnType);
            if (unit.isDead()) {
                deadUnits.add(unit);
            }
        }
        for (Unit unit : deadUnits) {
            mBattleGrid.removeObjectFromGrid(unit, unit.getPosition());
            mUnitList.remove(unit);
        }
    }

    public boolean areAllEnemiesDead() {
        for (Unit unit : mUnitList) {
            if (unit.getTurnType() == TurnHandler.TURN_TYPE.ENEMY) {
                return false;
            }
        }
        return true;
    }

    private class UnitComparator implements java.util.Comparator {
        @Override
        public int compare(Object lhs, Object rhs) {
            if (lhs instanceof Unit && rhs instanceof Unit) {
                return ((Float)((Unit)rhs).getPositionY()).compareTo(
                               ((Unit)lhs).getPositionY());
            }
            return 0;
        }
    }
}
