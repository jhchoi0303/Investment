/*DESCRIPTION
����� ���� ������ ���ؼ� pi�� ����� �� �ֽ��ϴ�. i�� �Է����� �޾� pi�� ����ϴ� ���α׷��� �ۼ��ϼ���.  

You can approximate pi by using the following series:



Write a program that displays the pi value for i.

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���� i (1~1,00000)

 

OUTPUT
* Line 1 ~ T : pi(�Ҽ��� �׹�° �ڸ����� ���, ��: 11.713243�� ��� 11.7132�� ����ϰ� 11.0000�� ��� 11.0000�� ���)

 

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





