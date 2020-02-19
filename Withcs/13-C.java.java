/*
DESCRIPTION
분모와 분자를 BigInteger로 사용하는 Rational 클래스를 구현하시오.

(Use BigInteger for the Rational class) Redesign and implement the Rational class in Listing 13.13 using BigInteger for the numerator and denominator.

INPUT
* Line 1 : 테스트케이스의 개수 N

* Line 2 ~ N+1 : 각 케이스 별 숫자 a b c d

OUTPUT
* Line 1 ~ 4N : 각 테스트 케이스마다 다음과 같이 4줄씩 출력

- Line 1 : a/b + c/d = 결과

- Line 2 : a/b - c/d = 결과

- Line 3 : a/b * c/d = 결과

- Line 4 : a/b / c/d = 결과

- 모든 숫자는 분수 형태의 유리수

SAMPLE CODE
import java.math.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            Rational r1 = new Rational(new BigInteger(sc.next()), new BigInteger(sc.next()));
            Rational r2 = new Rational(new BigInteger(sc.next()), new BigInteger(sc.next()));

            System.out.println(r1 + " + " + r2 + " = " + r1.add(r2));
            System.out.println(r1 + " - " + r2 + " = " + r1.subtract(r2));
            System.out.println(r1 + " * " + r2 + " = " + r1.multiply(r2));
            System.out.println(r1 + " / " + r2 + " = " + r1.divide(r2));
        }
    }
}

YOUR_CODE
SAMPLE INPUT
3
5 9 1 -6
-3 -9 -8 -2
-7 3 -6 -3
SAMPLE OUTPUT
5/9 + -1/6 = 7/18
5/9 - -1/6 = 13/18
5/9 * -1/6 = -5/54
5/9 / -1/6 = -10/3
1/3 + 4 = 13/3
1/3 - 4 = -11/3
1/3 * 4 = 4/3
1/3 / 4 = 1/12
-7/3 + 2 = -1/3
-7/3 - 2 = -13/3
-7/3 * 2 = -14/3
-7/3 / 2 = -7/6
SOURCE
JAVA2015 PE13.15   */



class Rational {
    BigInteger p, q;

    Rational(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) < 0) {
            p = a.negate();
            q = b.negate();
        } else {
            p = a;
            q = b;
        }
    }

    Rational add(Rational s) {
        BigInteger w = q.gcd(s.q);
        w = (q.multiply(s.q)).divide(w);
        BigInteger x1 = w.divide(q);
        BigInteger x2 = w.divide(s.q);


        Rational result = new Rational((p.multiply(x1)).add(x2.multiply(s.p)), w);
        return result;
    }

    Rational subtract(Rational s) {
        BigInteger t = q.gcd(s.q);
        t = (q.multiply(s.q)).divide(t);
        BigInteger a1 = t.divide(q);
        BigInteger a2 = t.divide(s.q);

        Rational result = new Rational((p.multiply(a1)).subtract(a2.multiply(s.p)), t);
        return result;
    }

    Rational multiply(Rational s) {
        Rational result=new Rational(p.multiply(s.p),q.multiply(s.q));
        return result;
    }

    Rational divide(Rational s) {
        Rational result=new Rational(p.multiply(s.q),q.multiply(s.p));
        return result;
    }

    public String toString() {
        String result = "";
        BigInteger BI = q.gcd(p);
        if (!(q.gcd(p)).equals(BigInteger.ONE)) {
            p = p.divide(BI);
            q = q.divide(BI);
        }
        if (q.equals(BigInteger.ONE)) {
            result =result+ p;
        } else {

            result =result+ p;
            result =result+"/";
            result =result+ q;
        }

        return result;
    }


}