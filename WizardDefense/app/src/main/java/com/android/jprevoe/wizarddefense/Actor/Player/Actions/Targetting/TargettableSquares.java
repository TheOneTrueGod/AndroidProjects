package com.android.jprevoe.wizarddefense.Actor.Player.Actions.Targetting;

import com.android.jprevoe.wizarddefense.Actor.ModifiablePosition;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;

/**
 * Created by jprevoe on 9/12/15.
 */
public abstract class TargettableSquares {
    protected int mIteratorPos = 0;
    protected int mSquares;
    protected ModifiablePosition mPosition;
    private Position mOffset;

    private boolean mCanOnlyTargetWalkable = false;

    public TargettableSquares() {
        mSquares = 0;
        mOffset = Position.create(0, 0);
    }

    public void reset() {
        this.mIteratorPos = 0;
    }

    public boolean hasNext() {
        return mIteratorPos < mSquares;
    }

    protected abstract void setOffsetForIteratorIndex(int pos);

    public ModifiablePosition getNext() {
        if (!hasNext()) {
            return mPosition;
        }
        setOffsetForIteratorIndex(mIteratorPos);
        mPosition.addPosition(mOffset.x, mOffset.y);
        mIteratorPos += 1;
        return mPosition;
    }

    public void setOffset(Position offset) {
        mOffset = offset;
    }

    public boolean isValidTarget(Unit unit, int deltaX, int deltaY) {
        if (mCanOnlyTargetWalkable) {
            BattleGrid.Grid.GridColumn.GridSquare targetSquare = BattleGrid.GetBattleGrid().getGridSquare(
                    unit.getPositionX() + deltaX, unit.getPositionY() + deltaY
            );
            if (targetSquare == null || !targetSquare.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public TargettableSquares canOnlyTargetWalkable() {
        mCanOnlyTargetWalkable = true;
        return this;
    }
}
