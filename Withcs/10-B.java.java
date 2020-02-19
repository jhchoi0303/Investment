/DESCRIPTION
JAVA2015 PE10.7에 만든 Account 클래스를 활용해서 ATM 기계를 만들어 보자.  ATM 기계는 전원이 들어오는 것과 동시에 0, 1, . . . , 9의 id를 가지는 10개의 account 생성하고, 초기 잔액으로 $100를 넣어준다. ATM 기계의 시스템은 사용자에게 account id를 요구한다. 만약 잘못된 id가 입력되면, 다시 입력할 것을 요구한다. id가 타당하다면 시스템은 사용자에게 다음 4가지 메뉴를 제공한다.  

현재 id의 잔액을 소수점 한자리로 반올림해서 보여준다.
돈을 인출한다. 현재 잔액보다 더 많은 돈을 인출하려고 하면 메세지를 보여주며 무시한다.
돈을 입금한다. -금액을 입금하려고 하면 메세지를 보여주며 무시한다.
메뉴를 나간다
4가지 선택중 다른 선택을 하려고 하면 메세지를 보여주며 재입력을 요청한다. 시스템은 항상 켜있어야 하므로 id 입력단계에서 종료코드 -20150901이 들어오기 전까지 계속 반복되어야 한다.

 

힌트1: 이 문제에서는 인출값의 음수는 처리하고 있지 않습니다.

힌트2: "Wrong choice, try again: " 끝에 공백이 한 칸 있습니다.

Use the Account class created in Programming Exercise 9.7 to simulate an ATM machine. Create ten accounts in an array with id 0, 1, . . . , 9, and initial balance $100. The system prompts the user to enter an id. If the id is entered incorrectly, ask the user to enter a correct id. Once an id is accepted, the main menu is displayed as shown in the sample run. You can enter a choice 1 for viewing the current balance, 2 for withdrawing money, 3 for depositing money, and 4 for exiting the main menu. Once you exit, the system will prompt for an id again. Thus, once the system starts, it will not stop until get exit code -20150901.

INPUT
* 마지막 수를 제외하고, 모든 입력값은 정수이며 절대값은 100을 넘지 않는다

* 잔액이 int의 범위를 넘는 경우는 없다

* 프로그램이 종료되지 않는 경우는 없다

OUTPUT
Input에 따른 Output의 예는 다음줄 부터 시작된다. Input은 이탤릭 처리되어 있다. 

Enter an id: 4

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 100.0
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 2
Enter an amount to withdraw: 4
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 96.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 2
Enter an amount to withdraw: -1

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 97.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 3
Enter an amount to deposit: 10
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 107.0
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 4
 
Enter an id: 11
Please enter a correct id
Enter an id: 10
Please enter a correct id
Enter an id: 1
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 0
Wrong choice, try again: 
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 5
Wrong choice, try again: 
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 1
The balance is 100.0
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 2
Enter an amount to withdraw: 101
The amount is too large, ignored
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 3
Enter an amount to deposit: -1
The amount is negative, ignored
 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 4
 
Enter an id: -20150901
Exit code entered
SAMPLE INPUT
4
1
2
4
1
2
-1
1
3
10
1
4
11
10
1
0
5
1
2
101
3
-1
4
-20150901
SAMPLE OUTPUT
Enter an id: 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: The balance is 100.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Enter an amount to withdraw: 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: The balance is 96.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Enter an amount to withdraw: 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: The balance is 97.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Enter an amount to deposit: 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: The balance is 107.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 
Enter an id: Please enter a correct id
Enter an id: Please enter a correct id
Enter an id: 
Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Wrong choice, try again: 

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Wrong choice, try again: 

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: The balance is 100.0

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Enter an amount to withdraw: The amount is too large, ignored

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: Enter an amount to deposit: The amount is negative, ignored

Main menu
1: check balance
2: withdraw
3: deposit
4: exit
Enter a choice: 
Enter an id: Exit code entered
SOURCE
JAVA2015 PE10.7*/


import java.util.*;
public class Main {
    
    public static void main(String[] args) {
        Scanner SCAN=new Scanner(System.in);
        
        boolean tf=true;
        
        Account[] accounts = new Account[10];
        
        for (int i = 0; i < 10; i++) {
            accounts[i] = new Account(i, 100);
        }
        
        System.out.print("Enter an id: ");
        int N = SCAN.nextInt();
        
        while (tf) {
            
            if (N >= 0 && N <= 9) {
                System.out.println();
                System.out.print("Main menu\n1: check balance\n2: withdraw\n3: deposit\n4: exit\nEnter a choice: ");
                int a = SCAN.nextInt();
                if (a == 1) {
                    System.out.print("The balance is ");
                    System.out.println(accounts[N].getB());
                    
                }
                else if (a==2) {
                    System.out.print("Enter an amount to withdraw: ");
                    int w=SCAN.nextInt();
                    if (w>accounts[N].getB()) {
                        System.out.println("The amount is too large, ignored");
                        
                    }
                    else {
                       
                        accounts[N].remove(w);
                    }
                }
                else if (a==3) {
                    System.out.print("Enter an amount to deposit: ");
                    int amount=SCAN.nextInt();
                    if (amount<0) {
                        System.out.println("The amount is negative, ignored");
                        
                    }
                    else {
                        
                        accounts[N].deposit(amount);
                    }
                }
                else if (a==4) {
                    System.out.println();
                    System.out.print("Enter an id: ");
                    int i=SCAN.nextInt();
                    N=i;
                }
                else {
                    System.out.println("Wrong choice, try again: ");
                   
                    continue;
                }
            }
            else if (N==-20150901) {
               
                System.out.print("Exit code entered");
                tf=false;
            }
            else {
                System.out.println("Please enter a correct id");
                System.out.print("Enter an id: ");
                N=SCAN.nextInt();
                if (N>=0 && N<=9) {
                    
                }
            }
        }
    }
}

class Account {
    private int identity;
    private double b;
    private double annualInterestRate;
    private static Date dateCreated;
    Account(int identity1, double b1) {
        identity=identity1;
        b=b1;
    }
    Account(){}
    public void setAnnualInterestRate(double x) {
        annualInterestRate=x;
    }
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    public double getMonthlyInterestRate() {
        return annualInterestRate/1200;
    }
    public double getMonthlyInterest() {
        return getMonthlyInterestRate()*b;
    }
    public void remove(double x) {
        if(x>b) {
        }
        else {
            b =b- x;
        }
    }
    public void deposit(double x) {
        b=b+x;
    }
    public int getId() {
        return identity;
    }
    public double getB() {
        return b;
    }
}