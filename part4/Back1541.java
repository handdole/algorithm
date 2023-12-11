import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.Scanner;

public class Back1541 {

    public static void main(String[] args) {
        // 마이너스가 나오면 괄호를 열고
        // 그 뒤에 또 다른 마이너스가 나오기 전에 괄호를 닫아야함.
        /*
        * String 식 받기
        *  + , - <= ' ' 으로 변환
        *  temp String [] / ' ' 으로 배열 생성
        * 숫자 넣는 int list
        * + , - 넣는 String list
        *
        * flag 괄호 안이냐 밖이냐 따지는 list
        *
        * flag
        * for String 배열
        *   if ( - 이면 괄호 flag
        *
        * for 숫자 넣는 배열
        *
        *
        *
        * */

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engin = manager.getEngineByName("script");

        Scanner sc = new Scanner(System.in);
        String sik = sc.next();
        String[] gihos = sik.replaceAll("[0-9]"," ").replaceAll(" " , "").split(""); // 기호글만 이루어진 배열
        String[] numbers = sik.replaceAll("[.+.-]"," ").split(" "); // 숫자들만 이루어진 배열
        int g_idx = 0;
        // 연산식 만들기
        StringBuffer sb = new StringBuffer();
        for (String temp : gihos) System.out.printf(temp + " ");
        System.out.println("");
        for (String temp : numbers) System.out.printf(temp + " ");
        System.out.println("");

        boolean flag = false; // 괄호 열렸으면 true 닫혔으면 false


        // 숫자들이 무조건 1개 더 많음으로 numbers 로 식 만들기
        // 여는 괄호는 숫자 다음 연산 사이에 들어감.
        // 닫히는 괄호는 연산 다음 숫자 사이에 들어감.
        for (int i = 0; i < numbers.length; i++) {
            // 숫자 넣기
            sb.append(numbers[i]);
            // 마이너스 연산 기준으로 진행
            if (gihos[g_idx].equals("-")){
                if (flag){
                    sb.append(")-");
                }
                else{

                }
            }
            else{
                sb.append("+");
            }
            //마지막 연산자 인지 체크
            if (g_idx == gihos.length){
                // 마지막에 기호 닫아야 하면 기호 추가
                if (flag){
                    sb.append(numbers[i] + ")");
                    break;
                }
                else{
                    sb.append(numbers[i]);
                    break;
                }
            }

        }

        System.out.printf(sb.toString());



    }

}
