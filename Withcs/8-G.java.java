/*DESCRIPTION
2���� �迭�� �Է����� �޾� �迭�ȿ� ����, ����, �밢������ ������ ���ڰ� ���������� 4�� �ݺ��Ǵ� ��찡 ��� �ִ��� ã�Ƴ��� ���α׷��� �ۼ��ϼ���. �Ʒ� �׸��� ������ ���ڰ� ���������� 4�� �ݺ��Ǵ� ����� ���� �����ְ� �ֽ��ϴ�. (���� ���ڰ� ���� �ٸ� ���ӿ� ���� �� �� �����Ƿ� �����ؾ� �մϴ�. ���� ��� ���������� 6�� �ݺ��� ���� ���� ���, ������ 4�� �ݺ��� +3���� ����ؾ��մϴ�)

Write a test program that prompts the user to enter the number of rows and columns and a two-dimensional array and then displays the number of four consecutive numbers with the same value, either horizontally, vertically, or diagonally. Here are some examples of the four consecutive numbers.



INPUT
* Line 1 : ���Ǽ�N ���Ǽ�M (N, M�� 4~100������ ����)

* Line 2 ~ N+1 : �������� ���е� M���� ���� (���Ҵ� 0~9 ������ ����) 

 

OUTPUT
* Line 1 : ������ ���ڰ� ���������� 4�� �ݺ��Ǵ� ����� ��

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