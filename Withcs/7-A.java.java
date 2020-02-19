/*DESCRIPTION
학생들의 점수를 입력받아서 최고점을 찾아내고, 이를 토대로 학생들의 성적을 결정해주는 프로그램을 작성하세요. 규칙은 다음과 같습니다.

성적이 최고점-10 이상이면 A
성적이 최고점-20 이상이면 B
성적이 최고점-30 이상이면 C
성적이 최고점-40 이상이면 D
그외는 F
Write a program that reads student scores, gets the best score, and then assigns grades based on the following scheme: 

Grade is A if score is ≥ best - 10
Grade is B if score is ≥ best - 20 
Grade is C if score is ≥ best - 30
Grade is D if score is ≥ best - 40 
Grade is F otherwise. 
The program prompts the user to enter the total number of students, then prompts the user to enter all of the scores, and concludes by displaying the grades.

INPUT
* Line 1 : 학생의 수 N (1~100)

* Line 2 ~ N+1 : 실수형태의 학생의 성적 (0~100)

 

OUTPUT
* Line 1 ~ T : 학생의 성적

SAMPLE INPUT
4
40
55
70
58
SAMPLE OUTPUT
C
B
A
B
SOURCE
JAVA2015 PE7.1*/


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input =new Scanner(System.in);
        String a1= input.nextLine();


        int a =Integer.parseInt(a1);

        String[] p=new String[a];

        int[] q=new int[a];



        for (int i=0;i<a;i++) {


            p[i]= input.nextLine();
            q[i] = Integer.parseInt(p[i]);
        }

        int big=q[0];
        for (int i=1;i<a;i++) {
            big=Math.max(big,q[i]);
        }

        for (int i=0;i<a-1;i++) {
            if (q[i]>=big-10)
                System.out.println("A");
            else if(q[i]>=big-20 && q[i]<big-10)
                System.out.println("B");
            else if(q[i]>=big-30 && q[i]<big-20)
                System.out.println("C");
            else if (q[i]>=big-40 && q[i]<big-30)
                System.out.println("D");
            else
                System.out.println("F");
        }

        if (q[a-1]>=big-10)
        System.out.printf("A");
            else if(q[a-1]>=big-20 && q[a-1]<big-10)
            System.out.printf("B");
        else if(q[a-1]>=big-30 && q[a-1]<big-20)
            System.out.printf("C");
        else if (q[a-1]>=big-40 && q[a-1]<big-30)
            System.out.printf("D");
        else
            System.out.printf("F");
    }
}