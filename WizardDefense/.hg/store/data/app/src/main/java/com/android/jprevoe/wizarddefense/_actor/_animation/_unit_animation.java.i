          P        ����������i�-]��͌�����|            4P  �4package com.android.jprevoe.wizarddefense.Actor.Animation;

import 7 0sup �	.v4.util.SimpleArrayMap;/ dview.aO Y � c8 �s.Helpers.Unit �Listener} � 
 �Components  a  � � Bjava5/ � ;  �
/**
 * Created by i � on 7/24/15.
 */
public class � � {
    protecF `long m  [Time; 
��<Integer, � <oJ>> m sR � <M > vB � ivate int mCurr* O = 0o pallback� 	r  � � float mPrevious5  - x 1 |] �� �final double �OPct;' �EventType;
' �u (] t\ ,F eE )�   � L = t�    & =F $ }�  3get[ (t nreturn� M   � 5get� L E� T P 	#	M �o = new&()� s[ �J /G hD 
Rvoid �"e(�@currv ,#X unit% t,1� Dif (> & <b�= . /��  %do� @Beha�%r(�� 
� �� ? 	� �  � qo= null�� _for (c / :'g � �<O .xO&&
   - <z �� (s(I ��
�_whileh@.siz�> � "  �/ =8 � (Z ;s J � 'nd,+	2 ~1�	h� .+++ �continuee��p.�0� eO!= 0� U f/
  	_ - 1): 
� �� U �Math.max(0,q   Nin(1   �, -?) />+ c  � i�)� v_break|�	"
S^
9get3 	a�
��%ddF X2(in� a., y) a y �3 - = �r )�9 	[ 
��  /()=D [.add(� ;�6.pu� ,G .�vSmf l	 :�% 4.do� � �}
    }
}
         �  �           �����A���>>���V��0�            4a  B  I �: Cimport com.android.jprevoe.wizarddefense.Actor.CharacterAnimation;
  � �    public SpriteState get �(float currTime) {
  �return new@ (w e.IDLE,D @ / m P ;O ?}

� �BetweenTurnh � )�0);
    }

    �     E  �          �����;ɹ�������xjb%/Î$              �  �   9import com.android.jprevoe.wizarddefense.Actor.Position;
    0       p          ������'H�Sv�� At�x�#GΩ:               k   �      �  �        H     �         !   �����Qq�[aї ��N�cO�            4�   C   k �import android.util.Log;
    �) �    public boolean isAnimationOver(float currTime) {
  �Log.e("", � + " >= " + mG 3 ;2 freturn/ &>=' �;
    }

    �       �       "   �����������h�z�"�:$(�              N  �        �        �       #   ������f3O���3�W*��m�v                �     �  �       '   ������S���6i9���            4+  B  K �     protected long mStartTime;
  4 3     A = 0$ ��  �   K  � timePct = (curr1 -> �) / (mAnim )W q  {  �n  �   m_ �return new SpriteState(CharacterX �ation.IDLE,� � Pe));
