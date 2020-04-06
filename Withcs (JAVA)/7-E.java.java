/*DESCRIPTION
전통적인 8퀸 퍼즐은 체스판에서 8명의 퀸이 서로 공격 못하게(동일 행, 동일 칼럼, 동일 대각선 상에 있는 퀸은 서로 공격할 수 있다) 배치하는 문제이다. 이 문제를 확장해서 NxN 체스판에 N개의 퀸이 서로 공격 못하게 배치하는 문제를 N퀸 퍼즐이라고 한다. 여러분은 NxN 체스판에서 N개의 퀸이 서로 공격 못하게 배치할 수 있는 모든 가지수를 계산하는 프로그램을 작성해야 한다.

INPUT
* Line 1 : N을 나타내는 정수 (1 ≤ N < 11)

OUTPUT
* Line 1 : N개의 퀸을 서로 공격 못하게 배치하는 경우의 수

SAMPLE INPUT
8
SAMPLE OUTPUT
92
SOURCE
JAVA2015 PE7.22*/



import java.util.*;

public class Main {
    static int a=0;
    
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int t = input.nextInt();
        int[] b = new int[t];
        Starting(0, b);
        System.out.println(a);
    }
    
    
    private static boolean point(int p, int q, int[] q1) {
        
        for (int i = 0; i < q; i++) {
            
            if (q1[i] == p) {
            return false;
        }
            if (Math.abs(q1[i] - p) == Math.abs(i - q)) {
                return false;
            }
            
        }
        return true;
    }
    
    
    private static void Starting(int p, int[] q) {
        
        
        int length = q.length;
        if (p == length) {
            
            String s=Arrays.toString(q);
            
            
            
            a++;
        } else {
            
            
            for (int j = 0; j < length; j++) {
                
                
                if (point(j, p, q)) {
                    q[p] = j;
                    Starting(p + 1, q);
                    q[p] = -1;
                }
            }
        }
    }

   
}
