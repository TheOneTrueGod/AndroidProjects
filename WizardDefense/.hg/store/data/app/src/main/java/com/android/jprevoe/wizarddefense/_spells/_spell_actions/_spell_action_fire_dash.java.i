        +  [        ��������V~\Ơ$+��?<$�X̭�            4[  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB � .FireDashAttack R (� H &VPlaye�  /AcL 1�Targetting.Square Oable[ % > ?osi� " \5 �Projectile H 5�sR  6Def
 i�#�
java.util.concurrent.Call��
/**
 * Created by o � on 8/23/15.
 */
public class � � extends rs {
    < �static final int ANIMATION_TIME = 800;2 
�PROJECTILE3 23 4 �  (*# s	 )�   esuper( ; m� 9��s = new �(-1, -4, 3, 4).canOnly  AWalk$ Z }� �@Override� 	6 ge (d! p � �u anim =' / @.get d ?(
  !,! �  \ �/(). 
5);
* �* a �( d(this,7� E.add� 1 !�DASH_FINISHED,� Z *`EXPLOS� _START\ Rretur�Mdvoid af  Pback(T�timeType,h 8] unit.A = 2 �   '.s�tOffset(�!.ctg(0, 0)8 5if U O == ��  I�float oldX =� vX}. Y.  Y. ! @telea3To(�4.x,,.ya Bor (f 1y =j V; y >1 \; y--�   �+`Explos7 � ,, J � K, y)} } o} elseb�� � � 5add�l 1, 0 � E  /-1E -0E 0/-1E 4
}�`protec��X ��^ ! tq �t& p = L��/ t� q�.� C� ��  ;? p �(�
J 
 ObP � call() throws Excep��  �Handler().a �(  �f
�Team.ENEMIES);U �Onull�N� &ddv(,_IlongV:TimKa %;) (�	+��/ -& L -

*�.�);
    }
}
    +     >  h           �����,��w��P��X�y��A�              z  �   2    public long getAnimationTime(Player player) {
    i     H  m       J   ����R��M���`���ȩ�E�!                R   <    public UnitAnimation getChildAnimation(Player player) {
