/*
DESCRIPTION
 숫자가 아닌 문자가 피연산자로 들어 왔을 때, 그 정보를 제공하는 프로그램을 작성하시오. 

올바른 표현 : 숫자 op(+, -, *, /, %) 숫자



INPUT
Line 1 : N ( 문장의 개수 N =  1 ~ 1000)

 

Line 2 ~ N+1 : 공백으로 구분된 3개의 단어 (차례대로 숫자, op, 숫자)

- 단어의 길이는 2을 넘지 않음

OUTPUT
Line 1 ~ N : 올바른 문장이면 계산 결과를 출력

 

올바르지 않은 문장은 "Wrong Input: 올바르지 않은 문자열" 출력  (cf, 피연산자 두개 모두 올바르지 않을 때, 앞에 꺼 출력)

SAMPLE INPUT
3
4 + 5
4 - 5
4x - 5
SAMPLE OUTPUT
4 + 5 = 9
4 - 5 = -1
Wrong Input: 4x
SOURCE
JAVA2015 PE12.1 */


import java.util.*;

public class Main {
   

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        
        int A = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < A; i++) {
            boolean a1 = true;
            boolean a2 = true;
            String w = scan.nextLine();
            String q = "";
            String[] strings=new String[3];
            
            for (int j=0;j<3;j++) {
                strings[j]=w.split(" ")[j];
            }
            
            for (int k = 0; k < strings[0].length(); k++) {
                if (strings[0].charAt(k) >= '0' && strings[0].charAt(k) <= '9') {
                    a1 = true;
                }
                else if (strings[0].charAt(0)=='-') {
                    a1=true;
                }
                else {
                    a1 = false;
                    break;
                }
            }
           
            
            if (a1) {
                for (int k = 0; k < strings[2].length(); k++) {
                    if (strings[2].charAt(k) >= '0' && strings[2].charAt(k) <= '9') {
                        a1 = true;
                    } else if (strings[2].charAt(0) == '-') {
                        a1 = true;
                    } else {
                        a1 = false;
                        break;
                    }
                }
            }

            if (strings[1].contains("+") || strings[1].contains("-") || strings[1].contains("*") || strings[1].contains("/") || strings[1].contains("%")) {
                a2=true;
            }
            else {
                a2=false;
            }
         
            if (a1 && a2) {
                String sum=w;
                sum= sum+" = ";
                if (strings[1].equals("-")) {
                    sum+=Integer.parseInt(strings[0])-Integer.parseInt(strings[2]);
                }
                else if (strings[1].equals("+")) {
                    sum+=Integer.parseInt(strings[0])+Integer.parseInt(strings[2]);
                }
                else if (strings[1].equals("*")) {
                    sum+=Integer.parseInt(strings[0])*Integer.parseInt(strings[2]);
                }
                else if (strings[1].equals("/")) {
                    if (strings[2].equals("0")) {
                        sum="Wrong Input: 0";
                    }
                    else
                        sum+=Integer.parseInt(strings[0])/Integer.parseInt(strings[2]);
                }
                else {
                    sum+=Integer.parseInt(strings[0])%Integer.parseInt(strings[2]);
                }
                System.out.println(sum);
            }
            else {
                String ending="Wrong Input: ";
                boolean TF=true;
                if (a2) {
                    for (int j = 0; j < strings[0].length(); j++) {
                        if (strings[0].charAt(0)=='-' ||    (strings[0].charAt(j) >= '0' && strings[0].charAt(j) <= '9')) {
                            TF = true;
                        }
                        else {
                            TF=false;
                            break;
                        }

                    }
                    if (TF) {
                        ending += strings[2];
                    } else {
                        ending += strings[0];
                    }
                }
                else {
                    for (int j = 0; j < strings[0].length(); j++) {
                        if (!(strings[0].charAt(j) >= '0' &&     strings[0].charAt(j) <= '9')) {
                            TF = false;
                            break;
                        }
                    }
                    if (TF) {
                        ending += strings[1];
                    } else {
                        ending += strings[0];
                    }
                    
                }
                System.out.println(ending);
            }
        }
    }
}