        �  �       ��������&[�]R�!-Mf�y��mb`�            4�  �0package com.android.jprevoe.wizarddefense.Actor.UnitStats.Enemy �;

importJ � Actions.AttacksZ  RBasic ;V 7oRangedW ,�MovementX PSmart U  D 5 "�
 �priteCreatorL -�q/**
 * U ced by D � on 11/14/15.
 */
public class MeleeI � extends V � {
    @Override = �void initialize(B Sunit)6   gsuper.& ! ;    B.add�_(new � ?(3)4 �(5 6 ms Im6-= ��.get().c>�FromFull. �("character_m,"� /}
Protec��float GeKxHealth(�return 1;
    }
}
    �    �  �           ����߻oA���}���Ga��7���            4�  C   K �import android.util.Log;

  M # F& Dcom.* �(jprevoe.wizarddefense.Actor.Animation.SpriteState;
  ( p     } �)  �   �@Override
 �protected String getCurrentb gFrame(g & s S) {
  �switch ( 6.geI (().   �case MELEE_AIM:
  �return "character_melee_4";H NWALKC �if (((int) Math.floor� �
PctDone() * 10)) % 2 == 0� � =2";0 }� 3� JIDLE� default01X P   }
    a        �       ��������8�v�]~	>����?�7*                a    s  a          �����L�PR�ű����`�ÉW            4�  C   K �Mimport android.sup �
.v4.util.SimpleArrayMap;
/ $  B  � # C* Dcom.. �jprevoe.wizarddefense.Actor.CharacterAnimationO "s # =O �java.lang.reflect~ (;
  � �List;

  �  �  ��  �  �  mu ns.put(� �.MELEE_ATTACK, new String[]{
  $"c< �_melee_5", %6"5 O});
� RETREAT� 7� 8� ,;AIM� c /4"Z ?WALc2� 1 3* ` 8P%OIDLEK`1"});
    �     ;  7          �����lpK�WĔȻ�t��n            4X   �  �  �     �"character_melee_5"
  &  [, Pe_6"
         g  �          ������z�{Z�,�E�k���0�ڌ            4i   B  5 � ]
    @Override �public float getImageScale() {
  �return (( �)(40.0 / 32.0);
    }
    v       �       &   ����zM��Y`'#Bh��e]�            4  B  � 3  �
mAnimations.put(Character �.DYING, new String[]{
  $"c9 �_melee_9", /10 %1"P O});
� ?EAD� p P });
    �     3  �       '   ����F��Z�g�Ej��`�;���.            4F   �  "  r   :  �"character_melee_9", P_10"
    (        �       (   ����H�a/�Ј��ÿ�e�[U�p�                (     ,  �       -   ���� \�4���~��)����,�            41   �  �  �   %  �"character_melee_10"
    T     �  
       0   	�����͢g�>4���YYg���,            4�  B  � C�
  �
mAnimations.put(Character �.KNOCKDOWN, new String[]{
  $"c= �_melee_9", 510": O});
� oLYING_� "/11w 'STANDUPt 23� P });
    �     @  
       M   
����ϭ^�k��"b�.���]L�              �      4        unit.addAction(new UnitActionSmartMove(1));
