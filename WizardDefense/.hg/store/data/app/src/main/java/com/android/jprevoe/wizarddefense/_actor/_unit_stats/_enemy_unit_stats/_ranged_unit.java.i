        �  8       ��������%��
��z�p~��އ��Hf            48  �0package com.android.jprevoe.wizarddefense.Actor.UnitStats.Enemy �;

importJ � Actions.AttacksZ  RBasic ;V 7oRangedW ,�MovementX PSmart U  D 5 "�
 �priteCreatorL -�D �R;

/**
 * � ced by , � on 7/27/15.
 */
public class � u � extends � � {
    @Override > �void initialize(B Sunit)6   gsuper.& ! ;    B.add�_(new � ?(3)4 Z(6 �5 6 m� Im�-= ��.get().ct�FromFull. �("character_r� "� /}
UProtec��float Ge�xHealth(S�return 1;
    }
}
    �     �  �           ����XH���fgھ}��p�<�@R            4�   B  M �= Fimport com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
  � p     } ��  �   {
 �@Override �protected String getCurrentc gFrame(h & s ") W   �return "character_ranged";
    �        �       �������������{~Hj ��KYS�W;                �     @  �       M   ������ꛏ�X�9�T�oz2z��I              1  e   4        unit.addAction(new UnitActionSmartMove(1));
