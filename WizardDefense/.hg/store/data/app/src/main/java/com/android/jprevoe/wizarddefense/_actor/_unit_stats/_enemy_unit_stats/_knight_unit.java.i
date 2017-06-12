        �  �       ��������t��8�Q����jt�4P_��            4�  �0package com.android.jprevoe.wizarddefense.Actor.UnitStats.Enemy �;

importJ � Actions.AttacksZ  RBasic ;V %�MovementW PSmart U  D 5 "*
 �priteCreatorL -qq/**
 * U ced by D � on 11/14/15.
 */
public class KnightJ � extends W � {
    @Override > �void initialize(B Sunit)6   gsuper.& ! ;    B.add�_(new � ?(3)4 .(5 6 mt Im�-= ��.get().c?�FromFull. �("character_k-"� /}
Protec��float GeLxHealth(�return 3;
    }
}
    �     �  �           �����C�����k��^"1�            4�   C   � �<Fimport com.android.jprevoe.wizarddefense.Actor.Animation.SpriteState;
  � p     } ��  +   z �@Override
 �protected String getCurrentb gFrame(g & s S) {
  �return "character_knight";
    �        �       ���������!�.�oJ1��j��<�                �    I  	�       0   ������LS�=7s�����hv            4�  C   � �0�import com.android.jprevoe.wizarddefense.Actor.Animation.Death /;
I &� KnightKnockdownS B  < / C_ �CharacterO # 3�
  m! ns.put(9 �.IDLE, new String[]{"c' �_armored_1"});W �MELEE_ATTACK_ '
  l  ?5", 56",: � "RETREAT� 6� /7"� +?AIMv4v?WALn2� 1 3. h >`%_DYING�melee_9", /10�&ODEAD� l �  -  �  A �public void on��Trigger() \ �UnitStats s =� Mc   (�   E.set4 (4 # "//% Eplay� (J.get (5 5get APosi -))� 
] - O  q �  �  �   o} �return 1� !}
 �@Override
t�float getImageScaletJ (( �)(40.0 / 32.0);
    �    ^  �       2   �����u��8GNU�P��KAy��            4[  B  � �- �import com.android.jprevoe.wizarddefense.Spells.Projectile /;
H 3�Animations;
S �java.util.concurrent.Callaby B  8 �< @    private static final float HAT_FALLING_OFF_DURATION = 600;

  =  �  "	 C*
  � & p = �.create(mUnit.get� @Posi [(),
  . Onew 4�.HatFallingOff C N);

� �ttackHandler().add (	Ple);
    G     @  �       M   ����Sewv�a��aXZ+$�t���              �  �   4        unit.addAction(new UnitActionSmartMove(1));
