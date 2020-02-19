/*DESCRIPTION
다이아몬드의 크기 N을 입력으로 받아 출력하는 프로그램을 작성하세요.

Write a program that prompts the user to enter an integer N from 1 to 15 and displays a diamond.

 

INPUT
* Line 1 : 다이아몬드의 크기 N (1~15)

 

OUTPUT
N크기의 다이아몬드

 

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





