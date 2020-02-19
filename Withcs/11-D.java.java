/*
DESCRIPTION
GeometricObject Ŭ������ ��ӹ��� Triangle�̶�� �̸��� Ŭ������ ����ÿ�. �� Ŭ������ ������ �����Ѵ� :

���� side1, side2, side3. �ﰢ���� �� ���� �ǹ��ϴ� double�� �����̸�, ����Ʈ ���� 1.0�̴�.
���ڸ� ���� �ʴ� ������(constructor). ����Ʈ ���� ���� �ﰢ���� �����.
���ڸ� �޴� ������(constructor). side1, side2, side3�� �����ϸ� �ﰢ���� �����.
�� ���� ������ �����ϴ� ������(accessor)
�ﰢ���� ���̸� ��ȯ�ϴ� �޼ҵ� getArea()
�ﰢ���� �ѷ��� ���̸� ��ȯ�ϴ� �޼ҵ� getPerimeter()
�ﰢ���� ���� ���縦 ��ȯ�ϴ� �޼ҵ� toString(). �ﰢ���� ���̸� ����ϴ� ������ �������� 2.19�� �����Ͻÿ�.
toString() �޼ҵ�� ������ ���� �����Ѵ� : return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;

 

(The Triangle class) Design a class named Triangle that extends GeometricObject. The class contains:

Three double data fields named side1, side2, and side3 with default values 1.0 to denote three sides of the triangle.
A no-arg constructor that creates a default triangle.
A constructor that creates a triangle with the specified side1, side2, and side3.
The accessor methods for all three data fields.
A method named getArea() that returns the area of this triangle.
A method named getPerimeter() that returns the perimeter of this triangle.
A method named toString() that returns a string description for the triangle. For the formula to compute the area of a triangle, see Programming Exercise 2.19.
The toString() method is implemented as follows: return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : side1 side2 side3 color filled

 - side1, side2, side3 �� 0~10������ �Ǽ�

 - color�� ������� ���̰� 50�� ���� �ʴ� ���ڿ�

 - filled�� true �Ǵ� false

OUTPUT
Sample Output �������� ���

���ڴ� �Ҽ��� ��°�ڸ� ���� ����Ͻÿ�. (DecimalFormat("##.00") ����)

SAMPLE CODE
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            double side1 = sc.nextDouble();
            double side2 = sc.nextDouble();
            double side3 = sc.nextDouble();

            GeometricObject triangle = new Triangle(side1, side2, side3);
            String color = sc.next();
            triangle.setColor(color);

            boolean filled = sc.nextBoolean();
            triangle.setFilled(filled);
            DecimalFormat df = new DecimalFormat("##.00");
            System.out.println("The area is " + df.format(triangle.getArea()));
            System.out.println("The perimeter is " + df.format(triangle.getPerimeter()));
            System.out.println(triangle);
        }
    }
}

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;

    /**
     * Default construct
     */
    protected GeometricObject() {
    }

    /**
     * Construct a geometric object
     */
    protected GeometricObject(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    /**
     * Getter method for color
     */
    public String getColor() {
        return color;
    }

    /**
     * Setter method for color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Getter method for filled. Since filled is boolean,
     * so, the get method name is isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Setter method for filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Abstract method findArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}

YOUR_CODE
SAMPLE INPUT
5
5.22856359077 8.64369661889 7.81208777215 red false
4.73859498495 5.28984483026 6.43911724765 blue true
9.85370908953 7.66252345724 4.89050910369 orange true
6.28459944776 9.74426851916 4.98337330199 green false
7.63836147698 7.61050092554 7.24533208254 violet true
SAMPLE OUTPUT
The area is 20.14
The perimeter is 21.68
Triangle: side1 = 5.23 side2 = 8.64 side3 = 7.81
The area is 12.33
The perimeter is 16.47
Triangle: side1 = 4.74 side2 = 5.29 side3 = 6.44
The area is 18.38
The perimeter is 22.41
Triangle: side1 = 9.85 side2 = 7.66 side3 = 4.89
The area is 13.66
The perimeter is 21.01
Triangle: side1 = 6.28 side2 = 9.74 side3 = 4.98
The area is 24.30
The perimeter is 22.49
Triangle: side1 = 7.64 side2 = 7.61 side3 = 7.25
SOURCE
JAVA2015 PE11.1   */


class Triangle extends GeometricObject {
    static double side1 = 1.0;
    static double side2 = 1.0;
    static double side3 = 1.0;

    Triangle() {

    }

    @Override
    public double getArea() {
        double SUM = side1 + side2 + side3;
        SUM =SUM/ 2;
        double all = SUM * (SUM - side1) * (SUM - side2) * (SUM - side3);
        all = Math.sqrt(all);
        return all;
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    Triangle(double x, double y, double z) {
        side1 = x;
        side2 = y;
        side3 = z;
    }

    DecimalFormat w =new DecimalFormat("##.00");

    public String toString() {
        String a = "";
        a =a+("Triangle: side1 = ");
        a =a+w.format(side1);
        a =a+" side2 = ";
        a =a+w.format(side2);
        a =a+" side3 = ";
        a =a+w.format(side3);
        return a;
    }

    public static void setSide1(double x) {
        Triangle.side1 = x;
    }

    public static void setSide2(double x) {
        Triangle.side2 = x;
    }

    public static void setSide3(double x) {
        Triangle.side3 = x;
    }

    public static double getSide1() {
        return side1;
    }

    public static double getSide2() {
        return side2;
    }

    public static double getSide3() {
        return side3;
    }


}