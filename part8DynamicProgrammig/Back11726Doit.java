import java.util.Scanner;

public class Back11726Doit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] D = new long[1001]; // F(n) 값 저장할 배열 선언

        // init 데이터 삽입
        D[1] = 1;
        D[2] = 2;

        for (int i = 3; i <= n; i++) {
            D[i] = ( D[i-1] + D[i-2] ) % 10007;
        }

        // 100007 나눈 정답 출력
        System.out.println(D[n]);

    }



}
