        �  �        ��������H'}\g��f΃)~�]7���            4�  � package com.android.jprevoe.wizarddefense.Actor �ions.Movement;

importB @PosiD ;9 7Unio �	java.lang.reflect.Array;  Butil 0Lis= �/**
 * Created by r � on 7/27/15.
 */
public class { � PSmart� x extend  c{
    > 8  0(in� soldown)/   esuper( ; } �@Override\  H CgetC1 hTurns(Q �return m" BDurayZ [ �void pickTarget(� ] unit� .& ! ;  m � = null;
 Qif (m� �BeforeUse > 0\ � P }B �// TODO: ; �a priority system to figure out where FmoveC *<� �Square> t s� 5ew & (� Afor ��deltaX :+ � int[]{-1, 0, 1}� X X.add(r H.get ?(
    ],  D XSX() +� 2 9Y()( )� 6}*/xGthis��WalkAroundWorldObjectse|privateX@ n 5�isFriendIn*n)>
 � �Everything� !> � �nt randomizer = Math. �() < 0.5 ? -1 : 1f'0,R 6, - xCfloaD 4Y =M p== 0 ? s 0s jQValid�ePH o
�Y!.ch(= 
p �
�}��boolean � ~,� X Y#  E �Handler().canQ  �.On��bN().x�/ 	:y +/� ;_ fP }
}
    �                   �����6�,�b4iZ0gh�����
i                �        �    b  o       B   �����m�Mw_���%n��-0�\�d�            4g  C   � �&:import com.android.jprevoe.wizarddefense.Grid.Battle b;
   �<
    protected ArrayList<Position> getPossibleMoveTargets(Unit unit) {

  7 P hear8 6 = | F.Get s().getH) 7 5();K Fif (F `= nulll   �return super.� � W &}
� � �al = new � tal.add( �.create(0, 1)� A.x >3� � <X()� [ H1, 0[ o} else< -= +

E�al;
    }
    7     R  s       C   ����1�'���(#�Bt�*�-tS/              �     .        /*if (isFriendInSquare(unit, 0, 1)) {
    $           }*/
    �        s       D   �����ۥ嚫ɷ�)�k�ҡP��6            