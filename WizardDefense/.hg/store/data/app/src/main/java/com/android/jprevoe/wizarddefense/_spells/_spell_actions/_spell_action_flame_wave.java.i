        ?  e        ���������k�C"�!��x�w�)�            4e  �!package com.android.jprevoe.wizarddefense.Spells �Actions;

import ; �content.C <xt;  �graphics.CanvaA � cActor.z �.Helpers.Unit �Listener;S @nimaB �.BasicAttack O (�FlameWaveS 7� H &VPlayeD /AcL ) > ?osiw " 5 �Grid.Battle :   ODraw� )�Projectile H 5sR  6Def
 i8��java.util�Acurr�Pallab� �
/**
 * Created by o � on 8/25/15.
 */
public class :� extends �s {
    = �static final int ANIMATION_TIME = 200;2 
�PROJECTILE3 33 4 � (,# s	 )�   esuper( � }b �@Overridep �boolean can� 2Use ( ! p $, +� eventCoordz �return truev �void drawValidTargetsOn�y  / 2ing #, �" c �  key = 0; Pfor ( x f x <= ��.GRIDSIZE_X; x++N R sf (x !=� D.get<X().   �.� � �tingReticule(� � ?,
  /x,~  }Y() + y5 )); *}

 .}
�o�� �		6 ge L   �} anim =� 0   (KH/()y
�Z � E.addr �(� � ATTACK_FINISHEDu Nnew LT(this <));v � v2set��t �m2 / =:  J0, 0wqprivate��getDistanceToEdge(C  ��)Math.max(| ?.x,�5 - # )a� MAback�timeType,� �] unita.A = 2 z#-1{  L+= 2;z �% =� kxk��& p = !.c.o , � ���.Explosion�U� �  �  x Ww m� ; x)L    ��sHandler�g (r /);)�A� � implements ��> Q0mUs� ��"  DSmDire(! ��s� ,N dM �� I = u� 

t�  � & =^ T��  Ob�� call() throws Excep�		� � dSquareB,���Team.ENEMIES);�60 <r8x +� /&& <��b ��0��D�&02
� �Onull9 �Ilong)	?Tim+ (j<+ (J * ".` �));
    }
}
    ?     >  r           ����=�/�6�����E�S�i��              �     2    public long getAnimationTime(Player player) {
    }     �  k       J   ����oPѭ�9��߂�����л            4�   �  �  ^   U    public SpellActionFlameWave( �Definer. # s	 �) { super( �; }
  �  �   <a �UnitAnimac � getChild �(Player player) {
