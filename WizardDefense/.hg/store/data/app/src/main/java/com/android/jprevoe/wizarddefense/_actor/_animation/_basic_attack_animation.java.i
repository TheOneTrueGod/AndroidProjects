        s  J        ���������W%�[�����L�Y߄�m�            4J  �3package com.android.jprevoe.wizarddefense.Actor.Animation;

import; 
 �Components.Retreat ;h ;oStrikeg 0BPosi	9 � Unit;

/**
 * C� ced by 5 � on 8/2/15.
 */
public class BasicAttack� � extends Z  c{
    > �static final int ATTACK_STARTED = 0;0 bCONNEC2 12 aFINISH1 ?2;
2 uDouble ` P_TIME� #.5g arivate[ 0mAc� ZFired �p mTargei ?(4 t3 ,c 1dur )H  �super(); e # =;   _ eTime =K  � z = -1;
: ��add(new �T(0.5,� ?));N t)(1M � pallback� Q  ;(0,n� S 
',�b /,1,�T }��?getq dplayer �preturn � b +
  j �.capDistanceA5+8,s -.x =y),O � �;
    }
}
    s     �  $           �����k"�z�ZD��66��#���#            4�   C   < �import android.util.Log;

   # C& Dcom.* �%jprevoe.wizarddefense.Actor.CharacterAnimation;
  6 � }    public SpriteState getBetweenTurn c() {
  �return new= (t �.MELEE_AIM, 0);
    }

    D     H            �������ȯ��J	;�2�0zR�L>              �  	   <        return new SpriteState(CharacterAnimation.IDLE, 0);
    �     �  E          �����\q�p^�GΒ-���ђ            4�  �  �    �    public SpriteState get �(float currTime) {
   �animPct = (% � / mAnim1 ;0 Dif (. �< CONNECTED_TIMEX   �return new� �(Character_ �ation.MELEE_ATTACK, � )i /i � o} elsez ,wRETREAT{ | -� N/ (1 � P   }
    y                 ����U��i�<�C��Kw�S½��                !      �  �        �      ]          ����A*���eٓP�\�Ձ�            4�  �$  "  d   T    protected BasicAttackAnimation(Posi	 � target, int dur �, boolean mo �) {
  �  I   �  Fif ("   mj �
Components.add(new Strike" �(0.5, mT� ?));R RetreatS  1Q �}
  �  q   �/�ublic static3O getK dplayer d��     #  8 �motion);
    �     \  �       0   ������&�3�k4B �������            4t   �4  �  �   h    public static final int ATTACK_DAMAGE_TRIGGER = 2;
7 �FINISHED = 3;
