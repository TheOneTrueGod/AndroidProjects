package com.android.jprevoe.wizarddefense.Grid.Structures;

import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.R;

/**
 * Created by jprevoe on 7/26/15.
 */
public class CastleWall extends GridStructure {
    private long mMaxHealth = 5;
    private long mHealth = mMaxHealth;

    public CastleWall() {
        super();
        mResourceId = R.drawable.terrain_wall;
    }

    @Override
    protected double getSheetHeight() {
        return 1;
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
    public boolean isDestructible() {
        return true;
    }

    @Override
    public void applyStructureEffect(BattleGrid.GridStructureEffect effect, float amount) {
        super.applyStructureEffect(effect, amount);
        switch (effect) {
            case DAMAGE:
                mHealth -= amount;
            break;
        }
    }

    public boolean ReadyToDestroy() {
        return mHealth <= 0;
    }

    @Override
    public boolean protectsUnitFromAttack() {
        return true;
    }
}
