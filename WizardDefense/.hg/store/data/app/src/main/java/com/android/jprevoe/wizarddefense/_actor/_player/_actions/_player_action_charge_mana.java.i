        N  C        ������������Z"+'��3������            4C  �'package com.android.jprevoe.wizarddefense.Actor.Player �ions;

import < �content.C <xt;  �graphics.CanvaA � z �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (�ChargeManaN 1� H 0?Wal� ( > ?osiw " � 5 "aStats.�OmounE AGrid oDrawer:  ~ �MoveHandl? �Spells.Projectile H 5�� java.util.ArrayR; oRandom  qconcurr Pallab� �
/**
 * Created by � � on 8/1/15.
 */
public class a�Hz extend �' {
    private static final long ANIMATION_TIME = 400;4 �PROJECTILE5 25 �0 mT� t �- m. �( m�% (i u )  �super(null); � O = u� }� �void set� � 8anas � ! = z �Done = falsee �@Overrides �&geXTime(m �return (int) (�<+ (�++
  -</* � �.MOVEMENT_FINISHED- /))9�boolean can�2Use�( ! p ,`�eventCoord�  ?tru<��drawValid�2sOn�y  / 2ing #, �" c  � w o� @ 	�	�M � y anim =��?get  (d   �;(),5);
_  n E.addB �(u eATTACK;,�Nnew �d(this,   � a�  �@backB� timeType, � S.A = 2 � [ �otal = 0d x<8� L 3> m
 1s =/ '>(��S rand)  (� _for (f  o mt :   �.values() J  � i� H i <� 9�(mt); i++<  �   	! 5f (� @.siz�?> 0M M  
 �.nextIntC )j -}
 6 Cadd([ O, mt?  �*++ /}
_  �double offse� D �() * Math.PI * 2;
n
� kb: �ndex = i;!  =e  �D P� Xang =� # /S* i +� < �	& p = !.cD	(w c
� � /
  P(floa+� pcos(angy?2),5 6sin5 4 /),� ��
�.Crystal�/mt?  ��^ &P u �
(Z
@	R L ObX � call() throws Excep�
1addI	 � �A().s;>, 1�	� �	� 
�C ���	;#(.? �}


    }
}
    N     >  P           �������^Ѥ�B�7�q���L [�L              �  �   2    public long getAnimationTime(Player player) {
    �     H  U       J   ������е"Fi9,�fK(�� uE�              �  �   <    public UnitAnimation getChildAnimation(Player player) {
