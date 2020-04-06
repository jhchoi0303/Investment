/*DESCRIPTION
�־��� 4���� ���� ���簢������ üũ�ϴ� ���α׷��� �ۼ��ϼ���.

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : �������� ���е� 4���� ��ǥ �� (�� ��ǥ���� -100~100 ������ ����) 

OUTPUT
* Line 1 ~ T : ���簢���� ��� square�� ���, �ƴ� ��� not square�� ���

SAMPLE INPUT
3
0 0 0 2 2 0 2 2
0 0 4 0 2 2 2 -2
0 0 0 2 2 2 2 4
SAMPLE OUTPUT
square
square
not square */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        int N=input.nextInt();

        boolean c1=false, c2=false, c3=true;
        boolean[] result=new boolean[N];
        for (int i=0;i<N;i++) {
            int[] m=new int[4];
            int[] n=new int[4];
            int[] a=new int[4];
            for (int j=0;j<4;j++) {
                m[j]=input.nextInt();
                n[j]=input.nextInt();
            }


            double m1=(m[0]+m[1]+m[2]+m[3])/4;
            double n1=(n[0]+n[1]+n[2]+n[3])/4;

            double[] queue=new double[3];
            queue[0]=Math.pow(m[1]-m[0],2) +Math.pow(n[1]-n[0],2);
            queue[1]=Math.pow(m[2]-m[0],2) +Math.pow(n[2]-n[0],2);
            queue[2]=Math.pow(m[3]-m[0],2)   +Math.pow(n[3]-n[0],2);

            Arrays.sort(queue);

            if (queue[0]==queue[1])
                c1=true;
            if (queue[0]*2==queue[2])
                c2=true;
            Arrays.sort(m);
            if (m[0]==m[1] && m[0]==m[2]) {
                c3=false;
            }
            if (c1 && c2 && c3) {
                result[i]=true;
                c1=false;
                c2=false;
                c3=true;
            }
            else {
                result[i] = false;
                c1=false;
                c2=false;
                c3=true;
            }

        }


        for (int i=0;i<N;i++) {
            if (result[i])
                System.out.println("square");
            else
                System.out.println("not square");
        }
    }
}