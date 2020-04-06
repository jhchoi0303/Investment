/*DESCRIPTION
�Է����� ���ĵ� �迭 A, B�� ����x�� �־�������, x�� ���� ����� ���� ������ A[i] + B[j]�� ã�� ���α׷��� ���弼��.

INPUT
* Line 1 : �迭Aũ�� �迭Bũ�� ����x
- �迭Aũ��, �迭Bũ��, ����x: 1~1,000,000 ������ ����

* Line 2 : �������� ���е�  �迭A�� �ڿ��� ����

* Line 3 : �������� ���е� �迭B�� �ڿ��� ����

OUTPUT
* Line 1 : x�� ���� ����� ���� ������ A[i] + B[j]�� ��(����)

SAMPLE INPUT
4 4 30
1 4 5 7
10 20 30 40
SAMPLE OUTPUT
1*/

import java.util.*;

public class Main {
    

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        
        int m=input.nextInt();
        int numbers=input.nextInt();
        int v=input.nextInt();
        
        
        int[] ma=new int[m];
        int[] na=new int[numbers];
        
        for (int i=0;i<m;i++) {
            ma[i]=input.nextInt();
        }
        for (int i=0;i<numbers;i++) {
            na[i]=input.nextInt();
        }
        

        int chaei=Math.abs(ma[0]+na[0]-v);


        int t=0;
        int s=numbers-1;
        
        int t1=t;
        int s1=s;

        
        while (t<m && s>=0) {
            if (Math.abs(ma[t]+na[s]-v)<chaei) {
                t1=t;
                s1=s;
                chaei=Math.abs(ma[t]+na[s]-v);
            }
            
            
            
            if (ma[t]+na[s]>v)
                s--;
            else
                t++;
        }
        System.out.println(Math.abs(ma[t1]+na[s1]-v));
    }
}
