        �  �        ���������6bKH�)ܲ���L[;��            4�  �7package com.android.jprevoe.wizarddefense.Spells.Projectiles;

import : �content.C <xt;  � graphics.Bitmap  oCanvas  �drawable.D	 � � � Actor.Position;9 �Grid.Battle :    � /er: R� �java.util.ArrayList; qconcurr�3all�/**
 * Created by o � on 8/14/15.
 */
public class �� {
    private final D� mSource;$ 
oTarget$ g PAnima/ /s.  / m  
Q �boolean mInitializeds �loat mDur?  �StartTime { OffsetX% OY;

� ;Dong �<�0> m _enersn 0PctH Z = 0;h 2(�s�,�t�?,
  �a
 K � d}5) {) DG = sM :G = tC � := a* �% =~  .x = fals� |o = new�"()0 }~FhstaticGc���O�areturnY� � o E Pvoid �"On�(  2ing #, P" c � Aif (C � �/}
6
.� 	J �5.x, yH�"  " �,�
�� � 	# Cp"e(��interpol� �e, long�lMillisD!LptimeLef�
L - -t + *$ ;Q  r O <k�4 
N }��/ =� 7tru,}
�� = Math.max(�  ?in(s(� ' -� 6) /U N, 1)�60);� �E = (�& -�5) *� @ Y@ y@ y@ 
�C<= 1����Dor (uG c :�=_try {,dc.call�	O� catch (Excepz^) �}� � is� (T 	�$dd�  	 	G�U.add(# �;
    }
}
    �     �  
�       !    ����ܪ2�o������c�;�=r��            4�   �4  �  �   *    public void animate(float currTime) {
    	   #  `mStart& % =1 � ;
  	e  	�   <  (/ ' -G �) / mDuration
         y  s       "   ����,ꊥ87�Th5%3$v%�l4�            4�   B  
� � {
    public long getTimeLeftInAnimation( @curr ") 8   qreturn ! a)(mDur1 D - (/ � - mStarY �));
    }
    �        s       #    ����'{X�jiў-?���7�v�                �     �         -   �����a7.�Y����8�

@�:�            4  B  � �     private boolean mCollided;
  A +  # � = false+ �	q  	�   `' �if (mPctDone >= mProjectileAnimation.getN �sionPct()) {
m 1trul "
[ ? B
m 1H  D �        }
    E     \  *       0   �����O��dy�T}X���z��M�              	�  	�   P        if (mPctDone >= mProjectileAnimation.getCollisionPct() && !mCollided) {
