        �  �        ����������q@�s�}#�\�[��ܱ��            4�  �$package com.android.jprevoe.wizarddefense;

import ' 0sup �.v4.app.Fragment;( 7( �ActionBar	 Mvity1 �os.Bundle �view.Menu OItem oWindow 	�Manager;


public class Battle� �  extends Single�  � {
    @Override �protected / e creat> #()8   creturnw ` � .newInstance();- /}
l 
�void onCj (Td savedI XState{ �this.request�Feature( �.FEATURE_NO_TITLE);< !//> #ge: �().setFlags(a�.LayoutParams.FLAG_FULLSCREEN, , } esuper.� �  �;
    }
}
    �    /  k       ?    ����2�F�+ ��C>�$)I��            4�  C   , �<import android.app.Activity;
 �content.I � ;
  �  �   �  �BattleFragment f	 = �.newInstance(this);
D 5 D.set� $ ereturn+  � "� ! �& �public void b| �Ending(boolean player_won) {Y � s result S= new (� % �.putExtra("Y (",f 9 AsetR< (� �.RESULT_OK,W � inish();
    }
          X  �       M   �������u�[O� ����>            4Z   B  Q 3 N  �getWindow().addFlags( �Manager.LayoutParams.FLAG_KEEP_SCREEN_ON);
