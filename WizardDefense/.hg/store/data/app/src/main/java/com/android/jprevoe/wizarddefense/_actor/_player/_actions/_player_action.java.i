        �  *        �������� �$�5InN�`�m��K�=            4*  �'package com.android.jprevoe.wizarddefense.Actor.Player �ions;

import < �content.C <xt;  �graphics.CanvaA � z �.Helpers.Unit �Listenable;U @nimaD O  H `Modifi� NPosiC a�.Targetting  ^ Squares] % > � % U5 "VStats
 D AGrid ODraw� bSpells 6Def
 Finer�� java.util.Array}�;

/**
 * Created by e � on 8/1/15.
 */
public abstract class ��� implements �� {
    protecm �oolean mDone = false;% �" mO  e/ my{ �CostPaid hivate JW$ m
 ";
. �void advanceTurn()�   � 3trud }= �drawValid� 2sOnu(g! p ",  / 2ing #, �" c ~ Oif ( � == null+   breturn� � � \�.reset()0 _whiler �.hasNext()t �! t? / =u 2getI w � 7.isY(IR(int)g *.x y�   �.~��Reticule(��?,
  �  � � fX() + � " Y" y[ *}

 +}
�enum Dire��{UP, DOWN, LEFT, RIGHT, NONE}��(-s	 	 =  o` 	H) {}+ 	6 ge 8 
�~ $ Is�(:  �; 	2can~ ?Use� ,��eventCoord�.�
�int deltaX =�(x O.x -�.);B YB ?y -�-);<��  /Y))3set: d2	�Td ] 0pay+M�NQ� �Q )!�mt4().� ?  !    s�}� restart�aFU �@Override-��CallbackQ� timeType,�@ uni�
� �Ilong��Time();
}
    �     F  7           ���� {��*�O$)����m�C=              �  (   :    public abstract long getAnimationTime(Player player);
    �    n  �       J   ����3�w&݊&./�
�^ق�Yp=            4�  B  � � I    protected int mDuration = 1;
!  �TurnsSpentUsing = 0;
  �  �     * +S B  � $ �+ �
if (spellDef != null) {
  � , �.getCastTime() +�  4 o} elseE , �

    X   �� �ublic final UnitAnim; &ge �(Player p �  � <� <- 1� areturn� �  Athis� Fhild� �  b"_ * H��abstract� L 
� ;�}  �   .� � &>=�  � �u  �   P= 0;
