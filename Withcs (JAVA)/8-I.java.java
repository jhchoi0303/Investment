/*DESCRIPTION
��������� �־����� �� 1��ä���� ���� ū ���簢�� �κ������ ã������.

Given a binary matrix, find out the maximum size square sub-matrix with all 1s.

INPUT
* Line 1 : ���ǰ���N ���ǰ���M (N, M�� 1~1,000������ ����)

* Line 2 ~ N+1 : �������� ���е� M���� 0 �Ǵ� 1

* N x M �����߿� ��� �ϳ��� 1�� ����

OUTPUT
* Line 1 : i j k
- i: �κ������ ������ (0���ͽ���)
- j: �κ������ ���ۿ� (0���ͽ���)
- k: �κ������ �Ѻ��� ũ��

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