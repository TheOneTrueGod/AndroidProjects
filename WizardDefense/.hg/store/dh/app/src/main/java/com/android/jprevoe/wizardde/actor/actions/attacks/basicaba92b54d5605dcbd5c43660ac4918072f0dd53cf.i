        $  �        ���������v#�*�V=3O�¶"~w��            4�  � package com.android.jprevoe.wizarddefense.Actor �ions.Attacks.Targetters;

importL @PosiN ;9 FUnito �java.util.ArrayLis �/**
 * Created by R � on 8/28/15.
 */
public class Basic� � � extends  �{
    private int mnRange; rWidth;
 w q (- rD )d   Qthis( B, 1)^ }L ,� w� W �super(); � " =<  � " =I 	� �@Override� @otec|�<�1> c��   (�X unit� Afor � �y = 1; y <=dH y++2 	6 Sx = -u! x<  6 : �loat targX =� D.get� �X() + x;7 Y7  Y7 y7 vmCachedT.add(7 .#(� ,^ *))F .}

 nreturn] �;
    }
}
    $      �       H    �����=�bJ��l�A�ahs ���            4d  C   M �import android.util.ArrayMap;

   � 0+ Bjava( AHash'   �  ]  u  b�  � c)  A ��  �    �Map<Float, Boolean> targetsMap = new | d<>();
: & �.put(getKeyForPosition(unit.get \X(),  �Y()), true[ �for (int y = -mAttackRange; y <=  U++) {> 	B xB xB xB �  l  �   �  Wif (!� �containsKey�   ) !X,$<Y))�  �mCachedTV �List.add(E {.createL ;J �	E qK }� ! � �protected f' [  #x,! y� �7return x * 10000 + y; // A big number, the size of which I don't think  �grid will ever reach
    }
