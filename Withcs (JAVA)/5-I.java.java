/*DESCRIPTION
당신은 다음 계산식을 통해서 e를 계산할 수 있습니다. i를 입력으로 받아 e를 계산하는 프로그램을 작성하세요.  

You can approximate e using the following series:



Write a program that displays the e value for i

 

 

INPUT
* Line 1 : 테스트케이스 T (1~100)

* Line 2 ~ T+1 : 정수 i (1~100)

 

OUTPUT
* Line 1 ~ T : e(소수점 여섯째자리까지만 출력. sample 참고)

 

SAMPLE INPUT
3
2
8
20
SAMPLE OUTPUT
2.500000
2.718278
2.718281
SOURCE
JAVA2015 PE5.26

*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();

        int arr[];
        arr = new int[T];


        for (int i = 0; i < T; i++) {
            int a = scan.nextInt();
            arr[i] = a;
        }


        for (int i = 0; i < T; i++) {
            double sum = 1;
            double s=1;
            for (int j = 1; j <= arr[i]; j++) {

                s=s*j;
                sum = sum+(1/s);

            }
            System.out.printf("%.6f",( Math.floor(sum * 1000000) )/ 1000000.0);
            System.out.printf("\n");
        }
    }
}


