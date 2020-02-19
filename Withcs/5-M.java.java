/*DESCRIPTION
A, E, I, O, U를 모음이라고 가정했을때, 입력으로 들어온 문자열이 몇개의 모음과 자음으로 구성되어 있는지 출력하는 프로그램을 작성하세요.

Assume letters A, E, I, O, and U as the vowels. Write a program that prompts the user to enter a string and displays the number of vowels and consonants in the string.

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 문자열 (공백을 포함하며 길이는 100을 넘지 않는다)

 

OUTPUT
* Line 1 ~ T : vowels consonants (공백으로 나누어서 출력)

 

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
