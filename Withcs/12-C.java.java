/*

DESCRIPTION
next-line brace style을 end-of-line brace style로 변환 하는 프로그램을 작성하시오.

예를 들어, 다음 (a)의 Java code는 next-line brace style이고, (b)는 end-of-line brace style입니다.

여러분의 프로그램은 Java source code file로부터 Command line을 argument로 전달 받습니다.

그 Command line을 end-of-line brace style로 변환 해야 합니다.

Write a program that converts the Java source code from the next-line brace style to the end-of-line brace style.

For example, the following Java source in (a) uses the next-line brace style. Your program converts it to the end-of-line brace style in (b).

Your program can be invoked from the command line with the Java sourcecode file as the argument.

It converts the Java source code to a new format.

For example, the following command converts the Java source-code file Test.java to the end-of-line brace style.

 


INPUT
next-line brace style인 자바 소스코드

OUTPUT
end-of-line brace style인 자바 소스코드

SAMPLE INPUT
public class Test
{
	public static void main(String[] args)
	{
		System.out.println("###");
	}
}
SAMPLE OUTPUT
public class Test {
	public static void main(String[] args) {
		System.out.println("###");
	}
}
SOURCE
JAVA2015 PE12.12   */

import java.util.*;
public class Main {

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String N,ending=scan.nextLine();
        
        while (scan.hasNext()) {
            
            N=scan.nextLine();
            if (N.matches(".*[{]$")) ending=ending+" {";
            else ending=ending+"\n"+N;
        }
        System.out.print(ending);
    }
}