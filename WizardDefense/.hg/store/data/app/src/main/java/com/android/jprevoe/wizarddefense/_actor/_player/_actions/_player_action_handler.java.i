          Z        ��������0Z�<b���%���1
 Q�P1            4Z  �'package com.android.jprevoe.wizarddefense.Actor.Player �ions;

import < �content.C <xt;  � graphics.Canvas  0sup �.v4.view.VelocityTrackerCompaV �util.Log D  Mo� _Event! e �  ;> 0osi� 9 �Grid.Battle : �UnitMoveHandl� cSpells�  OListA  6Def
 (inzostatic�$  b.Direc`�
/**
 * Created by V � on 8/1/15.
 */
publ� Xlass O 3� {
    private� �final double MIN_MOVEMENT = 40.0;5 . �- m�4 �  + , m 6 lWait m 
6 - m( . Afloa�}rtX = 0 Y [ WQ #()S  l = new+6();2 3  ([ D !D   	x %=7t.obtain5 }	avoid h� gClick(�  e , ! p &:G �1med K =
  �E.get %() PE � Hif ([ x!= null� <~ 2.do4(� � ;1 freturn &}
s �nt index = � S I  � - �switch () @Mask� � Wcase m�.ACTION_DOWN:6�@.addDBmentr -);5 � /X(' Y' Y' obreak;�  u� 4v (w  >UP)v  //��historySiz��Math.max�H  �() - 1, 0�  U\deltaX� - this.u; 
l	; Y;  �t *} +K *	 <�* ~ $do�_Touch)
_ elseM  � [3abs� J) >  /Y)� �  .0;$ >< 0N R   �/-1S � Z >Z Y 	 F[ YYYY"��Swipe((int)!,  s �	H}o  >}  YEu== 0 &&#=N��.setTurns(1� k    �Selected�D �
 �` targeo(f 4get  ()� �
�	B.can 3Use� d ,v )
D  , ; :8 6get�rSquare(u =e" U )NY	�DEPRECATEDc	� ��8 S�) �Coord = � !   hinate(�,�));.
��(b ^.x - \XB YB yB � }�/3\y 7S�drawValid� 2sOn�(�",  / 2ing #, �" c N^O*� � � � t�}
    }
}
        �  ^       
    �������>
�2bJ�4�g|!��            4�  B  � �$ Jimport com.android.jprevoe.wizarddefense.Battle.W D �&MotionEvent;
  t  �   M    public void handleClick(B   e �, Player p �) {
  D  u   d  �primedSpell.doAcJ (� �Grid.get �Coordinate(b   UX(),  TY()),q  � q�  �  �  K   F  �mVelocityTracker.addMovementk � !()^ o�  R 9�	j  	�   g   $doD _Touch#3��  �   G�Bvate�p @Posi� N l 
�Pr) {
    �     1  �       M   ����:�
\�C�d��m�j�T��            45   B  5 7 )  �mPlayerActionMove.restart();
