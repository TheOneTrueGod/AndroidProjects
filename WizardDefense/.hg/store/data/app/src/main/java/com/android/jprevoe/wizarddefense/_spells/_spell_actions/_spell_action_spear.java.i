        �  t        ����������v�r�{��-�y��z�            4t  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (� H &�ModifiablePosiC "VPlaye4 /AcL 1�Targetting.Square  � [ % > % �5 ��Projectile H 5/sR  6Def
 ic�
java.util.concurrent.Call��
/**
 * Created by o � on 8/23/15.
 */
public class ��Spear extends os {
    9 �static final int ANIMATION_TIME = 100;2 
�PROJECTILE3 33 4 � ($# s	 )�   esuper( ; m� 3��s = new �(0, -2, 1, 2A }� �@Override� �boolean can82Use� ( ! p $, �� eventCoord� �return truev 	�6 ge 
v a %u anim =$ , 	O.get ?(
  u,! �  Y /(). 
m� � E.add� S(� �ATTACK_CONNECTEDr  �d(this,Z,);� � ��void set%t ��/ =7    �/1)� a SPback(��timeType,� ] unito.A = 2 �
w.reset(% while (, �hasNext()�  �u$ t/I 2getI ;G � C  Po, 	g � �\X(),  JY())�
s D& p = !.c�h� , *  ��f.Slash���� �  "2 t �(��	R � ObX � call() throws Excep�� ��pHandler$ (: �W�Team.ENEMIES);\ �Nnull! } }C � &dd�(K? }�Ilong
_Time(b  �;) (�;+ (�� -�*(Y)�);
    }
}
    �     >  �           �����_3&5&���f�\�I��^              �  �   2    public long getAnimationTime(Player player) {
    �     3  �          ���������}3~A[V�'f�            4S   �  �  �   G  �ANIMATION_TIME,
( ptrue);
    (     B  �       4   ����}~���M*c�u�z�\㋶;            4P   �  	�  
:   D   �new ProjectileAnimations.Slash �(false),
    j     H  �       J   ����`W��O�r�R��zK��P�I              �  �   <    public UnitAnimation getChildAnimation(Player player) {
