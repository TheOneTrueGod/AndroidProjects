package com.android.jprevoe.wizarddefense.Actor.Player.Actions;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Animation.NoAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;

/**
 * Created by jprevoe on 8/2/15.
 */
public class PlayerActionWait extends PlayerAction {
    private int mTurns = 0;

    public PlayerActionWait() {
        super(null);
    }

    public void setTurns(int turns) {
        mTurns = turns;
    }

    @Override
    public boolean IsDone() {
        return mTurns <= 0;
    }

    public UnitAnimation getAnimation() {
        return new NoAnimation();
    }

    @Override
    public void doAction(Player player) {
        super.doAction(player);
        mTurns -= 1;
    }

    public UnitAnimation getChildAnimation(Player player) {
        return null;
    }

    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        return true;
    }

    @Override
    public long getAnimationTime(Player player) {
        return 0;
    }

    @Override
    public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {
        GridDrawer.drawTargettingReticule(drawingCanvas, context,
                player.getPositionX(), player.getPositionY()
        );
    }
}
