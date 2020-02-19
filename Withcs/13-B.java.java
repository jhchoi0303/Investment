/*
DESCRIPTION
howToColor() method�� ������  �̸��� Colorable�� interface�� �������Ͻÿ�.  Colorable�� �����ϰ� GeometricObject�� ����� �߰��� Square, Rectangle Ŭ������  ������ �Ͻÿ�. howtocolor method�� howToColor: xxx�� ��� �ؾ� �մϴ�.

(The Colorable interface) Design an interface named Colorable with a void method named howToColor(). Every class of a colorable object must implement the Colorable interface. Design a class named Square that extends GeometricObject and implements Colorable. Implement howToColor to display the message Color all four sides.

INPUT
* Line 1 : ������ ���� N

* Line 2 ~ N : Square or Rectangle / Square�̸� �Ѻ��� ���� a, Rectangle �̸� �� ���� ���� a, b

OUTPUT
* Line 1 ~ 4N : �� �׽�Ʈ ���̽����� ���� ��°� ���� 4�پ� ���

- Line 1: ���� ���

- Line 2 : howToColor: xxx

- Line 3 : area: ����

- Line 4 : perimeter: �� ���� ���� ��    

SAMPLE CODE
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        GeometricObject[] aObject = new GeometricObject[N];
        for (int i = 0; i < N; i++) {
            String shape = sc.next();
            if (shape.equals("Square")) {
                aObject[i] = new Square(sc.nextDouble());
            } else if (shape.equals("Rectangle")) {
                aObject[i] = new Rectangle(sc.nextDouble(), sc.nextDouble());
            }
        }
        for (int i = 0; i < aObject.length; i++) {
            if (aObject[i] instanceof Colorable)
                ((Colorable) aObject[i]).howToColor();
            System.out.println("area: " + aObject[i].getArea());
            System.out.println("perimeter: " + aObject[i].getPerimeter());
        }
    }
}

YOUR_CODE
SAMPLE INPUT
3
Square 3
Square 5
Rectangle 10 2
SAMPLE OUTPUT
Square
howToColor: xxx
area: 9.0
perimeter: 12.0
Square
howToColor: xxx
area: 25.0
perimeter: 20.0
Rectangle
howToColor: xxx
area: 20.0
perimeter: 24.0
SOURCE
JAVA2015 PE13.7 */

interface Colorable {
    void howToColor();
}

abstract class GeometricObject implements Colorable {


    double p, q;
    String strings;

    public String toString() {
        String ending = "";
        ending = ending+ strings;
        ending = ending+'\n';
        ending = ending+"howToColor: xxx"+'\n';
        return ending;
    }


    public double getArea() {
        return p * q;
    }

    public double getPerimeter() {
        return (p + q) * 2;
    }
}

class Square extends GeometricObject {


    Square(double x) {
        strings = "Square";
        p = x;
        q = x;
    }

    @Override
    public void howToColor() {
        System.out.println(strings);
        System.out.println("howToColor: xxx");
    }
}

class Rectangle extends GeometricObject {
    
    Rectangle(double a, double b) {
        strings = "Rectangle";
        p = a;
        q= b;
    }

    @Override
    public void howToColor() {
        System.out.println(strings);
        System.out.println("howToColor: xxx");
    }
}
