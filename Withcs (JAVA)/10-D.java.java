/*DESCRIPTION
������ �����ϴ� ť(Queue) Ŭ������ ����� ����. ������ ���Ҹ� �����Ѵٴ� ������ ���ð� ť�� ����������, �Է°� ��¿����� ���� �ٸ� ���� ����� ���Ѵ�. ������ ���߿� ������ ���Ҹ� ���� ����Ѵٸ�, ť�� ���� �Էµ� ���Ҹ� ���� ����Ѵ�. �������� ������ ť Ŭ������ ���� ������ �����ؾ� �Ѵ�.

ť ���� int������ �����ϴ� int[]���� elements �ʵ带 ������.
ť ���� elements�� ���� �����ϴ� size �ʵ带 ������.
�迭 ũ�Ⱑ 8�� ť�� ����� �����ڸ� ������.
ť ������ v�� �ִ� enqueue(int v) �޼ҵ带 ������.
ť���� element�� ��ȯ�ϰ� �����ϴ� dequeue() �޼ҵ带 ������.
���� ť�� ��������� true�� ��ȯ�ϴ� empty()�޼ҵ带 ������.
ť�� ũ�⸦ ��ȯ�ϴ� getSize() �޼ҵ带 ������.
 

Section 10.6 gives a class for Stack. Design a class named Queue for storing integers. Like a stack, a queue holds elements. In a stack, the elements are retrieved in a last-in first-out fashion. In a queue, the elements are retrieved in a first-in first-out fashion. The class contains:

An int[] data field named elements that stores the int values in the queue.
A data field named size that stores the number of elements in the queue.
A constructor that creates a Queue object with default capacity 8.
The method enqueue(int v) that adds v into the queue.
The method dequeue() that removes and returns the element from the queue.
The method empty() that returns true if the queue is empty.
The method getSize() that returns the size of the queue.
 

 

INPUT
ť Ŭ������ �׽�Ʈ�� ���ؼ� ù° �ٿ��� �Է��� ���� N�� ���´�. ��° �� ���ʹ� N���� ������ �Է����� ��� �´�. -1�� �Է����� ���� ��� dequeue�� �����ϰ�, �׿��� ���� ť�� enqueue ���� �Ѵ�. 

* Line 1 : ����ǰ��� N (1~1,000)

* Line 2 ~ N+1 : �������� ������ (-1~1,000)

 

OUTPUT
ť�� ���� �ִ� ���Ҹ� Sample Output�� ���·� ������� ����Ѵ�. 

SAMPLE CODE
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            if (n == -1) {
                if (!queue.empty()) queue.dequeue();
            } else {
                queue.enqueue(n);
            }
        }
        while (!queue.empty())
            System.out.println(queue.dequeue());
    }
}

YOUR_CODE
SAMPLE INPUT
6
5
-1
-1
2
3
4
SAMPLE OUTPUT
2
3
4
SOURCE
JAVA2015 PE10.10 */


class Queue {
    int[] elements=new int[1000000];
    static int size=0;

    Queue() {
        size=8;
    }

    void enqueue(int v) {
        elements[size]=v;
        size++;
    }


    int dequeue() {
        for (int a=0;a<size-1;a++) {
            elements[a]=elements[a+1];
        }
        size--;
        return elements[7];
    }


    boolean empty() {
        if (size!=8) {
            return false;
        }
        else
            return true;
    }
    int getSize() {
        return size;
    }
}
