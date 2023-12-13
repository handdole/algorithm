import java.util.Scanner;

class Back11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(solution( sc.nextInt() , sc.nextLong() ));
    }

    public static long solution( int first , long second ) {
        long answer = 0;

        long namaji = 0;

        // 두 번째 수 각 자리수 별로 변환
        // 10진수로 10씩 나누어서 앞자리수 가져오기

        // 10의 0 승부터 first 제곱승까지 나눠서 나머지 구분
        for (int i = 0; i < first ; i++) {
            namaji += (long) (second % 10);

            second = (long) (second / 10);

        }

        answer = namaji;


        return answer;
    }




}