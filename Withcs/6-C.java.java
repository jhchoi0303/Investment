/*DESCRIPTION
몇몇 웹사이트에서는 특정 규칙을 만족하는 패스워드만 사용할 수 있게 한다. 당신은 다음과 같은 패스워드 생성 규칙이 주어졌을때, 입력으로 들어온 문자열이 패스워드로 타당한지 체크하는 프로그렘을 작성하려고 한다.

■ 패스워드는 적어도 8글자 이상이어야 한다
■ 패스워드는 문자와 숫자로만 구성되어야 한다 (특수기호 허용안함)
■ 패스워드는 적어도 2개 이상의 숫자를 포함해야 한다

만약 타당한 패스워드라면 Valid를 타당하지 않다면 Invalid를 출력하면 된다.

Some websites impose certain rules for passwords. Write a method that checks whether a string is a valid password. Suppose the password rules are as follows:

■ A password must have at least eight characters. 
■ A password consists of only letters and digits. 
■ A password must contain at least two digits.

Write a program that prompts the user to enter a password and displays Valid Password if the rules are followed or Invalid Password otherwise.

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 공백이 포함되지 않은 패스워드(길이는 100을 넘지 않는다)

 

OUTPUT
* Line 1 ~ T : 타당하면 Valid를 타당하지 않다면 Invalid를 출력

 

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
