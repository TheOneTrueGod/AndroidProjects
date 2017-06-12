package com.android.jprevoe.wizarddefense.Spells;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.jprevoe.wizarddefense.CustomCallback.CustomCallback;
import com.android.jprevoe.wizarddefense.R;

import java.util.Vector;
import java.util.concurrent.Callable;

public class SpellHolder extends LinearLayout {
    private int SPELLS_TO_FORECAST = 4;
    private Vector<AbilityCard> mAbilityHolders;
    private Context mContext;
    private PlayerSpellList mPlayerSpellList;

    public SpellHolder(Context context) {
        super(context);
        mContext = context;
    }

    public SpellHolder(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    public SpellHolder(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public void initialize(LayoutInflater inflater,
                           ViewGroup container,
                           PlayerSpellList playerSpellList,
                           View mainView) {
        mPlayerSpellList = playerSpellList;
        if (mAbilityHolders == null) {
            mAbilityHolders = new Vector<>();
        }
        for (int i = 0; i < SPELLS_TO_FORECAST; i++) {
            AbilityCard ac = new AbilityCard(i <= 2, mContext, inflater, container, this, mainView);
            addView(ac.getView());
            mAbilityHolders.add(ac);
            ac.setAbility(playerSpellList.getSpell(i));
        }

        PlayerSpellList.SetSpellUseListener(new CustomCallback() {
            @Override
            public void call() {
                UpdateSpellList();
            }
        });

        invalidate();
    }

    public void unprimeAllSpells() {
        for (AbilityCard ac : mAbilityHolders) {
            ac.unprime();
        }
    }

    private void UpdateSpellList() {
        unprimeAllSpells();
        AbilityCard matchingCard = null;
        for (int i = 0; i < SPELLS_TO_FORECAST; i++) {
            mAbilityHolders.get(i).disable();
            if (matchingCard == null &&
                 !mAbilityHolders.get(i).isHoldingAbility(mPlayerSpellList.getSpell(i))) {
                matchingCard = mAbilityHolders.get(i);
            }
        }

        final AbilityCard usedCard = matchingCard;
        usedCard.animateOut(new CustomCallback() {
            @Override
            public void call() {
                usedCard.animateIn();
                for (int i = 0; i < SPELLS_TO_FORECAST; i++) {
                    mAbilityHolders.get(i).setAbility(mPlayerSpellList.getSpell(i));
                    mAbilityHolders.get(i).enable();
                }
            }
        });
    }
}
