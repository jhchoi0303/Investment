/*DESCRIPTION
4���� ������ ������ ���� �ٰ����� �Ʒ� �׸�ó�� 4���� �ﰢ������ ������ ���ϴ�. ���� �ٰ�����  ������ ��ǥ 4���� �Է� �޾�, 4���� �ﰢ���� ���̸� ������������ �����ؼ� ����ϴ� ���α׷��� ���弼��.

���ǻ���: �̹��������� �ð� �������� �����Ͱ� ������ ����� �׷��� ���� ��쿡 ���� ������ �߰��Ǿ� �ֽ��ϴ�. �Ϲ����� ���(���� ������ �Է�)�� �ذ�å�� ã���ֽñ� �ٶ��ϴ�.

A convex 4-vertex polygon is divided into four triangles, as shown in Figure 8.9. Write a program that prompts the user to enter the coordinates of four vertices and displays the areas of the four triangles in increasing order. 



INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : �������� ���е� 4���� ��ǥ �� (�� ��ǥ���� -100~100 ������ ����) 

OUTPUT
* Line 1 ~ T : ������������ ���ĵ� �ﰢ���� ���� (�Ҽ��� 2�ڸ��� �ݿø�)

SAMPLE INPUT
1
0 0 1 1 2 0 2 -1
SAMPLE OUTPUT
0.25 0.25 0.75 0.75
HINT
https://ko.wikipedia.org/wiki/ũ��޸�_����
https://ko.wikipedia.org/wiki/�����_����
SOURCE
JAVA2015 PE8.33 */

import java.util.*;
public class Main {
   
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        
        int N=scan.nextInt();
        
        double[] ending=new double[N*4];
        
        for (int i=0;i<N;i++) {
            double[] a=new double[4];
            double[] b=new double[4];
            for (int j=0;j<4;j++) {
                a[j]=scan.nextDouble();
                b[j]=scan.nextDouble();
            }
            
            
            
            double p,q,r,s,t,u;
            p=b[0]-b[2];
            q=a[2]-a[0];
            r=b[1]-b[3];
            s=a[3]-a[1];
            t=p*a[0]+q*b[0];
            u=r*a[1]+s*b[1];
            double a1=(t*s-q*u)/(p*s-q*r);
            double b1=(p*u-t*r)/(p*s-q*r);
            
            
            double[] ints=new double[4];
            ints[0]=a[0]*b[1]+a[1]*b1+a1*b[0]-a[1]*b[0]-a1*b[1]-a[0]*b1;
            ints[1]=a[1]*b[2]+a[2]*b1+a1*b[1]-a[2]*b[1]-a1*b[2]-a[1]*b1;
            ints[2]=a[2]*b[3]+a[3]*b1+a1*b[2]-a[3]*b[2]-a1*b[3]-a[2]*b1;
            ints[3]=a[3]*b[0]+a[0]*b1+a1*b[3]-a[0]*b[3]-a1*b[0]-a[3]*b1;
            
            
            
            for (int j=0;j<4;j++) {
                ints[j]=Math.abs(ints[j]);
                ints[j]=ints[j]/2;
                ints[j]=Math.round(ints[j]*100);
                ints[j]=ints[j]/100;
            }
      
            Arrays.sort(ints);
            
            
            for (int j=0;j<4;j++) {
                ending[4*i+j]=ints[j];
            }
        }
        for (int i=0;i<N;i++) {
            System.out.printf("%.2f %.2f %.2f %.2f",ending[4*i],ending[4*i+1],ending[4*i+2],ending[4*i+3]);
            System.out.println();
        
        }
    }
}
