/*DESCRIPTION
피라미드의 크기 N을 입력으로 받아 출력하는 프로그램을 작성하세요.

Write a program that prompts the user to enter an integer from 1 to 15 and displays a pyramid.

 

INPUT
* Line 1 : 피라미드의 크기 N (1~15)

 

OUTPUT
N크기의 피라미드

 

SAMPLE INPUT
5
SAMPLE OUTPUT
    *
   **
  ***
 ****
*****
 ****
  ***
   **
    *
SOURCE
JAVA2015 PE5.17




*/



import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    	
    	Scanner scan=new Scanner(System.in);
    	int N=scan.nextInt();
    	
    	
    
    	for(int i=0;i<N;i++) {
    		for(int j=1;j<N-i;j++) {
    			System.out.printf(" ");
    		}
    		
    		for(int j=0;j<=i;j++) {
    			System.out.printf("*");
    		}
    		System.out.printf("\n");
    	}
    	for(int i=1;i<N;i++){
    		
    		for(int j=0;j<i;j++) {
    			System.out.printf(" ");
    		}
    		
    		for(int j=1;j<=N-i;j++) {
    			System.out.printf("*");
    		}
    		System.out.printf("\n");
    	}
    	
    	
    		
    		
    	}
    	
    	
    	
    }
    






