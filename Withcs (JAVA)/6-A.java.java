/*DESCRIPTION
������ �Է����� �޾� palindrome �������� üũ�ϴ� ���α׷��� �ۼ��ϼ���. ���ʿ��� ���������� �д� �Ͱ� �����ʿ��� �������� �д� ���� ������ ��� palindrome ���ڶ�� �մϴ�.

Write a test program that prompts the user to enter an integer and reports whether the integer is a palindrome. A number is palindrome if it reads the same from right to left and from left to right.

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���� (1~1,000,000)

 

OUTPUT
* Line 1 ~ T : palindrome ������ ��� Y, �ƴҰ�� N�� ���

 

SAMPLE INPUT
4
1
1221
12321
132
SAMPLE OUTPUT
Y
Y
Y
N
SOURCE
JAVA2015 PE6.3
*/

import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int T=scan.nextInt();

        String arr[];
        arr=new String[T];

        for(int i=0;i<T;i++){

            arr[i]=scan.next();


        }


        boolean P[];
        P=new boolean[T];


        for(int i=0;i<T;i++) {
            int l=0;
            int h=arr[i].length()-1;
            P[i] = true;
            while (l<h){
                if(arr[i].charAt(l) != arr[i].charAt(h)){
                    P[i]=false;
                    break;
                }

                l++;
                h--;
            }


        }

        for(int i=0;i<T;i++){
            if(P[i])
                System.out.println("Y");

            else
                System.out.println("N");


        }







    }
    }
