        k  1        ��������\����\�%�$`e�L ��k��            41  �4package com.android.jprevoe.wizarddefense.Grid.Structures;

import 7 �content.C <xt;  � graphics.Canvas  VPaint` � �Actor.Unit;5 !�Effects.Slow G `Battle :   oDrawer: �R;

/**
 * Created by , � on 7/26/15.
 */
public class p �� {
    protecF � oolean mInvalid[ ;$ Pint m7 /�down = 0;
& k �final void drawOn�( ! c #, )" c �, float x	 #y)�    I 4Me(< 4 ex, y);' � � = false +}
� � /Me� .eSquare� � �, R.color.white)� T =,�q � ]  p �ToUse = new (I" P.setCG (l �.getResources().g   m E �.� DRect+
  # �  v�.SQUARESIZE_X, YB /��5�canWalkOn(X unity�return trueF 	QisDes�_ible(B  �C :Uapply��(� 	 ! e :Yamoun� U� 0 � _I qReadyTo/oy
�5get �UnderneathQ Onull� 	�s��FromAttack� �Entering0Jif (h8> 0!  � 5 C.add� ��
? �}� 	MLeav� �
    }
}
    k    �  i       <    �������vkX�<���Ҧ>I            4�  C   \ � import android.graphics.Bitmap;
   � J, kRect;
 0sup �.annotation.NullableV "� # :8 Dcom.< �jprevoe.wizarddefense.UI.SpriteLoaderF "I � B    protected int mResourceId = 0;
# `ivate � ! m `= nullN �;  }  �  Hif (H �!= 0) {
  *� grass = � B.get F )� d  � � a % �nt rectX�  �Y = (int)Math.floor( �random() * getSheetHeight())O wK �BattleGrid.SQUARESIZE_X6 h6 =Y;
7 �!ew�(� C* w,�   G+ 1) Y h� }  � �Drawer.drawSubImage(
   canvas, � �(float)(x), \y + (q  -� O/ 2)I   �, YF q	 <k} else�4�quareOnC(%� context, x, y, R.color.whiteW 
 
�mdouble� �return 1;
         n  �       J   ����d�'bHK�؀�{!\My�            4q   �  A  �   e
  �Bitmap grass = SpriteLoader.getScaled% �(mResourceId, BattleGrid.SQUARESIZE_X / 32);
