package com.android.jprevoe.wizarddefense.Turn;

import android.view.animation.Animation;

import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerActionChargeMana;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Battle.Battle;
import com.android.jprevoe.wizarddefense.TurnAnimation;

/**
 * Created by jprevoe on 8/3/15.
 */
public class TurnAnimationListener implements Animation.AnimationListener {
    private TurnAnimation mTurnAnimation;
    private Battle mBattle;
    private Player mPlayer;

    public TurnAnimationListener(TurnAnimation turnAnimation,
                                 Battle battle,
                                 Player player) {
        mTurnAnimation = turnAnimation;
        mBattle = battle;
        mPlayer = player;
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        long timeRemaining = mBattle.getTimeLeftInTurnAnimation(mTurnAnimation.getEndTime(), mTurnAnimation.getCurrentTurnType());
        if (timeRemaining > 0) {
            mTurnAnimation.incrementIteration();
            mTurnAnimation.reset();
            mTurnAnimation.setDuration(timeRemaining);
            mTurnAnimation.start();
            return;
        }
        mBattle.TurnEnding(mTurnAnimation.getCurrentTurnType());
        switch (mTurnAnimation.getCurrentTurnType()) {
            case PLAYER:
                mBattle.advanceTurn(TurnHandler.TURN_TYPE.ALLY);
                break;
            case ALLY:
                mBattle.advanceTurn(TurnHandler.TURN_TYPE.ENEMY);
                break;
            case ENEMY:
                boolean skipTurn = false;
                if (mPlayer.hasAction()) {
                    if (mPlayer.getSelectedAction() instanceof PlayerActionChargeMana) {
                        if (!mPlayer.canAffordPrimedSpell()) {
                            skipTurn = true;
                        }
                    } else {
                        skipTurn = true;
                    }
                }
                if (mPlayer.isDead()) {
                    skipTurn = true;
                }
                if (skipTurn) {
                    mBattle.advanceTurn(TurnHandler.TURN_TYPE.PLAYER);
                }
                break;
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}
}
