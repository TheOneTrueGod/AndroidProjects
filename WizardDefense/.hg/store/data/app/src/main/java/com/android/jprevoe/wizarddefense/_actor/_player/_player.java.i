        �          ��������}jH-&�Q侗��F4|�ͦ�            4  �0package com.android.jprevoe.wizarddefense.Actor.Player;

import8 �Actions.Helpers.UnitAttackHandlS R @nimaU 5.No F � �  /AcL =�ChargeManaV ?osi� " c5 "`Stats.� _AmounE )
 D AGrid9 OMoveTSpell~ ?Lis� ATurn | �
/**
 * Created by ; � on 7/31/15.
 */
public class � � extends � �  {
    private $� mSelected�* N" m 2 3 � 2 (@# p	 =,
  o* u 3 	�, u 7 $ u
 5) {) esuper(� � e  I 3} c:gete(} _retur�
U mvoid sM 	l s h a O = sr �boolean has�  Mif (V h= null' � efalse; }K 	�.IsDone()L   Itrue� �@Override� @long��MTime� �� 0� N  .� padvance-�%UmCurrp 7 = � �  '()� \ elseL �#do� 4thix = A .
. !� � ~payCost� + 	h� 
���.TURN_TYPE�  OType�5 .PLAYER� �@TeamX  X  K �� canAffordPrimed��]�hasEnough
"Fo�(� � %() g /()4e(] mana�- �	% O new� �)() 
Q A.set< � ;C
4�    }
}
    �     G             �������-y���� N�ߋ�{�t�              �  '   ;        return getSelectedAction().getAnimationTime(this);
    �     .            �����h�
�0]��2��R{;d              2  R   "    public void doTurnActions() {
