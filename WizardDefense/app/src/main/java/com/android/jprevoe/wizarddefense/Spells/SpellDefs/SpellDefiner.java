package com.android.jprevoe.wizarddefense.Spells.SpellDefs;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;

import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction;
import com.android.jprevoe.wizarddefense.Actor.Player.Player;
import com.android.jprevoe.wizarddefense.Actor.Position;
import com.android.jprevoe.wizarddefense.Actor.UnitStats.ManaAmount;
import com.android.jprevoe.wizarddefense.Grid.BattleGrid;
import com.android.jprevoe.wizarddefense.R;
import com.android.jprevoe.wizarddefense.Spells.PlayerSpellList;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionArrow;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionBroadsword;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionDagger;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionDoubleStrike;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionFireDash;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionFirestorm;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionFlameWave;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionFlameblast;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionLongsword;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionShuriken;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionSpear;
import com.android.jprevoe.wizarddefense.Spells.SpellActions.SpellActionTripleArrow;

/**
 * Created by jprevoe on 8/7/15.
 */
public class SpellDefiner {
    public enum SpellType {
        Weapon,
        Fire
    }

    public enum SpellEnum {
        LONGSWORD, SHURIKEN, ARROW, TRIPLE_ARROW, SPEAR, BROADSWORD, DAGGER, FLAMEWAVE, FLAMEBLAST,
        FIRESTORM, DOUBLESTRIKE, FIREDASH
    }
    public SpellDef GetSpellDef(SpellEnum i) {
        switch (i) {
            case LONGSWORD:
                return new SpellDefLongsword();
            case SHURIKEN:
                return new SpellDefShuriken();
            case ARROW:
                return new SpellDefArrow();
            case TRIPLE_ARROW:
                return new SpellDefTripleArrow();
            case SPEAR:
                return new SpellDefSpear();
            case BROADSWORD:
                return new SpellDefBroadsword();
            case DAGGER:
                return new SpellDefDagger();
            case FLAMEWAVE:
                return new SpellDefFlameWave();
            case FLAMEBLAST:
                return new SpellDefFlameblast();
            case FIRESTORM:
                return new SpellDefFirestorm();
            case FIREDASH:
                return new SpellDefFireDash();
            case DOUBLESTRIKE:
                return new SpellDefDoubleStrike();
        }
        return new SpellDefLongsword();
    }

    public abstract class SpellDef {
        protected int mSpellIcon;
        protected PlayerAction mSpellAction;
        protected String mSpellName;
        protected SpellType mSpellType;
        protected int mCastTime;
        protected ManaAmount mSpellCosts = new ManaAmount();

        public SpellDef() { mSpellName = "EMPTY NAME"; }

        public int getSpellIcon() {
            return mSpellIcon;
        }
        public PlayerAction getSpellAction() {
            return mSpellAction;
        }

        public void doAction(Position eventCoord, Player player) {
            if (getSpellAction() != null &&
                    getSpellAction().canPlayerUseAction(player, eventCoord)) {
                PlayerAction spellAction = getSpellAction();
                spellAction.setTarget(player, eventCoord);
                spellAction.restart();
                player.setSelectedAction(spellAction);
                PlayerSpellList.getSpellList().useSpell();
            }
        }

        public void drawValidTargetsOnCanvas(Player player, Canvas drawingCanvas, Context context) {
            mSpellAction.drawValidTargetsOnCanvas(player, drawingCanvas, context);
        }

        public void removeAndRestock() {

        }

        public String getSpellName() {
            return mSpellName;
        }
        public ManaAmount getSpellCosts() { return mSpellCosts; }
        public int getCastTime() {
            return mCastTime;
        }

        public SpellType getSpellType() {
            return mSpellType;
        }
    }

    public class SpellDefLongsword extends SpellDef {
        public SpellDefLongsword() {
            super();
            mSpellIcon = R.drawable.icon_ability_longsword;
            mSpellAction = new SpellActionLongsword(this);
            mSpellName = "Longsword";
            mSpellType = SpellType.Weapon;
        }
    }

    public class SpellDefShuriken extends SpellDef {
        public SpellDefShuriken() {
            super();
            mSpellIcon = R.drawable.icon_ability_shuriken;
            mSpellAction = new SpellActionShuriken(this);
            mSpellName = "Shuriken";
            mSpellType = SpellType.Weapon;
        }
    }

    public class SpellDefArrow extends SpellDef {
        public SpellDefArrow() {
            super();
            mSpellIcon = R.drawable.icon_ability_arrow;
            mSpellAction = new SpellActionArrow(this);
            mSpellName = "Arrow";
            mSpellType = SpellType.Weapon;
            mSpellCosts.set(ManaAmount.ManaType.PHYSICAL, 1);
        }
    }

    public class SpellDefTripleArrow extends SpellDef {
        public SpellDefTripleArrow () {
            super();
            mSpellIcon = R.drawable.icon_ability_tripleshot;
            mSpellAction = new SpellActionTripleArrow(this);
            mSpellName = "Triple Shot";
            mSpellType = SpellType.Weapon;
            mSpellCosts.set(ManaAmount.ManaType.PHYSICAL, 1);
        }
    }

    public class SpellDefSpear extends SpellDef {
        public SpellDefSpear() {
            super();
            mSpellIcon = R.drawable.icon_ability_spear;
            mSpellAction = new SpellActionSpear(this);
            mSpellName = "Spear";
            mSpellType = SpellType.Weapon;
        }
    }

    public class SpellDefBroadsword extends SpellDef {
        public SpellDefBroadsword() {
            super();
            mSpellIcon = R.drawable.icon_ability_broadsword;
            mSpellAction = new SpellActionBroadsword(this);
            mSpellName = "Broadsword";
            mSpellType = SpellType.Weapon;
        }
    }
    public class SpellDefDagger extends SpellDef {
        public SpellDefDagger() {
            super();
            mSpellIcon = R.drawable.icon_ability_dagger;
            mSpellName = "Dagger";
            mSpellType = SpellType.Weapon;
            mSpellAction = new SpellActionDagger(this);
        }
    }
    public class SpellDefFlameWave extends SpellDef {
        public SpellDefFlameWave() {
            super();
            mSpellIcon = R.drawable.icon_ability_flame_wave;
            mSpellName = "Flame Wave";
            mSpellType = SpellType.Fire;
            mSpellCosts.set(ManaAmount.ManaType.FIRE, 1);
            mSpellAction = new SpellActionFlameWave(this);
        }
    }
    public class SpellDefFlameblast extends SpellDef {
        public SpellDefFlameblast() {
            super();
            mSpellIcon = R.drawable.icon_ability_flameblast;
            mSpellName = "Flameblast";
            mSpellType = SpellType.Fire;
            mSpellCosts.set(ManaAmount.ManaType.FIRE, 3);
            mSpellAction = new SpellActionFlameblast(this);
        }
    }
    public class SpellDefFirestorm extends SpellDef {
        public SpellDefFirestorm() {
            super();
            mSpellIcon = R.drawable.icon_ability_firestorm;
            mSpellName = "Firestorm";
            mSpellType = SpellType.Fire;
            mSpellCosts.set(ManaAmount.ManaType.FIRE, 1);
            mSpellAction = new SpellActionFirestorm(this);
        }
    }

    public class SpellDefFireDash extends SpellDef {
        public SpellDefFireDash() {
            super();
            mSpellIcon = R.drawable.icon_ability_firedash;
            mSpellName = "Fire Dash";
            mSpellType = SpellType.Fire;
            mSpellCosts.set(ManaAmount.ManaType.FIRE, 1);
            mSpellCosts.set(ManaAmount.ManaType.PHYSICAL, 1);
            mSpellAction = new SpellActionFireDash(this);
        }
    }

    public class SpellDefDoubleStrike extends SpellDef {
        public SpellDefDoubleStrike() {
            super();
            mSpellIcon = R.drawable.icon_ability_double_strike;
            mSpellName = "Double Strike";
            mSpellType = SpellType.Weapon;
            mSpellAction = new SpellActionDoubleStrike(this);
        }
    }
}
