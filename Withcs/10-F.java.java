/*DESCRIPTION
��ǥ�࿡ ���ĵ� �ٿ�� �簢���� 2�� ��ǥ���� n���� ���� �־�������, �簢���� �� ���� X�� Y�࿡ �����ϸ鼭 �־��� n���� ���� �����ϴ� �ּ� ũ���� �簢���� ���Ѵ�. 2�� ��ǥ���� n���� ���� �־����� �� �׸� 10.24d�� ���̴� ��ó�� �ٿ�� �簢���� ���ϴ� ���α׷��� ����� ����. 

A axis-aligned bounding rectangle is the minimum rectangle that encloses a set of points in a two-dimensional plane, as shown in Figure 10.24d.

INPUT
* Line 1 : ���ǰ��� N (1~1,000)

* Line 2 ~ N+1 : ���� x y ��ǥ (�������� ���е� 2���� �Ǽ�)

 

OUTPUT
* Line 1 : ���� ���ó�� �簢���� �߽��� ���

* Line 2 : ���� ���ó�� �簢���� width�� height�� ���

 

SAMPLE CODE
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        double[][] points = new double[N][2];
        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextDouble();
            points[i][1] = sc.nextDouble();
        }
        MyRectangle2D boundingRectangle = MyRectangle2D.getRectangle(points);
        System.out.printf("x, y: %.1f, %.1f\n", boundingRectangle.getX(), boundingRectangle.getY());
        System.out.printf("w, h: %.1f, %.1f\n", boundingRectangle.getWidth(), boundingRectangle.getHeight());
    }
}

YOUR_CODE
SAMPLE INPUT
3
3 1
-5 -5
0 7
SAMPLE OUTPUT
x, y: -1.0, 1.0
w, h: 8.0, 12.0
SOURCE
JAVA2015 PE10.15 */

class MyRectangle2D {
    double x;
    double y;
    double width;
    double height;
    MyRectangle2D(double a1, double b1,double W, double H) {
        x=a1;
        y=b1;
        width=W;
        height=H;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public static MyRectangle2D getRectangle(double[][] A) {
        double bigx=A[0][0];
        double bigy=A[0][1];
        double smallx=A[0][0];
        double smally=A[0][1];
        for (int i=1;i<A.length;i++) {
            if (bigx<A[i][0]) {
                bigx=A[i][0];
            }
            if (smallx>A[i][0]) {
                smallx=A[i][0];
            }
            if (bigy<A[i][1]) {
                bigy=A[i][1];
            }
            if (smally>A[i][1]) {
                smally=A[i][1];
            }
        }
        MyRectangle2D result=new MyRectangle2D(bigx/2+smallx/2,bigy/2+smally/2,Math.abs(bigx-smallx),Math.abs(bigy-smally));
        return result;
    }
}
