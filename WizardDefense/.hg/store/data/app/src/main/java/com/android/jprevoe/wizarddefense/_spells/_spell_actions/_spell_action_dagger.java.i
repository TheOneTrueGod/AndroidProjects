        <  
�        ��������2=�`�`��rM�3'�U�j            4�
  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? cActor.9 �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (� H &VPlaye�  /AcL 1�Targetting.Square Oable[ % > ?osi� " \5 |�Projectile H 5�sR  6Def
 i� �
java.util.concurrent.Call��
/**
 * Created by o � on 8/23/15.
 */
public class �� Dagger extends ps {
    : �static final int ANIMATION_TIME = 100;2 
�PROJECTILE3 33 4 � (&# s	 )�   esuper( ; m� 5��s = new �(0, -1,  A }� �@Override� �boolean can92Use� ( ! p $, �� eventCoord� �return truev 	a6 ge 
v a �u anim =$ , 	O.get ?(
   q, �  Q /()* 
b� � E.add� (� �ATTACK_CONNECTEDn  Td(this,N,);� � ��void sett ��/ =3   �)� a IPback(��timeType,� ] unitc.A = 2 *'& p = !.c�(4 �wf.Slash�N zK�  Q� l h([J c ObP � call() throws ExcepT�  2 ��pHandler� ���Team.ENEMIES);V �Jnull } #})|� 
&ddt(.mIlong�_Time(�  �;) (Q;+ (�� -�*����);
    }
}
    <     >  
�           �����Ҭ_�N��*�/8(b��s              
  
>   2    public long getAnimationTime(Player player) {
    z     3  
�          �����a_\CƉ����:�X�            4K   �  Q  v   ?   �ANIMATION_TIME,
$ ptrue);
    �     J  
�       4   �����;0;�	��F�vgU�dI��            4U   �  u  �   I  �mTarget, new ProjectileAnimations.Slash �(false),
    �     �  
�       I   ������ӄZ��Vzh��	
�            4E  B  � �( Zimport com.android.jprevoe.wizarddefense.Actor.Player � ions.Targetting �ableList;
  ` # f � java.util.Array( ��  \   �   P<Posil 1> ta vs = new" D();
7 # T.add(9 �.create(0, 1), m� dSquare[ � (V )� �:  �        �     H  
�       J   ����GE��<y���閮ޠ�)�              �     <    public UnitAnimation getChildAnimation(Player player) {
