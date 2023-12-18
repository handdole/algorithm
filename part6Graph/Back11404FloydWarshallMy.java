import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back11404FloydWarshallMy {

    private static int n;
    private static int m;

    private static long[][] A;
    private static BufferedReader br ;
    private static BufferedWriter bw ;
    private static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        A = new long[n+1][n+1]; // 그래프

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                A[i][j] = MAX;
            }
        }

        for (int i = 1; i <= n; i++) {
            A[i][i] = 0; // 같은 노드는 0으로 처리
        }

        String [] temp;

        for (int i = 0; i < m; i++) {
            temp= br.readLine().split(" ");
            int a = Integer.parseInt(temp[0]); // 출발 노드
            int b = Integer.parseInt(temp[1]); // 도착 노드
            int c = Integer.parseInt(temp[2]); // 비용

            // 시작 도시와 도착 도시를 연결하는 노선이 두 개 이상일 경우 작은 값으로 대체
            if (A[a][b] > c) A[a][b] = c;
        }


        // Floyd Warshall

        for (int k = 1; k <= n ; k++) { // 중간 거치는 노드
            for (int s = 1; s <= n ; s++) { // 시작 노드
                for (int e = 1; e <= n ; e++) { // 끝 노드
                    A[s][e] = Math.min(A[s][e] , A[s][k] + A[k][e]);
                }
            }
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n ; j++) {
                if ( A[i][j] == MAX ) bw.write(0 + " ");
                else{
                    bw.write(A[i][j] + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();
    }



}
