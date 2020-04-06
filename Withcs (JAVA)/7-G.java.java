/*DESCRIPTION
n명의 학생과 n명의 사물함이 있다. 모든 사물함은 초기에 닫혀있다. 첫번째 학생은 1번째 사물함부터 1의 배수인 사물함의 상태를 바꾼다(닫혀있으면 열고 열려있으면 닫고) 두번째 학생은 2번째 사물함부터 2의 배수인 사물함의 상태를 바꾼다. 3,4,5번째 학생도 똑같이 자기 배수의 사물함의 상태를 바꾼다. n번째학생이 n번째 사물함의 상태를 바꿀때까지 계속된다!

A school has n lockers and n students. All lockers are closed on the first day of school. As the students enter, the first student, denoted S1, opens every locker. Then the second student, S2, begins with the second locker, denoted L2, and closes every other locker. Student S3 begins with the third locker and changes every third locker (closes it if it was open, and opens it if it was closed). Student S4 begins with locker L4 and changes every fourth locker. Student S5 starts with L5 and changes every fifth locker, and so on, until student Sn changes Ln.

모든 학생이 해당 놀이를 하면서 학교에 들어갔다고 했을때, 어떤 사물함이 열려 있고 닫혀있는지 찾아내는 프로그램을 작성해보자. 

After all the students have passed through the building and changed the lockers, which lockers are open? Write a program to find your answer. 

 

INPUT
* Line 1 : 테스트케이스 T (1~100)

* Line 2 ~ T+1 : n i
- n: 학생수 (1~100,000)
- i : 열려 있는지 확인할 사물함 번호 (1~n)

OUTPUT
* Line 1 ~ T : 열려있으면 open을 닫혀있으면 close를 출력

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
