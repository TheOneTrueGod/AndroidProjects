          	�        ��������\/�b���_^ۤr��Sj4@            4�	  �4package com.android.jprevoe.wizarddefense.Actor.UnitStats;

import 7 �content.res.Resources;& � graphics.Bitmap  _Canva@ �drawable.D	 + �util.ArrayMap 6Log� �Grid.Battle ;: Rg Bjava~ HHash�   �
/**
 * Created by ] � on 8/13/15.
 */
public class �Qprite: �or {
    private static'  m ;9 �' m�* � b Sget()�   Fif (E � == null"   }Log.e("O �Error", "B �not initialized.  Please call� F.set= �
in the fragment or view c- 9");� areturn�  }� � * N new� /()n � �}�Xvoid (r
 � �" 
b ,�Map<Integer, �2> m	 *s;, �  u 5 5O<>()� - ��e(int feet, 
 Bbody
 Rhands 3eye
 �accessory��nt key =H � * 10000 +M  " +Q  ! +T  & +V ;!� 8�ainsKey(key)� b = .�  ?(
    � )��.SQUARESIZE_X, 	/Y,P y �Config.ARGB_8888� �3ing � (� 7  0 ^#On* 	E 6, R�s/`_part_�/_1P 7OfootP 9 P   1�v ,] { }� 5�_ 
��0put�,��
4 !ge4 ��� gc�  �rP$$ d	 =� u " '(r� � � etBounds(0, 0,
k7n  	 (� �);
    }
}
        F  �           �����!А45�n������)a��            4�  C   < �
 import android.content.C �xt;
  J � &    private static ( % m1 R
  L ! W2 Tublic1 �void set0 (A c S) {
  T $ = ; }c �M  x   *� �Map<Object, Bitmap> m	 s� "� '��   � createFromFullImage(String i HName� �//int key = feet * 10000 + body � + hands b + eye � + accessory;V Tif (!� ��ainsKey(� �   � b = .�  ?(
   �(int)BattleGrid.SQUARESIZE_X, 	/Y,P y �Config.ARGB_8888);. �Canvas drawing S= new (� 7  0 �ResourceOn* 	E � m5 � s.getIdentifierQ0, "H eable",v . CPack% i()));
b �8putN � }
 freturn: 'ge: �);
    }

    X    �            ��������#�����(�<-���            4  C   � �0import android.graphics.drawable.ScaleD � ;
  	x  	�   �  �return createFromFullImage(i �Name, 1);
. !}
 �public Bitmap< wString C pfloat s� �) {
  
/  
   T   �(int)(BattleGrid.SQUARESIZE_X),  
�Y),
  v  �   �X � � 3d = .� 0d !(b /,
� # *� � ( 
� �false);
 m� Xs.put�� )�" $ }5  �ResourceOnCanvas(c ?, r�Ovoid;   B _int r� �q  �   Q�9PY));
    �     �  �          �������VfW�.G@o��'��3�            4�  �  
�  
�   d   �(int)(BattleGrid.SQUARESIZE_X * scale),( 
Y( �
  r  �   |p �)mResources.getIdentifier(imageName, "drawable", mContext. CPack% _()),
` � �;
  �  �   -� �Bitmaps.putt b 9 �  X   a-IPe));
