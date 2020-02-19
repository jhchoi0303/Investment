/*DESCRIPTION
�� ���� n1�� n2�� �Է¹޾� �ִ�����(greatest common divisor)�� ���ϴ� ���α׷��� �ۼ��ϼ���.

Write a program that find the greatest common divisor of two integers n1 and n2

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : n1 n2

 - n1�� n2�� 1~1,000 ������ ����

 

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