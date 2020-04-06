/*DESCRIPTION
N���� ������ �Է����� �޾�, ���� ���� ��Ÿ�� ������ �� ������ ����ϴ� ���α׷��� �ۼ��ϼ���. ����  3 5 2 5 5 5�� �Է����� �޴´ٸ� ���� ���� ��Ÿ�� ������ 5�̰� �� ������ 4�Դϴ�.

Write a program that reads integers, finds the most frequent number of them, and counts its occurrences. Suppose that you entered 3 5 2 5 5 5; the program finds that the most frequent number is 5 and the occurrence count for 5 is 4.

 

INPUT
* Line 1 : ������ ���� N (1~1,000)

* Line 2 ~ N+1 : ����(-1,000,000,000 ~ 1,000,000,000)

 

OUTPUT
* Line 1 : ���� ���� ����(�ߺ��Ǵ� ��� ���ٰ� ���� ex. ���� ���� ������ ������ n�϶� x�� n�� y�� n�� ������ ��� ����)

* Line 2 : ���� ���� ������ ����

 

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