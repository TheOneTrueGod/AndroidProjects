        �  %        ��������7T����@<��dKE���a>            4%  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (� H &�ModifiablePosiC "VPlaye4�Targetting.Square  c [ % > � % S5 s�Projectile H 5�sR  6Def
 i��
java.util.concurrent.Call��
/**
 * Created by o � on 8/23/15.
 */
public class ��Flameblast extends_%  s {
    u �static final int ANIMATION_TIME = 100;2 
�PROJECTILE3 53 4 � (Xe# s	 )�   esuper( ; m9 t9�s = new G�(-1, -2, 3, 2B }� �@Override� �boolean can>2Use� ( ! p $, 2� eventCoord� �return truev 	�6 ge 
v a u anim =$ , 	O.get ?(
  vD.add� �(0, -1),4 �  l 3 +),n� �  ` � D(� �ATTACK_CONNECTED�  �d(this,U,);� � ��void set t ��/ =y a }Pback(��timeType,� � ] unitX.A = 2 p
w.reset(% while (, �hasNext()�  �S$ tI 2getI ;G � C  Pot� � sX� OY())� n& p = !.cPo �� X ���.FireballWithExplosQ ��� �  ;8 { �(��	R � ObX � call() throws Excep�. �Handler().a (6���Team.ENEMIES_ �Nnull! } }C � &dd�(N? }�Ilong_Time(f  �;) (�+�P }
}
    �     �  �           ����uNv�ŷp셪w� d[@�ڱ            4�   C   @ �import android.util.Log;

  W # & Bjava# �Random;
  p 3 $   � rand = new  ()0 "	Z 7 6  �double r =8 a.nextD �() * 0.5 +  B �
  
9   4   �(int) (PROJECTILE_TIME * (r)));
    y     >  �          ����/H�U|H���r%�>�v�$>              Z     2    public long getAnimationTime(Player player) {
    �     I  �          �������%������S��+��A��            4i   �  �  �   ]  �player.getPosition(), ANIMATION_TIME,
> ptrue);
          H  �       J   ����8����N�+,���A�J*E��              �     <    public UnitAnimation getChildAnimation(Player player) {
