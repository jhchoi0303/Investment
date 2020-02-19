/*DESCRIPTION
Palindromic 소수는 소수이면서 동시에 palindromic한 수를 말합니다. 예를 들어, 131은 두가지 조건을 모두 만족하므로 Palindromic 소수입니다. 여러분은 최대값 M을 입력받아, 0부터 M까지 Palindromic 소수가 몇개 존재하는지 출력하는 프로그렘을 작성해야 합니다.

A palindromic prime is a prime number and also palindromic. For example, 131 is a prime and also a palindromic prime, as are 313 and 757. Write a program that prompts the user to enter a max M and displays the number of palindromic prime numbers between 0 and M. 

INPUT
* Line 1 : 테스트케이스 T (1~100)

* Line 2 ~ T+1 : 정수 (1~10,000)

 

OUTPUT
* Line 1 ~ T : palindromic 소수의 개수

 

SAMPLE INPUT
3
11
180
900
SAMPLE OUTPUT
5
8
18
SOURCE
JAVA2015 PE6.26
*/

import java.util.Scanner;

public class Main {
    static Scanner input =new Scanner(System.in);
    
    public static void main(String[] args) {
        String string = input.nextLine();
        
        int p1 = Integer.parseInt(string);
        
        String[] a=new String[p1];
        
        
        int[] b=new int[p1];
        
        int[] count=new int[p1];
        for (int i=0;i<p1;i++) {
            a[i] = input.nextLine(); b[i] = Integer.parseInt(a[i]);
            count[i]=0;
        }
        
        
        
        
        for (int i=0;i<p1;i++) {
            for (int j=2;j<=b[i];j++) {
                
                
                
                if (Prime(j)==1) {
                    
                    
                    String x1=Integer.toString(j);
                    String y1=reverseString(x1);
                    if (x1.equals(y1)) {
                        count[i]=count[i]+1;
                       
                    }
                   
                }
            }
        }
        for (int i=0;i<p1;i++)
            System.out.println(count[i]);
    }
    
    
    
    public static String reverseString(String s) {
        return ( new StringBuffer(s) ).reverse().toString();
    }

    
    
    
    public static int Prime(int number) {
        for (int i=2;i<=(number/2);i++) {
            if (number%i==0)
                return 0;
        }
        return 1;
    }
}