        
1  �        ��������b��GMԝ�}�t N���k            4�  �#!/usr/bin/env bash

# :
 �  Gradle start up script for UN*X' y :�7
# Add default JVM options here. You can also use JAVA_OPTS and GRADLE yto passE sto this� �.
DEFAULT_JVM5 � =""

APP_NAME="" BBASE � `basename "$0"`� �!Use the maximum available, or set MAX_FD != -1 t� �that value.
  #="B �"

warn ( ) {
    echo "$*"
}

die $ 
 Pxit 18 �# OS specific support (must be 'true'� �'false').
cygwin= S
msys 6dar �case "`u�`" in
  CYGWIN* )� G  a  a;;
  DD # R 
# TMINGW"    @esac� QFor Cb �, ensure paths are in UNIX� ma� � fore anything i�uched.
if $�   ;�ni q[ -n "$k�HOME" ] &&  P=`cygp y --unix, A`
fi�`ttempt�  S   �	
# Resolve links: $0 may�a P
PRG=jr
# Need� ��relative sym= p.
while� ph "$PRG� 2; d�ls=`ls -ld ` �ink=`expr "$ls" : '.*-> \(.*\)$'' 4if $ 1ink& �/.*' > /dev/null4  � . � + C`dirI� '"/. �fi
done
SAVED="`pwd`"
cd "7 \8 �\"`/" >&-
U. 3 -P1 $D $ �
CLASSPATH=$0 !/g��/wrapper - @.jar��Determin��Java commx�o-! !VMQ>)" 	4�/jre/sh/java.   �# IBM's JDK on AIX} �s strange loca� % � `execut�sF  n OCMD=x �2  �/ &fi� !� ?CMD�   �v"ERROR:K �!se&�an invalid directory: | P

Plex#seqE @vari�  �� your environmen[ Pmatch4 
,2 of* �qinstall .� 	� `which  % >� 2>&1 ||� 1not�  D@no 'A 'VPcould	Ufound�  �.� W�kIncrea�fm"deN0ors� we��"NQ" = "+r" -a "$� 	 �_LIMIT=`ulimit -H -n`b�$? -eq 0[| F e W= -o � � 8="$� ��  � #n , 
�  � One 0g �!"C�` h :f � 	�X _queryZ � #fi d�X, addT	RQy how Sappli[ Can Adockg�	8="$�	@\"-X8 :�$=$�	&\" Gicon�Smedia�t.icns\"�+0swi+�to Windows*@runn) �"y
 @mixe�# u�3 $  e
��We buildLqpattern�@argu�� �be converted via c E �ROOTDIRSRAW=`find -L / -maxdepth 1 -min �type d 2�� SSEP="$ or� �$_ zx %="$ �$SEP$dir�U | � ��OURCYGPATTERN="(^(B 3))" 8a	�r-defined �e+
,ph "�" � $ .|(J )T# Now�.�q- kludgIT�ourselve�ns�5i=0{0arg{J"$@"ssCHECK=`�arg"|egrep -c � J" -`8 29 _^-"`  (##1	 if�2
m "%&& 2�g @Adde�Qcondib `Reval � args$i`r 0ign�{ � 	YU !"\6 /\"#�i=$((i+1))�9F$i i� 1(0)"-- 1 h 9s0" 2 	 1( 3( 	 21 41 	 3: 5: 	 4C 6C #	 5L 7L ,	 6U 8U 5	 7^ 9^ >	 8g AASpli��|AV� ���array, follow% = �shell quot  �
�substitu ru�Afunc sx �JvmOpts(��(�A)
}
s, , $�& $A
! E[${# �*]}]="-Dorg.*6appc�0"

A�5"${H �@]}" -classN� ] NUW �Main "$@"
