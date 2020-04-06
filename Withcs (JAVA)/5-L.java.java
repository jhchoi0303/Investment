/*DESCRIPTION
Short 범위에 해당되는 값을 입력 받아, binary로 출력하는 프로그램을 작성하세요.

A short value S is stored in 16 bits. Write a program that prompts the user to enter a short integer and displays the 16 bits for the integer.

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : S (-32,768~32,767)

 

OUTPUT
* Line 1 ~ T : S에 대한 bit 표현

 

SAMPLE INPUT
2
5
-5
SAMPLE OUTPUT
0000000000000101
1111111111111011
HINT
You need to use the bitwise right shift operator (>>) and the bitwise AND operator (&), which are covered in Appendix G, Bitwise Operations.

SOURCE
JAVA2015 PE5.44
*/
import java.util.*;
public class Main {
    static Scanner scan =new Scanner(System.in);
    public static void main(String[] args) {
        int N= scan.nextInt();
        
        short[] Short=new short[N];
        String[] string=new String[N];
        
        
        
        
        
        for (int i = 0; i<N; i++)
            Short[i]= scan.nextShort();
        for (int i = 0; i<N; i++) {
            if (Short[i]<0) string[i]=Integer.toBinaryString(0xFFFF & Short[i]);
            else string[i] = String.format("%16s", Integer.toBinaryString(Short[i])).replace(' ', '0');
            System.out.println(string[i]);
        }
    }
}



