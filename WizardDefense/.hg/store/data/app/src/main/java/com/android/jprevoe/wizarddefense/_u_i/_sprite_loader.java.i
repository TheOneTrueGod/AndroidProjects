        �  �       <��������=���y����(���?�|            4�  �'package com.android.jprevoe.wizarddefense.UI;

import * �content.C ?xt;  �res.Resources& � graphics.Bitmap  Factory' _Canvag �drawable.D	 � �Grid.Battle ; � java.util.HashM� �
/**
 * Created by U �1 on 2/16/16.
 */
public class SpriteLoader {
    private static c �<Object, 2> m	 us = new' O>();G �' m�)  �% m�& � % �void setK (` r
 )�   u J = r� }a � (� c 	[  = W X  5B get
 E(int� V Tif (!d��ainsKey(. / � . 5put& ), �t.decode(,� �  freturne &gee )� jScaled� �ID, float s -ID� i r�� _ID);
J
!ID) /ID	_ � "OnK( ! c !, '� 5 . Or, 1w 7��$ d	 =a " I(r);� �setBounds(0, 0,
   &)(�� .SQUARESIZE_X *� ,( 
Y( �  	 6�);
    }
}
    �     �  >       J    ������7iq\�{<�*�'z�%��            4�   B  T 7 %  �scale /= BattleGrid.DPI;
  �  �   x1 �res = Bitmap.createSD d �(res, (int) �.getWidth() *m ) iHeight  �false);
