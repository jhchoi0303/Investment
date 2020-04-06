/*DESCRIPTION
2차 배열을 오름차순으로 정렬해서 출력하는 프로그램을 만드세요. 먼저 첫번째 원소로 오름차순으로 정렬하고, 만약 동일한 첫번째 원소를 가질 경우 두번째 원소로 오름차순으로 정렬해야 합니다. Write a program to sort a two-dimensional array. The program performs a primary sort on rows and a secondary sort on columns.

예를 들어 다음과 같은 2차배열이 입력으로 들어온다면 For example, the following array

{{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}

다음과 같이 정렬되어야 합니다. will be sorted to

{{1, 1},{1, 2},{1, 7},{4, 1},{4, 2},{4, 5}}.

 

INPUT
* Line 1 : 배열의 크기 N (1~100)

* Line 2 ~ N+1 : 첫번째원소 두번째원소 (각각 int범위의 정수)

 

OUTPUT
* Line 1 ~ N : 정렬된 배열의 원소

 

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
