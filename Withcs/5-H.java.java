/*DESCRIPTION
당신은 다음 계산식을 통해서 pi를 계산할 수 있습니다. i를 입력으로 받아 pi를 계산하는 프로그램을 작성하세요.  

You can approximate pi by using the following series:



Write a program that displays the pi value for i.

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 정수 i (1~1,00000)

 

OUTPUT
* Line 1 ~ T : pi(소수점 네번째 자리까지 출력, 예: 11.713243의 경우 11.7132로 출력하고 11.0000의 경우 11.0000로 출력)

 

SAMPLE INPUT
3
9
999
99999
SAMPLE OUTPUT
3.2523
3.1425
3.1416
SOURCE
JAVA2015 PE5.25



*/






import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int T=scan.nextInt();

        int arr[];
        arr=new int[T+1];

        for(int i=0;i<T;i++){
                int individual= scan.nextInt();
                arr[i]=individual;
        }

        for(int j=0;j<T;j++){
            double sum=0;
            for(int i=1;i<=arr[j];i++){
                sum=sum+((Math.pow(-1,i+1))/(2*i-1))*4;

            }
            System.out.printf("%.4f",Math.floor(sum*10000)/10000.0);
            System.out.printf("\n");
        }
    }
}





