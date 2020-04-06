/*DESCRIPTION
이진행렬이 주어졌을 때 1로채워진 가장 큰 정사각형 부분행렬을 찾으세요.

Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

INPUT
* Line 1 : 행의개수N 열의개수M (N, M은 1~1,000범위의 정수)

* Line 2 ~ N+1 : 공백으로 구분된 M개의 0 또는 1

* N x M 원소중에 적어도 하나의 1은 존재

OUTPUT
* Line 1 : i j k
- i: 부분행렬의 시작행 (0부터시작)
- j: 부분행렬의 시작열 (0부터시작)
- k: 부분행렬의 한변의 크기

SAMPLE INPUT
6 5
0 1 1 0 1
1 1 0 1 0
0 1 1 1 0
1 1 1 1 0
1 1 1 1 1
0 0 0 0 0
SAMPLE OUTPUT
2 1 3
SOURCE
JAVA2015 PE8.35*/

import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); 
        
        int p, q, r, s;
        int a = 0;
        int b = 0;
        int v = 1;
        
        int i = input.nextInt();
        int j = input.nextInt();
        int end = 0;
        
        
        int[][] a1 = new int[i][j];
        
        
        for (p = 0; p < i; p++) {
            for (q = 0; q < j; q++)
                a1[p][q] = input.nextInt();
        }
        for (p = 0; p < i; p++)
            for (q = 0; q < j; q++)
                if (a1[p][q] == 1) {
                    for (; p + v <= i && q + v <= j; ++v) {
                        for (r = p; r < p + v; ++r) {
                            for (s = q; s < q + v; ++s)
                                if (a1[r][s] != 1)
                                    break;
                            if (s != q + v)
                                break;
                        }
                        
                        
                        if (r != p + v)
                            break;
                        if (v > end) {
                            end = v;
                            a = p;
                            b = q;
                        }
                    }
                }
        System.out.print(a + " " + b + " " + end);
    }
}