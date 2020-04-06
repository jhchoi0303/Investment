/*DESCRIPTION
N개의 정수를 입력으로 받아, 가장 많이 나타난 정수와 그 개수를 출력하는 프로그램을 작성하세요. 만약  3 5 2 5 5 5을 입력으로 받는다면 가장 많이 나타난 정수는 5이고 그 개수는 4입니다.

Write a program that reads integers, finds the most frequent number of them, and counts its occurrences. Suppose that you entered 3 5 2 5 5 5; the program finds that the most frequent number is 5 and the occurrence count for 5 is 4.

 

INPUT
* Line 1 : 정수의 개수 N (1~1,000)

* Line 2 ~ N+1 : 정수(-1,000,000,000 ~ 1,000,000,000)

 

OUTPUT
* Line 1 : 가장 많은 정수(중복되는 경우 없다고 가정 ex. 가장 많은 정수의 개수가 n일때 x도 n번 y도 n번 나오는 경우 없음)

* Line 2 : 가장 많은 정수의 개수

 

SAMPLE INPUT
6
3
5
2
5
5
5
SAMPLE OUTPUT
5
4
SOURCE
JAVA2015 PE5.41

*/

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        int arr[];
        arr = new int[N + 1];

        int count[];
        count = new int[N + 1];


        for (int i = 0; i < N; i++) {

            int a = scan.nextInt();
            arr[i] = a;

        }


        for (int i = 0; i < N; i++) {

            count[i] = 0;
            for (int j = 0; j < N; j++) {
                if (arr[i] == arr[j]) {
                    count[i]++;
                }

            }


        }
        int m = 0;
        int c = 0;

        for (int i = 0; i < N; i++) {

            if (m < count[i]) {
                c = arr[i];
                m = count[i];
            }

        }

        System.out.println(c);
        System.out.println(m);


    }

}