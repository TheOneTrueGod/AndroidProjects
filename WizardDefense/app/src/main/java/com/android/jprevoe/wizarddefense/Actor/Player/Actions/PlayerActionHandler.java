package com.android.jprevoe.wizarddefense.Actor.Player.Actions;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.VelocityTrackerCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;

import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Battle.WizardDefenseMotionEvent;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;
import com.android.jprevoe.wizarddefense.Spells.PlayerSpellList;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import static com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction.Direction;

/**
 * Created by jprevoe on 8/1/15.
 */
public class PlayerActionHandler {
    private static final double MIN_MOVEMENT = 40.0;
    private final UnitMoveHandler mUnitMoveHandler;
    private final PlayerActionMove mPlayerActionMove;
    private final PlayerActionWait mPlayerActionWait;
    private VelocityTracker mVelocityTracker;
    float startX = 0;
    float startY = 0;

    public PlayerActionHandler() {
        mUnitMoveHandler = new UnitMoveHandler();
        mPlayerActionMove = new PlayerActionMove(mUnitMoveHandler);
        mPlayerActionWait = new PlayerActionWait();
        mVelocityTracker = VelocityTracker.obtain();
    }

    public void handleClick(WizardDefenseMotionEvent event, Player player) {
        SpellDefiner.SpellDef primedSpell =
                PlayerSpellList.getSpellList().getSpellPrimed();
        if (primedSpell != null) {
            switch (event.getActionMasked()) {
                case MotionEvent.ACTION_DOWN:
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_UP:
                    primedSpell.doAction(BattleGrid.getGridCoordinate(event.getX(), event.getY()), player);
                    break;
            }
            return;
        }

        switch (event.getActionMasked()) {
            case MotionEvent.ACTION_DOWN:
                mVelocityTracker.addMovement(event.getMotionEvent());
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                mVelocityTracker.addMovement(event.getMotionEvent());
                break;
            case (MotionEvent.ACTION_UP):
                //int historySize = Math.max(event.getHistorySize() - 1, 0);
                float deltaX = event.getX() - this.startX;
                float deltaY = event.getY() - this.startY;
                if (deltaX * deltaX + deltaY * deltaY < MIN_MOVEMENT * MIN_MOVEMENT) {
                    doMovementTouch(BattleGrid.getGridCoordinate(event.getX(), event.getY()), player);
                } else {
                    if (Math.abs(deltaX) > Math.abs(deltaY)) {
                        deltaY = 0;
                        if (deltaX < 0) {
                            deltaX = -1;
                        } else if (deltaX > 0) {
                            deltaX = 1;
                        }
                    } else {
                        deltaX = 0;
                        if (deltaY < 0) {
                            deltaY = -1;
                        } else if (deltaY > 0) {
                            deltaY = 1;
                        }
                    }
                    doMovementSwipe((int) deltaX, (int)deltaY, player);
                }
                break;
        }
    }

    private void doMovementSwipe(int deltaX, int deltaY, Player player) {
        if (deltaX == 0 && deltaY == 0) {
            mPlayerActionWait.setTurns(1);
            player.setSelectedAction(mPlayerActionWait);
            return;
        }
        Position target = (player.getPosition().addPosition(deltaX, deltaY));
        if (mPlayerActionMove.canPlayerUseAction(player, target)) {
            mPlayerActionMove.setTarget(player,
                    mPlayerActionMove.getMovementToSquare(target, player));
            mPlayerActionMove.restart();
            player.setSelectedAction(mPlayerActionMove);
        }
    }

    private void doMovementTouch(Position eventCoord, Player player) {
        int deltaX = (int)(eventCoord.x - player.getPositionX());
        int deltaY = (int)(eventCoord.y - player.getPositionY());
        if (deltaX == 0 && deltaY == 0) {
            mPlayerActionWait.setTurns(1);
            player.setSelectedAction(mPlayerActionWait);
            return;
        }
        if (mPlayerActionMove.canPlayerUseAction(player, eventCoord)) {
            mPlayerActionMove.setTarget(player,
                    mPlayerActionMove.getMovementToSquare(eventCoord, player));
            player.setSelectedAction(mPlayerActionMove);
        }
    }

    public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {
        SpellDefiner.SpellDef primedSpell =
                PlayerSpellList.getSpellList().getSpellPrimed();

        if (primedSpell != null) {
            primedSpell.drawValidTargetsOnCanvas(player, drawingCanvas, context);
        }
    }
}
