/*DESCRIPTION
�������� 8�� ������ ü���ǿ��� 8���� ���� ���� ���� ���ϰ�(���� ��, ���� Į��, ���� �밢�� �� �ִ� ���� ���� ������ �� �ִ�) ��ġ�ϴ� �����̴�. �� ������ Ȯ���ؼ� NxN ü���ǿ� N���� ���� ���� ���� ���ϰ� ��ġ�ϴ� ������ N�� �����̶�� �Ѵ�. �������� NxN ü���ǿ��� N���� ���� ���� ���� ���ϰ� ��ġ�� �� �ִ� ��� �������� ����ϴ� ���α׷��� �ۼ��ؾ� �Ѵ�.

INPUT
* Line 1 : N�� ��Ÿ���� ���� (1 �� N < 11)

OUTPUT
* Line 1 : N���� ���� ���� ���� ���ϰ� ��ġ�ϴ� ����� ��

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
