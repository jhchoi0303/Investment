/*DESCRIPTION
0�� 1�� ä���� �簢����� �־����� ��, 1�� ä���� ���� ū �κ� ����� ã�� ���α׷��� �ۼ��ϼ���. (������ ũ�Ⱑ ������ �� ��쿡�� i, j �켱������ ���� ����� �簢����� ���)

Given a square matrix with the elements 0 or 1, write a program to find a maximum square submatrix whose elements are all 1s. Your program should prompt the user to enter the number of rows in the matrix. The program then displays the location of the first element in the maximum square submatrix and the number of the rows in the submatrix.

 

INPUT
* Line 1 : ���ǰ���N (N�� 1~20������ ����)

* Line 2 ~ N+1 : �������� ���е� N���� 0 �Ǵ� 1

OUTPUT
* Line 1 : i j k
- i: �κ������ ������ (0���ͽ���)
- j: �κ������ ���ۿ� (0���ͽ���)
- k: �κ������ ũ��

SAMPLE INPUT
5
1 0 1 0 1
1 1 1 0 1
1 0 1 1 1
1 0 1 1 1
1 0 1 1 1
SAMPLE OUTPUT
2 2 3
SOURCE
JAVA2015 PE8.35 */

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        int q, r, s;
        int a1 = 0;
        int b1 = 0 ;
        int v = 1;
        int N = input.nextInt();
        int ending = 0;
        int M = N;
        
        int[][] ints = new int[N][M];
        
        
        
        for (int p = 0; p < N; ++p) {
            for (q = 0; q < M; ++q)
                ints[p][q] = input.nextInt();
        }
        
        
        
        
        for (int p = 0; p < N; ++p)
            for (q = 0; q < M; ++q)
                if (ints[p][q] == 1) {
                    for (; p + v <= N && q + v <= M; ++v) {
                        for (r = p; r < p + v; ++r) {
                            for (s = q; s < q + v; ++s)
                                if (ints[r][s] != 1)
                                    break;
                            if (s != q + v)
                                break;
                        }
                        if (r != p + v)
                            break;
                        if (v > ending) {
                            ending = v;
                            a1 = p;
                            b1 = q;
                        }
                    }
                }
        System.out.print(a1 + " " + b1 + " " + ending);
    }
}