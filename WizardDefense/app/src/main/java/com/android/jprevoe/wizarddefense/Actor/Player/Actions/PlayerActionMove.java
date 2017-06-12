package com.android.jprevoe.wizarddefense.Actor.Player.Actions;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.WalkAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;

/**
 * Created by jprevoe on 8/1/15.
 */
public class PlayerActionMove extends PlayerAction {
    private Position mTarget;
    private UnitMoveHandler mUnitMoveHandler;

    public PlayerActionMove(UnitMoveHandler unitMoveHandler) {
        super(null);
        mUnitMoveHandler = unitMoveHandler;
    }

    public void setTarget(Player player, Position target) {
        mTarget = target;
        mDone = false;
    }

    @Override
    public long getAnimationTime(Player player) {
        return getAnimation(player).getAnimationTime();
    }

    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        Position target = getMovementToSquare(eventCoord, player);
        if (CanPlayerMoveInDirection((int)target.x, (int)target.y, player)) {
            return true;
        }
        return false;
    }

    @Override
    public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {
        for (int i = -1; i <= 1; i += 2) {
            GridDrawer.drawTargettingReticule(drawingCanvas, context,
                    player.getPositionX() + i, player.getPositionY() + 0
            );

            GridDrawer.drawTargettingReticule(drawingCanvas, context,
                    player.getPositionX(), player.getPositionY() + i
            );
        }
    }

    public static Position getMovementToSquare(Position target, Player player) {
        int deltaX = (int)(target.x - player.getPositionX());
        int deltaY = (int)(target.y - player.getPositionY());
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX < 0) {
                return Position.create(-1, 0);
            } else {
                return Position.create(1, 0);
            }
        } else {
            if (deltaY < 0) {
                return Position.create(0, -1);
            } else {
                return Position.create(0, 1);
            }
        }
    }

    public boolean CanPlayerMoveInDirection(int deltaX, int deltaY, Player player) {
        return mUnitMoveHandler.canUnitWalkOnSquare(player,
                player.getPositionX() + deltaX, player.getPositionY() + deltaY);
    }

    @Override
    public void doAction(Player player) {
        player.getMoveHandler().handleUnitMovement(
                player,
                player.getPosition().x, player.getPosition().y,
                mTarget.x, mTarget.y);
    }


    @Override
    public UnitAnimation getChildAnimation(Player player) {
        return WalkAnimation.getWalkAnimation(Position.create(-mTarget.x, -mTarget.y));
    }


}
