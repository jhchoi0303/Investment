/*DESCRIPTION
��� ������Ʈ������ Ư�� ��Ģ�� �����ϴ� �н����常 ����� �� �ְ� �Ѵ�. ����� ������ ���� �н����� ���� ��Ģ�� �־�������, �Է����� ���� ���ڿ��� �н������ Ÿ������ üũ�ϴ� ���α׷��� �ۼ��Ϸ��� �Ѵ�.

�� �н������ ��� 8���� �̻��̾�� �Ѵ�
�� �н������ ���ڿ� ���ڷθ� �����Ǿ�� �Ѵ� (Ư����ȣ ������)
�� �н������ ��� 2�� �̻��� ���ڸ� �����ؾ� �Ѵ�

���� Ÿ���� �н������� Valid�� Ÿ������ �ʴٸ� Invalid�� ����ϸ� �ȴ�.

Some websites impose certain rules for passwords. Write a method that checks whether a string is a valid password. Suppose the password rules are as follows:

�� A password must have at least eight characters. 
�� A password consists of only letters and digits. 
�� A password must contain at least two digits.

Write a program that prompts the user to enter a password and displays Valid Password if the rules are followed or Invalid Password otherwise.

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ������ ���Ե��� ���� �н�����(���̴� 100�� ���� �ʴ´�)

 

OUTPUT
* Line 1 ~ T : Ÿ���ϸ� Valid�� Ÿ������ �ʴٸ� Invalid�� ���

 

SAMPLE INPUT
3
ABCD1234_
QWERTY
qwerty1234
SAMPLE OUTPUT
Invalid
Invalid
Valid
SOURCE
JAVA2015 PE6.18
*/

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        String string = "";
        for (int i = 0; i < T; i++) {
            
            
            String P1 = input.next();
            
            
            if(P1.length() >= 8 && hv(P1) == 1 && ct(P1) == 1)
                string = string + "Valid" + '\n';
            
            
            else
                string = string + "Invalid" + '\n';
        }
        
        
        
        
        System.out.printf("%s", string);



    }
    public static int hv(String a){
        int a1 = a.length();
        
        
        int c = 0;
        for (int j = 0; j<a1; j++){
            
            
            char t = a.charAt(j);
            if(('0' <= t && t <= '9') || 
                    ('A'<= t && t <= 'Z') || ('a' <= t && t <= 'z'))
                c++;

        }
        if (c == a1)
            return 1;
        else
            return 0;
    }


    public static int ct(String a){
        int a1 = a.length();
        int c = 0;
        
        
        for(int i = 0; i < a1; i++)
        {
            char t = a.charAt(i);
            
            
            if (t>= '0' && t <= '9')
                c++;
        }
        if (c >= 2)
            return 1;
        else
            return 0;
    }



}
