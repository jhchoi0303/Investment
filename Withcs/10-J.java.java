/*DESCRIPTION
�־��� ���ڵ��� �����Ͽ� ���� ũ�� ����� �� �� �ִ� 3�� ����� ����Ͻÿ�. (��� ���ڸ� ����ؾ� ��)

�׻� ���� �����Ѵٰ� �����ص� ����

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���ڿ� (�������� ���е� 0-9 ������ ����; ������ ������ 100���� ���� ����)

 

OUTPUT
* Line 1 ~ T : 3�� ���

SAMPLE INPUT
1
0 1 2 9 6
SAMPLE OUTPUT
96210 */

import java.util.*;
public class Main {
    
    public static void main(String[] args) {
         Scanner input=new Scanner(System.in);
        int N=input.nextInt();
        input.nextLine();
        for (int i=0;i<N;i++) {
            String string=input.nextLine();
            int num=0;
            for (int o=0;o<string.length();o++) {
                if (string.charAt(o)==' ') {
                    num++;
                }
            }

            int[] array=new int[num+1];
            for (int j=0;j<num+1;j++) {
                array[j]=Integer.parseInt(string.split(" ")[j]);
            }
            Arrays.sort(array);
            String result="";
            int[] y=new int[num+1];
            for (int j=0;j<num+1;j++) {
                y[j]=array[num-j];
                result=result+y[j];
            }
            System.out.println(result);
        }
    }
}
