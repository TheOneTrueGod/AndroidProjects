package com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting;

import com.android.jprevoe.wizarddefense.Actor.ModifiablePosition;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

/**
 * Created by jprevoe on 9/12/15.
 */
public class SquareTargetable extends TargettableSquares {
    private final int mLeft;
    private final int mTop;
    private final int mRight;
    private final int mBottom;

    public SquareTargetable(int left, int top, int width, int height) {
        mLeft = left;
        mTop = top;
        mRight = left + width;
        mBottom = top + height;
        mSquares = width * height;
        mPosition = new ModifiablePosition();
    }

    @Override
    protected void setOffsetForIteratorIndex(int pos) {
        int width = Math.abs(mLeft - mRight);
        mPosition.x = pos % width + Math.min(mLeft, mRight);
        mPosition.y = (float) Math.floor(pos / width) + Math.min(mTop, mBottom);
    }

    @Override
    public boolean isValidTarget(Unit unit, int deltaX, int deltaY) {
        if (!(deltaX >= mLeft && deltaX < mRight &&
              deltaY >= mTop && deltaY < mBottom)) {
            return false;
        }
        return super.isValidTarget(unit, deltaX, deltaY);
    }
}
