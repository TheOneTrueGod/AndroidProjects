        �  �        ��������q!j��4����OXh⯲��            4�  �4package com.android.jprevoe.wizarddefense.Actor.UnitStats;

import 7 �content.C <xt;  � graphics.Bitmap  oCanvas  NPain_ 0sup �.v4.util.SimpleArrayMap� � �Animation�  ;H 'OWalkH '� HealthBarDrawer@ OPosiy " � 5 �Grid.Battle :   � bSpells 6Def
 Finer�BjavaFList ostatic	�.ManaAmount �Type.*;

/**
 * Created by P � on 7/27/15.
 */
public abstract class b � {

    protecL   " m�
 rfloat m- Tivate :Max ; �� mSpriteImage;y �  I $na! � �void initialize(� �unit) {
  � ! = ; � Q = Ge�  '()# � * =�  �na = new� @ .}
� bdrawOnm( ! c #, �" c � ~! p o   j $ �.f L(\ a;,
  D.get�f().x + B`Offset F yF yF �  ��.SQUARESIZE_X, Y��a�a�	+#-= I = %ge2A �return Math.max(Q O, 0)K 
jN ' ;, 1Q ��� /10%2raw9 � 6.M OBar(8�^, - � � � 	S R USpawn "	> �	 � �!.c�](0, -�Y() - 1)> )�
 Y�K  �boolean hasEnoughS 1For�(��  s	 hPrimedGif ( � == null# ?Ftrue.}^?.� ] .��ellCosts()'icharge�  sJ �� A  6 ~ ��naNeeded� $D � )0pay" p i 1sub�s` 1add, � 3) {X '  `; }
}
    �     X  �           ���� �;�;R���Rt,�O#�}P            4e   �  �  �   )  �/*HealthBarDrawer.draw � (
  C  e   $  �canvas, context);*/
    �    a  �          �����|���ሿ�"�չ�S�Z>�            4�  C   � �AFimport com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
  �     ��  *   X    public void drawOnCanvas( ! c �, Contex�  ', b & s �) {
  N  �   �  �GridDrawer.g cImage(] +
  BUnit` @Crea� pget().c �eFromFullD �getCurrent� hFrame(� r),
  n ! r� �rotected String I � � �return "character_melee";
    }

    N    �  2          ����(`[7��=�y#Gq�R�a�            4t  B  � �: Cimport com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
  , #  O �java.lang.reflect.Array, "e � I    protected Simple' NMap<i �, String[]> m �s;

   C -
  # k = newb  ()� "H $_8 Gif (< �.containsKey(spriteState.get& �())) {
  � ` frame� U ?getM 	;K 2intF �Index = Math.max(0, [in(
  Q(int) bfloor(� �.length * � �PctDone()), + 9- 1] � creturn5 [� �];
        }
    �      �          ����(���1_Y<Y�{gїIE��            4f  �  �  �   �  �
UnitSpriteCreator.get().c �eFromFullImage(
  �getCurrentAnimationFrame(sZ �State), this_ N }Scale()T � ),
  �  	?   bo �(int) Math.floor(fm �s.length * w  p �PctDone()), + �- 1
  0 ! <� �public float � % {� �return 1;
    }
    �     �  v          ������a�J��{b.YF*��w��            4�   B  	� 3 �  �if (mAnimations.containsKey(Character  �.IDLE)) {
  � spriteState.set. A ;? �return getCurrenA gFrame(_ : P   }
    	y     1  �       0   �����@^���u��	i ;<�k�w              t  t   %
    public void onDeathTrigger() {}
