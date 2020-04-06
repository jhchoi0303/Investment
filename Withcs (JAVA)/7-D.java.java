/*DESCRIPTION
전통적인 8퀸 퍼즐은 체스판에서 8명의 퀸이 서로 공격 못하게(동일 행, 동일 칼럼, 동일 대각선 상에 있는 퀸은 서로 공격할 수 있다) 배치하는 문제이다. 8퀸을 배치하는 가지수는 많이 존재한다. 여러분은 주어진 체스판에 8명의 퀸이 타당하게 배치되어 있는지 판단하는 프로그램을 작성해야 한다

The classic Eight Queens puzzle is to place eight queens on a chessboard such that no two queens can attack each other (i.e., no two queens are on the same row, same column, or same diagonal). There are many possible solutions. Write a program that check valid solution of Eight Queens puzzle.



INPUT
* Line 1 ~ 8 : 퀸은 Q 빈칸은 . 으로 표시된 행

 

OUTPUT
* Line 1 ~ T : 타당하면 Valid를 타당하지 않다면 Invalid를 출력

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