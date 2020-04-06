/*
DESCRIPTION
m이 주어졌을때 m * n를 정수의 제곱수로 만드는 최소의 n을 찾아라.

Write a program that prompts the user to enter an integer m and find the smallest integer n such that m * n is a perfect square. (Hint: Store all smallest factors of m into an array list. n is the product of the factors that appear an odd number of times in the array list. For example, consider m = 90, store the factors 2, 3, 3, 5 in an array list. 2 and 5 appear an odd number of times in the array list. So, n is 10.) Here are sample runs:

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : m (1~10,000 범위의 정수)

OUTPUT
* Line 1 ~ T : m * n 을 Sample Output 형식으로 출력

 

SAMPLE INPUT
3
90
1500
63
SAMPLE OUTPUT
900 = 90 x 10
22500 = 1500 x 15
441 = 63 x 7
SOURCE
JAVA2015 PE11.17 */



import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner scan =new Scanner(System.in);
        int N=scan.nextInt();
        for (int i=0;i<N;i++) {
            double a=1;
            double b=0;
            int p=scan.nextInt();
            int q=1;
           
            while (true) {
                a= Math.sqrt(p * q);
                b = Math.floor(a);
                
                if (a==b) {
                    break;
                }
                q++;
            }
            
            
            System.out.println((p*q)+" = "+p+" x "+q);
            
        }
    }
}