/*DESCRIPTION
�������� 8�� ������ ü���ǿ��� 8���� ���� ���� ���� ���ϰ�(���� ��, ���� Į��, ���� �밢�� �� �ִ� ���� ���� ������ �� �ִ�) ��ġ�ϴ� �����̴�. 8���� ��ġ�ϴ� �������� ���� �����Ѵ�. �������� �־��� ü���ǿ� 8���� ���� Ÿ���ϰ� ��ġ�Ǿ� �ִ��� �Ǵ��ϴ� ���α׷��� �ۼ��ؾ� �Ѵ�

The classic Eight Queens puzzle is to place eight queens on a chessboard such that no two queens can attack each other (i.e., no two queens are on the same row, same column, or same diagonal). There are many possible solutions. Write a program that check valid solution of Eight Queens puzzle.



INPUT
* Line 1 ~ 8 : ���� Q ��ĭ�� . ���� ǥ�õ� ��

 

OUTPUT
* Line 1 ~ T : Ÿ���ϸ� Valid�� Ÿ������ �ʴٸ� Invalid�� ���

SAMPLE INPUT
Q.......
....Q...
.......Q
.....Q..
..Q.....
......Q.
.Q......
...Q....
SAMPLE OUTPUT
Valid
SOURCE
JAVA2015 PE7.22 */








import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);


        String[] str=new String[8];
        int[] str1=new int[8];
        boolean valid=true;


        for (int i=0;i<8;i++) {
            str[i]=scan.nextLine();
        }



        for (int i=0;i<8;i++) {
            int c=0;



            for (int j=0;j<8;j++) {
                char first=str[i].charAt(j);



                if (first=='Q') {
                    c++;
                    str1[i]=j+1;

                }
            }
            if(c>1) {
                valid=false;
                break;


            }
            else {
                c=0;
            }
        }

        if (valid==true) {


            for (int i=0;i<8;i++) {
                for (int j=1;j<7;j++) {
                    if (i!=j &&(str1[i] == str1[j])) {
                        valid = false;
                        break;
                    }

                }
            }
            for (int i=0;i<7;i++) {


                if (Math.abs(str1[i]-str1[i+1])==1) {
                    valid=false;
                    break;
                }
            }
        }
        if (valid==true) {
            System.out.println("Valid");
        }
        else
            System.out.println("Invalid");
    }
}