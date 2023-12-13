import java.util.Scanner;

public class Back9359Coprime {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt(); // 테스트 케이스 받기

        StringBuffer sb = new StringBuffer();

        for (int i = 1; i <= T; i++) { // 테스트 케이스 만큼 포문 돌리기
            long A = scanner.nextLong(); // A 받기
            long B = scanner.nextLong(); // B 받기
            long N = scanner.nextLong(); // N 받기

            // coprime ( A , B , N  ) 함수 실행
            long count = coprime( A , B , N );

            // 출력양식에 맞게 append

            sb.append("Case #" + i + ": " + count + "\n");

        }

        System.out.printf(sb.toString());

    }

    // 10의 7승 
    
    static long coprime( long A , long B , long N ) {
        long count = 0;

        for (long i = A; i <= B ; i++) {  // A이상 부터 B이하 까지 서로소 체크
            if ( i % N != 0 ){  // N으로 나눠서 한번이라도 나눠진다면 서로소가 아님.
                count++;
            }
        }

        return count ;
    }

}
