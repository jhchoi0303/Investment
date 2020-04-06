/*DESCRIPTION
행렬a와 행렬b를 곱하기 위해서는 행렬a의 열의 개수와 행렬b의 행의 개수가 일치 해야하고, 두 행렬의 각각의 원소는 동일한 자료형을 가져야 한다. 행렬c를 행렬a와 행렬b를 곱해서 만든 행렬이라고 하자. 행렬a의 열의 개수를 n이라면 행렬c의 ij원소는 ai1 * b1j + ai2 * b2j + ... + ain * bnj 이다.

To multiply matrix a by matrix b, the number of columns in a must be the same as the number of rows in b, and the two matrices must have elements of the same or compatible types. Let c be the result of the multiplication. Assume the column size of matrix a is n. Each element cij is ai1 * b1j + ai2 * b2j + ... + ain * bnj.



여러분은 두개의 3*3 행렬을 입력으로 받아, 두 행렬을 곱한 새로운 행렬을 구해야 한다.  

Write a test program that prompts the user to enter two 3 * 3 matrices and displays their product. 

 

INPUT
* Line 1 ~ 3 : 첫번째 행렬의 행 (공백으로 구분된 3개의 원소)

* Line 4 ~ 6 : 두번째 행렬의 행 (공백으로 구분된 3개의 원소)

- 모든 행렬의 원소는 정수이며 범위는 -1,000~1,000

 

OUTPUT
* Line 1 ~ 3 : 곱해진 행렬의 행 (행의 원소를 공백으로 구분해 출력)

 

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
