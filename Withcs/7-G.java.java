/*DESCRIPTION
n���� �л��� n���� �繰���� �ִ�. ��� �繰���� �ʱ⿡ �����ִ�. ù��° �л��� 1��° �繰�Ժ��� 1�� ����� �繰���� ���¸� �ٲ۴�(���������� ���� ���������� �ݰ�) �ι�° �л��� 2��° �繰�Ժ��� 2�� ����� �繰���� ���¸� �ٲ۴�. 3,4,5��° �л��� �Ȱ��� �ڱ� ����� �繰���� ���¸� �ٲ۴�. n��°�л��� n��° �繰���� ���¸� �ٲܶ����� ��ӵȴ�!

A school has n lockers and n students. All lockers are closed on the first day of school. As the students enter, the first student, denoted S1, opens every locker. Then the second student, S2, begins with the second locker, denoted L2, and closes every other locker. Student S3 begins with the third locker and changes every third locker (closes it if it was open, and opens it if it was closed). Student S4 begins with locker L4 and changes every fourth locker. Student S5 starts with L5 and changes every fifth locker, and so on, until student Sn changes Ln.

��� �л��� �ش� ���̸� �ϸ鼭 �б��� ���ٰ� ������, � �繰���� ���� �ְ� �����ִ��� ã�Ƴ��� ���α׷��� �ۼ��غ���. 

After all the students have passed through the building and changed the lockers, which lockers are open? Write a program to find your answer. 

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~100)

* Line 2 ~ T+1 : n i
- n: �л��� (1~100,000)
- i : ���� �ִ��� Ȯ���� �繰�� ��ȣ (1~n)

OUTPUT
* Line 1 ~ T : ���������� open�� ���������� close�� ���

SAMPLE INPUT
3
10 2
1000 99
10000 998 
SAMPLE OUTPUT
close
close
close
SOURCE
JAVA2015 PE7.23 */

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);

        int p=scan.nextInt();
        int[] a=new int[p*2];


        for (int i=0;i<p*2;i++) {
            a[i]=scan.nextInt();
        }


        for (int i=0;i<p;i++) {
            boolean[] b=new boolean[a[2*i]];

            for (int j=0;j<a[2*i];j++) {
                b[j]=false;
            }


            for (int r=0;r<a[2*i];r++) {
                for (int s=1;s<a[2*i+1]+1;s++) {
                    if (a[2*i]>=(r+1)*s) {
                        b[(r+1)*s-1]=!b[(r+1)*s-1];
                    }
                }
            }
            
            
            if (b[a[2*i+1]-1]==true)
                System.out.println("open");
            else
                System.out.println("close");
        }
    }
}
