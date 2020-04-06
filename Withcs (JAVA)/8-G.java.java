/*DESCRIPTION
2차원 배열을 입력으로 받아 배열안에 수평, 수직, 대각선으로 동일한 숫자가 연속적으로 4번 반복되는 경우가 몇번 있는지 찾아내는 프로그램을 작성하세요. 아래 그림은 동일한 숫자가 연속적으로 4번 반복되는 경우의 예를 보여주고 있습니다. (동일 숫자가 서로 다른 연속에 포함 될 수 있으므로 주의해야 합니다. 예를 들어 연속적으로 6번 반복된 수가 있을 경우, 숫자의 4번 반복은 +3으로 계산해야합니다)

Write a test program that prompts the user to enter the number of rows and columns and a two-dimensional array and then displays the number of four consecutive numbers with the same value, either horizontally, vertically, or diagonally. Here are some examples of the four consecutive numbers.



INPUT
* Line 1 : 행의수N 열의수M (N, M은 4~100범위의 정수)

* Line 2 ~ N+1 : 공백으로 구분된 M개의 원소 (원소는 0~9 범위의 정수) 

 

OUTPUT
* Line 1 : 동일한 숫자가 연속적으로 4번 반복되는 경우의 수

SAMPLE INPUT
5 5
0 0 0 0 0
2 3 0 2 9
3 6 6 0 9
7 7 3 0 0
6 3 8 8 7
SAMPLE OUTPUT
3
SOURCE
JAVA2015 PE8.19*/

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        
        int p=input.nextInt();
        int q=input.nextInt();

        int[][] ints=new int[p][q];

        for (int i=0;i<p;i++) {
            for (int j=0;j<q;j++) {
                ints[i][j]=input.nextInt();
            }
        }

        
        int numbers=0;

        for (int i=0;i<p;i++) {
            for (int j=0;j<q;j++) {
                if (j<q-3) {
                    if (ints[i][j] == ints[i][j + 3]) {
                        if (ints[i][j] == ints[i][j + 1] && 
                                ints[i][j] == ints[i][j + 2]) {
                            numbers++;
                        }
                    }
                }
                if (i<p-3) {
                    if (ints[i][j] == ints[i + 3][j]) {
                        if (ints[i][j] == ints[i + 2][j] 
                                && ints[i + 2][j] == ints[i + 1][j]) {
                            numbers++;
                        }
                    }
                }
                if (i<p-3 && j<q-3) {
                    if (ints[i][j] == ints[i + 3][j + 3]) {
                        if (ints[i][j] == ints[i + 2][j + 2] && ints[i][j] == ints[i + 1][j + 1]) {
                            numbers++;
                        }
                    }
                    else{
                        continue;
                    }
                }
            }
            for (int j = q - 1; j > 2; j--) {
                if (i<p-3) {
                    if (ints[i][j] == ints[i + 3][j - 3]) {
                        if (ints[i][j]==ints[i+2][j-2] && ints[i][j]==ints[i+1][j-1])
                            numbers++;
                    }
                }
            }
        }

        System.out.println(numbers);
    }
}