/*DESCRIPTION
N명의 학생의 이름과 성적을 입력으로 받아, 1등과 2등을 한 학생의 이름과 성적을 출력하는 프로그램을 작성하세요. 

Write a program that prompts the user to enter the number of students and each student’s name and score, and finally displays the student with the highest score and the student with the second-highest score.

INPUT
* Line 1 : 학생수 N (2~10)

* Line 2 ~ N+1 : 이름 점수

 - 이름은 길이가 100을 넘지 않고 공백이 포함되지 않은 문자열임

 - 점수는 0~100 까지의 정수임 (동일한 점수는 존재하지 않음)

OUTPUT
* Line 1 : 1등을한 학생의 이름과 점수

* Line 2 : 2등을한 학생의 이름과 점수

SAMPLE INPUT
5
Anna 80
June 75
Brave 35
Geek 95
April 99
SAMPLE OUTPUT
April 99
Geek 95
SOURCE
JAVA2015 PE5.9


*/

















import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		
		Scanner scan=new Scanner(System.in);
		int N=scan.nextInt();
		
		String n1=scan.next();
		int g1=scan.nextInt();
		String n2=scan.next();
		int g2=scan.nextInt();
		
		if(g1<g2) {
			String a=null;
			a=n2;
			n2=n1;
			n1=a;
			int b=0;
			b=g2;
			g2=g1;
			g1=b;
					}
		
		for(int i=0;i<N-2;i++) {
			
			String n=scan.next();
			int g=scan.nextInt();
			
			if(g>g1) {
			
				n2 = n1;
				g2 = g1;
				n1=n;
				g1=g;
				
			}
			else if(g>g2 && g<g1){
					n2=n;
					g2=g;
					
				}
					
				}
		
		System.out.printf("%s %d\n",n1,g1);
		
		System.out.printf("%s %d",n2,g2);
			}
			
			
	}
