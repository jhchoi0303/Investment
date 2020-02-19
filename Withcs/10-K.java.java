/*  DESCRIPTION
�־��� ���ڵ��� �����Ͽ� ���� ũ�� ����� �� �� �ִ� 3�� ����� ����Ͻÿ�. (��� ���ڸ� ������� �ʾƵ� ��)

 

INPUT
* Line 1 : �׽�Ʈ���̽� T (1~1,000)

* Line 2 ~ T+1 : ���ڿ� (�������� ���е� ����; ������ ������ 100���� ���� ����)

OUTPUT
* Line 1 ~ T : 3�� ���

 - 3�� ����� ���� ��� 0�� ���

SAMPLE INPUT
1
0 1 6 7 8
SAMPLE OUTPUT
8760  */




import java.util.*;
public class Main {
    static Scanner input =new Scanner(System.in);
    public static void main(String[] args) {
        int t=input.nextInt();
        input.nextLine();
        for (int i=0;i<t;i++) {
            String string=input.nextLine();
            int count=0;
            for (int p=0;p<string.length();p++) {
                if (string.charAt(p)==' ') {
                    count++;
                }
            }

            int[] x=new int[count+1];
            for (int j=0;j<count+1;j++) {
                x[j]=Integer.parseInt(string.split(" ")[j]);
            }
            Arrays.sort(x);
            String end="";
            String[] data=new String[3];
            for (int j=0;j<3;j++)
                data[j]="";
            int sum=0;
            for (int j=0;j<count+1;j++) {
                sum=sum+x[j];
            }
            for (int j=0;j<count+1;j++) {
                if (x[j]%3==0) {
                    data[0]=data[0]+x[j];
                }
                else if (x[j]%3==1) {
                    data[1]=data[1]+x[j];
                }
                else {
                    data[2]=data[2]+x[j];
                }
            }
            for (int j=count;j>=0;j--) {
                end=end+x[j];
            }
           
            if (sum%3==0) {
                end=end;
            }
            else if (sum%3==1){
                if (data[1].length()!= 0) {
                  
                    end=end.replaceFirst(data[1].substring(0,1),"");
                }
                else {
                    if (data[2].length()<2) {
                        end="0";
                    }
                    else {
                      
                        end=end.replaceFirst(data[2].substring(0,1),"");
                        end=end.replaceFirst(data[2].substring(1,2),"");
                    }
                }
            }
            else {
                if (data[2].length()!=0) {
                   
                    end=end.replaceFirst(data[2].substring(0,1),"");
                }
                else {
                    if (data[1].length()<2) {
                        end="0";
                    }
                    else {
                        
                        end=end.replaceFirst(data[1].substring(0,1),"");
                        end=end.replaceFirst(data[1].substring(1,2),"");
                    }
                }
            }
            System.out.println(end);
        }
    }
}