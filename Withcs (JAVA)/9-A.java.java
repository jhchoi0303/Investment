/*DESCRIPTION
���� Ư¡�� ������ Rectangle Ŭ������ ����� �ٶ��ϴ�.

double ���� width�� height�� �ʵ�� ������.
���ڰ� ���� �����ڿ� width�� height�� ���ڷ� ������ �����ڸ� ������.
getArea() �޼ҵ�� �簢���� ���̸� �����Ѵ�.
getPerimeter() �޼ҵ�� �簢���� �ѷ��� �����Ѵ�. 
�������� �ۼ��� �ڵ�� �Ʒ� �����ڵ��� YOUR_CODE �κп� �� ������ �˴ϴ�. 



(The Rectangle class) Following the example of the Circle class in Section 9.2, design a class named Rectangle to represent a rectangle. The class contains:

Two double data fields named width and height that specify the width and height of the rectangle. The default values are 1 for both width and height.
A no-arg constructor that creates a default rectangle.
A constructor that creates a rectangle with the specified width and height.
A method named getArea() that returns the area of this rectangle.
A method named getPerimeter() that returns the perimeter. 
Your code is compiled into the YOUR_CODE part of the sample code below


INPUT
* Line 1 : �簢���� �ʺ� (1~1,000 ������ �Ǽ�)

* Line 2 : �簢���� ���� (1~1,000 ������ �Ǽ�)


OUTPUT
* Line 1 : �簢���� ���� (�Ҽ��� ��° �ڸ��� �ݿø�)

* Line 2 : �簢���� �ѷ� (�Ҽ��� ��° �ڸ��� �ݿø�)


SAMPLE CODE
import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        double w1, h1;
        w1 = sc.nextDouble();
        h1 = sc.nextDouble();

        Rectangle r1 = new Rectangle();
        r1.width = w1;
        r1.height = h1;
        System.out.printf("%.2f\n", r1.getArea());

        Rectangle r2 = new Rectangle(w1, h1);
        System.out.printf("%.2f\n", r2.getPerimeter());
    }
}

YOUR_CODE
SAMPLE INPUT
2
3
SAMPLE OUTPUT
6.00
10.00
HINT


SOURCE
JAVA2015 PE9.1*/


class Rectangle
{
    double height;
    double width;

    public Rectangle () {

    }
    public Rectangle(double a, double b) {
        width=a;
        height=b;
    }

    public double getArea() {
        return width*height;
    }

    public double getPerimeter() {
        return (width*2+height*2); }
}