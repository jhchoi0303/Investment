/*DESCRIPTION
입력으로 정렬된 배열 A, B와 숫자x가 주어졌을때, x와 가장 가까운 값을 가지는 A[i] + B[j]를 찾는 프로그램을 만드세요.

INPUT
* Line 1 : 배열A크기 배열B크기 숫자x
- 배열A크기, 배열B크기, 숫자x: 1~1,000,000 범위의 정수

* Line 2 : 공백으로 구분된  배열A의 자연수 원소

* Line 3 : 공백으로 구분된 배열B의 자연수 원소

OUTPUT
* Line 1 : x와 가장 가까운 값을 가지는 A[i] + B[j]의 차(절댓값)

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
