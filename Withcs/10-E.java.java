/*
DESCRIPTION
다음 내용을 포함하는 Triangle2D 클래스를 만들어보자.

MyPoint형의 세 점 p1, p2, p3필드를 설정하고 반환하는 메소드를 가진다. MyPoint 타입은 Programming Exercise 10.4에 정의되어있습니다.
세 점의 좌표를 각각 (0, 0), (1, 1), (2, 5)로 가지는 default 삼각형을 만드는 무(無)인자(no-arg) 생성자를 가진다.
특정한 좌표를 가지는, 삼각형을 만드는 생성자를 가진다.
삼각형의 넓이를 반환하는 getArea() 메소드를 가진다.
삼각형의 둘레를 반환하는 getPerimeter() 메소드를 가진다.
특정한 점 p가 이 삼각형 안에 있으면 true를 반환하는 contains(MyPoint p) 메소드를 가진다. (Figure 10.22a)
특정한 삼각형이 이 삼각형 안에 있으면 true를 반환하는 contains(Triangle2D t) 메소드를 가진다. (Figure 10.22b)
특정한 삼각형이 이 삼각형과 겹치면 true를 반환하는 overlaps(Triangle2D t) 메소드를 가진다. (Figure 10.22c)
Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods. MyPoint is defined in Programming Exercise 10.4.
A no-arg constructor that creates a default triangle with the points (0, 0), (1, 1), and (2, 5).
A constructor that creates a triangle with the specified points.
A method getArea() that returns the area of the triangle.
A method getPerimeter() that returns the perimeter of the triangle.
A method contains(MyPoint p) that returns true if the specified point p is inside this triangle (see Figure 10.22a).
A method contains(Triangle2D t) that returns true if the specified triangle is inside this triangle (see Figure 10.22b).
A method overlaps(Triangle2D t) that returns true if the specified triangle overlaps with this triangle (see Figure 10.22c).
여러분이 작성한 코드는 아래 샘플코드의 YOUR_CODE 부분에 들어가 컴파일 됩니다.

 

 



INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : x1 y1 x2 y2 x3 y3 x4 y4 x5 y5 x6 y6 x7 y7 (공백으로 구분된 14개의 실수)

- 실수의 범위는 -100 ~ 100

- x1 y1 x2 y2 x3 y3는 삼각형 r1의 정점

- x4 y4 x5 y5 x6 y6는 삼각형 r2의 정점

- x7 y7는 정점 p

- r1과 r2는 항상 삼각형

OUTPUT
* Line 1 ~ 4T : 각 테스트 케이스마다 샘플 출력과 같이 4줄씩 출력

 - Line 3 : r1이 p를 포함하면 true 아니라면 false 

 - Line 4 : r1이 r2를 포함하면 contain, r1와 r2가 겹치면 overlaps, 만나지 않는다면 no overlap을 출력

 

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
