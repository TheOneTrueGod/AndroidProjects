        �  
�        ��������`����!��wr��7Īk+            4�
  �*package com.android.jprevoe.wizarddefense.Spells;

import2 �CustomCallback ;H z  6Def
 Finer� �java.util.ArrayList; s  oVector  �concurrent.� �
able;

/**
 * Created by � � on 8/7/15.
 */
public class Player�  � � {
    private static% m ;5 
^! m. 0Use1 e(5 "<LY>@ s6 tInteger( JBook+ W * m�(  � mPrimed z = null7 � 5 `1 ~Z5get #()�  Lif (w" =� (   ( L newl 5();6 }
 oreturn�}� �void Set�(c�� % =( 
s g� M s� � 	�)  ,  IR +
  �1.as �0, 1, 2, 3, 4, 5, 6, 7, 8));
< "adON(0); 1 2 3 4 5 6 /7)���(int index�B0 <= 3 &&	 <�|.size()��% Bget(\ ��
� �p�� � s	 � s�=p� _ else2 f � _this.L .%(� x 	7�� E#usC�� !��iremove3 �	�/);i� T�  �	Z�
 }�� bdouble�I��= Math.floor(b" * �random()�ys.add(m�4Get (� c  C �)� )0 .))o�  �= Dx� -Y � �&on�g 	 � G% =/ �;
    }
}
    �      
@       
    �������=>Uqt$a�a�}B�X}            4�  �   !  L   :    private ArrayList<SpellDefiner. qEnum> m �Book;
  �  �   A  J @s.asN (N �.values()))M ��  �   iE �for (int i = 0; i <� �.size(); i++) {
 1add( (/ Pget(ik % �}
  	�  
   uFvoidD �   s
 (ID{ n ys.add(m7 4Get �(spellID));
    �     F            ����!�R���^gq�����A            4�   B  � 3 �  �addSpell( �Definer. �Enum.FLAMEBLAST);
5 �PST);
    6       
@          ����bvie��3B�yy�#�H[SC              �  �        B     L  �       1   ����{G�=]�o;���~��]Ft�            4�  �  �  �  �  �addSpell( �Definer. �Enum.DOUBLESTRIKE);
7 �3PKE);
    �     �  
�       3   ����VE��7M4 3?�u.K[�#N            4�   �  �  �   �  �addSpell( �Definer. �Enum.DAGGER);
1 / �/*for (int i = 0; i < m( �Book.size(); i++) {
  �  �           }*/
         }  
�       I   ����ev�[v-+�+�.��+I�            4�   B  W 3 j  � for (int i = 0; i < mSpellBook.size(); i++) {
  1add( (/ �get(i));) � }

    �   (< + �addSpell();
    �     K  
�       J   ������A
��������o)��!?            4u   �  �  W   i  �addSpell( �Definer. �Enum.FLAMEWAVE);
4 �BLAST);
