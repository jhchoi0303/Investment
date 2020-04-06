/*DESCRIPTION
n���� ����� ���� ���Ҷ��� ���ϴ� ������ ���� ������ Ƚ���� �޶����� �Ѵ�. ���� ��� ��� A�� ũ�Ⱑ 10 �� 30 �̰�, ��� B�� ũ�Ⱑ 30 �� 5 �̰�, ��� C�� ũ�Ⱑ 5 �� 60 ��� ����. (AB)C�� A(BC)�� ����ϴµ� �ʿ��� ������ Ƚ���� ������ ����.

(AB)C = (10��30��5) + (10��5��60) = 1500 + 3000 = 4500 
A(BC) = (30��5��60) + (10��30��60) = 9000 + 18000 = 27000 
�������� n���� ����� ũ�⸦ �Է¹޾�, n���� ����� ��� ���ϴµ� �ʿ��� ������ �ּ� Ƚ���� ���ϴ� ���α׷��� �ۼ��ؾ��Ѵ�.

 

INPUT
* Line 1 : ����� ���� n (1~1,000)

* Line 2 ~ n+1 : ����_���� ����_���� 

- ��� ������ �����̸� ������ 1~1,000

 

�Է����� �־����� ������ ���Ϸ��� ��Ȳ�̰�,

i��° ����� ���� ������

i+1��° ����� ���� ������ ����.

OUTPUT
* Line 1 : �ʿ��� ������ �ּ� ȸ��

SAMPLE INPUT
4
40 20
20 30
30 10
10 30
SAMPLE OUTPUT
26000
SOURCE
JAVA2015 PE8.6 */

import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        int s= input.nextInt();
        int[] ints=new int[s+1];
        
        
        int numbers=0;
        
        int[] keep=new int[s*2];
        
        
        for (int i=0;i<s*2;i++) {
            keep[i]= input.nextInt();
        }
        for (int i=0;i<s;i++) {
            ints[i]=keep[i*2];
        }
        
        ints[s]=keep[s*2-1];
        int n=ints.length;
        System.out.println(hanegreul(ints,n));
    }
    public static long chaein(int v[], int a, int b) {
        if (a==b)
            return 0;
        
        
        int r;
        
        long smallest=1;
        long times;
        
        for (int l=0;l<v.length;l++) {
            smallest*=v[a];
        }
        for (r=a;r<b;r++) {
            times= chaein(v,a,r)+ chaein(v,r+1,b)+v[a-1]*v[r]*v[b];
            if (times<smallest)
                smallest=times;
        }
        

        return smallest;
    }

    public static long hanegreul(int v[], int e) {
        
        long[][] m=new long[e][e];
        int a,b,p,q;
        long x;
        long smallest=1000000000;

        for (a=1;a<e;a++)
            m[a][a]=0;
        for (q=2;q<e;q++) {
            for (a = 1; a < e - q + 1; a++) {
                b = a + q - 1;
                m[a][b] = smallest;
                for (p = a; p <= b - 1; p++) {
                    x =  m[p + 1][b] +m[a][p] + v[a - 1] * v[p] * v[b];
                    if (x < m[a][b])
                        m[a][b] = x;
                }
            }
        }
        return m[1][e-1];
    }
}