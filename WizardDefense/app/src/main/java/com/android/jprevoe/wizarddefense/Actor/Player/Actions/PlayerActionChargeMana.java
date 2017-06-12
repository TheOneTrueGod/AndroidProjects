package com.android.jprevoe.wizarddefense.Actor.Player.Actions;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.ChargeManaAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.WalkAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.Grid.UnitMoveHandler;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/1/15.
 */
public class PlayerActionChargeMana extends PlayerAction {
    private static final long ANIMATION_TIME = 400;
    private static final long PROJECTILE_TIME = 200;
    private Position mTarget;
    private UnitMoveHandler mUnitMoveHandler;
    private ManaAmount mManaAmount;

    public PlayerActionChargeMana(UnitMoveHandler unitMoveHandler) {
        super(null);
        mUnitMoveHandler = unitMoveHandler;
    }

    public void setMana(ManaAmount mana) {
        mManaAmount = mana;
        mDone = false;
    }

    @Override
    public long getAnimationTime(Player player) {
        return (int) (ANIMATION_TIME + (PROJECTILE_TIME + ANIMATION_TIME
                - ANIMATION_TIME * ChargeManaAnimation.MOVEMENT_FINISHED_TIME));
    }

    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        return true;
    }

    @Override
    public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {

    }

    @Override
    public void doAction(Player player) {

    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        ChargeManaAnimation anim =
            ChargeManaAnimation.getChargeManaAnimation(player.getPosition(), ANIMATION_TIME);

        anim.addAnimationListener(ChargeManaAnimation.ATTACK_FINISHED,
                new UnitActionListener(this, player));

        return anim;
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);

        int total = 0;
        final ArrayList<ManaAmount.ManaType> manaTypes = new ArrayList<>();
        Random rand = new Random();

        for (ManaAmount.ManaType mt : ManaAmount.ManaType.values()) {
            for (int i = 0; i < mManaAmount.get(mt); i++) {
                int randint = 0;
                if (manaTypes.size() > 0) {
                    randint = rand.nextInt(manaTypes.size());
                }

                manaTypes.add(randint, mt);
                total ++;
            }
        }

        double offset = rand.nextDouble() * Math.PI * 2;
        for (int i = 0; i < manaTypes.size(); i++) {
            final int index = i;
            final ManaAmount.ManaType mt = manaTypes.get(index);

            double ang = Math.PI * 2 / total * i + offset;

            Projectile projectile = Projectile.create(
                unit.getPosition().addPosition(
                        (float) (Math.cos(ang) * 2),
                        (float) (Math.sin(ang) * 2)
                ),
                unit.getPosition(),
                new ProjectileAnimations.CrystalAnimation(mt),
                PROJECTILE_TIME);

            projectile.addListener(new Callable() {
                @Override
                public Object call() throws Exception {
                    unit.addMana(new ManaAmount().set(mt, 1));
                    return null;
                }
            });
            unit.getAttackHandler().addProjectile(projectile);
        }


    }
}
