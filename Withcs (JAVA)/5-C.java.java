/*DESCRIPTION
정수 I를 입력으로 받아 I의 모든 소인수를 오름차순으로 출력하는 프로그램을 작성하세요. 예를 들어, 120의 소인수분해 결과는 2, 2, 2, 3, 5입니다.

Write a program that reads an integer I and displays all its smallest factors in increasing order. For example, if the input integer is 120, the output should be as follows: 2, 2, 2, 3, 5.

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 정수 (2~1,000)

OUTPUT
* Line 1 ~ T : 소인수(factor)를 공백으로 구분해서 오름차순으로 출력 

 

SAMPLE INPUT
3
24
76
119
SAMPLE OUTPUT
2 2 2 3
2 2 19
7 17
SOURCE
JAVA2015 PE5.16

*/











import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T = scan.nextInt();
        int []N;
        N=new int[T];



        for (int i = 0; i < T; i++) {

            N[i] = scan.nextInt();

        }


        for(int i=0;i<T;i++) {


            while (N[i] != 1) {
                for (int j = 2; j <= N[i]; j++) {

                    if (N[i] % j == 0) {
                        N[i] /= j;
                        System.out.printf("%d", j);
                        break;
                    }


                }

                if(N[i]==1){
                    break;
                }
                else{
                    System.out.printf(" ");
                }
            }
            System.out.printf("\n");
        }

    }
}


