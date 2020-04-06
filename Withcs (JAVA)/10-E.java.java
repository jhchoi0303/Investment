/*
DESCRIPTION
���� ������ �����ϴ� Triangle2D Ŭ������ ������.

MyPoint���� �� �� p1, p2, p3�ʵ带 �����ϰ� ��ȯ�ϴ� �޼ҵ带 ������. MyPoint Ÿ���� Programming Exercise 10.4�� ���ǵǾ��ֽ��ϴ�.
�� ���� ��ǥ�� ���� (0, 0), (1, 1), (2, 5)�� ������ default �ﰢ���� ����� ��(��)����(no-arg) �����ڸ� ������.
Ư���� ��ǥ�� ������, �ﰢ���� ����� �����ڸ� ������.
�ﰢ���� ���̸� ��ȯ�ϴ� getArea() �޼ҵ带 ������.
�ﰢ���� �ѷ��� ��ȯ�ϴ� getPerimeter() �޼ҵ带 ������.
Ư���� �� p�� �� �ﰢ�� �ȿ� ������ true�� ��ȯ�ϴ� contains(MyPoint p) �޼ҵ带 ������. (Figure 10.22a)
Ư���� �ﰢ���� �� �ﰢ�� �ȿ� ������ true�� ��ȯ�ϴ� contains(Triangle2D t) �޼ҵ带 ������. (Figure 10.22b)
Ư���� �ﰢ���� �� �ﰢ���� ��ġ�� true�� ��ȯ�ϴ� overlaps(Triangle2D t) �޼ҵ带 ������. (Figure 10.22c)
Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods. MyPoint is defined in Programming Exercise 10.4.
A no-arg constructor that creates a default triangle with the points (0, 0), (1, 1), and (2, 5).
A constructor that creates a triangle with the specified points.
A method getArea() that returns the area of the triangle.
A method getPerimeter() that returns the perimeter of the triangle.
A method contains(MyPoint p) that returns true if the specified point p is inside this triangle (see Figure 10.22a).
A method contains(Triangle2D t) that returns true if the specified triangle is inside this triangle (see Figure 10.22b).
A method overlaps(Triangle2D t) that returns true if the specified triangle overlaps with this triangle (see Figure 10.22c).
�������� �ۼ��� �ڵ�� �Ʒ� �����ڵ��� YOUR_CODE �κп� �� ������ �˴ϴ�.

 

 



INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : x1 y1 x2 y2 x3 y3 x4 y4 x5 y5 x6 y6 x7 y7 (�������� ���е� 14���� �Ǽ�)

- �Ǽ��� ������ -100 ~ 100

- x1 y1 x2 y2 x3 y3�� �ﰢ�� r1�� ����

- x4 y4 x5 y5 x6 y6�� �ﰢ�� r2�� ����

- x7 y7�� ���� p

- r1�� r2�� �׻� �ﰢ��

OUTPUT
* Line 1 ~ 4T : �� �׽�Ʈ ���̽����� ���� ��°� ���� 4�پ� ���

 - Line 3 : r1�� p�� �����ϸ� true �ƴ϶�� false 

 - Line 4 : r1�� r2�� �����ϸ� contain, r1�� r2�� ��ġ�� overlaps, ������ �ʴ´ٸ� no overlap�� ���

 

SAMPLE CODE
import javafx.geometry.*;
import java.awt.geom.Line2D;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            double x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, x7, y7;
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
            x6 = sc.nextDouble();
            y6 = sc.nextDouble();
            x7 = sc.nextDouble();
            y7 = sc.nextDouble();

            Triangle2D r1 = new Triangle2D(x1, y1, x2, y2, x3, y3);
            Triangle2D r2 = new Triangle2D(x4, y4, x5, y5, x6, y6);

            System.out.printf("Area is %.1f\n", r1.getArea());
            System.out.printf("Perimeter is %.1f\n", r1.getPerimeter());
            System.out.println(r1.contains(x7, y7));
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
-2 0 0 2 2 0 -1 0 0 1 1 0 2 0
-1 0 0 1 1 0 -2 0 0 2 2 0 2 0
-2 0 0 2 2 0 -1 -1 0 -2 1 -1 -1 1
SAMPLE OUTPUT
Area is 4.0
Perimeter is 9.7
true
contain
Area is 1.0
Perimeter is 4.8
false
overlaps
Area is 4.0
Perimeter is 9.7
true
no overlap
SOURCE
JAVA2015 PE10.12 */


class Triangle2D {
    MyPoint p1;
    MyPoint p2;
    MyPoint p3;
    public Triangle2D() {
        p1 = new MyPoint(0, 0);
        p2 = new MyPoint(1, 1);
        p3 = new MyPoint(2, 5);
    }

    public Triangle2D(double x1,double y1,double x2,double y2,double x3,double y3) {
        p1=new MyPoint(x1,y1);
        p2=new MyPoint(x2,y2);
        p3=new MyPoint(x3,y3);
    }

    public double getArea() {
        double area=Math.abs(p1.x * p2.y + p2.x * p3.y + p3.x * p1.y - p2.x * p1.y - p3.x * p2.y - p1.x * p3.y);
        area=area/2;
        return area;
    }
    public double getPerimeter() {
        double L=0;
        L+=Math.pow(Math.pow(p1.y-p2.y,2)+Math.pow(p1.x-p2.x,2),0.5);
        L+=Math.pow(Math.pow(p3.x-p2.x,2)+Math.pow(p3.y-p2.y,2),0.5);
        L+=Math.pow(Math.pow(p1.y-p3.y,2)+Math.pow(p1.x-p3.x,2),0.5);
        return L;
    }
    public boolean contains(double x, double y) {

        MyPoint p=new MyPoint(x,y);
        double area1=0.5*Math.abs(p1.x * p2.y + p2.x * p.y + p.x * p1.y - p2.x * p1.y - p.x * p2.y - p1.x * p.y);
        double area2=0.5*Math.abs(p.x * p2.y + p2.x * p3.y + p3.x * p.y - p2.x * p.y - p3.x * p2.y - p.x * p3.y);
        double area3=0.5*Math.abs(p1.x * p.y + p.x * p3.y + p3.x * p1.y - p.x * p1.y - p3.x * p.y - p1.x * p3.y);
        double ADD=area1+area2+area3;
        if (Double.compare(ADD,getArea())==0) {
            return true;
        }
        else
            return false;
    }
    public boolean contains(Triangle2D t) {
        boolean TF1=false,TF2=false,TF3=false;
        if (contains(t.p1.x,t.p1.y))
            TF1=true;
        if (contains(t.p2.x,t.p2.y))
            TF2=true;
        if (contains(t.p3.x,t.p3.y))
            TF3=true;
        if (TF1 && TF2 && TF3)
            return true;
        else
            return false;
    }
    public boolean overlaps(Triangle2D t) {

        Line2D[] l=new Line2D[6];
        l[0]=new Line2D.Double(p2.x,p2.y,p3.x,p3.y);
        l[1]=new Line2D.Double(p1.x,p1.y,p2.x,p2.y);
        l[2]=new Line2D.Double(p1.x,p1.y,p3.x,p3.y);
        l[3]=new Line2D.Double(t.p1.x,t.p1.y,t.p2.x,t.p2.y);
        l[4]=new Line2D.Double(t.p1.x,t.p1.y,t.p3.x,t.p3.y);
        l[5]=new Line2D.Double(t.p3.x,t.p3.y,t.p2.x,t.p2.y);
        boolean TF=true;
        for (int i=0;i<3;i++) {
            for (int j=3;j<6;j++) {
                if (l[i].intersectsLine(l[j])) {
                    TF=false;
                    break;
                }
            }
        }
        return !TF;

    }


    class MyPoint {
        double x, y;

        public MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
