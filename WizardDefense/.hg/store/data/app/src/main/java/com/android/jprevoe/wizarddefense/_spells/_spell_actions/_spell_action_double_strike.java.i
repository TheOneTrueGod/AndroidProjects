        s  �       1���������A�ʅ�Y�"�N�%@���            4�  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (oDoubleP 7� H &VPlayeA /AcL 1�Targetting.Square Oable[ % > ?osi� " \5 ��Projectile H 5�sR  6Def
 ip�
java.util.concurrent.Call��
/**
 * Created by o � on 2/15/16.
 */
public class ��� Strike extends vs {
    @ �static final int ANIMATION_TIME = 400;2 
�PROJECTILE3 33 4 � (%2# s	 )�   esuper( ; m A�s = new �(0, -1,  A }� �@Override� 	�6 ge (O! p � {u anim =% - 
.i /
  � ,! �  N �/(). 
�^ � E.add� �(� �ATTACK_CONNECTEDs  �>d(this,R� 8/_2� .Rretur�6�boolean can&^UseAc6$, �� eventCoordKv Otruev �void setj t f >/ =1 y >)� a� �Pback(*�timeType,> �I uni� ��/ p  f= null�Dif (v O == 5� � l /ew� VSlash�Mo} else^ 9yFlippede 
8.���; � ' = !.c�(� � . ?} �� 3(�
�J � ObP � call() throws Excep�  �1pHandler a���Team.ENEMIES);V �
��
 )A� 
&dd�(.�Ilong�OTime�� 
'�;
    }
}
    s     :  �       2    ����wGvP ����s��Y/]�            4R   �  �  	   F  �ProjectileAnimations.  + p Pion;
    �       �       4   �����W����$Xn��is񜬠O�            4�   �  �  
   �  �ProjectileAnimations.  / p  7=
  ?newO USlash �
(timeType == DoubleAttack" �.ATTACK_CONNECTED_2);
    ,     H  �       J   �����P���<g�?=;��m��oi              W  �   <    public UnitAnimation getChildAnimation(Player player) {
