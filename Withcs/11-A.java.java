/*
DESCRIPTION
Person�̶�� �̸��� Ŭ������, �̸� ��ӹ޴� Student�� Employee��� �̸��� Ŭ������ ����ÿ�. Employee�� ��ӹ޾� Faculty�� Staff��� �̸��� ���� Ŭ������ ����ÿ�. ���(Person)���Դ� �̸�, �ּ�, ��ȭ ��ȣ, �̸��� �ּҰ� �ִ�. �л�(Student)���Դ� �г� ���°� �ִ�.(freshman, sophomore, junior, Ȥ�� senior). �� ���¸� ����� �����Ͻÿ�. �ǰ����(Employee)���Դ� �繫��, ����, ä�����ڰ� �ִ�. ä�����ڸ� �����ϱ� ���� �������� 10.14�� MyDate Ŭ������ �̿��Ͻÿ�. ������(Faculty)���Դ� �ٹ� �ð�, ����� �ִ�. ����(Staff)���Դ� Īȣ(title)�� �ִ�. toString �޼ҵ带 �������̵��Ͽ� Ŭ���� �̸��� ����� �̸��� ǥ���Ͻÿ�. Ŭ�������� UML ���̾�׷��� �׸��� �����Ͻÿ�. Person, Student, Employee, Faculty, �׸��� Staff�� �����ϰ�, toString() �޼ҵ带 ȣ���ϴ� �׽�Ʈ ���α׷��� �ۼ��Ͻÿ�.

 

(The Person, Student, Employee, Faculty, and Staff classes) Design a class named Person and its two subclasses named Student and Employee. Make Faculty and Staff subclasses of Employee. A person has a name, address, phone number, and email address. A student has a class status (freshman, sophomore, junior, or senior). Define the status as a constant. An employee has an office, salary, and date hired. Use the MyDate class defined in Programming Exercise 10.14 to create an object for date hired. A faculty member has office hours and a rank. A staff member has a title. Override the toString method in each class to display the class name and the person��s name. Draw the UML diagram for the classes and implement them. Write a test program that creates a Person, Student, Employee, Faculty, and Staff, and invokes their toString() methods.

INPUT
* Line 1 : Person�� �� N (1~1,000)

* Line 2 ~ N+1 : ������ ���е� name, address, phoneNumber, email, class, title

 - name, address, phoneNumber, email, class, title�� ������� ���̰� 50�� ���� �ʴ� ���ڿ�

 

OUTPUT
Sample Output �������� ���

SAMPLE CODE
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Person> list = new ArrayList<>();
        int N = sc.nextInt();
        sc.nextLine();
        for (int n = 0; n < N; n++) {
            String[] items = sc.nextLine().split("\t");
            Person p = null;
            if (items[4].equals("Student")) {
                Student p1 = new Student();
                if (items[5].equals("FRESHMAN")) p1.status = Student.FRESHMAN;
                else if (items[5].equals("SOPHOMORE")) p1.status = Student.SOPHOMORE;
                else if (items[5].equals("JUNIOR")) p1.status = Student.JUNIOR;
                else if (items[5].equals("SENIOR")) p1.status = Student.SENIOR;
                p = p1;
            } else if (items[4].equals("Employee")) {
                Faculty p1 = new Faculty();
                if (items[5].equals("LECTURER")) p1.rank = Faculty.LECTURER;
                else if (items[5].equals("ASSISTANT_PROFESSOR")) p1.rank = Faculty.ASSISTANT_PROFESSOR;
                else if (items[5].equals("ASSOCIATE_PROFESSOR")) p1.rank = Faculty.ASSOCIATE_PROFESSOR;
                else if (items[5].equals("PROFESSOR")) p1.rank = Faculty.PROFESSOR;
                p = p1;
            } else if (items[4].equals("Staff")) {
                Staff p1 = new Staff();
                p1.title = items[5];
                p = p1;
            }
            p.name = items[0];
            p.address = items[1];
            p.phoneNumber = items[2];
            p.email = items[3];
            list.add(p);
        }
        for (Person p : list) System.out.println(p);
    }
}

YOUR_CODE
SAMPLE INPUT
5
Milass	64642	010-2808-2327	Milass24@daum.com	Staff	ACADEMIC_AFFAIRS
Elijah	98778	010-1807-4212	Elijah18@yahoo.com	Student	SOPHOMORE
Connor	19331	010-6685-1955	Connor28@gmail.com	Staff	BUSINESS_ADMINISTRATIVE_AFFAIRS
Evelynss	71931	010-6929-5816	Evelynss2@daum.com	Employee	ASSOCIATE_PROFESSOR
Gracess	47917	010-7317-5923	Gracess26@hotmail.com	Employee	PROFESSOR
SAMPLE OUTPUT
Milass is Staff
Elijah is Student
Connor is Staff
Evelynss is Faculty
Gracess is Faculty
SOURCE
JAVA2015 PE11.2 */



class Person {
    String name;
    String address;
    String phoneNumber;
    String email;

    public String toString() {
        String result="";
        result=result+name;
        result=result+" is ";
        String k="";
        k+=getClass();
        k=k.substring(6);
        result=result+k;
        return result;
    }
}

class Student extends Person {
    static final String FRESHMAN="FRESHMAN";
    static final String SOPHOMORE="SOPHOMORE";
    static final String JUNIOR="JUNIOR";
    static final String SENIOR="SENIOR";

    String status;
}

class Employee extends Person {
    String office;
    double salary;
    MyDate hired;
}

class Faculty extends Employee {
    static int LECTURER =1;
    static int ASSISTANT_PROFESSOR=2;
    static int PROFESSOR=3;
    static int ASSOCIATE_PROFESSOR=4;

    int hours;
    int rank;
}

class Staff extends Employee {
    String title;
}

class MyDate {
    private int a;
    private int b;
    private int c;

    public MyDate() {

    }

    public int GetYear() {
        return a;
    }

    public int GetMonth() {
        return b;
    }

    public int GetDay() {
        return c;
    }

    public void SetYear(int newYear) {
        a = newYear;
    }

    public void SetMonth(int newMonth) {
        if (newMonth <= 12 && newMonth >=0) {

            b = newMonth;
        } else {

        }
    }

    public void SetDay(int newDay) {
        c = newDay;
    }
}