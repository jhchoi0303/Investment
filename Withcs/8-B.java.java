/*DESCRIPTION
���a�� ���b�� ���ϱ� ���ؼ��� ���a�� ���� ������ ���b�� ���� ������ ��ġ �ؾ��ϰ�, �� ����� ������ ���Ҵ� ������ �ڷ����� ������ �Ѵ�. ���c�� ���a�� ���b�� ���ؼ� ���� ����̶�� ����. ���a�� ���� ������ n�̶�� ���c�� ij���Ҵ� ai1 * b1j + ai2 * b2j + ... + ain * bnj �̴�.

To multiply matrix a by matrix b, the number of columns in a must be the same as the number of rows in b, and the two matrices must have elements of the same or compatible types. Let c be the result of the multiplication. Assume the column size of matrix a is n. Each element cij is ai1 * b1j + ai2 * b2j + ... + ain * bnj.



�������� �ΰ��� 3*3 ����� �Է����� �޾�, �� ����� ���� ���ο� ����� ���ؾ� �Ѵ�.  

Write a test program that prompts the user to enter two 3 * 3 matrices and displays their product. 

 

INPUT
* Line 1 ~ 3 : ù��° ����� �� (�������� ���е� 3���� ����)

* Line 4 ~ 6 : �ι�° ����� �� (�������� ���е� 3���� ����)

- ��� ����� ���Ҵ� �����̸� ������ -1,000~1,000

 

OUTPUT
* Line 1 ~ 3 : ������ ����� �� (���� ���Ҹ� �������� ������ ���)

 

SAMPLE INPUT
1 2 3
3 2 1
2 1 3
4 5 6
6 5 4
4 6 5
SAMPLE OUTPUT
28 33 29
28 31 31
26 33 31
SOURCE
JAVA2015 PE8.6 */

import java.util.Scanner;

public class Main {
    static Scanner input =new Scanner(System.in);
    public static void main(String[] args) {



        int[] a=new int[9];
        int[] b=new int[9];

        for (int i=0;i<9;i++){
            a[i]= input.nextInt();}
        for (int i=0;i<9;i++){
            b[i]= input.nextInt();}

        System.out.printf("%d %d %d",a[0]*b[0]+a[2]*b[6]+a[1]*b[3],a[0]*b[1]+a[1]*b[4]+a[2]*b[7],a[0]*b[2]+a[1]*b[5]+a[2]*b[8]);
        System.out.println();
        System.out.printf("%d %d %d",a[3]*b[0]+a[4]*b[3]+a[5]*b[6],a[3]*b[1]+a[4]*b[4]+a[5]*b[7],a[3]*b[2]+a[4]*b[5]+a[5]*b[8]);
        System.out.println();
        System.out.printf("%d %d %d",a[6]*b[0]+a[7]*b[3]+a[8]*b[6],a[6]*b[1]+a[7]*b[4]+a[8]*b[7],a[6]*b[2]+a[7]*b[5]+a[8]*b[8]);
    }
}
