/*DESCRIPTION
쌍둥이 소수는 정확히 2의 차이를 가지고 있는 소수 쌍을 말합니다. 예를 들어, 3과 5는 쌍둥이 소수이고 5와 7도 쌍둥이 소수입니다. 또한 11과 13도 쌍둥이 소수입니다. 여러분은 최대값 M을 입력받아, 0부터 M까지 쌍둥이 소수가 몇개 존재하는지 출력하는 프로그램을 작성해야 합니다. 

Twin primes are a pair of prime numbers that differ by 2. For example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are twin primes. Write a program that prompts the user to enter a max M and displays the number of twin prime numbers between 0 and M. 

 

INPUT
* Line 1 : 테스트케이스 T (1~100)

* Line 2 ~ T+1 : 정수 (1~10,000)

 

OUTPUT
* Line 1 ~ T : 쌍둥이 소수의 개수

 

SAMPLE INPUT
3
10
30
100
SAMPLE OUTPUT
2
4
8
HINT
에라토스테네스의 체를 씁시다!

SOURCE
JAVA2015 PE6.29
*/
import java.util.Scanner;

public class Main {
    static Scanner keyboard=new Scanner(System.in);
    public static void main(String[] args) {
        String M = keyboard.nextLine();
        
        
        
        int M1 = Integer.parseInt(M);
        String[] a=new String[M1];
        int[] b=new int[M1];
        int[] count=new int[M1];
        
        
        for (int i=0;i<M1;i++) {
            a[i] = keyboard.nextLine();
            b[i] = Integer.parseInt(a[i]);
            count[i]=0;
        }
        
        
        for (int i=0;i<M1;i++) {
            
            
            for (int j=2;j<b[i]-1;j++) {
                if (Prime(j)==1) {
                    if (Prime(j+2)==1) {
                        count[i]=count[i]+1;
                       
                    }
                }
            }
        }
        
        
        
        for (int i=0;i<M1;i++)
            System.out.println(count[i]);
        
        
    }
    
    
    
    public static int Prime(int number) {
        for (int i=2;i<=(number/2);i++) {
            
            
            
            if (number%i==0)
                return 0;
                
                
                
        }
        return 1;
    }
    
    public static String exchangString(String s) {
        return ( new StringBuffer(s) ).reverse().toString();
    }

    
}
