          ~        ��������a�Ӫp��  �o���            4~  �!package com.android.jprevoe.wizarddefense.Spells �Defs;

import 8 �content.C <xt;  � graphics.Canvas  �view.MotionEventb � �Actor.Player Cions  ;L $ > ?osiw "�UnitStats.ManaAmountE �Grid.Battle : R, ` OListA  � _ArrowO 7�BroadswordT 7oDaggerP 7�FireDashR ;_stormS 8�lameWaveS <?bla?9OLong�<�ShurikenR 8?pea@8cTriple9�
/**
 * Created by U � on 8/7/15.
 */
public class ��iner {
      Benum CType   uWeapon,  u (}
@ Z D Get w(int i)M �switch (   �case 0:
  �return newb �>();D 1D �C 2C �@ 3@ �F 4�  d@ 5@ 9N6E *A 7A vD 8D gE 9E R\0E  �D /}
�
[�abstract�B`protec rm"  Ic�" 3	' m`- cString' OName% 6m ( �) qCosts =  > 
^G() {� � = "EMPTY NAME"; }:  5get(z�5}M 	<V >X b� svoid doM $  e ,| ! p m �
- �Coord = &
@.get  ainate(*   UX(),  8Y()� ] Mif (� �!= null &&
   0 B.can� 3Use � ,� )� � usU - =f ;= 0 �.setTargetz !%i  D?art� z  � 1Sel� @ /);� �  a().use r }q�rawValid2sOn�(n",  / 2ing #, " c ��.j c \ T 4�removeAndR�!ck�5 �B G�
��T ��	I  � AB   � 
e}7�	d~ extendHn�� >sup�CA = R��able.icon_ability_l�,�_(thisw + "& e=q.�
I;
Hn
G6s�F� E* DE�
A&>6aE;� 8' 5#+ ' "([+8 �PHYSICAL, 1)soy6 �8tW Oshot�2�- _ Shot���E�B7�?� < ' 9E����6br�� �, �+M�I��6dc�� �( 9D�<�?6fT !_w�C� F+  , J �BNFIRE>���"�;��� �, �O3�-�a�7�� �+ c� i��:d�~� } + }[ �	/P }
}
                  
    ����m:��@31ѯڎ[�U�aB�            4H  C   } �-import android.util.Log;
  \  �   �    public enum SpellE
 3{
  �LONGSWORD, SHURIKEN, ARROW, TRIPLE_ �SPEAR, BROAD2 �DAGGER, FLAMEWAVE eBLAST,d �FIRESTORM, ADASH '}
� � tDef Get (� @i) {� ��  �     Fcase� :( ��  �   ( �  ' �!  5   ' � $ �a  u   $ !+ _�  �O >$ ��  �   $ [ ) `,  @�) x% _m  ��( _�  �v �) _�  	
Q � ( o	:  	Oa� ' ��  6   C# ��void doAction(Posi	 � eventCoord, Player p ���  W   ;  s*N �.setTarget(< ,W Prd);
    	    q  "       1   �����׃��2���$�G�6��            4\  B  Z �" Vimport com.android.jprevoe.wizarddefense.Spells iAction �DoubleStrike;
  �     *  �	FIRESTORM, DOUBLESTRIKE, �DASH
  
� 7 R  Icase4 ;:
  �return new � 8Def�  ()� "  !Z@ �public class6 v extend % {y = m ) {� Psuper�  m; �Icon = R.drawable.icon_ability_dW #_sW@ }& =� �_(this~ �Name = ".  / "* 0Typ*  v.Weapon+ �}
    }
    
|    I  "�       J   ����=�<7x�:��s��'ʹ)�            4�  B  > 3 !  �protected int mCastTime;
  � % K- Qublic* 4get, g() {
  hreturnM  �}
  �    "g ( 8@ �mSpellAction = new  �Dagger(this)� b$  _P "� ) VP � o = 1;
k �FlameWaven b�  �n "n / Wn 2n Vblasto b*  eo "� / ;T �irestormS b�  �S " � / :S FDashR b!p  !�R "" / >��oubleStrike(this);
    �       "�       M   ����3sI���~�H	�r§)n$N-                5      �  �    