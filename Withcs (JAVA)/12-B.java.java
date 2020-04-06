/*
DESCRIPTION
Sample Code를 참고하여 입력 문자열이 16진법이 아니면 16진법 예외가 발생한 위치를 알려주는 프로그램을 구현하시오.

본 문제에서 사용하는 16진법은 아라비아 숫자와 알파벳 대문자(소문자는 예외처리)로만 표현된 숫자라고 가정한다. 0X, 0x 표기는 생략한다.

 

INPUT
Line 1 : 문자열의 개수 N

 

Line 2 ~ 1+N : 16진법이거나 아닌 문자열들

OUTPUT
Line 1 ~ N : 16진법이라면 10진수로 변환 /

16진법이 아니라면

 

HexFormatException: Illegal hex character: "16진법이 아닌 문자" 출력

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