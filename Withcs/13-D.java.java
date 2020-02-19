/*

DESCRIPTION
����ڰ� �Ǽ��� �Է��ϸ� �м��� �ٲ��ִ� ���α׷��� �ۼ��Ͻÿ�.

��Ʈ : �Ǽ��� string���� ���� ��, �����κа� �Ҽ��κ����� ������ Rational Ŭ������ BigInteger�� ����ؼ� �Ҽ��� ������ ����(a/b)���� ������.

(Convert decimals to fractions) Write a program that prompts the user to enter a decimal number and displays the number in a fraction. Hint: read the decimal number as a string, extract the integer part and fractional part from the string, and use the BigInteger implementation of the Rational class in Programming Exercise 13.15 to obtain a rational number for the decimal number. 

INPUT
* Line 1 : �׽�Ʈ���̽��� ���� N

* Line 2 ~ N+1 : �� ���̽� �� �Ҽ��� ���� a b

OUTPUT
* Line 1 ~ 4N : �� �׽�Ʈ ���̽����� ������ ���� 4�پ� ���

- Line 1 : a + b = ��� 

- Line 2 : a - b = ��� 

- Line 3 : a * b = ���

- Line 4 : a / b = ���

- ��� ���ڴ� �м������� ������

SAMPLE CODE
import java.math.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            Rational r1 = Rational.getFraction(sc.next());
            Rational r2 = Rational.getFraction(sc.next());

            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
            System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
            System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
            System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        }
    }
}

YOUR_CODE
SAMPLE INPUT
2
3.25 -3
-1.0 -9
SAMPLE OUTPUT
13/4 + -3 = 1/4
13/4 - -3 = 25/4
13/4 * -3 = -39/4
13/4 / -3 = -13/12
-1 + -9 = -10
-1 - -9 = 8
-1 * -9 = 9
-1 / -9 = 1/9
SOURCE
JAVA2015 PE13.19  */

class Rational {
    BigInteger a, b;

    Rational(BigInteger p, BigInteger q) {
        if (q.compareTo(BigInteger.ZERO) < 0) {
            a = p.negate();
            b = q.negate();
        } else {
            a = p;
            b = q;
        }
    }

    public static Rational getFraction(String sting) {
        int number=-1;
        int keep=-1;
        String strings="";


        for (int i=0;i<sting.length();i++) {
            if (sting.charAt(i)=='.') {
                number++;
                keep=i;
            }
            else {
                strings+=sting.charAt(i);
            }
        }
        String m="1";
        for (int i=0;i<sting.length()-keep-1;i++) {
            m+="0";
        }
        BigInteger x1=new BigInteger(strings);
        BigInteger y1=new BigInteger(m);
        if (number==0) {
            Rational ending=new Rational(x1,y1);
            return ending;
        }
        else {
            Rational ending=new Rational(x1,BigInteger.ONE);
            return ending;
        }
    }

    Rational add(Rational k) {
        BigInteger r = b.gcd(k.b);
        r = (b.multiply(k.b)).divide(r);
        BigInteger x1 = r.divide(b);
        BigInteger x2 = r.divide(k.b);

        Rational ending = new Rational((a.multiply(x1)).add(x2.multiply(k.a)), r);
        return ending;
    }

    Rational subtract(Rational B) {
        BigInteger r = b.gcd(B.b);
        r = (b.multiply(B.b)).divide(r);
        BigInteger x1 = r.divide(b);
        BigInteger x2 = r.divide(B.b);

        Rational ending = new Rational((a.multiply(x1)).subtract(x2.multiply(B.a)), r);
        return ending;
    }

    Rational multiply(Rational C) {
        Rational ending=new Rational(a.multiply(C.a),b.multiply(C.b));
        return ending;
    }

    Rational divide(Rational D) {
        Rational ending=new Rational(a.multiply(D.b),b.multiply(D.a));
        return ending;
    }

    public String toString() {
        String ending = "";
        BigInteger BI = b.gcd(a);
        if (!(b.gcd(a)).equals(BigInteger.ONE)) {
            a = a.divide(BI);
            b = b.divide(BI);
        }
        if (b.equals(BigInteger.ONE)) {
            ending =ending+ a;
        } else {


            ending =ending+ a;
            ending =ending+ "/";
            ending =ending+ b;
        }

        return ending;
    }

}
