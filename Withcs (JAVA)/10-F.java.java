/*DESCRIPTION
좌표축에 정렬된 바운딩 사각형은 2차 좌표계의 n개의 점이 주어졌을때, 사각형의 각 변이 X와 Y축에 평행하면서 주어진 n개의 점을 포함하는 최소 크기의 사각형을 말한다. 2차 좌표계의 n개의 점이 주어졌을 때 그림 10.24d에 보이는 것처럼 바운딩 사각형을 구하는 프로그램을 만들어 보자. 

A axis-aligned bounding rectangle is the minimum rectangle that encloses a set of points in a two-dimensional plane, as shown in Figure 10.24d.

INPUT
* Line 1 : 점의개수 N (1~1,000)

* Line 2 ~ N+1 : 점의 x y 좌표 (공백으로 구분된 2개의 실수)

 

OUTPUT
* Line 1 : 샘플 출력처럼 사각형의 중심을 출력

* Line 2 : 샘플 출력처럼 사각형의 width와 height를 출력

 

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
