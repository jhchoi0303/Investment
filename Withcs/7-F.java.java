/*DESCRIPTION
100���� �л��� 100���� �繰���� �ִ�. ��� �繰���� �ʱ⿡ �����ִ�. ù��° �л��� 1��° �繰�Ժ��� 1�� ����� �繰���� ���¸� �ٲ۴�(���������� ���� ���������� �ݰ�) �ι�° �л��� 2��° �繰�Ժ��� 2�� ����� �繰���� ���¸� �ٲ۴�. 3,4,5��° �л��� �Ȱ��� �ڱ� ����� �繰���� ���¸� �ٲ۴�. 100��°�л��� 100��° �繰���� ���¸� ������ ������ ����ȴ�.

A school has 100 lockers and 100 students. All lockers are closed on the first day of school. As the students enter, the first student, denoted S1, opens every locker. Then the second student, S2, begins with the second locker, denoted L2, and closes every other locker. Student S3 begins with the third locker and changes every third locker (closes it if it was open, and opens it if it was closed). Student S4 begins with locker L4 and changes every fourth locker. Student S5 starts with L5 and changes every fifth locker, and so on, until student S100 changes L100.

��� �л��� �ش� ���̸� �ϸ鼭 �б��� ���ٰ� ������, � �繰���� ���� �ְ� �����ִ��� ã�Ƴ��� ���α׷��� �ۼ��غ���. 

After all the students have passed through the building and changed the lockers, which lockers are open? Write a program to find your answer. 

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���� �ִ��� Ȯ���� �繰�� ��ȣ (1~100)

OUTPUT
* Line 1 ~ T : ���������� open�� ���������� close�� ���

SAMPLE INPUT
3
2
10
100
SAMPLE OUTPUT
close
close
open
HINT
Use an array of 100 Boolean elements, each of which indicates whether a locker is open (true) or closed (false). Initially, all lockers are closed.

SOURCE
JAVA2015 PE7.23*/


import java.util.Scanner;
public class Main {
    static Scanner scan =new Scanner(System.in);



    public static void main(String[] args) {
        boolean[] TF=new boolean[100];


        for (int i=0;i<100;i++) {
            TF[i]=false;}
        
        int a= scan.nextInt();
        int[] p=new int[a];
        
        for (int i=0;i<a;i++) {
            p[i]= scan.nextInt();
        }
     
        for (int i=0;i<100;i++) {
            for (int j=1;j<101;j++) {
                if((i+1)*j<=100) {
                    TF[(i+1)*j-1]=!TF[(i+1)*j-1];
                }
            }
        }

        for (int i=0;i<a;i++) {
            if (TF[p[i] - 1] == true)
                System.out.println("open");
            else
                System.out.println("close");
        }
    }
}