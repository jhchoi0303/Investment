/*DESCRIPTION
N���� �л��� �̸��� ������ �Է����� �޾�, 1��� 2���� �� �л��� �̸��� ������ ����ϴ� ���α׷��� �ۼ��ϼ���. 

Write a program that prompts the user to enter the number of students and each student��s name and score, and finally displays the student with the highest score and the student with the second-highest score.

INPUT
* Line 1 : �л��� N (2~10)

* Line 2 ~ N+1 : �̸� ����

 - �̸��� ���̰� 100�� ���� �ʰ� ������ ���Ե��� ���� ���ڿ���

 - ������ 0~100 ������ ������ (������ ������ �������� ����)

OUTPUT
* Line 1 : 1������ �л��� �̸��� ����

* Line 2 : 2������ �л��� �̸��� ����

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
