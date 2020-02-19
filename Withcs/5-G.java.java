/*DESCRIPTION
피라미드의 크기 N을 입력받아, 숫자로된 피라미드를 출력하는 프로그램을 작성하세요. 만약 N=8일 경우 다음과 같이 출력되어야 합니다.

Write a program that prompts the user to enter an integer N from 1 to 10 and displays a pyramid. If N=8, pyramid is displayed as shown in following:

 

 

INPUT
* Line 1 : 피라미드의 크기 N (1~10)

 

OUTPUT
N크기의 피라미드(각 숫자는 4칸의 공간을 할당 받습니다. 한자리 수일 경우 공백*3숫자('   2') 이고 세자리 수일 경우 공백숫자(' 128') 입니다. 아무 숫자도 들어가지 않을 떄는 공백 4칸입니다.('    '))

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

