/*DESCRIPTION
���Ϻ� �������� �۾��ð��� 2�� �迭�� ��� �ִ�. �迭�� �� �࿡�� ������ ������ �۾��ð��� ���� ���еǾ� ����Ǿ� �ִ�. ���� ���, 8���� ������ �۾��ð��� ���� �׸�ó�� ����ȴ�. �������� �� ������ �۾��ð��� �Է� �޾Ƽ� �� �� ���� ���� ���� ���� �������� ������������ ����ϴ� ���α׷��� �ۼ��ؾ� �Ѵ�. 

Suppose the weekly hours for all employees are stored in a two-dimensional array. Each row records an employee's seven-day work hours with seven columns. For example, the following array stores the work hours for eight employees. Write a program that displays employees and their total hours in decreasing order of the total hours.



INPUT
* Line 1 : ������ N (1~100)

* Line 2 ~ N+1 : �̸� �ð�1 �ð�2 �ð�3 �ð�4 �ð�5 �ð�6 �ð�7
- �̸�: ������ �������� ���� ���ڿ��̸� ���̴� 100�� ���� �ʴ´�
- �ð�1~7: ���� (0~24)

OUTPUT
* Line 1 ~ N : �̸� �ð���_��

-�ð��� ���� ���ٸ� ������ �̸��� �Էµ� ������ ������.

 

SAMPLE INPUT
8
Employee0 2 4 3 4 5 8 8
Employee1 7 3 4 3 3 4 4
Employee2 3 3 4 3 3 2 2
Employee3 9 3 4 7 3 4 1
Employee4 3 5 4 3 6 3 8
Employee5 3 4 4 6 3 4 4
Employee6 3 7 4 8 3 8 4
Employee7 6 3 5 9 2 7 9
SAMPLE OUTPUT
Employee7 41
Employee6 37
Employee0 34
Employee4 32
Employee3 31
Employee1 28
Employee5 28
Employee2 20
SOURCE
JAVA2015 PE8.4*/


import java.util.*;

public class Main {
    

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] employees = new int[7];
        String[] names = new String[N];
        int[] total = new int[N];
        
        
        for (int i = 0; i < N; i++) {
            names[i] = scan.next();
            for (int j = 0; j < 7; j++) {
                employees[j] = scan.nextInt();
                total[i] += employees[j];
            }
        }
        int[] result = new int[N];
        for (int i = 0; i < N; i++){
            result[i] = total[i];}
        
        
        Arrays.sort(total);
        
        
        for (int i=N-1;i>=0;i--) {
            for (int j=0;j<N;j++) {
                if (result[j]==total[i]) {
                    if (i!=0 && total[i]==total[i-1]) {
                       
                        break;
                    }
                    else
                        System.out.printf("%s %d",names[j],total[i]);System.out.println();
                }
            }
        }
    }
}
