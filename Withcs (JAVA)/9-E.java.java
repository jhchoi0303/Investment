/*DESCRIPTION
���� Ư¡�� ������ Account Ŭ������ ����� �ٶ��ϴ�.

int���� id �ʵ带 ������.
double���� balance �ʵ带 ������.
double���� ���ڷ� ������ ���� �������� �����ϴ� annualInterestRate�� ������. ��� ���´� ���� �������� �����ٰ� �����Ѵ�.
���°� ��������� �� �����͸� �����ϴ� dateCreated �ʵ带 ������.
���¸� default�� ����� ��(��)����(no-arg) �����ڸ� ������.
Ư���� id�� �ʱ� balance�� ���� ���¸� ����� �����ڸ� ������.
id�� balance, ���������� ���� accessor �޼ҵ�(���� ��ȯ�ϴ� �޼ҵ�)�� mutator �޼ҵ�(���� �����Ű�� �޼ҵ�)�� ������.
dateCreatead�� ���� accessor �޼ҵ带 ������.
���������� ��ȯ�ϴ� getMonthlyInterestRate() �޼ҵ带 ������.
�����ڸ� ��ȯ�ϴ� getMonthlyInterest() �޼ҵ带 ������.
���¿��� ������ �ݾ��� �����ϴ� withdraw �޼ҵ带 ������.
���¿� ������ �ݾ��� �Ա��ϴ� deposit �޼ҵ带 ������.
getMonthlyInterest () �޼ҵ�� �ݸ��� �ƴ� �������ڸ� ��ȯ�ϴ� ���Դϴ�. �������ڴ� �ܾ� * ���� �������Դϴ�. monthlyInterestRate�� annualInterestRate / 12�Դϴ�. annualInterestRate�� ������Դϴ� (�� : 4.5 %). �װ��� 100���� ���� �ʿ䰡 �ֽ��ϴ�.
The class contains:

A private int data field named id for the account (default 0).
A private double data field named balance for the account (default 0).
A private double data field named annualInterestRate that stores the current interest rate (default 0). Assume all accounts have the same interest rate. 
A private Date data field named dateCreated that stores the date when the account was created.
A no-arg constructor that creates a default account.
A constructor that creates an account with the specified id and initial balance.
The accessor and mutator methods for id, balance, and annualInterestRate.
The accessor method for dateCreated.
A method named getMonthlyInterestRate() that returns the monthly interest rate.
A method named getMonthlyInterest() that returns the monthly interest.
A method named withdraw that withdraws a specified amount from the account.
A method named deposit that deposits a specified amount to the account.
The method getMonthlyInterest() is to return monthly interest, not the interest rate. Monthly interest is balance * monthlyInterestRate. monthlyInterestRate is annualInterestRate / 12. Note that annualInterestRate is a percentage, e.g., like 4.5%. You need to divide it by 100.
�������� �ۼ��� �ڵ�� �Ʒ� �����ڵ��� YOUR_CODE �κп� �� ������ �˴ϴ�. 

INPUT
���� �ڵ� ����

OUTPUT
���� �ڵ� ����

- ��� �ݾ��� �ܾ� ���� Ŭ��� ������� �ʴ´�.  

SAMPLE CODE
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Account account = new Account(sc.nextInt(), sc.nextInt());
        Account.setAnnualInterestRate(sc.nextDouble());

        System.out.printf("Balance : %.2f\n", account.getBalance());
        System.out.printf("Monthly interest : %.2f\n", account.getMonthlyInterest());

        account.withdraw(sc.nextDouble());

        System.out.printf("Balance : %.2f\n", account.getBalance());
        System.out.printf("Monthly interest : %.2f\n", account.getMonthlyInterest());

        account.deposit(sc.nextDouble());

        System.out.printf("Balance : %.2f\n", account.getBalance());
        System.out.printf("Monthly interest : %.2f\n", account.getMonthlyInterest());
    }
}

YOUR_CODE
SAMPLE INPUT
1
1000
10
20000
100
SAMPLE OUTPUT
Balance : 1000.00
Monthly interest : 8.33
Balance : 1000.00
Monthly interest : 8.33
Balance : 1100.00
Monthly interest : 9.17
SOURCE
JAVA2015 PE9.7*/


class Account {
    private static int id;
    private static double balance;
    private static double annualInterestRate;
    private static Date dateCreated;
    Account(int id1, double balance1) {
        id=id1;
        balance=balance1;
    }



    Account(){}
    public static void setAnnualInterestRate(double a) {
        annualInterestRate=a;
    }

    public static double getMonthlyInterestRate() {
        return annualInterestRate/1200;
    }

    public static double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public static double getMonthlyInterest() {
        return getMonthlyInterestRate()*balance;
    }

    public static void withdraw(double b) {
        if(b>balance) {
        }
        else {
            balance=balance- b;
        }
    }
    public static int getId() {
        return id;
    }
    public static void deposit(double c) {
        balance=balance+c;
    }

    public static double getBalance() {
        return balance;
    }
}

