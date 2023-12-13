import java.util.Scanner;

public class Back1541DoIt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // answer ( 정답 변수 선언 )
        int answer = 0;

        // 들어온 데이터를 - 기호를 기준으로 split() 수행
        String[] str = sc.next().split("-");

        // 나눠진 데이터 개수만큼 반복
        for (int i = 0 ; i < str.length; i++
             ) {
            // 결과 값 함수 수행
            int int_temp = mySum(str[i]);
            // 가장 앞 데이터 일 때 answer 에 결과 값 더하기
            if (i==0) {
                answer = answer + int_temp;
            }
            // answer 에 결과 값 빼기
            else{
                answer = answer - int_temp;
            }
        }
        // answer 출력

        System.out.printf(answer + "");
    }

    static int mySum( String str ){
        // mySum 함수 구현
        int sum = 0;

        // 현재 들어온 String 값을 "+" 기호 기준으로 split 수행
        String[] str_arr = str.split("\\+");
        //나눠진 데이터 개수만큼 반복
        for (int i = 0; i < str_arr.length; i++) {
            // String 값을 Integer 형으로 변환하여 리턴값에 더하기
            sum = sum + Integer.parseInt(str_arr[i]);
        }
        // 전체 합 리턴하기
        return sum;
    }

}
