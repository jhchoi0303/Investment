/*DESCRIPTION
�ſ�ī�� ��ȣ�� ������ ��Ģ�� ������ �ֽ��ϴ�. �ſ�ī�� ��ȣ�� 13~16���� ���ڷ� �Ǿ� �ְ�, ī�� ȸ�翡 ���� ������ ���� ���ڷ� �����մϴ�.

Credit card numbers follow certain patterns. A credit card number must have between 13 and 16 digits. It must start with:

�� 4 for Visa cards
�� 5 for Master cards
�� 37 for American Express cards
�� 6 for Discover cards

1954�� IBM�� Hans Luhn�� �ſ�ī�� ��ȣ�� Ÿ������ üũ�ϴ� �˰����� �����Ͽ����ϴ�. �� �˰����� ī���ȣ�� �ùٸ��� �ԷµǾ����� üũ�ϰų� ī�帮���Ⱑ ��ȣ�� �ùٸ��� �ν��ߴ��� üũ�ϴ� �뵵�� ������ ���Ǿ� �Խ��ϴ�. Luhn check �Ǵ� Mod 10 check�� �˷��� üũ �˰����� ������ �����ϴ�. (������ ���� ī���ȣ�� 4388576018402626�� ����):

In 1954, Hans Luhn of IBM proposed an algorithm for validating credit card numbers. The algorithm is useful to determine whether a card number is entered correctly or whether a credit card is scanned correctly by a scanner. Credit card numbers are generated following this validity check, commonly known as the Luhn check or the Mod 10 check, which can be described as follows (for illustration, consider the card number 4388576018402626):

1. �����ʿ��� �������� ¦����ġ�� ���ڵ��� ���� �ι��մϴ�. ���� �ι�� ���ڰ� 10�̻��̸� ���� �ڸ��� ���� �ڸ��� ���ڸ� ���ؼ� ���ڸ� ���ڷ� ����ϴ�. (Double every second digit from right to left. If doubling of a digit results in a two-digit number, add up the two digits to get a single-digit number)



2. �ܰ�1���� ���� ��� ���ڸ� ���մϴ�. (Now add all single-digit numbers from Step 1)

4 + 4 + 8 + 2 + 3 + 1 + 7 + 8 = 37

3. �����ʿ��� �������� Ȧ�� ��ġ�� ���ڵ��� ��� ���մϴ�. (Add all digits in the odd places from right to left in the card number.)

6 + 6 + 0 + 8 + 0 + 7 + 8 + 3 = 38

4. �ܰ�2�� �ܰ�3���� ���� ���ڸ� ���մϴ�. (Sum the results from Step 2 and Step 3.)

37 + 38 = 75

5. �ܰ�4���� ���� ���ڰ� 10���� ������ ��������, ī���ȣ�� Ÿ���մϴ�. ���� ���, 4388576018402626 ��ȣ�� �ſ�ī�� ��ȣ�ν� Ÿ������ ������ 4388576018410707�� Ÿ���� �ſ�ī�� ��ȣ �Դϴ�. (If the result from Step 4 is divisible by 10, the card number is valid; otherwise, it is invalid. For example, the number 4388576018402626 is invalid, but the number 4388576018410707 is valid.)

�ſ�ī�� ��ȣ�� �Է� �޾Ƽ� Ÿ���ϴٸ� Valid�� Ÿ������ �ʴٸ� Invalid�� ����ϴ� ���α׷��� �ۼ��ϼ���. (long integer�� �Է¹޾ƾ� ������ ���� �� ���� ���Դϴ�)

Write a program that prompts the user to enter a credit card number as a long integer. Display whether the number is valid or invalid. 

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : �ſ��ȣ (13~16�ڸ� ����)

 

OUTPUT
* Line 1 ~ T : Ÿ���� �ſ�ī�� ��ȣ�� Valid�� �׷��� �ʴٸ� Invalid�� ���

 

SAMPLE INPUT
2
4388576018410707
4388576018402626
SAMPLE OUTPUT
Valid
Invalid
SOURCE
JAVA2015 PE6.31
*/

import java.util.*;
public class Main {
    static Scanner scan = new Scanner(System.in);
    
    
    
    public static void main(String[] args) {
        String p= scan.nextLine();
        
        int p1=Integer.parseInt(p);
        
        
        int[] l=new int[p1];
        
        
        String[] s=new String[p1];
        
        
        for (int i=0;i<p1;i++) {
            s[i]= scan.nextLine();
        }
        for (int i=0;i<p1;i++) {
            if (gilyi(s[i])==0 &&
                    duhae(s[i])==0 && shijak(s[i])==0) {
                
                System.out.println("Valid");
            }
            else
                System.out.println("Invalid");
        }
    }
    
    static public int shijak(String x) {
        char x1=x.charAt(0);
        char y1=x.charAt(1);

        
        
        if (x1=='4' || x1=='5' || x1=='6')
            return 0;
        else if (x1=='3' && y1=='7')
            return 0;
        else
            return 1;
    }
    
    
    
    
    
    static public int gilyi(String x) {
        int x1=x.length();
        if (x1>=13 && x1<=16)
            return 0;
        return 1;
    }
    
    static public int duhae(String x) {
        int p1=0;
        int p2=0;

        
        
        for (int i=x.length()-2;i>=0;i=i-2) {
            char c=x.charAt(i);
            
            
            String a=Character.toString(c);
            int b=Integer.parseInt(a);
            b*=2;
            if (b>=10) {
                p1+=b%10+b/10;
            }
            else {
                p1 += b;
            }
        }
        
        
        
        
        
        
        for (int i=x.length()-1;i>=0;i=i-2) {
            char z=x.charAt(i);
            String a=Character.toString(z);
            int b=Integer.parseInt(a);
            p2+=b;
        }
        
        
        
        if ((p1+p2)%10==0)
            return 0;
        else
            return 1;
    }
}
