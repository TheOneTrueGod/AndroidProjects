        '  
B        ���������_!L0�A=>�t&��Vi�            4B
  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB �.FirestormAttack S (� H &VPlaye�  /AcL 1�Targetting.Square Oable[ % > ?osi� " \5 ��Projectile H 5�sR  6Def
 i�$�
java.util.concurrent.Call��
/**
 * Created by o � on 8/23/15.
 */
public class �� extends ss {
    = �static final int ANIMATION_TIME = 800;2 
�PROJECTILE3 63 4 � (,# s	 )�   esuper( ; m  ; �s = new �(-1, -4, 3, 3B }� �@Override� 	�6 ge (M! p � yu anim =( 0 O.get ?(
  ,! �  ] �/(). 
7, 8w � E.add� �(� �ATTACK_CONNECTEDy  �d(this,m� Rretur[�dvoid a�  mPback(��timeType,� � ] unit�.A = 2 %;
2  [ @r = d �	)(Math.random() * 5) - 2� { �! t�$ =� l��r % 2, r / 2�& p = !.cSB � .� / tV �1�ballWithExplosj8� �  �  s )(��J   ObP � call() throws Excep��Handler().a ](3��Team.ENEMIES);U �Jnull } }7 � &ddy(,�Ilong�:TimKW�+ (+�P }
}
    '     >  
O           ����?{w�5�A��O=�A�e!              	�  
   2    public long getAnimationTime(Player player) {
    e     H  
T       J   ����K��Rg�#6T4H�z��RyK"                =   <    public UnitAnimation getChildAnimation(Player player) {
