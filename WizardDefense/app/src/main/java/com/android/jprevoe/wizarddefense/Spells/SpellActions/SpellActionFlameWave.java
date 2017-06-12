package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import android.content.Context;
import android.graphics.Canvas;

import com.android.jprevoe.wizarddefense.Actor.Actions.Helpers.UnitActionListener;
import com.android.jprevoe.wizarddefense.Actor.Animation.BasicAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.FlameWaveAttackAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/25/15.
 */
public class SpellActionFlameWave extends PlayerAction {
    public static final int ANIMATION_TIME = 200;
    public static final int PROJECTILE_TIME = 300;

    public SpellActionFlameWave(SpellDefiner.SpellDef spellDef) { super(spellDef); }

    @Override
    public boolean canPlayerUseAction(Player player, Position eventCoord) {
        return true;
    }

    @Override
    public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {
        int y = 0;
        for (int x = 0; x <= BattleGrid.GRIDSIZE_X; x++) {
            if (x != player.getPositionX()) {
                GridDrawer.drawTargettingReticule(drawingCanvas, context,
                        x, player.getPositionY() + y
                );
            }
        }
    }

    public void doAction(Player player) {
    }

    @Override
    public UnitAnimation getChildAnimation(Player player) {
        FlameWaveAttackAnimation anim =
                FlameWaveAttackAnimation.getFlameWaveAttackAnimation(
                        player.getPosition(),
                        ANIMATION_TIME);
        anim.addAnimationListener(FlameWaveAttackAnimation.ATTACK_FINISHED,
                new UnitActionListener(this, player));
        return anim;
    }

    @Override
    public void setTarget(Player player, Position target) {
        mTarget = player.getPosition().addPosition(0, 0);
    }

    private int getDistanceToEdge() {
        return (int)Math.max(mTarget.x, BattleGrid.GRIDSIZE_X - mTarget.x);
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        super.animationCallback(timeType, unit);
        for (int x = -1; x <= 1; x+= 2) {
            final Position target = mTarget.addPosition(x, 0);
            Projectile projectile = Projectile.create(
                    target, target,
                    new ProjectileAnimations.ExplosionAnimation(),
                    PROJECTILE_TIME);
            projectile.addListener(new FlameWaveCallback(unit, target, x));
            unit.getAttackHandler().addProjectile(projectile);
        }
    }

    private class FlameWaveCallback implements Callable {
        private Unit mUser;
        private Position mTarget;
        private int mDirection;

        public FlameWaveCallback(Unit user, Position target, int direction) {
            mUser = user;
            mTarget = target;
            mDirection = direction;
        }
        @Override
        public Object call() throws Exception {
            mUser.getAttackHandler().attackSquare(mTarget, Unit.UnitTeam.ENEMIES);
            if (0 <= mTarget.x + mDirection && mTarget.x + mDirection < BattleGrid.GRIDSIZE_X) {
                final Position target = mTarget.addPosition(mDirection, 0);
                Projectile projectile = Projectile.create(
                        target, target,
                        new ProjectileAnimations.ExplosionAnimation(),
                        PROJECTILE_TIME);
                projectile.addListener(new FlameWaveCallback(mUser, target, mDirection));
                mUser.getAttackHandler().addProjectile(projectile);
            }
            return null;
        }
    }


    @Override
    public long getAnimationTime(Player player) {
        return (int) (ANIMATION_TIME + (PROJECTILE_TIME * this.getDistanceToEdge()));
    }
}
