/*DESCRIPTION
�ڵ����� ����ǥ�� Ű������ ���� �׸��� �����ϴ�.

The international standard letter/number mapping for telephones is shown as follows:

���ڿ� ������ ��ȭ��ȣ�� �Է����� �޾�, �ùٸ� ��ȭ��ȣ�� ��ȯ�� �ִ� ���α׷��� �ۼ��ϼ���. �Է����� ���� ��ȭ��ȣ�� ��ҹ��� ������ ���ĺ��� ���ԵǾ� �ִٸ� ���ڷ� ��ȯ ���־�� �մϴ�.

Write a test program that prompts the user to enter a phone number as a string. The input number may contain letters. The program translates a letter (uppercase or lowercase) to a digit and leaves all other characters intact.

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ������ ���Ե��� ���� ��ȭ��ȣ(���̴� 100�� ���� �ʴ´�)

 

OUTPUT
* Line 1 ~ T : ��ȯ�� ��ȭ��ȣ

 

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