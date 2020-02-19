/*DESCRIPTION
N���� ���ڿ��� �Է����� �޾�, ��� ���ڿ��� �������� ������ longest common string�� ����ϴ� ���α׷��� �ۼ��ϼ���.

Write a program that prompts the user to enter N strings and displays the longest common string of the N strings.

INPUT
* Line 1 : ���ڿ��ǰ��� N (1~100)

* Line 2 ~ N+1 : ���ڿ� (������ �����ϸ� ���̴� 100�� ���� �ʴ´�)

 

OUTPUT
* Line 1 : N���� ���ڿ����� �����ϰ� ��Ÿ���� longest common string�� ���

 

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

