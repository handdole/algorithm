import java.util.Scanner;

public class Back1929DoitSieveOfEratosthenes {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();

        int []A = new int[N+1];

        for (int i = 1; i <= N; i++) {
            A[i] = i;
        }

        // A[1] 은 소수가 아니다 .
        A[1] = 0;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0)continue;
            for (int j = i+i; j <= N; j=j+i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N ; i++) {
            if (A[i] != 0 ){
                System.out.println(A[i] + "");
            }
        }

    }

}
