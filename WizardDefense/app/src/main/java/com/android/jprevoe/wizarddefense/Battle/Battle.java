package com.android.jprevoe.wizarddefense.Battle;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;

import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerActionChargeMana;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerActionHandler;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.BattleActivity;
import com.android.jprevoe.wizarddefense.CustomCallback.CustomCallback;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Logging.Logger;
import com.android.jprevoe.wizarddefense.R;
import com.android.jprevoe.wizarddefense.Spells.PlayerSpellList;
import com.android.jprevoe.wizarddefense.Spells.ProjectileManager;
import com.android.jprevoe.wizarddefense.Turn.TurnAnimationListener;
import com.android.jprevoe.wizarddefense.Turn.TurnHandler;
import com.android.jprevoe.wizarddefense.TurnAnimation;

/**
 * Created by jprevoe on 8/3/15.
 */
public class Battle {
    private final View mMainView;
    private final ProjectileManager mProjectileManager;
    private final BattleEffects mBattleEffects;

    private TurnAnimation mTurnAnimation;
    private boolean mTurnBeingTaken;
    private Player mPlayer;
    private BattleGrid mBattleGrid;
    private PlayerActionHandler mPlayerActionHandler;
    private Canvas mDrawingCanvas;
    private Bitmap mDrawingBitmap;
    private UnitList mUnitList;
    private BattleAI mBattleAI;

    public static Position CANVAS_OFFSET = Position.create(0, 0);
    private WizardDefenseMotionEvent mMotionEvent;
    private BattleActivity mActivity;

    public Battle(View v) {
        mMainView = v;
        mBattleGrid = BattleGrid.GetBattleGrid();
        mBattleEffects = BattleEffects.GetBattleEffects(mMainView);
        mUnitList = new UnitList();
        mBattleAI = new BattleAI(mUnitList);

        mPlayerActionHandler = new PlayerActionHandler();
        mProjectileManager = ProjectileManager.get();
    }

    public void initialize(BattleActivity activity) {
        mUnitList.initialize();
        mActivity = activity;
        mPlayer = mUnitList.spawnYou();
        mBattleGrid.addPlayer(mPlayer);
        mTurnAnimation = new TurnAnimation(mUnitList, mMainView);
        mTurnAnimation.setAnimationListener(
                new TurnAnimationListener(mTurnAnimation, this, mPlayer));
        mTurnBeingTaken = false;

        PlayerSpellList.getSpellList().onSpellPrime(new CustomCallback() {
            @Override
            public void call() {
            PlayerPrimedSpell();
            }
        });
    }

    public boolean isTurnBeingTaken() {
        return mTurnBeingTaken;
    }

    public void advanceTurn(TurnHandler.TURN_TYPE turnType) {
        if (isTurnBeingTaken() == false) {
            TurnStarting(turnType);
            mTurnAnimation.setCurrentTurnType(turnType);

            long animationTime = mUnitList.doTurnActionsAndGetActionTime(turnType);
            animationTime = Math.max(mBattleAI.advanceTurn(turnType), animationTime);

            mTurnAnimation.setDuration(animationTime);
            mTurnAnimation.resetIteration();
            mMainView.startAnimation(mTurnAnimation);
        }
    }

    public void handleClick(MotionEvent event) {
        if (mMotionEvent == null) {
            mMotionEvent = new WizardDefenseMotionEvent();
        }

        mMotionEvent.setEvent(event);
        mMotionEvent.setOffset(CANVAS_OFFSET);
        mPlayerActionHandler.handleClick(mMotionEvent, mPlayer);
        if (mPlayer.hasAction()) {
            advanceTurn(TurnHandler.TURN_TYPE.PLAYER);
        }
    }

    public void ChargeSpellForPlayer() {
        mPlayer.setSelectedAction(null);
        ManaAmount mana = mPlayer.getUnitStats().getManaNeededForSpell(
            PlayerSpellList.getSpellList().getSpellPrimed().getSpellCosts()
        );
        if (!mPlayer.canAffordPrimedSpell()) {
            PlayerSpellList.getSpellList().primeSpell(null);
        }
        mPlayer.setSelectedAction(mPlayer.getChargeAction(mana));
        advanceTurn(TurnHandler.TURN_TYPE.PLAYER);
    }

    private void PlayerPrimedSpell() {

    }

    public void drawOnCanvas(Canvas canvas, Context context) {
        if (mDrawingCanvas == null) {
            mDrawingBitmap = Bitmap.createBitmap(
                    (int)mBattleGrid.getWidth(), (int)mBattleGrid.getHeight(),
                    Bitmap.Config.ARGB_8888);
            mDrawingCanvas = new Canvas(mDrawingBitmap);
        }
        mDrawingCanvas.drawColor(context.getResources().getColor(R.color.black));
        Logger.startTimer("Drawing Canvas");
        mBattleGrid.drawOnCanvas(mDrawingCanvas, context);
        Logger.logTime(10);

        Logger.startTimer("Drawing Units");
        mUnitList.drawOnCanvas(mDrawingCanvas, context, mTurnAnimation.getCurrentTurnType());
        Logger.logTime(10);

        Logger.startTimer("Drawing Targeters");
        mPlayerActionHandler.drawValidTargetsOnCanvas(mPlayer, mDrawingCanvas, context);
        Logger.logTime(10);

        Logger.startTimer("Drawing Effects");
        mBattleEffects.drawOnCanvas(mDrawingCanvas, context);
        Logger.logTime(10);

        Logger.startTimer("Drawing Projectiles");
        mProjectileManager.drawOnCanvas(mDrawingCanvas, context);
        Logger.logTime(10);

        Logger.startTimer("Refreshing View");

        Position canvasOffset = getCanvasOffset(canvas);
        CANVAS_OFFSET = canvasOffset;
        canvas.drawBitmap(mDrawingBitmap, canvasOffset.x, canvasOffset.y, null);
        Logger.logTime(10);
    }

    private Position getCanvasOffset(Canvas canvas) {
        double xPct = mPlayer.getPositionX() / BattleGrid.GRIDSIZE_X;
        if (canvas.getWidth() > mDrawingBitmap.getWidth()) {
            xPct = 0.5;
        }
        int x = (int)((canvas.getWidth() - mDrawingBitmap.getWidth()) * xPct);

        double yPct = mPlayer.getPositionY() / BattleGrid.GRIDSIZE_Y;
        if (canvas.getHeight() > mDrawingBitmap.getHeight()) {
            yPct = 0.5;
        }
        int y = (int)((canvas.getHeight() - mDrawingBitmap.getHeight()) * yPct);

        return Position.create(x, y);
    }

    public void TurnStarting(TurnHandler.TURN_TYPE currentTurnType) {
        mTurnBeingTaken = true;
        mUnitList.TurnStarting(currentTurnType);
        mTurnAnimation.invalidateView();
    }

    public void TurnEnding(TurnHandler.TURN_TYPE currentTurnType) {
        if (checkForGameOverConditions()) {
            return;
        }
        mTurnBeingTaken = false;
        mUnitList.TurnEnding(currentTurnType);
        mProjectileManager.turnEnding();
        mTurnAnimation.invalidateView();
    }

    private boolean checkForGameOverConditions() {
        if (mPlayer.isDead()) {
            mActivity.battleEnding(false);
            return true;
        }

        if (mBattleAI.areAllWavesComplete() && mUnitList.areAllEnemiesDead()) {
            mActivity.battleEnding(true);
            return true;
        }
        return false;
    }

    public long getTimeLeftInTurnAnimation(long currTime, TurnHandler.TURN_TYPE turnType) {
        return Math.max(
            mProjectileManager.getTimeLeftInAnimation(currTime),
            mUnitList.getTimeLeftInTurnAnimation(currTime, turnType)
        );
    }

    public void onDestroy() {
        BattleGrid.onDestroy();
        ProjectileManager.onDestroy();
    }
}
