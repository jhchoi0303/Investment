/*DESCRIPTION
�������� ������ ���� Ư¡�� ������ Stock Ŭ������ ������ �մϴ�. 

id�� name �ʵ带 ������.
������ �ֽİ��� �����ϴ� double���� previousClosingPrice �ʵ带 ������.
������ �ֽİ��� �����ϴ� double���� currentPrice �ʵ带 ������.
id�� name�� ���ؼ� Ŭ������ ������ �� �־�� �Ѵ�. 
�ֽİ��� ��ȭ���� %�� ǥ���ϴ� getChangePercent �޼ҵ带 ������.
�������� �ۼ��� �ڵ�� �Ʒ� �����ڵ��� YOUR_CODE �κп� �� ������ �˴ϴ�. 

 
(The Stock class) Following the example of the Circle class in Section 9.2, design a class named Stock that contains:

�� A string data field named symbol for the stock��s symbol.

�� A string data field named name for the stock��s name.

�� A double data field named previousClosingPrice that stores the stock price for the previous day.

�� A double data field named currentPrice that stores the stock price for the current time.

�� A constructor that creates a stock with the specified symbol and name.

�� A method named getChangePercent() that returns the percentage changed from previousClosingPrice to currentPrice.

 

INPUT
* Line 1 : id ���ڿ� (�ִ����1,000)

* Line 2 : name ���ڿ� (�ִ����1,000)

* Line 3 : ������ �ֽİ� (1~1,000,000,000 ������ �Ǽ�)

* Line 4 : ������ �ֽİ� (1~1,000,000,000 ������ �Ǽ�)

 
OUTPUT
* Line 1~3 : ���� ��� ����

SAMPLE CODE
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        Stock stock = new Stock(sc.nextLine(), sc.nextLine());
        stock.setPreviousClosingPrice(sc.nextDouble());
        stock.setCurrentPrice(sc.nextDouble());

        System.out.printf("Prev Price: %.2f\n", stock.getPreviousClosingPrice());
        System.out.printf("Curr Price: %.2f\n", stock.getCurrentPrice());
        System.out.printf("Price Change: %.2f%%\n", stock.getChangePercent() * 100);
    }
}

YOUR_CODE
SAMPLE INPUT
Naver
Naver Corp.
392930
29911223
SAMPLE OUTPUT
Prev Price: 392930.00
Curr Price: 29911223.00
Price Change: 7512.35%
SOURCE
JAVA2015 PE9.2*/


class Stock
{

    String id;
    String name;
    double previousClosingPrice;
    double currentPrice;


    public Stock(){}
    public Stock(String a, String b){
        this.id=a;
        this.name=b;


    }
    
    public void setCurrentPrice(double a){
        this.currentPrice=a;
    }

    public void setPreviousClosingPrice(double a){
        this.previousClosingPrice=a;
    }
    public double getPreviousClosingPrice(){
        return this.previousClosingPrice;
    }
    public double getCurrentPrice(){
        return this.currentPrice;
    }

   
    



    public double getChangePercent() {
        return (currentPrice-previousClosingPrice)/previousClosingPrice; }
}