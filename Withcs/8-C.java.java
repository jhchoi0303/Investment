/*DESCRIPTION
n개의 행렬을 서로 곱할때는 곱하는 순서에 따라 곱셈의 횟수가 달라지곤 한다. 예를 들어 행렬 A의 크기가 10 × 30 이고, 행렬 B의 크기가 30 × 5 이고, 행렬 C의 크기가 5 × 60 라고 하자. (AB)C와 A(BC)를 계산하는데 필요한 곱셈의 횟수는 다음과 같다.

(AB)C = (10×30×5) + (10×5×60) = 1500 + 3000 = 4500 
A(BC) = (30×5×60) + (10×30×60) = 9000 + 18000 = 27000 
여러분은 n개의 행렬의 크기를 입력받아, n개의 행렬을 모두 곱하는데 필요한 곱셈의 최소 횟수를 구하는 프로그램을 작성해야한다.

 

INPUT
* Line 1 : 행렬의 개수 n (1~1,000)

* Line 2 ~ n+1 : 행의_개수 열의_개수 

- 모든 개수는 정수이며 범위는 1~1,000

 

입력으로 주어지는 순서로 곱하려는 상황이고,

i번째 행렬의 열의 개수와

i+1번째 행렬의 행의 개수는 같다.

OUTPUT
* Line 1 : 필요한 곱셈의 최소 회수

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