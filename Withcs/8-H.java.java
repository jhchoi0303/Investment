/*DESCRIPTION
커넥트포는 두명의 플레이어가 번갈아가며 7개의 열과 6개의 행으로 구분된 보드에 색깔로 구분된 말을 떨어 뜨리는 방식으로 진행되는 보드게임입니다.

Connect four is a two-player board game in which the players alternately drop colored disks into a seven-column, six-row vertically suspended grid, as shown below.



게임의 승리조건은 행, 열, 대각선 방향 중 하나로 본인의 말을 연속적으로 4개 배치하는 것입니다. 빨강R과 노랑Y순으로 게임이 진행되고, 말이 떨어지는 열의 번호가 입력으로 주어진다고 할때, 게임이 종료되는 순간의 보드를 모습을 출력하는 프로그램을 작성하세요. (게임은 승리조건을 만족하는 즉시 종료됩니다.)

The objective of the game is to connect four same-colored disks in a row, a column, or a diagonal before your opponent can do likewise. The program prompts the series of the dropping column number with a red or yellow disk alternately, and display the the board on the console.

 

INPUT
* Line 1 : 말이 떨어지는 열의 번호를 공백으로 구분해서 출력 (0~6범위의 42개의 정수)

OUTPUT
게임의 종료모습을 샘플처럼 출력

보드의 빈칸은 스페이스로 표시

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