/*
DESCRIPTION
 ���� ������ �����ϴ� MyRectangle2D�� ����� ����. 

���簢���� �߽��� ��ǥ�� ��Ÿ���� �� double���� x�� y�ʵ带 �����ϰ� ��ȯ�ϴ� method�� ������. (���簢���� ���� x�� y�࿡ �����ϴٰ� �����Ѵ�.)
�ʺ�� ���̸� �����ϰ� ��ȯ�ϴ� method�� ������.
���簢���� x, y�� ���� (0, 0), �ʺ�� ���̸� ���� 1�� ����� ��(��)����(no-arg)�����ڸ� ������.
x, y, �ʺ�, ���̸� �����ϴ� �����ڸ� ������.
�簢���� ���̸� ��ȯ�ϴ� getArea() �޼ҵ带 ������.
�簢���� �ѷ��� ��ȯ�ϴ� getPerimeter() �޼ҵ带 ������.
Ư���� ��(x, y)�� �� ���簢�� �ȿ� ������ true�� ��ȯ�ϴ� contains(double x, double y) �޼ҵ带 ������. (Figure 10.24a)
Ư���� ���簢���� �� ���簢�� �ȿ� ������ true�� ��ȯ�ϴ� contains(MyRectangle2D r) �޼ҵ带 ������. (Figure 10.24b)
Ư���� ���簢���� �� ���簢���� ��ġ�� true�� ��ȯ�ϴ� overlaps(MyRectangle2D r) �޼ҵ带 ������. (Figure 10.24c)
Define the MyRectangle2D class that contains:

Two double data fields named x and y that specify the center of the rectangle with getter and setter methods. (Assume that the rectangle sides are parallel to x- or y- axes.) 
The data fields width and height with getter and setter methods.
A no-arg constructor that creates a default rectangle with (0, 0) for (x, y) and 1 for both width and height.
A constructor that creates a rectangle with the specified x, y, width, and height.
A method getArea() that returns the area of the rectangle.
A method getPerimeter() that returns the perimeter of the rectangle.
A method contains(double x, double y) that returns true if the specified point (x, y) is inside this rectangle (see Figure 10.24a).
A method contains(MyRectangle2D r) that returns true if the specified rectangle is inside this rectangle (see Figure 10.24b). 
A method overlaps(MyRectangle2D r) that returns true if the specified rectangle overlaps with this rectangle (see Figure 10.24c).
 



�������� �ۼ��� �ڵ�� �Ʒ� �����ڵ��� YOUR_CODE �κп� �� ������ �˴ϴ�.

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : x1 y1 w1 h1 x2 y2 w2 h2 x3 y3 (�������� ���е� 10���� �Ǽ�)

- �Ǽ��� ������ -100 ~ 100

- �簢���� width�� height�� ������ 1~100 

- x1 y1 w1 h1�� �簢�� r1�� ����

- x2 y2 w2 h2�� �簢�� r2�� ����

- x3 y3�� ���� p

OUTPUT
* Line 1 ~ 4T : �� �׽�Ʈ ���̽����� ���� ��°� ���� 4�پ� ���

 - Line 3 : r1�� p�� �����ϸ� true �ƴ϶�� false 

 - Line 4 : r1�� r2�� �����ϸ� contain, r1�� r2�� ��ġ�� overlaps, ������ �ʴ´ٸ� no overlap�� ���

SAMPLE CODE
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            double x1, y1, x2, y2, x3, y3, x4, y4, x5, y5;
            x1 = sc.nextDouble();
            y1 = sc.nextDouble();
            x2 = sc.nextDouble();
            y2 = sc.nextDouble();
            x3 = sc.nextDouble();
            y3 = sc.nextDouble();
            x4 = sc.nextDouble();
            y4 = sc.nextDouble();
            x5 = sc.nextDouble();
            y5 = sc.nextDouble();

            MyRectangle2D r1 = new MyRectangle2D(x1, y1, x2, y2);
            MyRectangle2D r2 = new MyRectangle2D(x3, y3, x4, y4);

            System.out.printf("Area is %.1f\n", r1.getArea());
            System.out.printf("Perimeter is %.1f\n", r1.getPerimeter());
            System.out.println(r1.contains(x5, y5));
            if (r1.contains(r2)) {
                System.out.println("contain");
            } else if (r1.overlaps(r2)) {
                System.out.println("overlaps");
            } else {
                System.out.println("no overlap");
            }
        }
    }
}

YOUR_CODE
SAMPLE INPUT
3
0 0 3 3 0 0 1 1 3 0
0 0 2 2 2 0 2 2 1 0
0 0 2 2 2 2 2 2 1 0
SAMPLE OUTPUT
Area is 9.0
Perimeter is 12.0
false
contain
Area is 4.0
Perimeter is 8.0
true
overlaps
Area is 4.0
Perimeter is 8.0
true
overlaps
SOURCE
JAVA2015 PE10.8  */


class MyRectangle2D {
    double x;
    double y;
    double W;
    double H;
    MyRectangle2D(double x1, double y1,double w, double h) {
        x=x1;
        y=y1;
        W=w;
        H=h;
    }

    public double Horizantal() {
        return W;
    }

    public double Vertical() {
        return H;
    }

    public void puth(double h) {
        this.H = h;
    }

    public void putw(double width) {
        this.W = width;
    }

    MyRectangle2D() {
        x=0;
        y=0;
        W=1;
        H=1;
    }

    double getArea() {
        return W*H;
    }

    double getPerimeter() {
        return 2*(W+H);
    }

    boolean contains(double x1, double y1) {
        if (Math.abs(x1-x)<=W/2 && Math.abs(y1-y)<=H/2)
            return true;
        else
            return false;
    }

    boolean contains(MyRectangle2D r) {
        if (Math.abs(x-r.x)+r.W/2<=W/2 && Math.abs(y-r.y)+r.H/2<=H/2) {
            return true;
        }
       
        else
            return false;
    }

    boolean overlaps(MyRectangle2D r) {
        if (!contains(r) && !(Math.abs(x-r.x)>(W+r.W)/2 || ((H+r.H)/2)<Math.abs(y-r.y))) {
            return true;
        }
        else
            return false;
    }
}