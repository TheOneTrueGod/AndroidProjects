package com.android.jprevoe.wizarddefense.Spells.SpellActions;

import com.android.jprevoe.wizarddefense.Actor.Player.Actions.PlayerAction;
import com.android.jprevoe.wizarddefense.Spells.SpellDefs.SpellDefiner;

/**
 * Created by jprevoe on 8/7/15.
 */
public abstract class SpellAction extends PlayerAction {
    public SpellAction(SpellDefiner.SpellDef spellDef) {
        super(spellDef);
    }
}
