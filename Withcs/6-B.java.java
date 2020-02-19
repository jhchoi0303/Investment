/*DESCRIPTION
정수 I를 입력받아 역순으로 출력하는 프로그램을 작성하세요. 예를 들어, reverse(3456)는 6543으로 출력되어야 합니다. 330은 033으로 출력되어야 합니다.

Write a test program that prompts the user to enter an integer I and displays its reversal. For example, reverse(3456) displays 6543. Also, reverse(330) displays 033.

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 정수 (1~1,000,000)

 

OUTPUT
* Line 1 ~ T : 뒤집혀진 숫자

 

SAMPLE INPUT
3
22
3215
111011
SAMPLE OUTPUT
22
5123
110111
SOURCE
JAVA2015 PE6.4
*/

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String a = scan.nextLine();
        int a1 = Integer.parseInt(a);

        String[] b = new String[a1];
        int[] l = new int[a1];

        String[] t = new String[a1];


        for (int i = 0; i < a1; i++) {

            b[i] = scan.nextLine();
            l[i] = b[i].length();
            t[i] = "";


        }

        for (int i = 0; i < a1; i++) {

            for (int j = l[i] - 1; j >= 0; j--) {

                t[i] = t[i] + b[i].charAt(j);

            }

            System.out.println(t[i]);


        }


    }
    
}