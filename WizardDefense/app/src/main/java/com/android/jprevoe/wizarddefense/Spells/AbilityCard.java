package com.android.jprevoe.wizarddefense.Spells;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.android.jprevoe.wizarddefense.Actor.ManaDrawer;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.CustomCallback.CustomCallback;
import com.android.jprevoe.wizarddefense.R;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

/**
 * Created by jprevoe on 8/6/15.
 */
public class AbilityCard {
    private final SpellHolder mSpellHolder;
    private final View mMainView;
    private FrameLayout mInflatedView;
    private RelativeLayout mBackgroundImage;
    private ImageView mCardImage;
    private TextView mCardTitle;
    private LinearLayout mManaCostContainer;
    private SpellDefiner.SpellDef mSpell;
    private Boolean mSelected = false;
    private Boolean mPrimed = false;
    private Context mContext;
    private boolean mEnabled = true;

    private final int NON_PRIMED_TRANSLATION = 10;

    public AbilityCard(Boolean selected,
                       Context context,
                       LayoutInflater inflater,
                       ViewGroup container,
                       SpellHolder spellHolder,
                       View mainView) {
        mMainView = mainView;
        mInflatedView = (FrameLayout) inflater.inflate(R.layout.ability_image, container, false);
        mSelected = selected;
        mContext = context;
        updateCardSelection();
        if (mInflatedView instanceof FrameLayout) {
            mCardImage = (ImageView) mInflatedView.findViewById(R.id.card_image);
            mBackgroundImage = (RelativeLayout) mInflatedView.findViewById(R.id.background_image);
            mCardTitle = (TextView) mInflatedView.findViewById(R.id.card_title);
            mManaCostContainer = (LinearLayout) mInflatedView.findViewById(R.id.mana_cost_container);
        } else {
            Log.e("AbilityCard", "Inflater failed on me. :(");
        }

        mInflatedView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if (!mEnabled) {
                return;
            }
            if (mSelected) {
                PlayerSpellList.getSpellList().primeSpell(mSpell);
                prime();
            }
            mMainView.invalidate();
            }
        });

        mSpellHolder = spellHolder;
    }

    private void updateCardSelection() {
        ViewGroup.LayoutParams params = mInflatedView.getLayoutParams();
        mInflatedView.setAlpha((float) 1);
        mInflatedView.setTranslationY(0);
        if (mSpell != null && PlayerSpellList.getSpellList().getSpellPrimed() == this.mSpell) {
            mInflatedView.setBackgroundColor(
                    mContext.getResources().getColor(R.color.red));
        } else if (mSelected == true) {
            mInflatedView.setTranslationY(NON_PRIMED_TRANSLATION);
            if (PlayerSpellList.getSpellList().getSpellPrimed() != null) {
                mInflatedView.setAlpha((float) 0.7);
            }
            mInflatedView.setBackgroundColor(
                    mContext.getResources().getColor(R.color.white));
        } else {
            mInflatedView.setTranslationY(NON_PRIMED_TRANSLATION);
            mInflatedView.setAlpha((float) 0.3);
            mInflatedView.setBackgroundColor(
                    mContext.getResources().getColor(R.color.black));
        }
        mInflatedView.setLayoutParams(params);
    }

    public FrameLayout getView() {
        return mInflatedView;
    }

    public boolean setAbility(SpellDefiner.SpellDef spell) {
        if (spell != mSpell) {
            mCardImage.setImageResource(spell.getSpellIcon());
            switch (spell.getSpellType()) {
                case Fire:
                    mBackgroundImage.setBackgroundResource(R.drawable.card_background_fire);
                    break;
                case Weapon:
                default:
                    mBackgroundImage.setBackgroundResource(R.drawable.card_background_weapon);
                    break;
            }
            mCardTitle.setText(spell.getSpellName());

            int castTime = spell.getCastTime();
            if (mSpell == null || castTime != mSpell.getCastTime()) {
                mManaCostContainer.removeAllViews();
                ManaDrawer.setContext(mContext);
                for (int i = 0; i < castTime; i++) {
                    ImageView iv = new ImageView(mContext);
                    iv.setImageResource(R.drawable.icon_clock);
                    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                            LinearLayout.LayoutParams.FILL_PARENT,
                            LinearLayout.LayoutParams.FILL_PARENT, 1.0f);
                    params.setMargins(1, 2, 1, 2);
                    iv.setLayoutParams(params);
                    mManaCostContainer.addView(iv);
                }

                if (castTime == 0) {
                    mManaCostContainer.setVisibility(View.INVISIBLE);
                } else {
                    mManaCostContainer.setVisibility(View.VISIBLE);
                }
            }

            mSpell = spell;
            return true;
        }
        return false;
    }

    public void prime() {
        boolean wasPrimed = mPrimed;
        mSpellHolder.unprimeAllSpells();
        if (!wasPrimed) {
            mPrimed = true;
        }
        updateCardSelection();
    }

    public void unprime() {
        mPrimed = false;
        updateCardSelection();
    }

    public boolean isHoldingAbility(SpellDefiner.SpellDef spell) {
        return spell == mSpell;
    }

    public void animateIn() {
        final LinearLayout.LayoutParams lp =
                new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.MATCH_PARENT);
        final float originalWidth = (mInflatedView.getWidth());
        lp.setMargins((int) (originalWidth), 0, 0, 0);
        mInflatedView.setLayoutParams(lp);
        mInflatedView.setAlpha(1);
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                lp.setMargins((int) (originalWidth * (1 - interpolatedTime)), 0, 0, 0);
                mInflatedView.setLayoutParams(lp);
            }
        };
        a.setDuration(600); // in ms
        a.setInterpolator(new BounceInterpolator());
        mInflatedView.startAnimation(a);
    }

    public void disable() {
        mEnabled = false;
    }

    public void enable() {
        mEnabled = true;
    }

    public void animateOut(final CustomCallback customCallback) {
        Animation a = new Animation() {
            @Override
            protected void applyTransformation(float interpolatedTime, Transformation t) {
                mInflatedView.setAlpha(1 - interpolatedTime);
            }
        };
        a.setDuration(400); // in ms
        a.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                customCallback.call();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mInflatedView.startAnimation(a);
    }
}
