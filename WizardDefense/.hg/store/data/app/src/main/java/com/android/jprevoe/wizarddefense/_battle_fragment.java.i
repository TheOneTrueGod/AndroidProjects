        �  ~        ������������g��fs�T���k鰐            4~  �$package com.android.jprevoe.wizarddefense;

import ' �content.C <xt;  � graphics.Canvas  �os.Bundle 0sup �.annotation.Nullab, � v4.app.Fragment( 	�
view.GestureDetectorCompa6 �util.Log D % �LayoutInflate$  Mo� .Ev� ! OView ]Group �widget.Linear� $ "stc � .A� p.UnitFa /y;< !RStats
 �priteCreaKL TBattl 8 CGrid6   : �Spells.Player  @A  �rojectile AAnim�sR  _HoldeB�UI.Ability� AAdap��
/**
 * �ced by @ � on 5/1/15.
 */
public class S�� extends  �{
    private � ) m� & k- m|/ � s4c� �newInstance()�   `return 2 "()� }� $ $ mp @� �Override�  _2 onM  (# i	 ?,
  	k  � �?ain< yd saved �e�� .setResources(g 5));8 � TmainC� % =� .	 A(R.l!.bJ_�,� � false);
X �, =E.get (� � � H= (( )� P.find) �ById(R.id.  � � 1v =DM]  �Activity! pOnClick� e#c 
M , � v�uOnTouch  	L - �SoundEffectsEn$d(l) &//�.SQUARESIZE_X = vf�Width() / ) BGRID' J YJ oHeightK Y�initialize(v� �1.ad�Y(v, 09f=$( skR_list
i .� ���9, v��& a�� �  	e \   (��=	� 6	7Hvoid�4nR' =�	�#�] �)� �w� � - �" c �  d0sup� � { 39oV
"ed;ronDraw(K! c h .* # n 0draT# * S, get� 	�}�
(�PimpleC:.�/ {� 	\�boolean o; 0', *  e Eif (��sTurnBeingTaken() ==X� ha� (d ;, �Jtrue /}
' �}
    }
}
    �     k  �           ����o ���^,�WK����V�            4�   �    L  "� 3 �  �UnitSpriteCreator.setContext(main vainer.g O));
B 
�ResourcesD (.g( P));

         �  9       <   ����6�$*��B�ĊD� ��            4.  B   �1 :import com.android.jprevoe.wizarddefense.UI.SpriteLoader;
   3 H  �"BattleGrid.SetDPI(getResources().getDisplayMetric � density);

   $ =T v �.setContext(main vainer.g  ))� qm  	  "< / 3U � � P());
    �     �  X       ?   ��������6h����y�$I��2            4�  B   � &    private BattleActivity m
 �;
    4   N2 �ublic static8 �Fragment newInstance(S b �) {
  �  �   �  m6 �.initialize(� 0);
# !}
 �@Override
� � void onDestroy(f Z gsuper. ,;
u  -}
] 4set� � a $ =& Pity;
