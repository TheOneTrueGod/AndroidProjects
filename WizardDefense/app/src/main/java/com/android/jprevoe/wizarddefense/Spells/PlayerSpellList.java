package com.android.jprevoe.wizarddefense.Spells;

import com.android.jprevoe.wizarddefense.CustomCallback.CustomCallback;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;
import java.util.concurrent.Callable;

/**
 * Created by jprevoe on 8/7/15.
 */
public class PlayerSpellList {
    private static PlayerSpellList mPlayerSpellList;
    private static CustomCallback mSpellUseListener;
    private ArrayList<SpellDefiner.SpellDef> mSpells;
    private ArrayList<SpellDefiner.SpellEnum> mSpellBook;
    private SpellDefiner mSpellDefiner;
    private SpellDefiner.SpellDef mPrimedSpell = null;
    private CustomCallback mSpellPrimeCallback;

    public static PlayerSpellList getSpellList() {
        if (mPlayerSpellList == null) {
            mPlayerSpellList = new PlayerSpellList();
        }
        return mPlayerSpellList;
    }

    public static void SetSpellUseListener(CustomCallback callable) {
        mSpellUseListener = callable;
    }

    private PlayerSpellList() {
        mSpells = new ArrayList();
        mSpellDefiner = new SpellDefiner();
        mSpellBook = new ArrayList(
                Arrays.asList(SpellDefiner.SpellEnum.values()));
        addSpell(SpellDefiner.SpellEnum.FLAMEWAVE);
        addSpell(SpellDefiner.SpellEnum.FLAMEBLAST);
        for (int i = 0; i < mSpellBook.size(); i++) {
            addSpell(mSpellBook.get(i));
        }

        addSpell();
        addSpell();
        addSpell();
        addSpell();
    }

    public SpellDefiner.SpellDef getSpell(int index) {
        if (0 <= index && index < mSpells.size()) {
            return mSpells.get(index);
        }
        return null;
    }

    public void primeSpell(SpellDefiner.SpellDef spell) {
        if (spell == mPrimedSpell) {
            mPrimedSpell = null;
        } else {
            mPrimedSpell = spell;
        }
        this.mSpellPrimeCallback.call();
    }

    public SpellDefiner.SpellDef getSpellPrimed() {
        return mPrimedSpell;
    }

    public void useSpell() {
        if (mPrimedSpell != null) {
            mSpells.remove(mPrimedSpell);
            addSpell();
            mPrimedSpell = null;
            if (mSpellUseListener != null) {
                mSpellUseListener.call();
            }
        }
    }
    private void addSpell() {
        double spellIndex = Math.floor(mSpellBook.size() * Math.random());
        mSpells.add(mSpellDefiner.GetSpellDef(
                mSpellBook.get((int)spellIndex)
        ));
    }

    private void addSpell(SpellDefiner.SpellEnum spellID) {
        mSpells.add(mSpellDefiner.GetSpellDef(spellID));
    }

    public void onSpellPrime(CustomCallback callback) {
        this.mSpellPrimeCallback = callback;
    }
}
