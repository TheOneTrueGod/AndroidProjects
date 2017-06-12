package com.android.jprevoe.wizarddefense.Actor.UnitStats;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v4.util.SimpleArrayMap;

import com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
import com.android.jprevoe.wizarddefense.Actor.Animation.UnitAnimation;
import com.android.jprevoe.wizarddefense.Actor.Animation.WalkAnimation;
import com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
import com.android.jprevoe.wizarddefense.Actor.HealthBarDrawer;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.Unit;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.Grid.GridDrawer;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount.ManaType.*;

/**
 * Created by jprevoe on 7/27/15.
 */
public abstract class UnitStats {

    protected Unit mUnit;
    protected float mHealth;
    private float mMaxHealth;

    protected ManaAmount mMana;

    protected SimpleArrayMap<CharacterAnimation, String[]> mAnimations;

    public void initialize(Unit unit) {
        mUnit = unit;
        mHealth = GetStatHealth();
        mMaxHealth = mHealth;
        mMana = new ManaAmount();

        mAnimations = new SimpleArrayMap();
    }

    public void drawOnCanvas(Canvas canvas, Context context, SpriteState spriteState) {
        Paint paint = new Paint();

        GridDrawer.drawImage(canvas,
                UnitSpriteCreator.get().createFromFullImage(
                        getCurrentAnimationFrame(spriteState), this.getImageScale()
                ),
                mUnit.getPosition().x + mUnit.getAnimationOffset().x,
                mUnit.getPosition().y + mUnit.getAnimationOffset().y,
                paint,
                BattleGrid.SQUARESIZE_X, BattleGrid.SQUARESIZE_Y);
    }

    protected String getCurrentAnimationFrame(SpriteState spriteState) {
        if (mAnimations.containsKey(spriteState.getAnimation())) {
            String[] frames = mAnimations.get(spriteState.getAnimation());
            int frameIndex = Math.max(0, Math.min(
                    (int) Math.floor(frames.length * spriteState.getPctDone()), frames.length - 1
            ));
            return frames[frameIndex];
        }
        if (mAnimations.containsKey(CharacterAnimation.IDLE)) {
            spriteState.setAnimation(CharacterAnimation.IDLE);
            return getCurrentAnimationFrame(spriteState);
        }
        return "character_melee";
    }

    public void damage(float amount) {
        mHealth -= amount;
    }

    public float getHealth() {
        return Math.max(mHealth, 0);
    }

    public float getMaxHealth() {
        return Math.max(mMaxHealth, 1);
    }

    protected float GetStatHealth() {
        return 10;
    }

    public void drawHealthOnCanvas(Canvas canvas, Context context) {
        /*HealthBarDrawer.drawHealthBar(
                mUnit,
                getHealth(), getMaxHealth(),
                canvas, context);*/
    }

    public UnitAnimation getSpawnAnimation() {
        return WalkAnimation.getWalkAnimation(
                Position.create(0, -mUnit.getPositionY() - 1)
        );
    }

    public void drawManaOnCanvas(Canvas canvas, Context context) {

    }

    public boolean hasEnoughManaForSpell(SpellDefiner.SpellDef spellPrimed) {
        if (spellPrimed == null) {
            return true;
        }
        return mMana.hasEnoughMana(spellPrimed.getSpellCosts());
    }

    public ManaAmount chargeManaForSpell(ManaAmount spellCosts) {
        return mMana.chargeManaForSpell(spellCosts);
    }

    public ManaAmount getManaNeededForSpell(ManaAmount spellCosts) {
        return mMana.getManaNeededForSpell(spellCosts);
    }

    public void payCost(ManaAmount spellCosts) {
        mMana.subtractMana(spellCosts);
    }

    public void addMana(ManaAmount manaAmount) { mMana.addMana(manaAmount); }

    public float getImageScale() {
        return 1;
    }

    public void onDeathTrigger() {}
}
