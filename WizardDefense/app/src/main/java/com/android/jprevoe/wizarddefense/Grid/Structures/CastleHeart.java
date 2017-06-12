package com.android.jprevoe.wizarddefense.Grid.Structures;

import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 2/17/16.
 */
public class CastleHeart extends GridStructure {

    private Unit mLinkedUnit;
    private Position mPosition;

    public CastleHeart(int x, int y) {
        super();
        mPosition = Position.create(x, y);
        mResourceId = R.drawable.terrain_castle_heart;
    }

    public void setLinkedUnit(Unit linkedUnit) {
        mLinkedUnit = linkedUnit;
    }

    @Override
    protected double getSheetHeight() {
        return 1;
    }

    @Override
    public boolean protectsUnitFromAttack() {
        return true;
    }

    @Override
    public boolean isDestructible() {
        return true;
    }

    @Override
    public boolean canWalkOn(Unit unit) {
        if (unit instanceof Player) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void applyStructureEffect(BattleGrid.GridStructureEffect effect, float amount) {
        super.applyStructureEffect(effect, amount);
        switch (effect) {
            case DAMAGE:
                if (mLinkedUnit != null) {
                    mLinkedUnit.damage(amount);
                }
                break;
        }
    }

    public Position getPosition() {
        return mPosition;
    }
}
