/*
DESCRIPTION
 ���ڰ� �ƴ� ���ڰ� �ǿ����ڷ� ��� ���� ��, �� ������ �����ϴ� ���α׷��� �ۼ��Ͻÿ�. 

�ùٸ� ǥ�� : ���� op(+, -, *, /, %) ����



INPUT
Line 1 : N ( ������ ���� N =  1 ~ 1000)

 

Line 2 ~ N+1 : �������� ���е� 3���� �ܾ� (���ʴ�� ����, op, ����)

- �ܾ��� ���̴� 2�� ���� ����

OUTPUT
Line 1 ~ N : �ùٸ� �����̸� ��� ����� ���

 

�ùٸ��� ���� ������ "Wrong Input: �ùٸ��� ���� ���ڿ�" ���  (cf, �ǿ����� �ΰ� ��� �ùٸ��� ���� ��, �տ� �� ���)

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