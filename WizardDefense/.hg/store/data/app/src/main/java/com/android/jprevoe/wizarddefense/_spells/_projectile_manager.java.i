        �  �        ����������UH�Ғ�+$�)e�	            4�  �+package com.android.jprevoe.wizarddefense.Spells;

import . �content.C <xt;  �graphics.CanvaA s �.Projectile I �java.util.ArrayList; @Coll: /on  4 �
/**
 * Created by � � on 8/14/15.
 */
public class � �Manager extends � <$ �> {
    private staticE  m Igr;
6 / #()X }) � ^ 5get3   Jif (r � == null&   & O new� ;6 }
 mreturn� � �@Override� �boolean add(; 0 ob
 � ` `super.. # ; �void drawOn�(  2ing #, �" c o Hfor � p l: this<! .z s k C�  �animate(float interpol�� Time, long dura�JMill� 	��toDelete��>�� ;�int i = 0; i <�.size(); i++!" =-  �?i);G � � 
B  �F �isDone()�   P4 Q }� � �removeAll(I �);
    }
}
    �     �  �       !    �����c=5aw}�M����3Q�G�B�            4�   �/  �  �   *    public void animate(float currTime) {
  �  �6  �projectile.= 7 b;
  ~ 7 P
m � boolean hasAnyPD  s(l \ �return this.size() > 0;
    }
    h     �  �       "   ������ה�S��f;���'Pv            4O  �$  J  �  C    public long getTimeLeftInAnimation( @curr S) {
   t2 U = 0; �Projectile p  �for (int i7 � i < this.size(); i++j � S =- yget(i);& � �Math.max(: .� � ,A X }
 �return timeLeft;
    C        �       #    ��������W�l"Ӱ���M�!R�K                C     W  �       ?   �����vk]�nf �;)`'��練u              �  �   K
    public static void onDestroy() {
        mProjectileMgr = null;
    }
    �     H         @   �����'�9|��+3�nM�tڰ�w              �  �   <
    public void turnEnding() {
        this.clear();
    }
    �               A   ������>7ҳ���X���I�[�b            