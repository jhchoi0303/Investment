/*DESCRIPTION
50�� �ڸ����� ������ ���� A�� �־��� ��, A���� ũ�鼭 100019�� ���������������� ���� ���� ������ ����϶�.

Find the minimum number is bigger than 50 decimal digits A and divided by 100019.

INPUT
* Line 1 : ���� A (�ڸ���:50)

 

OUTPUT
* Line 1 : A���� ũ�鼭 100019�� ���������������� ���� ���� ���� ��

 

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