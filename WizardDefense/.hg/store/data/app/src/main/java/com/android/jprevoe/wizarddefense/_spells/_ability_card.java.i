        
$          ��������m�瀼o7��x�� C�            4  �+package com.android.jprevoe.wizarddefense.Spells;

import . �content.C <xt;  � graphics.Canvas  �drawable.D	 + �media.Imag  | n.Layou� �util.Log Cview5 �Inflater$ OView _Group �animation.A
 ) �BounceInterpolator2 �Transfor` �widget.Frame"# [� ! oLinearE Relativk BTextj Q��Actor.Mana#�; �UnitStatsE oAmountE �CustomCallback H R, w 6Def
  in�
/**
 * Created by H �. on 8/6/15.
 */
public class AbilityCard {
    private final e �Holder m ;,   �b mMain�" t# mcd' 
3� mBackground�- �  m� "  \! KTitl! � � `naCost�<ain� q~
* �Boolean mSelec�= false' OPrim% O% mX bC  En* D btrue;
& ��(t s� ?,
  x c ( 
6# i	 0 ($ cg, ~s \ 
# m�5) {( �I = m� �G = (�)� .	 A(R.l ".aX _iz,� �)b 	z l8= c�  `update�C Gion(Y Jif (� �instanceof � {52 � J)A.fin	 pById(R.�2ard� *);R � X 
�] bC c � ] �� t8 Q � Y � �mana_cost_ f k} else}wLog.e("�E", "C0fai��on me. :("P 
��.setOnClickListener(new. �@Override =0voi� B (bv@  �!�  �jreturn|}C %C aPlayer � E.get @().pB (�-);C $ /()� 	(p.invali|2 7});��<= s,)}
�W��  � � != null && U�() == this.
G�oColor(m� n �Resources} 6 0R.c ^.red)	�" =�� \^white� � [Yblack� 	-�=	!ge�	'_X	
H b�t|(�s) �s�H
R &	 � ; � Ic�V{switch + oType()�case Fire:�� 
�� Rm%�<fir/] obreak;� nWeapon� default� Eww � }Y z  Y� Na:� 7 <2 J�;   sD�=�O|| !: s.equals0  ��.removeAll/s(* O �(�1  �int tota� 0# Vfor ('n �  t /:   .values�w `ceilAmu �(int) Math. (� )(g )� $+=Q * �  w i� E i <1 O i++�   �Piv = � ]	� vO� Q�rystalRes��: �ForSpot(i, >,V  ( % )� j
�Params p 1' � b �.FILL_PARENT,G 4_ 1.0f� �  ��Margins(1, 0,  	� J 4 	!ad?(iv8 /}
  ��>= 0�� s�#si{Q�INVISIBLE� �_ ] � W�
�.;
�fN  �
�O���5was;c1.unF 2All!K �b � u�  .un� �[  is� ?ing�	�se��  E*eI���Mlp =[�$
a�WRAP_CONT�= SMATCH�+);� �float orig {Width =O  	�
(lp��(I )�0��	/lp+ 	wAlpha(1# H# a( /()�2rot�JpplyC($i��edTime, '  `&} * (1 -` )?G 
�} a8 2Dur� �600); // in ms% �S�/()�Ftart�aF0dis�
F�Q/en< 	��BOut(
�) c b ��Er444	�A�*F Se(�
  V �f $?Endd y
4^.callF� '_Repea� 
 �P }
}
    
$     S  �       I    ����Z*����	.�&^&�����            4�   B  � 7 /  �mInflatedView.setAlpha((float) 1);
  � ;  " / 1; `0.3);
    
w    I  �       J   �����TK��p=�z	D�)NW$�            4d  B  � �( 1    private final int PRIMED_TRANSLATION = -20;

  � 3 �  �	ViewGroup.LayoutParams p �= mInflated) H.get' D();
I 
) �setAlpha((float) 1+ 	�TranslationY(0);� ��     ?6 : � K q�  �  " / /S 	� G ��  L   v�  s�castTime = spell'C #0 Pf (mS& � == null ||B ^!= mSD �) {
  �  �  +  Pfor (� �i = 0; i <T P; i++A    PImage� � iv = new �(mContext);<  iv// �Resource(R.drawable.icon_clock@ bLinearo~ � ' (V ^ �.FILL_PARENT,C 0_ 1.0f� �  '�Margins(1, 2,  V
� 0 �mManaCost��ainer.ad�1(iv���  �   &A  ��p= 0) {
