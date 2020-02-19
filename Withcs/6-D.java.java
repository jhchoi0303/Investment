/*DESCRIPTION
핸드폰의 국제표준 키매핑은 다음 그림과 같습니다.

The international standard letter/number mapping for telephones is shown as follows:

문자열 형태의 전화번호를 입력으로 받아, 올바른 전화번호로 변환해 주는 프로그램을 작성하세요. 입력으로 들어온 전화번호에 대소문자 형태의 알파벳이 포함되어 있다면 숫자로 변환 해주어야 합니다.

Write a test program that prompts the user to enter a phone number as a string. The input number may contain letters. The program translates a letter (uppercase or lowercase) to a digit and leaves all other characters intact.

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 공백이 포함되지 않은 전화번호(길이는 100을 넘지 않는다)

 

OUTPUT
* Line 1 ~ T : 변환된 전화번호

 

SAMPLE INPUT
2
1-800-Flowers
1800flowers
SAMPLE OUTPUT
1-800-3569377
18003569377
SOURCE
JAVA2015 PE6.21
*/

import java.util.Scanner;

public class Main {




    static Scanner input =new Scanner(System.in);




    public static void main(String[] args) {
        String a= input.nextLine();
        int p=Integer.parseInt(a);

        String[] k=new String[p];


        String[] s=new String[p];






        int[] t=new int[p];


        for (int i=0; i<p; i++) {
            k[i]= input.nextLine();
            s[i]="";
            t[i]=k[i].length();
        }






        for (int i=0;i<p;i++) {
            for (int j=0;j<t[i];j++) {
                char c=k[i].charAt(j);



                if (('a'<=c && c<='z') || ('A'<=c && c<='Z')) {
                    c=Character.toLowerCase(c);
                    switch (c) {
                        case 'a':case 'b':case 'c':
                            c='2'; break;
                        case 'd':case 'e':case 'f':
                            c='3';     break;
                        case 'g':case 'h':case 'i':
                            c='4';   break;
                        case 'j':case 'k':case 'l':
                            c='5';
                            break;
                        case 'm':case 'n':case 'o':
                            c='6';
                            break;
                        case 'p':case 'q':case 'r':case 's':
                            c='7';
                            break;
                        case 't':case 'u':case 'v':
                            c='8';
                            break;
                        default:
                            c='9';
                            break;
                    }
                }
                s[i] += c;
            }
        }






        for (int i=0;i<p;i++) {


            System.out.println(s[i]);
        }
    }
}