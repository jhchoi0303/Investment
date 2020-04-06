/*
DESCRIPTION
����ڷκ��� ���� ���� n�� �Է¹޾�, ������������ n�� ���μ� ���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. ���� ��� ���� ���� 120�� �־������� 5 3 2 2 2�� ���μ� ���� ����� ��µǾ�� �մϴ�. 

(Displaying the prime factors) Write a program that prompts the user to enter a positive integer and displays all its smallest factors in decreasing order. For example, if the integer is 120, the smallest factors are displayed as 5, 3, 2, 2, 2. Use the StackOfIntegers class to store the factors (e.g., 2, 2, 2, 3, 5) and retrieve and display them in reverse order.

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���μ� ������ ���� ���� n (1~1,000,000)

OUTPUT
* Line 1 ~ T : �������� ���е� �������� ���μ� ���� ���

SAMPLE INPUT
3
3
10
120
SAMPLE OUTPUT
3
5 2
5 3 2 2 2
HINT
StackOfInteger Ŭ������ ����ϼ���.

SOURCE
JAVA2015 PE10.5


*/



import java.text.MessageFormat;
import java.util.Scanner;



public class Main {


    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        String[] result = new String[N];



        for (int i = 0; i < N; i++) {
            result[i] = "";
        }



        for (int i = 0; i < N; i++) {


            int number = scan.nextInt();


            if (number == 1) {
                result[i] =result[i]+ " 1";
            } else {
                int count;
                StackOfIntegers intstack = new StackOfIntegers();
                for (int j = 2; j <= (number); j++) {


                    count = 0;
                    while (number % j == 0) {
                        number = number/ j;

                        intstack.add(j);
                        count++;
                    }


                    if (count == 0) {continue;}
                    count++;
                }


                while (!intstack.none()) {
                    result[i] =result[i]+MessageFormat.format(" {0}", intstack.react());
                }
            }
        }
        for (int i = 0; i < N; i++) {
            result[i]=result[i].replaceAll(",","");

            System.out.println(result[i].substring(1));
        }
    }
}

class StackOfIntegers {
    int[] elements;
    int size;

    public StackOfIntegers() {
        this(16);
    }

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    public int add(int value) {
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }

        return elements[size++] = value;
    }

    public boolean none() {
        return size == 0;
    }

    public int react() {
        return elements[--size];
    }



}




