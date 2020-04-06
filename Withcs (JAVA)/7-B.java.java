/*DESCRIPTION
-100���� 100������ �������� �Է¹޾� �� ���ں��� ��� ��Ÿ������ ������������ ������ ����ϴ� ���α׷��� ���弼��. 

Write a program that reads the integers between -100 and 100 and counts the occurrences of each with ascending order. 

INPUT
* Line 1 : ������ ���� N (1~10,000)

* Line 2 ~ N+1 : ���� (-100~100)

 

OUTPUT
* Line 1 ~ M :�������� �����Ͽ� ������ ������ ���

 - M�� �ߺ����� ���� ������ ����

 

SAMPLE INPUT
5
-3
100
-1
-2
-1
SAMPLE OUTPUT
-3 1
-2 1
-1 2
100 1
SOURCE
JAVA2015 PE7.3*/

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String N1=scan.nextLine();
        int N=Integer.parseInt(N1);


        String []str=new String[N];
        int []str1=new int [N];
        int[] count=new int[201];
        int []t=new int[N];
        for(int i=0;i<N;i++){

            str[i]=scan.nextLine();
            str1[i]=Integer.parseInt(str[i]);


            if (str1[i] < 0) {
                count[str1[i] + 201]++;
            } else {
                count[str1[i]]++;
            }
            t[i]=str1[i];
        }

        Arrays.sort(str1);


        for (int i=0;i<N;i++) {
            if (str1[i]<0) {
                if (i!=N-1) {
                    if (str1[i] != str1[i + 1])
                        System.out.println(str1[i] + " " + count[str1[i] + 201]);
                }
                else
                    System.out.print(str1[i]+" "+count[str1[i]]);
            }
            else {
                if (i!=N-1) {
                    if (str1[i] != str1[i + 1])
                        System.out.println(str1[i] + " " + count[str1[i]]);
                }
                else
                    System.out.print(str1[i]+" "+count[str1[i]]);
            }
        }
    }



        }




