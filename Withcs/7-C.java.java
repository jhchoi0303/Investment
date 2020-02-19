/*DESCRIPTION
Quincunx �Ǵ� Galton box�� �˷��� �ִ� ����� ������ ������ Sir Francis Galton�� �̸��� ���� ������� ��ġ�̴�. ����� �������� ������ ������ �������� �ﰢ���� ���·� �յ��ϰ� �����Ǿ� �ִ�.

The bean machine, also known as a quincunx or the Galton box, is a device for statistics experiments named after English scientist Sir Francis Galton. It consists of an upright board with evenly spaced nails (or pegs) in a triangular form, as shown in Figure 7.13.



���� ����� �Ա��� ������ ���� �߷¿� ���ؼ� �������µ�, �������� �ε�ĥ ������ 50%�� Ȯ���� ���� �Ǵ� ���������� ������ ��ȯ�Ѵ�. ��� �ϴܿ��� ������ ���� ������� ������ ������, ������ ���� ���Կ� ���̰� �ȴ�. ���� ���, Figure 7.13b���� ���� ��δ� LLRRLLR �̰� Figure 7.13c���� ���� ��δ� RLRRLRR�̴�. 

�������� ���� ���� �߸� Ƚ�� N�� ������ ���� M �׸��� �������� ���� ��θ� �Է����� �޾�, ���������� ������������ ���Կ� ��� ���� ��� �ִ��� ����ϴ� ���α׷��� �ۼ��ؾ� �Ѵ�. 

Balls are dropped from the opening of the board. Every time a ball hits a nail, it has a 50% chance of falling to the left or to the right. The piles of balls are accumulated in the slots at the bottom of the board. Write a program that simulates the bean machine. Your program should prompt the user to enter the number N of the balls and the number M of the slots in the machine, and the falling  path of each ball, then display the final buildup of the balls in the slots in a histogram. For example, the path for the ball in Figure 7.13b is LLRRLLR and the path for the ball in Figure 7.13c is RLRRLRR. 

 

INPUT
* Line 1 : ���� ���� �߸� Ƚ�� N (1~100)

* Line 2 : ������ ���� M (2~100)

* Line 3 ~ N+2 : ��θ� ��Ÿ���� M-1������ ���ڿ�  

OUTPUT
* Line 1 ~ M : ���Կ� ��� �ִ� ���� ����

 

SAMPLE INPUT
5
8
LRLRLRR
RRLLLRR
LLRLLRR
RRLLLLL
LRLRRLR
SAMPLE OUTPUT
0
0
1
1
3
0
0
0
HINT
Create an array named slots. Each element in slots stores the number of balls in a slot. Each ball falls into a slot via a path. The number of Rs in a path is the position of the slot where the ball falls. For example, for the path LRLRLRR, the ball falls into slots[4], and for the path is RRLLLLL, the ball falls into slots[2]

 

 

SOURCE
JAVA2015 PE7.21 */

import java.util.*;
public class Main {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
        String a=scan.nextLine();
        int a1=Integer.parseInt(a);
        String b=scan.nextLine();
        int b1=Integer.parseInt(b);



        String[] str=new String[a1];
        int[] s=new int[b1];

        for (int i=0;i<a1;i++) {
            str[i]=scan.nextLine();
        }


        for (int i=0;i<a1;i++) {
            int c=0;


            for (int j=0;j<b1-1;j++) {
                char beggining=str[i].charAt(j);

                if (beggining=='R') {
                    c++;
                }


                else
                    continue;
            }
            s[c]++;
        }



        for (int i=0;i<b1-1;i++) {
            System.out.println(s[i]);
        }
        System.out.print(s[b1-1]);
    }
}



