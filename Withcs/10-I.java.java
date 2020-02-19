/*DESCRIPTION
String 클래스에 포함된 split 메소드는 구분자로 구분된 문자열의 배열을 리턴하는 함수다. 기본적으로 구분자는 리턴된 배열에 포함되어 있지만 여러분은 구분자도 리턴 배열에 포함하고자 한다. 다음과 같이 정의된 새로운 split 메소드를 만들자. (리턴은 배열로 하지 않고 ,로 구분된 문자열로 한다)

public static String split(String s, String regex)

예를 들어, split("ab#12#453", "#")의 실행 결과는 ab,#,12,#,453 이고, split("a?b?gf#e", "[?#]")의 실행 결과는 a,?,b,?,gf,#,e 이다. 

The split method in the String class returns an array of strings consisting of the substrings split by the delimiters. However, the delimiters are not returned. Implement the following new method that returns an array of strings consisting of the substrings split by the matching delimiters, including the matching delimiters.

public static String split(String s, String regex)

For example, split("ab#12#453", "#") returns ab,#,12,#,453 as aString, and split("a?b?gf#e", "[?#]") returns a,?,b,?,gf,#,e as a String.

INPUT
* Line 1 : 테스트케이스 T (1~1,000)

* Line 2 ~ T+1 : 문자열 구분자

 - 문자열과 구분자는 공백을 포함하지 않으며, 길이가 1000을 넘지 않는다.

 

구분자의 형식은 아래의 링크를 참조하자.

 https://ko.wikipedia.org/wiki/%EC%A0%95%EA%B7%9C_%ED%91%9C%ED%98%84%EC%8B%9D

OUTPUT
* Line 1 ~ T : 각 테스트 케이스마다 ,로 구분된 문자열 출력

 

SAMPLE CODE
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            String str = sc.next();
            String delimiter = sc.next();

            String tokens = split(str, delimiter);
            System.out.println(tokens);
        }
    }

    YOUR_CODE

}
SAMPLE INPUT
5
aabbcc bb
aabbcc aa
aabbcc cc
112233 \d
112233 \d{2}
SAMPLE OUTPUT
aa,bb,cc
,aa,bbcc
aabb,cc,
,1,,1,,2,,2,,3,,3,
,11,,22,,33,
SOURCE
JAVA2015 PE10.25  */

public static String split(String string, String R) {
        Pattern p = Pattern.compile(R);
        Matcher m = p.matcher(string);
        String copy = string;
        Matcher T= p.matcher(copy);
        String result = "";
        int num = 0;
        while (T.find()) {
        num++;
        }
        String[] save = new String[2 * num + 1];
        for (int jj = 0; jj < 2 * num + 1; jj++) {
        save[jj] = "";
        }
        if (num == 0) {
        result = string;
        } else {
        int[] ind = new int[num * 2];
        int i = 0;
        while (m.find()) {
        
        ind[i] = m.start();
        ind[i + 1] = m.end();
        i =i+ 2;
        }
        i = 0;
        
        save[0] =save[0]+string.substring(0, ind[0]);
        save[0] =save[0]+",";
        
        save[2 * num] = string.substring(ind[num * 2 - 1]);
        if (ind[num * 2 - 1] == string.length() + 1) {
        save[2 * num] =save[2 * num]+ ",";
        }
        result =result+ save[0];
        for (i = 1; i < num * 2; i++) {
        save[i] = string.substring(ind[i - 1], ind[i]) + ",";
        result =result+save[i];
        }
        result =result+save[num * 2];
        }
       
        return result;

        }
