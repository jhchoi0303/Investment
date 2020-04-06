/*DESCRIPTION
두 정수 n1과 n2를 입력받아 최대공약수(greatest common divisor)를 구하는 프로그램을 작성하세요.

Write a program that find the greatest common divisor of two integers n1 and n2

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : n1 n2

 - n1과 n2는 1~1,000 범위의 정수

 

OUTPUT
* Line 1 ~ T : GCD

 

SAMPLE INPUT
4
2 3
2 4
67 203
638 932
SAMPLE OUTPUT
1
2
1
2
SOURCE
JAVA2015 PE5.14
*/








import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int G[] =null;
        G= new int[T];
        for (int i = 0 ; i < T ; i++)
        {
            int n1 = scan.nextInt();
            int n2 = scan.nextInt();
            int k = 2;
            int gcd = 1;
            while( k <= n1 && k <= n2)
            {
                if( n1 % k == 0 && n2 % k ==0 )
                gcd = k;
                k++;

            }

          G[i]=gcd;
        }
        for(int i=0;i<T;i++) {
        	System.out.println(G[i]);
        }






    }
}