        k          ���������>�o�{�랾 @,ӊ}�            4  �'package com.android.jprevoe.wizarddefense.Actor.Player �ions;

import < �content.C <xt;  �graphics.CanvaA � PAnima} U.Unit ;H 'OWalkH ' > ?osiw AGrid oDrawer:  6�MoveHandl? �
/**
 * Created by ? � on 8/1/15.
 */
public class �  P z extend �' {
    private static final long ANIMATION_TIME = 200;4 "� mTarget � . m� / � � (? u )�   �super(null); o , =C , }� �void set� (� ! p ,� t � G = t �Done = falset �@Override� |&ge?XTime(k kreturn�� �boolean can� 2Useb� �eventCoordr �   =�  J�mentToSquare(< ,Y �Tif (C�  ; bInDire� R(int)\ H.x,  yL � Ftrueg }&v��drawValid�2sOn
. / 2ing #, W" c � 1for� � i = -1; i <=  L+= 2� B.d � �tingReticule({ s ?,
   � D.get��X() + i,  Y 0I ?);
� ]� i� 
�
����), �g ��deltaX =�(�/ -� .);> Y> ?y -� ?�Math.abs(� J) >  Y$ 7 � << 0 Fv !.ck�(-1, 0);/ o} elseD C 
M 
� Y� _0, -1� ,=0, C ^
_�1,�b� �@.can  	#On��
�� YB+oI
� � � A().h
 �  �(� �  ()1 y@ %mTd y� � 	�
	�(�	�
 � 	 (x� -� � P


}
    k     g  
           ����g$�9̼�΅�R�����            4�   �  a  �  �$�  /   j    public long getAnimationTime(Player p S) {
  ireturn1 (& .F Pe();
    �     H         J   ����^�y	B��M���r>GĿ��              q  �   <    public UnitAnimation getChildAnimation(Player player) {
