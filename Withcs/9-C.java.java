/*DESCRIPTION
UTC+0 �ð��뿡�� 1970�� 1�� 1�Ϻ��� A���� �� �� ms�� �������� �־����ϴ�. �������� Date ��ü�� ����ؼ� �ѱ����� A�� ��¥�� �ð��� ã�� ���α׷��� �ۼ��ؾ� �մϴ�. ���� ��� 1000000000�� �־����ٸ� "Mon Jan 12 22:46:40 KST 1970"�� ����մϴ�.

(Use the Date class) Write a program that creates a Date object, sets its elapsed time to 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000, and 100000000000, and displays the date and time using the toString() method, respectively.

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : �и��ʸ� ��Ÿ���� ���� (1~1,000,000,000,000,000)

OUTPUT
* Line 1 ~ T : �ش� ��¥�� �ð��� ���Ŀ� ���߾� ���

 
SAMPLE INPUT
3
1000000000
1000000000000
1000000000000000
SAMPLE OUTPUT
Mon Jan 12 22:46:40 KST 1970
Sun Sep 09 10:46:40 KST 2001
Fri Sep 27 10:46:40 KST 33658
SOURCE
JAVA2015 PE9.3*/


import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int Testcase=input.nextInt();

        
        long a=0;
        java.util.Date date=new java.util.Date(a);

        long[] Long=new long[Testcase];
        for (int i=0;i<Testcase;i++) {
            Long[i]=input.nextLong();
            date.setTime(Long[i]);
            System.out.println(date.toString());
            
            
        }
        
        

    }
}
