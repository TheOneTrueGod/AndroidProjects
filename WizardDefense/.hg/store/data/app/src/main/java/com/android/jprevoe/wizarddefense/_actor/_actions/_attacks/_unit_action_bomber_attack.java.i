          �       ��������x��9p�Z*W}Y��'�@�I�            4�  � package com.android.jprevoe.wizarddefense.Actor �ions.Attacks;

importA %�.Targetters.Basic   �;

/**
 * Created by ` � on 8/2/15.
 */
public class UnitL bBomberp x extend  c{
    C = #()&   �super(); �mWindupTurns = 2 �  = new � �(1);
    }
}
        �  
           ����r�o������~�I�k��            4�  B   � �!�import com.android.jprevoe.wizarddefense.Actor �ions.Unit /;
C TPlaye > ?osiw " � 5 �Spells.Projectile H 5QAnimaQ$;
S �java.util.ArrayList; �concurrent.Callab� B   �$ 3    public static final int PROJECTILE_TIME = 300? �B  \     �mWindupTurns( & � 0y
# �@Override
t �float getPriority() {
V �if (mTarget != null   vreturn h�.VERY_HIGH_PRIORITY;2 /}
8 +NO1 /}
� dvoid a� [Pback(6�timeType,J c X unit� Afor . �x = -1; x <=  ,++� , y, y, y, 0 w " t@=� .k e().add mx, y);N �& p = �.create(i ,q ?,
  Onew ��.Explosion /()G ��  �  �  "Pener(� 	ob 
�Z  Ob` � call() throws Excepz{� ��AttackHandler� VSquarP A��Team.PLAYER, 2, true);e � 6% -}
 O);

� &dd�(m� }~ S �damage(9 )s�boolean canHit(�Bgrid ��Yfalse^ �Bpicka(�gsuper.& ! � ��+;
� �BeforeUse > 0�� �<�>[ bm� 0ter� �s� H:T �  � �1can9�bDthis%.x
 /y)w/mT��_breakjP   }
    	     6  
          ����aˈ��9V�R4ו� ��            47   �  �  �   +  �for (int y = 0; y <= 1; y++) {
