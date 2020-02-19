/*DESCRIPTION
0과 1로 채워진 사각행렬이 주어졌을 때, 1로 채워진 가장 큰 부분 행렬을 찾는 프로그램을 작성하세요. (동일한 크기가 여러개 일 경우에는 i, j 우선순위로 가장 가까운 사각행렬을 출력)

Given a square matrix with the elements 0 or 1, write a program to find a maximum square submatrix whose elements are all 1s. Your program should prompt the user to enter the number of rows in the matrix. The program then displays the location of the first element in the maximum square submatrix and the number of the rows in the submatrix.

 

INPUT
* Line 1 : 행의개수N (N은 1~20범위의 정수)

* Line 2 ~ N+1 : 공백으로 구분된 N개의 0 또는 1

OUTPUT
* Line 1 : i j k
- i: 부분행렬의 시작행 (0부터시작)
- j: 부분행렬의 시작열 (0부터시작)
- k: 부분행렬의 크기

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