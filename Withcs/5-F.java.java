/*DESCRIPTION
���̾Ƹ���� ũ�� N�� �Է����� �޾� ����ϴ� ���α׷��� �ۼ��ϼ���.

Write a program that prompts the user to enter an integer N from 1 to 15 and displays a diamond.

 

INPUT
* Line 1 : ���̾Ƹ���� ũ�� N (1~15)

 

OUTPUT
Nũ���� ���̾Ƹ��

 

SAMPLE INPUT
5
SAMPLE OUTPUT
    *
   ***
  *****
 *******
*********
 *******
  *****
   ***
    *
SOURCE
JAVA2015 PE5.17

*/


import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
	
		Scanner scan=new Scanner(System.in);
		
		int n=scan.nextInt();
		int i;
		int j;
		 

		   
		    

		    for (i = 0; i < n; i++)

		    {

		        for (j = 0; j <(n - i-1); j++)

		        {

		            System.out.printf(" ");

		        }

		        for (j = 0; j < (2 * i + 1); j++)

		        {

		            System.out.printf("*");

		        }

		        System.out.printf("\n");

		    }

		    for (i = n - 2; i >= 0; i--)

		    {

		        for (j = 0; j < (n - i-1); j++)

		        {

		            System.out.printf(" ");

		        }

		        for (j = 0; j < (2 * i + 1); j++)

		        {

		            System.out.printf("*");

		        }

		       System.out.printf("\n");

		    }

		   

		}
}





