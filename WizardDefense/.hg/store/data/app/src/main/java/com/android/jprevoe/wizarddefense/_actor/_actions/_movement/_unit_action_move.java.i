          �        ����������#��|�Tqz����ĭ            4�  � package com.android.jprevoe.wizarddefense.Actor �ions.Movement;

importB BUnit ;C OPosi9 " t 5 PAnimao �  H (GWalkH �
/**
 * Created by H � on 7/27/15.
 */
public class B �x extend � {
    protecZ �final int mCooldownDur� 
+ d� mTarget = null;
( � 
� (Y cX )}   �super(); ~ % =9 & }h �@Overridev  g 4getD hTurns(p nreturn� [ �void pick� (� ] unit� .& ! � 2  Qif (m� �BeforeUse > 0\ � P }B �float deltaY = -1; iX = 0;w  � @.get�PHandl�@.can�  ��OnSquare(
   ; ,  Q (c().x +� / y/ ,Y)B0 !.c(` 9 %�! � yriority4�w !����.LOW_PRIORITY� 2 +NO1 �"do; ��h
  1 ��),�< � 1  y
�/+=� 	� B  "�	t � 	 (h-� -� 
� �Aslow 	 YAmoun� �  ) �;
    }
}
        "  n           ������:.����ty���b�            4�  B  � � import java.util.ArrayList;

  � ��
    protected ' �!<Position> getPossibleMoveTargets(Unit unit) {
  �int randomizer = Math. �() < 0.5 ? -1 : 1;
8 x �al = new 5();< tal.add( �.create(0, 1)' � ?, 00 -1 2 �return alE +}
]�void pickC�WalkAroundEverythingVt�� = this.�J � Efor � C $ :L s ��f (isValidT M ,- %.x
 ,y)9   m� < = BA  ;? L
 *}

 a�boolean � Q�, float deltaX Y� � 3  V E �Handler().canQ  ��OnSquare(� n  �d().x +� / y/ ?Y);tFriendI� ;_ dP   }
