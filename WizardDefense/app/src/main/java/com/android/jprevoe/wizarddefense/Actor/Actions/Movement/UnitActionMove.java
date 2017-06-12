package com.android.jprevoe.wizarddefense.Actor.Actions.Movement;

import com.android.jprevoe.wizarddefense.Actor.Actions.UnitAction;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.WalkAnimation;

import java.util.ArrayList;

/**
 * Created by jprevoe on 7/27/15.
 */
public class UnitActionMove extends UnitAction {
    protected final int mCooldownDuration;
    protected Position mTarget = null;

    public UnitActionMove(int cooldown) {
        super();
        mCooldownDuration = cooldown;
    }

    @Override
    public int getCooldownTurns() {
        return mCooldownDuration;
    }

    @Override
    public void pickTarget(Unit unit) {
        super.pickTarget(unit);
        mTarget = null;

        if (mTurnsBeforeUse > 0) {
            return;
        }

        float deltaY = -1;
        float deltaX = 0;
        if (unit.getMoveHandler().canUnitWalkOnSquare(
                unit,
                unit.getPosition().x + deltaX,
                unit.getPosition().y + deltaY)) {
            mTarget = Position.create(deltaX, deltaY);
        }
    }

    @Override
    public float getPriority() {
        if (mTarget != null) {
            return UnitAction.LOW_PRIORITY;
        }
        return UnitAction.NO_PRIORITY;
    }

    @Override
    public void doAction(Unit unit) {
        unit.getMoveHandler().handleUnitMovement(
                unit,
                unit.getPosition().x, unit.getPosition().y,
                mTarget.x, mTarget.y);
        mTurnsBeforeUse += getCooldownTurns();
    }

    @Override
    public UnitAnimation getAnimation(Unit unit) {
        return WalkAnimation.getWalkAnimation(Position.create(-mTarget.x, -mTarget.y));
    }

    public void slow(int slowAmount) {
        mTurnsBeforeUse += slowAmount;
    }

    protected ArrayList<Position> getPossibleMoveTargets(Unit unit) {
        int randomizer = Math.random() < 0.5 ? -1 : 1;

        ArrayList<Position> al = new ArrayList<Position>();
        al.add(Position.create(0, 1));
        al.add(Position.create(randomizer, 0));
        al.add(Position.create(-randomizer, 0));

        return al;
    }

    protected void pickTargetWalkAroundEverything(Unit unit) {
        ArrayList<Position> targets = this.getPossibleMoveTargets(unit);
        for (Position target : targets) {
            if (isValidMove(unit, target.x, target.y)) {
                mTarget = Position.create(target.x, target.y);
                return;
            }
        }
    }

    protected boolean isValidMove(Unit unit, float deltaX, float deltaY) {
        return unit.getMoveHandler().canUnitWalkOnSquare(
                unit,
                unit.getPosition().x + deltaX,
                unit.getPosition().y + deltaY);
    }

    protected boolean isFriendInSquare(Unit unit, float deltaX, float deltaY) {
        return unit.getMoveHandler().isFriendInSquare(
                unit,
                unit.getPosition().x + deltaX,
                unit.getPosition().y + deltaY);
    }
}
