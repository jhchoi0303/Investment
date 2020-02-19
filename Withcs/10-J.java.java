/*DESCRIPTION
주어진 숫자들을 연결하여 가장 크게 만들어 낼 수 있는 3의 배수를 출력하시오. (모든 숫자를 사용해야 함)

항상 답이 존재한다고 가정해도 좋다

 

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 문자열 (공백으로 구분된 0-9 범위의 정수; 정수의 개수는 100개를 넘지 않음)

 

OUTPUT
* Line 1 ~ T : 3의 배수

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
