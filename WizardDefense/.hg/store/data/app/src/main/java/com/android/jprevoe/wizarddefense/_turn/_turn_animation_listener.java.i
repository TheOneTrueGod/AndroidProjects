          0        ������������a8T�#�"��A���G            40  �)package com.android.jprevoe.wizarddefense.Turn;

import , �view.animation.A
 * Z �Actor.Player Cions  �ChargeMana;V $ > TBattl 8  &�/**
 * Created by 8 � on 8/3/15.
 */
public class F �Listener implements Ar' �{
    privateK + m� * � $ m�  @$ mH � � (x t ?,
  � b 0 � p 5) {2 
� N = t( r 7= b�  \ =^  }�@Overridefvoid of fStart(� /� M ?EndK 	� �@eFor =(1)� �wEnding( �switch (P �getCurrent hType()  ��case PLAYER:�v qadvance�   �	Handler.TURN_TYPE.ALLY);A nbreak;q  / o )OENEMp 0 q �boolean skipi � = falseY Cif (`B.has�N/ �getSelected7 P inst� ?of ?Y 
] !^ �canAffordPrimedSpell� �� _true;- } n} elsed ` /}
 InisDead� u _ 7 W �G)y �}^_Repea�P{}
}
         M  )           �����94Ja���`��k��\ �              �     A        mBattle.TurnEnding(mTurnAnimation.getCurrentTurnType());
    ^     �  	H       !   ����@J���	�a�D�h�Q^��%            47  C   1 �import android.util.Log;
  � 3  �if (!mBattle.isTurnAnimationOver(m �.getCurrTime(),  0ent �Type())) {
  4 �incrementIter ?();1 	_reset$ Mstar$ �return;
        }
          �  	�       "   ����Q�����v����W�fi~ԕ            4�   �  �  T   �  �*long timeRemaining = mBattle.getTimeLeftInTurnAnimation(m  * @Curr. O(),  0ent �Type());
� Jif (� �> 0) {
  �  �   7  _ bsetDur� H Png);
    �        	�       #   �������)�� ��K�W�J%��~�                �     �  	�       '   ����?�h!8�x�形�I�Ǖȶ�]            4�   �   1   J  ��  i   �  �*long timeRemaining = mBattle.getTimeLeftInTurnAnimation(m  * 0End- N(),  pCurrent �Type());
  � 7 $  > �reset();
