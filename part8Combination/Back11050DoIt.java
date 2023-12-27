import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back11050DoIt {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int [][] DP = new int[N+1][N+1];

        for (int i = 0; i <= N; i++) {
            DP[i][1] = i;
            DP[i][0] = 1;
            DP[i][i] = 1;
        }

        // 점화식으로 배열 완성
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j < i; j++) { // 고르는 수의 개수가 전체 개수를 넘을 수 없음
                DP[i][j] = DP[i-1][j] + DP[i-1][j-1]; // 점화식
            }
        }

        System.out.printf("" + DP[N][K]);

    }



}
