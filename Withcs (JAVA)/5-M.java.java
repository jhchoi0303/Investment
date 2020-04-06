/*DESCRIPTION
A, E, I, O, U�� �����̶�� ����������, �Է����� ���� ���ڿ��� ��� ������ �������� �����Ǿ� �ִ��� ����ϴ� ���α׷��� �ۼ��ϼ���.

Assume letters A, E, I, O, and U as the vowels. Write a program that prompts the user to enter a string and displays the number of vowels and consonants in the string.

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���ڿ� (������ �����ϸ� ���̴� 100�� ���� �ʴ´�)

 

OUTPUT
* Line 1 ~ T : vowels consonants (�������� ����� ���)

 

SAMPLE INPUT
2
Programming is fun
Hello World
SAMPLE OUTPUT
5 11
3 7
SOURCE
JAVA2015 PE5.49
*/

import java.util.Scanner;
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        
        
        
        String x=scan.nextLine();
        int k=Integer.parseInt(x);
        
        String[] string=new String[k];
        
        
        int[] count=new int[k];
        int[] notCount=new int[k];
        for (int i=0;i<k;i++) {
            string[i]=scan.nextLine();
            for (int j=0;j<string[i].length();j++)
            {
                char a=string[i].charAt(j);
                switch (a) {
                    case 'A':
                    case 'E':
                    case 'I':
                    case 'O':
                    case 'U': 

                    case 'e':
                    case 'i':
                    case 'o':
                    case 'u':
                    case 'a':
                        count[i]++; break;
                    case ' ': 
                        break;
                    default: 
                        notCount[i]++;
                        break; } } 
        
        }
        
        
        
        
        for (int i=0;i<k;i++)
            System.out.println(count[i]+" "+notCount[i]);
    }
}
