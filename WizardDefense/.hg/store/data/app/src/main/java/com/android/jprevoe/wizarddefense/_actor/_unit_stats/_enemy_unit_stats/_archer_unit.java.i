        �  �       ��������2��6Q٫/CԐ3@�GI            4�  �0package com.android.jprevoe.wizarddefense.Actor.UnitStats.Enemy �;

importJ � Actions.AttacksZ  bRanged ;W %�MovementX PSmart U  D 5 "+
 �priteCreatorL -rq/**
 * U ced by D � on 11/15/15.
 */
public class ArcherJ � extends W � {
    @Override > �void initialize(B Sunit)6   gsuper.& ! ;    B.add�_(new � ?(3)4 /o(3, 2, �.ProjectileTypes.ARROWh i m� Im-= ��.get().cr�FromFull. �("character_a`"� /}
RProtec��float GexHealth(P�return 1;
    }
}
    �     �  "           �������dD����Xm%���o���            4�   C   � �<Fimport com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
   p     } �  _   z �@Override
 �protected String getCurrentb gFrame(g & s S) {
  �return "character_archer";
    �        "       ��������$����cCCf@S�'�Ev8_                �     �  9          ����U ���0m&�N=e���V��            4�  B  = �? Cimport com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
  L  R  �S  �  T  m, ns.put(D �.WALK, new String[]{
  $"c4 �_archer_2",  1 3, d ;N _});

� KIDLE� w  P"});
    �     �  �          ����&og�m7T�K7���t+�            4�  B  � C
  �
mAnimations.put(Character �.MELEE_AIM, new String[]{"c, �_archer_4"});[  _TTACK^ 5^ #RETREAT_ 6_ B  7 ! ]l �@Override �public float getImageScale() {� �return (( �)(40.0 / 32.0);
    }
    m     �  �       -   ����Q����zΉaHԃҩ�            4  B  � C
  �
mAnimations.put(Character �.DYING, new String[]{
  $"c9 �_archer_1",  7 %8"Q ?});� ?EAD� p P });
    �     @  �       M   ����?K:=��s� ]�8)i	�ؤ              �  '   4        unit.addAction(new UnitActionSmartMove(1));
