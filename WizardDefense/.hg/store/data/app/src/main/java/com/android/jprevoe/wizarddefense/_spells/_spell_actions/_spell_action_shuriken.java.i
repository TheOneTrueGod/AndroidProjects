        G  
�        �����������J�R�]D�0��9            4�
  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (� H &VPlaye� �Targetting.Square Oable[ % > ?osi� " 5 0�Projectile H 5�sR  6Def
 i���
java.util.concurrent.Call��
/**
 * Created by o � on 8/7/15.
 */
public class @� Shuriken extend s {
    ; �static final int ANIMATION_TIME = 100;2 
�PROJECTILE3 63 Protec�  ) @mDamX= 1;
S �  (:G# s	 )�   esuper( ; m V�s = new )�(-1, -4, 3, 4B }� �@Override� 	�6 ge (<! p � Du anim =$ , 	O.get ?(
   ,! �  Y �/(). 
h � E.add� r(� �ATTACK_CONNECTEDr  ��d(this,Z� RreturL��dvoid a�  vPback(��timeType,� � ] unito.A = 2 %;
2 U& p = !.c�(: .O�� ��; 
���  ��
c � � ,� )� 1 �Handler()Z N (s 
�E# � 	��J" t� , {@ vb (  K&S Ob� � call() throws Excepq� �#(t� � #�Team.ENEMIES,N-);^ � :ull } }b lWW ��WithSlash(zIlongqOTimew  �;) (�;+ (�>-*��;�);
    }
}
    G     >             �����.G�ؐ���j���� p              
K  
p   2    public long getAnimationTime(Player player) {
    �     3  %          �����8�m*�&ixZ�MPӊ��{�            4S   �  �  �   G  �ANIMATION_TIME,
( ptrue);
    �     �  Q       "   �����m�~iЉ/?���t��ضp            4�   �  
�     �  �return  (int) (ANIMATION_TIME);
( #//* ) � + (PROJECTILE :  <  +- 6 �* BasicAttackAnimation.CONNECTED_TIME));
    D     �         1   �������Ң*������zq���            4�   �H  �      >    public static final int PROJECTILE_TIME_PER_SQUARE = 100;
  �  �   Y  > �* Math.abs(mTarget.y - unit.getPositionY()))e �
�  I        �     H  
       J   �����L��ր�A�zq���X              �     <    public UnitAnimation getChildAnimation(Player player) {
