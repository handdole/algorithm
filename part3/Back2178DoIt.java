import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2178DoIt {

    static int[] dx = {0 , 1 , 0 , -1};
    static int[] dy = {1 , 0 , -1 , 0};
    static boolean[][] visited;
    static int [][] A;
    static int N , M ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String line = st.nextToken();

            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        BFS(0,0);

        System.out.printf(A[N-1][M-1] + "");

    }

    static void BFS(int x , int y){
        Queue<int[]>queue = new LinkedList<>();
        queue.offer(new int[]{ x , y});

        while (!queue.isEmpty()){
            int now[] = queue.poll();
            visited[x][y] = true;

            for (int i = 0; i <4 ; i++) { // 상하 좌우 탐색
                int temp1 = now[0] + dx[i];
                int temp2 = now[1] + dy[i];

                if (temp1 >= 0 && temp2 >= 0 && temp1 < N && temp2 < M) {
                    if (A[temp1][temp2]!= 0 && !visited[temp1][temp2]){
                        visited[temp1][temp2] = true;
                        A[temp1][temp2] = A[now[0]][now[1]] + 1 ;
                        queue.add(new int[] {temp1 , temp2});
                    }
                }

            }

        }

    }

}
