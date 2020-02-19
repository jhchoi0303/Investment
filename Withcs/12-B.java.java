/*
DESCRIPTION
Sample Code�� �����Ͽ� �Է� ���ڿ��� 16������ �ƴϸ� 16���� ���ܰ� �߻��� ��ġ�� �˷��ִ� ���α׷��� �����Ͻÿ�.

�� �������� ����ϴ� 16������ �ƶ��� ���ڿ� ���ĺ� �빮��(�ҹ��ڴ� ����ó��)�θ� ǥ���� ���ڶ�� �����Ѵ�. 0X, 0x ǥ��� �����Ѵ�.

 

INPUT
Line 1 : ���ڿ��� ���� N

 

Line 2 ~ 1+N : 16�����̰ų� �ƴ� ���ڿ���

OUTPUT
Line 1 ~ N : 16�����̶�� 10������ ��ȯ /

16������ �ƴ϶��

 

HexFormatException: Illegal hex character: "16������ �ƴ� ����" ���

SAMPLE CODE
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String hex = sc.next();
            int value;
            try {
                value = HexFormat.parseHex(hex);
            } catch (HexFormatException ex) {
                System.out.println(ex);
                continue;
            }
            System.out.println(value);
        }
    }

}

YOUR_CODE
SAMPLE INPUT
5
A5
FAA
T10
ABC
10.
SAMPLE OUTPUT
165
4010
HexFormatException: Illegal hex character: T
2748
HexFormatException: Illegal hex character: .
SOURCE
JAVA2015 PE12.8 */


class HexFormat {
    static int w;
    public static int parseHex(String string) throws HexFormatException {

        for (int i = 0; i < string.length(); i++) {
            if ((string.charAt(i) >= '0' && string.charAt(i) <= '9') || (string.charAt(i) >= 'A' && string.charAt(i) <= 'F')) {

            } else {

                throw new HexFormatException(string.charAt(i));

            }
        }
        int ending = Integer.parseInt(string, 16);
        w = ending;
        return ending;
    }
}

class HexFormatException extends Exception {
    private String strings ="";
    public HexFormatException(char x) {
        strings=strings+x;
    }
    public String toString() {
        return "HexFormatException: Illegal hex character: " + this.strings;
    }
}