/*DESCRIPTION
N개의 문자열을 입력으로 받아, 모든 문자열이 공통으로 가지는 longest common string을 출력하는 프로그램을 작성하세요.

Write a program that prompts the user to enter N strings and displays the longest common string of the N strings.

INPUT
* Line 1 : 문자열의개수 N (1~100)

* Line 2 ~ N+1 : 문자열 (공백을 포함하며 길이는 100을 넘지 않는다)

 

OUTPUT
* Line 1 : N개의 문자열에서 동일하게 나타나는 longest common string을 출력

 

SAMPLE INPUT
4
AABB
AAABC
AABCC
AAAAA
SAMPLE OUTPUT
AA
SOURCE
JAVA2015 PE5.51
*/

import java.util.*;
public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int N= scan.nextInt();
        scan.nextLine();
        String[] string=new String[N];
        for (int i=0;i<N;i++) {
            string[i]= scan.nextLine();
        }
        Arrays.sort(string);
        
        
        
        String[] b=new String[N];
        for (int i=0;i<N;i++) { b[i]=string[N-i-1];
        }String g=b[0];
        
        
        
        for (int i=1;i<N;i++) {
            g=isPrefix(g, b[i]);
        } System.out.println(g);
        
    } 
    
    
    
    public static String isPrefix(String p,String q)
    { int l1=p.length();
        int l2=q.length();
        if (l1<l2) {
            
            
            String x=p; p=q; q=x; int y=l1; l1=l2; l2=y;
        } for (int j=l2;;j--)
    { for (int i=0;i+j<=l2;i++)
    { String x=q.substring(i,i+j);
        if (p.contains(x))
        { return x; }
    }
    }
    }
}

