/*DESCRIPTION
�� ���� ������� ���� ���� �����ְ� �޾� �Խ��ϴ�. �׷��� ���������� ���� �ñ⿡�� �����̶� �Ļ��� �� �ִµ�, �Ļ��� ���࿡ ����� �ݾ��� ������ ���� ���� �� �����ϴ�. ������ �� �ڻ��� ���� �ڻ� + �ٸ� ���࿡ �������� �ڻ����� ����մϴ�(�� �� �����࿡ ������ �͵� �����մϴ�). �Ʒ� �׸����� ������ �ټ� ������ ���Դϴ�. �̵� ������ ���� �ڻ��� 25, 125, 175, 75, 181�鸸$ �Դϴ�. �׸����� �������� ���1���� ���2���� ������, ����1�� ����2���� 40�鸸$�� ������ �־����� ��Ÿ���ϴ�.  

Banks lend money to each other. In tough economic times, if a bank goes bankrupt, it may not be able to pay back the loan. A bank��s total assets are its current balance plus its loans to other banks. The diagram in Figure 8.8 shows five banks. The banks�� current balances are 25, 125, 175, 75, and 181 million dollars, respectively. The directed edge from node 1 to node 2 indicates that bank 1 lends 40 million dollars to bank 2.



���� ������ �� �ڻ��� � ���ѱݾ׺��� �������� �Ǹ�, ������ �Ҿ����� ���ϴ�. ���� �Ҿ������� ���࿡ ���� �������� ������� �������� �ݾ׸�ŭ �� �ڻ��� �������� �˴ϴ�. ���������, �����ߴ� �����̶� �������� �� �ڻ��� ���ҷ� ���� �Ҿ����� �� �� �ֽ��ϴ�. 

�������� ��� �Ҿ����� ������ ã�Ƴ��� ���α׷��� �ۼ��ؾ� �մϴ�. ���α׷��� �Է��� ������ �����ϴ�. ù��° ���� ������ �� N�� ���ѱݾ� L�Դϴ�. �� ���� N���� �ٿ��� �� ������ �ڻ� ������ �ֽ��ϴ�(������ ��ȣ�� 0���� N-1���� �Դϴ�) . �� ������ �ڻ� ������ ù��° �׸��� ���� �ڻ��Դϴ�. �ι�° �׸��� �������� ������ �� B �Դϴ�. ���� B���� ���� ���� ����� �� �ݾ��Դϴ�.  ���� ���, �� �׸��� �Է����� ��ȯ�ϸ� ������ �����ϴ�. (L�� 201�� �����մϴ�)

If a bank��s total assets are under a certain limit, the bank is unsafe. The money it borrowed cannot be returned to the lender, and the lender cannot count the loan in its total assets. Consequently, the lender may also be unsafe, if its total assets are under the limit. Write a program to find all the unsafe banks. Your program reads the input as follows. It first reads two integers N and limit L, where N indicates the number of banks and L is the minimum total assets for keeping a bank safe. It then reads N lines that describe the information for N banks with IDs from 0 to N-1. The first number in the line is the bank��s balance, the second number indicates the number B of banks that borrowed money from the bank, and the rest are pairs of two numbers. Each pair describes a borrower. The first number in the pair is the borrower��s ID and the second is the amount borrowed. For example, the input for the five banks in Figure 8.8 is as follows (note that the limit is 201): 

5 201
25 2 1 100.5 4 320.5
125 2 2 40 3 85
175 2 0 125 3 75
75 1 0 125
181 1 2 125
����3�� ���ڻ��� 75+125=200 �̰� 201(=L)���� �����Ƿ�, �Ҿ����� �����Դϴ�. ����3�� �Ҿ����� �����Ƿ�, ����1�� ���ڻ��� 125+40=165�� ���ҵǰ�, ���������� �Ҿ����� ������ �˴ϴ�. ���� ���α׷��� �Ҿ����� �������� ����3�� ����1�� ã�Ƴ� �� �־�� �մϴ�.

The total assets of bank 3 are (75 + 125), which is under 201, so bank 3 is unsafe. After bank 3 becomes unsafe, the total assets of bank 1 fall below (125 + 40). Thus, bank 1 is also unsafe. The output of the program should be Unsafe banks are 3 1

INPUT
* Line 1 : �����Ǽ�N ���ѱݾ�L (N:1~100������ ����)

* Line 2~N+1 : �����ڻ� �������������B {�������� ����ݾ�}*B

- ���ѱݾ�, �����ڻ�, ����ݾ��� 1~1,000 ������ �Ǽ�

 

OUTPUT
* Line 1 : �Ҿ����� ������ ��ȣ�� ������������ �������� ������ ���

SAMPLE INPUT
5 201
25 2 1 100.5 4 320.5
125 2 2 40 3 85
175 2 0 125 3 75
75 1 0 125
181 1 2 125
SAMPLE OUTPUT
1 3
HINT
Use a two-dimensional array borrowers to represent loans. borrowers[i][j] indicates the loan that bank i loans to bank j. Once bank j becomes unsafe, borrowers[i][j] should be set to 0.

SOURCE
JAVA2015 PE8.17 */

import java.util.*;

public class Main {


    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);


        int t = input.nextInt();
        int[] ints = new int[t];

        double smallest = input.nextDouble();
        double[] here = new double[t];
        double[] total = new double[t];
        double[][] b = new double[t][t];
        
        
        
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < t; j++) {
                b[i][j] = 0;
            }
        }
        
        
        for (int i = 0; i < t; i++) {
            here[i] = input.nextInt();
            ints[i] = input.nextInt();
            for (int j = 0; j < ints[i]; j++) {
                int a = input.nextInt();
                b[i][a] = input.nextDouble();
            }
        }
        
        
        for (int i = 0; i < t; i++) {
            total[i] = here[i];
            for (int j = 0; j < t; j++) {
                total[i] += b[i][j];
            }
        }
        for (int i = 0; i < t; i++) {
            if (total[i] < smallest) {
                for (int j = 0; j < t; j++) {
                    b[j][i] = 0;
                }
            }
        }
        for (int i = 0; i < t; i++) {
            total[i] = here[i];
            for (int j = 0; j < t; j++) {
                total[i]=total[i]+ b[i][j];
            }
        }
        String result="";
        for (int i = 0; i < t; i++) {
            if (total[i] < smallest) {
                result+=i+" ";
            }
        }
        
        
        
        int length=result.length();
        if (length!=0) {
            result = result.substring(0, length - 1);
            System.out.print(result);
        }
        else {
            System.out.println(result);
        }
    }
}

