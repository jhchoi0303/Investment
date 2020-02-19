/*DESCRIPTION
50의 자리수를 가지는 숫자 A가 주어질 때, A보다 크면서 100019로 나누어지떨어지는 가장 작은 정수를 출력하라.

Find the minimum number is bigger than 50 decimal digits A and divided by 100019.

INPUT
* Line 1 : 정수 A (자리수:50)

 

OUTPUT
* Line 1 : A보다 크면서 100019로 나누어지떨어지는 가장 가장 작은 수

 

SAMPLE INPUT
10000000000000000000000000000000000000000000000000
SAMPLE OUTPUT
10000000000000000000000000000000000000000000032356
SOURCE
JAVA2015 PE10.16 
*/


import java.util.*;
import java.math.BigInteger;
public class Main {

    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        BigInteger B=scan.nextBigInteger();
        BigInteger x=new BigInteger("100019");
        while (((B.divide(x)).multiply(x)).compareTo(B)!=0) {
            B=B.add(BigInteger.ONE);
        }
        System.out.println(B);
    }
}