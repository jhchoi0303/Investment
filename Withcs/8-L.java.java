/*DESCRIPTION
4개의 정점을 가지는 볼록 다각형은 아래 그림처럼 4개의 삼각형으로 나누어 집니다. 볼록 다각형의  정점의 좌표 4개를 입력 받아, 4개의 삼각형의 넓이를 오름차순으로 정렬해서 출력하는 프로그램을 만드세요.

주의사항: 이미지에서는 시계 방향으로 데이터가 들어가지만 현재는 그렇지 않은 경우에 대한 문제가 추가되어 있습니다. 일반적인 경우(순서 무관한 입력)의 해결책을 찾아주시길 바랍니다.

A convex 4-vertex polygon is divided into four triangles, as shown in Figure 8.9. Write a program that prompts the user to enter the coordinates of four vertices and displays the areas of the four triangles in increasing order. 



INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 공백으로 구분된 4쌍의 좌표 값 (각 좌표값은 -100~100 범위의 정수) 

OUTPUT
* Line 1 ~ T : 오름차순으로 정렬된 삼각형의 넓이 (소수점 2자리로 반올림)

SAMPLE INPUT
1
0 0 1 1 2 0 2 -1
SAMPLE OUTPUT
0.25 0.25 0.75 0.75
HINT
https://ko.wikipedia.org/wiki/크라메르_공식
https://ko.wikipedia.org/wiki/헤론의_공식
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
