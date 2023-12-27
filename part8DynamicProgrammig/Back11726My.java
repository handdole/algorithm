import java.util.Scanner;

public class Back11726My {

    private static long[] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        D = new long[n+1]; // F(n) 값 저장할 배열 선언

        for (int i = 0; i <= n; i++) {
            D[i] = -1;
        }

        // init 데이터 삽입
        D[1] = 1;
        D[2] = 2;

        N2(n);

        // 100007 나눈 정답 출력
        System.out.println(D[n]);

    }

    static long N2( int n ){
        if (D[n] != -1 ){
            return D[n];
        }
        // 점화식으로 배열 채우기
        // F(n) = F(n-1) + F(n-2)
        return D[n] = ( N2(n-1 ) + N2( n - 2 ) ) % 10007;
    }


}
