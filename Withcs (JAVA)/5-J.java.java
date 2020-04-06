/*DESCRIPTION
년과 월을 입력으로 받아 해당 월의 달력을 출력하는 프로그램을 작성하세요.

Write a program that prompts the user to enter the year and the month and displays the calendar table for the year on the console. 

INPUT
* Line 1 : year (1,600~3,000)

* Line 2 : month (1~12)

 

OUTPUT
Sample Output 참조

SAMPLE INPUT
2013
1
SAMPLE OUTPUT
Sun Mon Tue Wed Thu Fri Sat
         1   2   3   4   5
 6   7   8   9  10  11  12
13  14  15  16  17  18  19
20  21  22  23  24  25  26
27  28  29  30  31
HINT
Chapter 6.11 참고

SOURCE
JAVA2015 PE5.29
*/

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int year = scan.nextInt();
        int month = scan.nextInt();


        printingmonth(year, month);


    }
        public static void printingmonth ( int year, int month){

            TitleMonth(year, month);
            BodyMonth(year, month);

        }

        public static void TitleMonth ( int year, int month){

            System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        }


        public static void BodyMonth ( int year, int month){
            int start = Starting(year, month);
            int TotalMonth = Numbermonth(year, month);

            int i = 0;
            for (i = 0; i < start; i++)
                System.out.print("    ");
            for (i = 1; i <= TotalMonth; i++) {

                if(i==TotalMonth){
                    System.out.printf("%d",i);
                }
                else {
                    System.out.printf("%2d", i);

                    if ((i + start) % 7 == 0)
                        System.out.println();
                    else {
                        System.out.printf("  ");
                    }
                }
            }

        }

        public static int Starting ( int year, int month){
            final int JAN = 3;
            int totalNumberOfDays = AllDays(year, month);
            return (totalNumberOfDays + JAN) % 7;
        }


        public static int AllDays ( int year, int month){
            int total = 0;


            for (int i = 1800; i < year; i++)
                if (LY(i))
                    total = total + 366;
                else
                    total = total + 365;

            for (int i = 1; i < month; i++)
                total = total + Numbermonth(year, i);

            return total;
        }


        public static int Numbermonth ( int year, int month){
            if (month == 1 || month == 3 || month == 5 || month == 7 ||
                    month == 8 || month == 10 || month == 12) return 31;

            if (month == 4 || month == 6 || month == 9 || month == 11) return 30;

            if (month == 2) return LY(year) ? 29 : 28;

            return 0;

        }

        public static boolean LY ( int year){
            return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
        }
    }


