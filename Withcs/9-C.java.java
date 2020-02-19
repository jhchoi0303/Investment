/*DESCRIPTION
UTC+0 시간대에서 1970년 1월 1일부터 A까지 총 몇 ms가 지났는지 주어집니다. 여러분은 Date 개체를 사용해서 한국에서 A의 날짜와 시간을 찾는 프로그램을 작성해야 합니다. 예를 들어 1000000000가 주어진다면 "Mon Jan 12 22:46:40 KST 1970"를 출력합니다.

(Use the Date class) Write a program that creates a Date object, sets its elapsed time to 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000, and 100000000000, and displays the date and time using the toString() method, respectively.

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 밀리초를 나타내는 정수 (1~1,000,000,000,000,000)

OUTPUT
* Line 1 ~ T : 해당 날짜와 시간을 형식에 맞추어 출력

 
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
