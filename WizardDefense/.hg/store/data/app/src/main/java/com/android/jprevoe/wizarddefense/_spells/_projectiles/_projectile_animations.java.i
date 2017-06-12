        �  
        ��������Ӌ_OŘ$�=�ʺ݆��v�            4
  �7package com.android.jprevoe.wizarddefense.Spells.Projectiles;

import : �content.C ?xt;  �res.Resources& � graphics.Bitmap  Factory' WCanva� � AR �.UnitStats.ManaAmount;E �Grid.Battle :   oDrawer: R� �	java.lang.reflect.Array;  Butil OList  PHashM��
/**
 * Created by � � on 8/21/15.
 */
public class 0�Animations {
    private static k �<Integer, �2> m	 us = new( O>();H Y' md* � ) �void set& (; )�   � .+ ) =s  2 /}
� � B get
 c(int r: q Tif (! ?�ainsKey(. /   . 5put& ), ,t.decode� (� ,� %);X }
 freturne &gee )� 	l� `protec]�<TImage  
? g  (V%[]� <IDs<�addResIDs(% n  G: i Dfor �OID :, 	  1b =:A -);2 1R.add(7 % }� �bdrawOn=(` bfloat � )X, /Y,. gtargX, * tpctDone, 1dur�/ � � 2ing #, �" c R�double offsetX = (� $ -� 4) *� ;: Y: Y: Y: �.� �(� �getFrame(� � )�   (#)(� $ +� +), Y YL Onull ��.SQUARESIZE_X, YE >�  
��� �0���WithEffect�oextend��_final, mPart1;2 22 �mFollowUpPct;�� 
�� p� ,+ 2+ )f� �`super(�2+{}�:" =�   2 2 !( =� ;�_gdestX, �kp k) /5�&if) <) ��.J3-� 6pct�,� � �_ else�  � � -� o/ (1 -� 	h
� 
� � 8�>
 �Looping�zA #	�	�CG : � On = Math.floor�*> p % 40 / *Xsize(�
9 �	)i /);�oSingle�'@ �1
 �@Override�c�B� �Shuriken�%{�< (k*  �(R#cable.sT ?_1,' 2' 3' 4SI_ArrowF!9 D%� aV E( 2� '^Slash� �=	8 :1 Q 7$  2$ 3$ 4$ 5$ 6~'�Firebally!< ��fS �' 2' 3' 4' 5o'�Explosion� <  q/eU r( 2( 3( 4( 5�/�Q ,��		M (b& ,��  ?0.5! � � %I � � � � � 7� Crystal : (9DcType m	 8	e& witch (F   �case PHYSICAL:>	�q �c� �_physical_1� O obreak;� NFIRE� default� 0 ?_1 � ��}
    }
}
    �     �  �       -    ������/�*z���C
8H�,A �            4�   B  � C J
  �public float getCollisionPct() {
  �return 1; b}
  
� / yU )(. �)(mFollowUpPct + (1 -  �) * 0.5)� P  }

        1  �       1   �������VV�Lx�"���">�X��            4�  B  0 3 J  �protected float mScaleX = 1;
% Y% �    U   k   �	BattleGrid.SQUARESIZE_X, ?Y,
F � ,| R
  / !�� �(ublic static class SlashAnimationFlipped extends Single & {� L ? I() {� �super(  new Integer[]{� �R.drawable.s] ?_1,( 2( 3( 4( 5( 6' O});
� G = -V�}
    }

    	>    {  %�       2   ����e�}�
����Ⱥ	k �            4�  C   � �import android.graphics.Rect;
  C �4�    public static class HatFallingOffAnimation extends Projectile  {
M Q D '()*   �*super(new Integer[]{ R.drawable.character_armored_hat });F ,}
{ Pvoid B �OnCanvas(
  �float sourceX, /Y,. gtargX, * tpctDone, 1dur� / � � 2ing �, Context c 3�final int NUM_FLASHES = 4;' �if ((int)(� ) *1 �* 2) % 2 == 0d  � jreturnU )}
 �double offset = j �0.2; // How far the shards should fly
N @rawS$ (�# -[ ,� � / 2.0,  	A/);V +V 1V � +� 1� /+� 1�  frivate!k �$x,�!y,_�X /Y,�=�Bitmap image = mI	 {s.get(0� [ rSizeX =5  + pWidth()� # *� < Y< jHeight= +Y;n�GridDrawern1Sub� (�U �(�X)(x +� �/ Battle] �.SQUARESIZE_X)C 8 (yD YD YD  Nnull � ,Y X  0ew 0:�� ,  Y  �+W �<7 ) 6�rotected��getFrame(�
�/��O �getCollisionPct(�/ 1� P  }

    �      &�       3   ����Tc��W �S�)���;ѓ|]            4  B  � �*    private static class InPlaceAnimation extends Singl 3{
  �protected= �(Integer[] resourceIDs)<   hsuper(! ;  &}
g �ublic float getCollisionPct(T �return (. H)0.5S Y �  ?  �   Ba 	^Slash&�{
  �     IN FlippedU ��  0   FU PExplo� Pon {
    �     �  %�       4   ����C���(��޾.S�?M��M            4r  �  �  �   0  �public ArrowAnimation (boolean flipY) {
  2 7 E  Eif (%   �mScaleY = -1; }Q ��  �   /� USlash� 	� X� o�  q� X� X� �$�  $�   M �super(new Shuriken� 1),  
� � false), 0.75);
    �     4  %�       H   �����p��By�/�Y8'P�.!�            4S   �  �  /   G  �R.drawable.arrow_1,
$ Pow_2
