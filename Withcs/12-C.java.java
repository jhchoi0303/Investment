/*

DESCRIPTION
next-line brace style�� end-of-line brace style�� ��ȯ �ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ���, ���� (a)�� Java code�� next-line brace style�̰�, (b)�� end-of-line brace style�Դϴ�.

�������� ���α׷��� Java source code file�κ��� Command line�� argument�� ���� �޽��ϴ�.

�� Command line�� end-of-line brace style�� ��ȯ �ؾ� �մϴ�.

Write a program that converts the Java source code from the next-line brace style to the end-of-line brace style.

For example, the following Java source in (a) uses the next-line brace style. Your program converts it to the end-of-line brace style in (b).

Your program can be invoked from the command line with the Java sourcecode file as the argument.

It converts the Java source code to a new format.

For example, the following command converts the Java source-code file Test.java to the end-of-line brace style.

 


INPUT
next-line brace style�� �ڹ� �ҽ��ڵ�

OUTPUT
end-of-line brace style�� �ڹ� �ҽ��ڵ�

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