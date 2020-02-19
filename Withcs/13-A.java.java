/*
DESCRIPTION
GeometricObject�� ���� �� �ֵ��� Comparable �������̽��� �����ϰ�, �־��� �� ���� GeometricObject ��ü �� �� ū ��ü�� ��ȯ�ϴ� ���� �޼ҵ� max �� �����Ͻÿ�.

(Enable GeometricObject comparable) Modify the GeometricObject class to implement the Comparable interface, and define a static max method in the GeometricObject class for finding the larger of two GeometricObject objects. 

INPUT
Line 1 : ���ڿ��� ���� N

Line 2 ~ 1+N : radius color weight ������ ���

OUTPUT
Line 1 ~ N : radius ũ�� ������� ����

SAMPLE CODE
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        GeometricObject1[] aCircle1 = new Circle1[N];
        for (int i = 0; i < N; i++) {
            aCircle1[i] = new Circle1(sc.nextDouble(), sc.next(), sc.nextDouble());
        }
        Arrays.sort(aCircle1);
        for (GeometricObject1 c1 : aCircle1) {
            System.out.println(c1);
        }
    }
}

YOUR_CODE
SAMPLE INPUT
3
5.1 white 2
3 black 1
9 red 10
SAMPLE OUTPUT
radius:3.0, color:black, weight:1.0
radius:5.1, color:white, weight:2.0
radius:9.0, color:red, weight:10.0
SOURCE
JAVA2015 PE13.5   */

class GeometricObject1 implements Comparable<GeometricObject1> {

    public GeometricObject1(){}

    public int compareTo(GeometricObject1 o) {
        return 1;
    }
    public static int max(double a, double b) {
        if (a==b) return 0;
        else if (a>b) return 1;
        else return -1;
    }
}

class Circle1 extends GeometricObject1 {
    double radius,weight;
    String color;
    Circle1(double p, String q, double r) {
        radius=p;
        color=q;
        weight=r;
    }

    public int compareTo(GeometricObject1 w) {
        return GeometricObject1.max(this.radius,((Circle1)w).radius);
    }
    
    public String toString() {
        return String.format("radius:%.1f, color:%s, weight:%.1f",radius,color,weight);
    }
}
