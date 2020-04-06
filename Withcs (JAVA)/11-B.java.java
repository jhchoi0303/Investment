/*
DESCRIPTION
다각형의 두 점을 잇는 선분들이 다각형 내부에 있따면 이를 볼록 다각형이라 한다. 볼록 다각형의 좌표를 시계 방향으로 입력받고, 면적을 출력하는 프로그램을 작성하시오. 다음은 프로그램의 실행 예시이다.

A polygon is convex if it contains any line segments that connects two points of the polygon. Write a program that prompts the user to enter the number of points in a convex polygon, then enter the points clockwise, and display the area of the polygon. Here is a sample run of the program:

 

INPUT
* Line 1 :  다각형의 변의 수 T (1~30)

* Line 2 ~ T+1 : 다각형의 꼭지점 좌표를 나타내는 x y

 - x, y는 0보다 크고 1,000 보다 작다

OUTPUT
* Line 1 : 다각형의 넓이를 반올림해서 소수점 두자리까지 출력

SAMPLE INPUT
8
395  304
454  255
467  169
427  93
327  88
275  150
247  213
286  315
SAMPLE OUTPUT
The total area is 37718.00
SOURCE
JAVA2015 PE11.15 */


import java.util.*;
import javafx.geometry.*;
import java.awt.geom.Line2D;
public class Main {
    static Scanner input =new Scanner(System.in);
    public static void main(String[] args) {
        int N=input.nextInt();
        double[] D=new double[N*2];
        for (int i=0;i<N;i++) {
            D[2*i]=input.nextDouble();
            D[2*i+1]=input.nextDouble();
        }
        double o=0,s=0;
        for (int i=0;i<N;i++) {
            o=o+D[2*i];
            s=s+D[2*i+1];
        } s/=(double)N;
        o/=(double)N;


        double total=0;
        double[] a=new double[N];
        for (int i=0;i<N-1;i++) {
            Triangle2D l=new Triangle2D(D[2*i],D[2*i+1],D[2*i+2],D[2*i+3],o,s);
            a[i]=l.getArea();
            total=total+a[i];

        }
        Triangle2D my=new Triangle2D(D[0],D[1],D[2*N-2],D[2*N-1],o,s);
        a[N-1]=my.getArea();
        total=total+a[N-1];
        System.out.printf("The total area is %.2f",total);

    }
}


class Triangle2D {
    MyPoint s1;
    MyPoint s2;
    MyPoint s3;
    public Triangle2D() {
        s1 = new MyPoint(0, 0);
        s2 = new MyPoint(1, 1);
        s3 = new MyPoint(2, 5);
    }

    public Triangle2D(double x1,double y1,double x2,double y2,double x3,double y3) {
        s1=new MyPoint(x1,y1);
        s2=new MyPoint(x2,y2);
        s3=new MyPoint(x3,y3);
    }

    public double getArea() {
        double area=Math.abs(s1.A * s2.B + s2.A * s3.B + s3.A * s1.B - s2.A * s1.B - s3.A * s2.B - s1.A * s3.B);
        area/=2;
        return area;
    }
    public double getPerimeter() {
        double W=0;
        W+=Math.pow(Math.pow(s1.A-s2.A,2)+Math.pow(s1.A-s2.B,2),0.5);
        W+=Math.pow(Math.pow(s3.A-s2.A,2)+Math.pow(s3.B-s2.B,2),0.5);
        W+=Math.pow(Math.pow(s1.A-s3.A,2)+Math.pow(s1.B-s3.B,2),0.5);
        return W;
    }
    public boolean contains(double x, double y) {
        MyPoint z=new MyPoint(x,y);
        double area1=0.5*Math.abs(s1.A * s2.B + s2.A * z.B + z.A * s1.B - s2.A * s1.B - z.A * s2.B - s1.A * z.B);
        double area2=0.5*Math.abs(z.A * s2.B + s2.A * s3.B + s3.A * z.B - s2.A * z.B - s3.A * s2.B - z.A * s3.B);
        double area3=0.5*Math.abs(s1.A* z.B + z.A * s3.B + s3.A * s1.B - z.A * s1.B - s3.A * z.B - s1.A * s3.B);
        double total=area1+area2+area3;
        if (Double.compare(total,getArea())==0) {
            return true;
        }
        else
            return false;
    }
    public boolean contains(Triangle2D t) {
        boolean check1=false,check2=false,check3=false;
        if (contains(t.s1.A,t.s1.B))
            check1=true;
        if (contains(t.s2.A,t.s2.B))
            check2=true;
        if (contains(t.s3.A,t.s3.B))
            check3=true;
        if (check1 && check2 && check3)
            return true;
        else
            return false;
    }
    public boolean overlaps(Triangle2D t) {

        Line2D[] l=new Line2D[6];
        l[0]=new Line2D.Double(s2.A,s2.B,s3.A,s3.B);
        l[1]=new Line2D.Double(s1.A,s1.B,s2.A,s2.B);
        l[2]=new Line2D.Double(s1.A,s1.B,s3.A,s3.B);
        l[3]=new Line2D.Double(t.s1.A,t.s1.B,t.s2.A,t.s2.B);
        l[4]=new Line2D.Double(t.s1.A,t.s1.B,t.s3.A,t.s3.B);
        l[5]=new Line2D.Double(t.s3.A,t.s3.B,t.s2.A,t.s2.B);
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
        double A, B;

        public MyPoint(double A, double B) {
            this.A = A;
            this.B = B;
        }
    }
}