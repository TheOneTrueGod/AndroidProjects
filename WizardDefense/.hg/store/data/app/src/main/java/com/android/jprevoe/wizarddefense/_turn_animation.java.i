        
  �        ��������|?�� �@�+��H��=9a            4�  �$package com.android.jprevoe.wizarddefense;

import ' �view.View; �animation.LinearInterpolator2 �Transfor { � �.Actor.Unit;5 aBattle6 ?Lis: �	Spells.ProjectileManagerC ATurn A�  � /enE #vHandler3�java.util.Vec{�
/**
 * Created by U � on 7/24/15.
 */
public class � � extends�) �{
    private final 0' m 9gr;4  d" mj �long mDuri jMillis" �.TURN_TYPE mCurrent JType4 & m! 	(. u	 ?,
  �  (5) {& f % =D ; 4 =6  � / =� g.ENEMY8 	e. =�b.get()2 }� �@Override�void set}(�d�� hsuper.1 , � 8set+^(new B'()3 + =� � 	Protec� Zapply~�(float i} �edTime, ' . t� N H t� A@eFor�- 
��9 � x�e�  h,j)\U C  ��.invalid= � ;set� (�c& 	Fc
 Sg� k oreturnyP }
}
    
    ?  �       !    ������;�H�h'�l!B�4]��l            4�  C   , �import android.util.Log;
  & �     private int mIteration( ��  �   �  �float currTime = (interpolated +E r) * mDu �Millis;
L �mUnitList.animate(X �, mCurrentTurnType)7 �ProjectileMgr< )� "� ! �7 �public void reset� F() {Z � B = 0r -}
B �incremenF /++D CCgetC� 	> hreturn� BP   }
    I     �  �       "   ����GB���2uDӆ��8��yh�            4]  �)  ?  [       private long mElapsedTime;
  &  r   p  �float curr$ � = (interpolat8 � * mDurationMillis) +Z N �Log.e("", "" +W )| ��     . D @ = 0& �>  T   )& ,+=� 5 �[  �   ORublicCgetC� E() {� lreturnL � Pime;
    :        �       #    �����
�W�J*h{:�Xm�\a1�xo                :       �       $   ����m��W���*Š9����B�h              w  �        F        �       %    �����<���v\��?��l#                F     �  	m       '   �������X�+$�|�x��ב�W            4�   B  ^ � $    private static float mCurrTime;
  w 3 ,  �TurnAnimation.- G = c8 �u  �   h �ublic long getEnd( @() {+ � 7 R
, 	� 0geth w > � hreturn� `    }
    �     J  	�       9   ����#�a�L-�D�3B��@m��&�            4R   B  	k � F
    public void invalidateView() {
  m .! �();
    }
