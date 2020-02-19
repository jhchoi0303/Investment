/*DESCRIPTION
���� Ư¡�� ������ Fan1 Ŭ������ ����� �ٶ��ϴ�.

��ǳ�� �ӵ��� ��Ÿ���� ��� SLOW, MEDIUM, FAST�� ������, �� ���� ���� 1, 2, 3�̴�.
��ǳ���� �ӵ��� ��Ÿ���� int���� speed �ʵ带 ������. (�⺻�� SLOW)
��ǳ�� ������ ���¸� ��Ÿ���� boolean���� on �ʵ带 ������. (�⺻�� false)
��ǳ���� �������� ��Ÿ���� double���� radius �ʵ带 ������. (�⺻�� 5)
��ǳ���� ������ ��Ÿ���� string���� color �ʵ带 ������. (�⺻�� blue)
��� ������ �ʵ忡 ���� accessor �޼ҵ�� mutator �޼ҵ带 ������.
�⺻���� ������ �ִ� ��ǳ�⸦ �����ϴ� ��(��)����(no-arg) �����ڸ� ������.
��ǳ���� Ư¡�� ��ȯ�ϴ� toString() �޼ҵ带 ������. ���� ��ǳ�Ⱑ �����ִٸ� �� �޼ҵ�� ��ǳ���� �ӵ�, ����, �������� �ϳ��� string���� ��ȯ�Ѵ�. ��ǳ�Ⱑ �����ִٸ�, ��ǳ���� ����, �������� "fan is off"��� string�� �ϳ��� string���� ��ȯ�Ѵ�.
The class contains:

Three constants named SLOW, MEDIUM, and FAST with the values 1, 2, and 3 to denote the fan speed.
A private int data field named speed that specifies the speed of the fan (the default is SLOW).
A private boolean data field named on that specifies whether the fan is on (the default is false).
A private double data field named radius that specifies the radius of the fan (the default is 5).
A string data field named color that specifies the color of the fan (the default is blue).
The accessor and mutator methods for all four data fields.
A no-arg constructor that creates a default fan.
A method named toString() that returns a string description for the fan. If the fan is on, the method returns the fan speed, color, and radius in one combined string. If the fan is not on, the method returns the fan color and radius along with the string ��fan is off�� in one combined string.
INPUT
���� �ڵ� ����

OUTPUT
���� �ڵ� ����

- �Ǽ����� �Ҽ��� ��°�ڸ��� �ݿø�

SAMPLE CODE
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Fan1 fan1 = new Fan1();
        for (int i = 0; i < n; i++) {
            String op = sc.next();
            String val = sc.next();
            if (op.compareTo("speed") == 0) {
                if (val.compareTo("SLOW") == 0) fan1.setSpeed(Fan1.SLOW);
                else if (val.compareTo("FAST") == 0) fan1.setSpeed(Fan1.FAST);
                else fan1.setSpeed(Fan1.MEDIUM);
            } else if (op.compareTo("radius") == 0) {
                fan1.setRadius(Double.parseDouble(val));
            } else if (op.compareTo("color") == 0) {
                fan1.setColor(val);
            } else if (op.compareTo("on") == 0) {
                if (val.compareTo("true") == 0) fan1.setOn(true);
                else fan1.setOn(false);
            }
        }
        System.out.println(fan1.toString());
    }
}

YOUR_CODE
SAMPLE INPUT
2
speed FAST
on true
SAMPLE OUTPUT
speed 3
color blue
radius 5.00
SOURCE
JAVA2015 PE9.8*/


class Fan1 {
    static final int SLOW=1;
    static final int MEDIUM=2;
    static final int FAST=3;
    private static boolean on=false;
    private static double radius=5.00;
    private static int speed=SLOW;
    private static String color="blue";
    
    
    Fan1(int S,boolean reset,double R,String a) {
        speed=S;
        on=reset;
        radius=R;
        color=a;
    }
    
    
    Fan1() {}

    public static void setSpeed(int S) {
        Fan1.speed = S;
    }

    public static void setColor(String c) {
        Fan1.color = c;
    }

    public static void setRadius(double R) {
        Fan1.radius = R;
    }

    public static void setOn(boolean reset) {
        Fan1.on = reset;
    }

    public String toString() {
        String string=String.format("%.2f", radius);
        String w="";
        if (on) {
            w=w+"speed "+speed; w=w+"\n";
            w=w+"color "+color; w=w+"\n";
            w=w+"radius "+string;
            return w;
        }
        else {
            w=w+"color "+color; w=w+"\n";
            w=w+"radius "+string; w=w+"\n";
            w=w+"fan is off";
            return w;
        }
    }
}