/*DESCRIPTION
�Ƕ�̵��� ũ�� N�� �Է¹޾�, ���ڷε� �Ƕ�̵带 ����ϴ� ���α׷��� �ۼ��ϼ���. ���� N=8�� ��� ������ ���� ��µǾ�� �մϴ�.

Write a program that prompts the user to enter an integer N from 1 to 10 and displays a pyramid. If N=8, pyramid is displayed as shown in following:

 

 

INPUT
* Line 1 : �Ƕ�̵��� ũ�� N (1~10)

 

OUTPUT
Nũ���� �Ƕ�̵�(�� ���ڴ� 4ĭ�� ������ �Ҵ� �޽��ϴ�. ���ڸ� ���� ��� ����*3����('   2') �̰� ���ڸ� ���� ��� �������(' 128') �Դϴ�. �ƹ� ���ڵ� ���� ���� ���� ���� 4ĭ�Դϴ�.('    '))

SAMPLE INPUT
5
SAMPLE OUTPUT
                   1
               1   2   1
           1   2   4   2   1
       1   2   4   8   4   2   1
   1   2   4   8  16   8   4   2   1
SOURCE
JAVA2015 PE5.19

*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N=scan.nextInt();
        for(int i=1;i<=Math.pow(2,N-1);i=i*2){

            for(int j=i;j<Math.pow(2,N-1);j=j*2){
                System.out.printf("    ");
            }

            for(int j=1;j<=i;j=j*2){
                System.out.printf(String.format("%4d",j));
            }
            for(int j=i/2;j>=1;j=j/2){
                System.out.printf(String.format("%4d",j));
            }
            System.out.printf("\n");

        }




    }
}

