        <  �        ����������p��+3�׏��剳E�            4�  � package com.android.jprevoe.wizarddefense.Actor �ions;

import 5 �content.C <xt;  �graphics.CanvaA z �.Helpers.Unit �Listenable;U @nimaD �.BasicAttack O (/NoF ' � { (} �
/**
 * Created by H � on 7/27/15.
 */
public class `� implements vs {
    > �static float MAX_PRIORITY = 9 ;1 HHIGH2 O1000. :LOW- + (NO* #-1* Protec�int mTurnsBeforeUse = 0' aWindup-  v K ASpen/%ng� (;
�  , �getCooldown6 #()R  dreturn� }= �void pickTarget(�P unitA 0  
�getPriorityj )t "do
r I G�  �+ Math.max(P�- 1, 0);N Nif (N)>=� � 
0T }�  	7 �  � /�G.get /()@padvance� 	�� >>> 0� 
a-�� ;<:+^ ;�boolean canB� dX� /<=�aE�Callback()�timeType, �� � Co�/te� [RrawOn�( ! c #, " c � Q IlongtOTimex
 y) this.�/ .K �);
    }
}
    <     �  	           �����暔:d��&�r�պW�;�            45  B  e �' >import com.android.jprevoe.wizarddefense.Actor.Playe b;
  x �% 4    public static float VERY_HIGH_PRIORITY = 10000@ "� 7 �
A �boolean canHitUnit(Object grid S) {
  Fif ( � instanceof � ,   �return true; +}
 �false;
    }
    6     (  	           ����
.o��\���-�R�Qt�;              �  �       public void endTurn() {
    ^       �          ����������lFY���XS��K%�               �          j     a  	       9   ����������tۗ��겍Ձ�Ð              J  J   U    public boolean UsingThisTurn() { return mTurnsSpentActing == mWindupTurns - 1;}

    �     �  	9       :   ����W)��;��5���^sed�B            4�   B  � � &
    }
 �public void startTurn() {
  J  �   a* �boolean UsingThis1   �return m �sSpentActing >= mWindup � - 1;
    }
    Y        	9       ;   ������f�x_ G&�q%�t��7            