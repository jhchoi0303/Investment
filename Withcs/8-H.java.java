/*DESCRIPTION
Ŀ��Ʈ���� �θ��� �÷��̾ �����ư��� 7���� ���� 6���� ������ ���е� ���忡 ����� ���е� ���� ���� �߸��� ������� ����Ǵ� ��������Դϴ�.

Connect four is a two-player board game in which the players alternately drop colored disks into a seven-column, six-row vertically suspended grid, as shown below.



������ �¸������� ��, ��, �밢�� ���� �� �ϳ��� ������ ���� ���������� 4�� ��ġ�ϴ� ���Դϴ�. ����R�� ���Y������ ������ ����ǰ�, ���� �������� ���� ��ȣ�� �Է����� �־����ٰ� �Ҷ�, ������ ����Ǵ� ������ ���带 ����� ����ϴ� ���α׷��� �ۼ��ϼ���. (������ �¸������� �����ϴ� ��� ����˴ϴ�.)

The objective of the game is to connect four same-colored disks in a row, a column, or a diagonal before your opponent can do likewise. The program prompts the series of the dropping column number with a red or yellow disk alternately, and display the the board on the console.

 

INPUT
* Line 1 : ���� �������� ���� ��ȣ�� �������� �����ؼ� ��� (0~6������ 42���� ����)

OUTPUT
������ �������� ����ó�� ���

������ ��ĭ�� �����̽��� ǥ��

SAMPLE INPUT
6 6 6 1 1 1 0 0 1 5 3 4 3 5 5 2 2 0 5 6 3 0 0 2 4 3 3 4 5 2 0 6 4 6 2 1 5 2 4 1 3 4
SAMPLE OUTPUT
     
R     
YR   RY
YYYR RR
YRRRRYY
RYYRYYR
SOURCE
JAVA2015 PE8.20 */

import java.util.*;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {



        String[][] end=new String[6][7];
        int[] start=new int[42];
        int[] numbers=new int[7];



        Arrays.fill(numbers, 5);
        for (int i=0;i<6;i++) {
            for (int j=0;j<7;j++) {
                end[i][j]=" ";
            }
        }
        for (int i=0;i<42;i++) {
            start[i]=scan.nextInt();
            if (i%2==0) {
                end[numbers[start[i]]][start[i]]="R";
            }
            else
                end[numbers[start[i]]][start[i]]="Y";
            numbers[start[i]]--;
            if (isCount(end,6,7)!=100) {
                for (int j=0;j<6;j++) {
                    for (int k=0;k<7;k++) {
                        System.out.print(end[j][k]);
                    }
                    System.out.println();
                }
                break;
            }
        }

    }
    public static int isCount(String[][] ints,int m,int n) {
        m=6;
        n=7;
        int numbers=0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                numbers++;
                if (j<n-3) {
                    if (ints[i][j].equals(ints[i][j + 3]) && !ints[i][j].equals(" ")) {
                        if (ints[i][j].equals(ints[i][j + 1]) && ints[i][j].equals(ints[i][j + 2])) {
                            return numbers;
                        }
                    }
                }
                if (i<m-3) {
                    if (ints[i][j].equals(ints[i + 3][j]) && !ints[i][j].equals(" ")) {
                        if (ints[i][j].equals(ints[i + 2][j]) && ints[i + 2][j].equals(ints[i + 1][j])) {
                            return numbers;
                        }
                    }
                }
                if (i<m-3 && j<n-3) {
                    if (ints[i][j].equals(ints[i + 3][j + 3]) && !ints[i][j].equals(" ")) {
                        if (ints[i][j].equals(ints[i + 2][j + 2]) && ints[i][j].equals(ints[i + 1][j + 1])) {
                            return numbers;
                        }
                    }
                }
            }
            for (int j = n - 1; j > 2; j--) {
                if (i<m-3) {
                    if (ints[i][j].equals(ints[i + 3][j - 3])
                            && !ints[i][j].equals(" ")) {
                        if (ints[i][j].equals(ints[i+2][j-2]) && ints[i][j].equals(ints[i+1][j-1])) {
                            return numbers;
                        }
                    }
                }
            }
        }
        return 100;
    }
}