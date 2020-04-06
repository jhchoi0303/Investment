/*DESCRIPTION
2�� �迭�� ������������ �����ؼ� ����ϴ� ���α׷��� ���弼��. ���� ù��° ���ҷ� ������������ �����ϰ�, ���� ������ ù��° ���Ҹ� ���� ��� �ι�° ���ҷ� ������������ �����ؾ� �մϴ�. Write a program to sort a two-dimensional array. The program performs a primary sort on rows and a secondary sort on columns.

���� ��� ������ ���� 2���迭�� �Է����� ���´ٸ� For example, the following array

{{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}

������ ���� ���ĵǾ�� �մϴ�. will be sorted to

{{1, 1},{1, 2},{1, 7},{4, 1},{4, 2},{4, 5}}.

 

INPUT
* Line 1 : �迭�� ũ�� N (1~100)

* Line 2 ~ N+1 : ù��°���� �ι�°���� (���� int������ ����)

 

OUTPUT
* Line 1 ~ N : ���ĵ� �迭�� ����

 

SAMPLE INPUT
6
4 2
1 7
4 5
1 2
1 1
4 1
SAMPLE OUTPUT
1 1
1 2
1 7
4 1
4 2
4 5
SOURCE
JAVA2015 PE8.16 */

import java.util.*;
public class Main {

    public static void main(String[] args)  {


        Scanner input=new Scanner(System.in);
        int a=input.nextInt();

        int[][] ints=new int[a][2];

        for (int i=0;i<a;i++) {
            for (int j=0;j<2;j++)
                ints[i][j]=input.nextInt();
        }



        for (int i=0;i<a;i++) {
            for (int j=0;j<a;j++) {
                if (ints[i][0] < ints[j][0]) {
                    int asp = ints[i][0];
                    ints[i][0] = ints[j][0];
                    ints[j][0] = asp;
                    asp = ints[i][1];
                    ints[i][1] = ints[j][1];
                    ints[j][1] = asp;
                }
            }
        }

        for (int i=0;i<a-1;i++) {
            for (int j=i+1;j<a;j++) {
                if (ints[i][0]==ints[j][0]) {
                    if (ints[i][1]>ints[j][1]) {
                        int asp=ints[i][1];
                        ints[i][1]=ints[j][1];
                        ints[j][1]=asp;
                    }
                }
            }
        }

        for (int i=0;i<a;i++) {
            System.out.printf("%d %d",ints[i][0],ints[i][1]);
            System.out.println();
            
        }
    }
}
