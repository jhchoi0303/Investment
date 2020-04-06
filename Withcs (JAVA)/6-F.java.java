/*DESCRIPTION
�ֵ��� �Ҽ��� ��Ȯ�� 2�� ���̸� ������ �ִ� �Ҽ� ���� ���մϴ�. ���� ���, 3�� 5�� �ֵ��� �Ҽ��̰� 5�� 7�� �ֵ��� �Ҽ��Դϴ�. ���� 11�� 13�� �ֵ��� �Ҽ��Դϴ�. �������� �ִ밪 M�� �Է¹޾�, 0���� M���� �ֵ��� �Ҽ��� � �����ϴ��� ����ϴ� ���α׷��� �ۼ��ؾ� �մϴ�. 

Twin primes are a pair of prime numbers that differ by 2. For example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are twin primes. Write a program that prompts the user to enter a max M and displays the number of twin prime numbers between 0 and M. 

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~100)

* Line 2 ~ T+1 : ���� (1~10,000)

 

OUTPUT
* Line 1 ~ T : �ֵ��� �Ҽ��� ����

 

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
�����佺�׳׽��� ü�� ���ô�!

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
