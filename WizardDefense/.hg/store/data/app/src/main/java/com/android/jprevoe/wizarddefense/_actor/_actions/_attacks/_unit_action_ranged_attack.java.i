        &  �        ���������{�=ۺ�g���Nf��ɒ            4�  � package com.android.jprevoe.wizarddefense.Actor �ions.Attacks;

importA %�.Targetters.Basic   ;` @nimaC O g  O (OUnitH ' > 5 �Spells.Projectile H 5� ��java.util.concurrent.Callaby �
/**
 * Created by y � on 8/2/15.
 */
public class <�bRanged�x extend  c{
    C �static final int PROJECTILE_TIME = 600;
4 q #()Z   �super(); �mWindupTurns = 2 � = new �S(4, 0U }� �@Override� dvoid a� ab�  � �timeType,�  � X unit� �& p = !.c�(: �.getPosil [(),
  m� ,� !�.ShurikenWithSlashG �\� �.addListener(o ]	�8J @ ObP � call() throws Excep� - {� 
PHandl�!.a uSquare( t��Team.PLAYER);U �return null } #})�� 
&ddv(-Ivlong ge�_Time(4Qif (m�ASpen Yng ==���  � h8is.m ^-).� <) +!o} elseh 1' �
    }
}
    &      	l           �����d�p|�yBwS��
81��h�            4�  B  � � �    private final ProjectileTypes m (;
3 �int mDamage;
 �ublic static enumR 3{
  � SHURIKEN, ARROW b}
  � $ �* �this(2, 1,O .E #);@ � �UnitActionRangedAttack(� �windupTurns,� d� a ) p �) {
       >� # =H %;
 Wj ( =x ;J X %0 
rO = p� � �rotected� PAnima� /s.  O get  '()��switch (mP�   Bcase�;:
  �return new� WArrow~ ;Z �
] defaultr �ShurikenWithSlashu  w��  =   8[ �mTarget,�.A�,
  �  .   ^D @unit; ��Handler().a uSquare(i  �. �Team.PLAYER, mDamage);
    7     /  	�          �����
�4��j�mV���ȩb�p            4/   B  � 3 #  �mMoveDuringAttack = false;
    f       �          �����z'a�m��g�����               �  	�        r     G  �       4   �����L!�ݶj܊��M|�s4y��            4R   �  �  �   F  �return new ProjectileAnimations.Arrow �(true);
    �     �  �       7   �����Eї�]2@���/�O�R��            4�   �H  �  �   >    public static final int PROJECTILE_TIME_PER_SQUARE = 100;
  �  D   �  �mTarget,
 �this.getProjectileAnimation()+ z �* Math.abs(f �.y - unit] 0osiR �Y())
        );
    |        �       8   ����KL��z찪[�����:���                |    V  	�       H   �������#���_�i?�m�jI�7�            4�  C   � � Yimport com.android.jprevoe.wizarddefense.Actor �ions.Attacks.Targetters.Line � ;
  v  �   1  m? & y = new : 0(4)= �5  �   �  �PROJECTILE_TIME_PER_SQUARE * Math.max(
   Rabs(mg �.y - unit.getPosi� _Y()),; x;  IX()): �)
    � s ; A�Handler().a dSquarel 0, U.   �Team.PLAYER, mDamage);t �return null;
