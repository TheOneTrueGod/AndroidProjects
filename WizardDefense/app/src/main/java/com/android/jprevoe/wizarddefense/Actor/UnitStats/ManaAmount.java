package com.android.jprevoe.wizarddefense.Actor.UnitStats;

import android.support.v4.util.SimpleArrayMap;

import java.util.ArrayList;

/**
 * Created by jprevoe on 11/7/15.
 */

public class ManaAmount {
    public static enum ManaType {
        PHYSICAL,
        FIRE,
    }

    SimpleArrayMap<ManaType, Integer> mAmounts;
    public ManaAmount() {
        mAmounts = new SimpleArrayMap<>();
        for (ManaType mt : ManaType.values()) {
            mAmounts.put(mt, 0);
        }
    }

    public ManaAmount set(ManaType type, Integer cost) {
        mAmounts.put(type, cost);
        return this;
    }

    public int get(ManaType type) {
        return mAmounts.get(type);
    }

    public boolean hasEnoughMana(ManaAmount spellCosts) {
        for (ManaType mt : ManaType.values()) {
            if (this.get(mt) < spellCosts.get(mt)) {
                return false;
            }
        }
        return true;
    }

    public ManaAmount chargeManaForSpell(ManaAmount spellCosts) {
        ArrayList<ManaType> typesNeeded = new ArrayList<>();
        for (ManaType mt : ManaType.values()) {
            if (this.get(mt) < spellCosts.get(mt)) {
                typesNeeded.add(mt);
            }
        }
        int selectedType = (int)Math.floor(Math.random() * typesNeeded.size());
        int amount = 1;
        this.mAmounts.put(
            typesNeeded.get(selectedType),
            this.mAmounts.get(typesNeeded.get(selectedType)) + amount
        );
        return (new ManaAmount()).set(typesNeeded.get(selectedType), amount);
    }

    public ManaAmount getManaNeededForSpell(ManaAmount spellCosts) {
        ArrayList<ManaType> typesNeeded = new ArrayList<>();
        for (ManaType mt : ManaType.values()) {
            if (this.get(mt) < spellCosts.get(mt)) {
                typesNeeded.add(mt);
            }
        }
        int selectedType = (int)Math.floor(Math.random() * typesNeeded.size());
        int amount = 1;

        return (new ManaAmount()).set(typesNeeded.get(selectedType), amount);
    }

    public void subtractMana(ManaAmount spellCosts) {
        for (ManaType mt : ManaType.values()) {
            this.set(mt, this.get(mt) - spellCosts.get(mt));
        }
    }

    public void addMana(ManaAmount manaAmount) {
        for (ManaType mt : ManaType.values()) {
            this.set(mt, this.get(mt) + manaAmount.get(mt));
        }
    }

    public float getMaxMana(ManaType fire) {
        return 5;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ManaAmount)) {
            return super.equals(o);
        }
        ManaAmount other = (ManaAmount) o;
        for (ManaType mt : ManaType.values()) {
            if (other.get(mt) != this.get(mt)) {
                return false;
            }
        }
        return true;
    }

    public int count() {
        int count = 0;
        for (ManaType mt : ManaType.values()) {
            count += get(mt);
        }
        return count;
    }
}