package com.android.jprevoe.wizarddefense.Actor.Actions.Attacks;

import com.android.jprevoe.wizarddefense.Actor.Actions.Attacks.Targetters.BasicActionTargetter;
import com.android.jprevoe.wizarddefense.Actor.Actions.UnitAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.Projectile;
import com.android.jprevoe.wizarddefense.Spells.Projectiles.ProjectileAnimations;

import java.util.ArrayList;
import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/2/15.
 */
public class UnitActionBomberAttack extends UnitActionAttack {
    public static final int PROJECTILE_TIME = 300;
    public UnitActionBomberAttack() {
        super();
        mWindupTurns = 3;
        mActionTargetter = new BasicActionTargetter(1);
    }

    @Override
    public float getPriority() {
        if (mTarget != null) {
            return UnitAction.VERY_HIGH_PRIORITY;
        }
        return UnitAction.NO_PRIORITY;
    }

    @Override
    public void animationCallback(int timeType, final Unit unit) {
        for (int x = -1; x <= 1; x++) {
            for (int y = 0; y <= 1; y++) {
                final Position target = unit.getPosition().addPosition(x, y);
                Projectile projectile = Projectile.create(target, target,
                        new ProjectileAnimations.ExplosionAnimation(),
                        PROJECTILE_TIME);
                projectile.addListener(new Callable() {
                    @Override
                    public Object call() throws Exception {
                        unit.getAttackHandler().attackSquare(target, Unit.UnitTeam.PLAYER, 2, true);
                        return null;
                    }
                });

                unit.getAttackHandler().addProjectile(projectile);
            }
        }
        unit.damage(99999);
    }

    @Override
    public boolean canHitUnit(Object gridObject) {
        return false;
    }

    public void pickTarget(Unit unit) {
        super.pickTarget(unit);
        mTarget = null;

        if (mTurnsBeforeUse > 0) {
            return;
        }

        ArrayList<Position> targets = mActionTargetter.getTargetPositions(unit);
        for (Position target : targets) {
            if (unit.getAttackHandler().canUnitAttackSquare(
                    this, target.x, target.y)) {
                mTarget = unit.getPosition();
                break;
            }
        }
    }
}
