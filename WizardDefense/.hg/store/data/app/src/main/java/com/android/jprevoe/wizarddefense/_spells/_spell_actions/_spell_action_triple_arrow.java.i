        ~  �        ��������iR� �.���*��~�"�            4�  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import? �Actor.Player.@   ;L ,�Targetting.Square Oable[ ?osi� "OUnit5 T�Projectile H 5SAnima�R  6Def
 Finer��
java.util.concurrent.Callw�
/**
 * Created by o � on 11/10/15.
 */
public class f�TripleArrow extend � Shuriken {
    F @ (� � # s	 )D   esuper( ; mh � h�s = new v�(-1, -6, 3, 4B 0Dams2= 2 "}
� Protec'��O get  (� areturn� W ; 	� �@Override\dvoid a2  ��
back(int timeType, final ] unit[.A = 2 %;
2 Afor ` 1x :� `int[]{`X0, 1}^   �! t�$ =�D.add �(x, Math.abs(x));C ,& p = !.c�(� E.getDa O),
   � ,� 6 	� PROJECTILE_TIME� �  � �Listener(c Uttacko � ,�  � 	P � 4 �Handler()@Q (v � }A�# � 	DU��b 	� A� Ob� � call() throws Excepr d) (� � #�Team.ENEMIES, 1);X � :ull }i�;
    }

}
    ~     `  �       1    ����1�x�S�>"\���/����5��            4h   �  �  �   \   �9PROJECTILE_TIME_PER_SQUARE * Math.abs(target.y - unit.getPositionY()));
    �     H         4   ����+0��wfR�a��l�            4K   �  �     ?  �return new ProjectileAnimations.Arrow �(false);
