package com.android.jprevoe.wizarddefense.Actor.Player;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitAttackHandler;
import com.android.jprevoe.wizarddefense.Actor.Animation.NoAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerActionChargeMana;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.UnitStats;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;
import com.android.jprevoe.wizarddefense.Spells.PlayerSpellList;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;

/**
 * Created by jprevoe on 7/31/15.
 */
public class Player extends Unit {
    private PlayerAction mSelectedAction;
    private PlayerActionChargeMana mChargeAction;

    public Player(Position position,
                  UnitMoveHandler unitMoveHandler,
                  UnitAttackHandler unitAttackHandler,
                  UnitStats unitStats) {
        super(position, unitMoveHandler, unitAttackHandler, unitStats);
    }

    public PlayerAction getSelectedAction() {
        return mSelectedAction;
    }

    public void setSelectedAction(PlayerAction selectedAction) {
        mSelectedAction = selectedAction;
    }

    public boolean hasAction() {
        if (mSelectedAction == null) {
            return false;
        }
        if (mSelectedAction.IsDone()) {
            return false;
        }
        return true;
    }

    @Override
    public long getAnimationTime() {
        if (getSelectedAction() == null) {
            return 0;
        }
        return getSelectedAction().getAnimationTime(this);
    }

    public void doTurnActions() {
        if (mSelectedAction == null) {
            mCurrAnimation = NoAnimation.getNoAnimation();
        } else {
            mSelectedAction.doAction(this);
            mCurrAnimation = mSelectedAction.getAnimation(this);
        }
        if (mSelectedAction != null) {
            mSelectedAction.payCost(this);
            mSelectedAction.advanceTurn();
        }
    }

    public TurnHandler.TURN_TYPE getTurnType() {
        return TurnHandler.TURN_TYPE.PLAYER;
    }

    public UnitTeam getUnitTeam() {
        return UnitTeam.PLAYER;
    }

    public boolean canAffordPrimedSpell() {
        return mUnitStats.hasEnoughManaForSpell(PlayerSpellList.getSpellList().getSpellPrimed());
    }

    public PlayerAction getChargeAction(ManaAmount mana) {
        if (mChargeAction == null) {
            mChargeAction = new PlayerActionChargeMana(getMoveHandler());
        }

        mChargeAction.setMana(mana);
        return mChargeAction;
    }
}
