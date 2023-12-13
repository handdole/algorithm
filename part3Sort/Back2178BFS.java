import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back2178BFS {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] miro = new int[N+1][M+1];
        boolean[][] miro_visited = new boolean[N+1][M+1];

        for (int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            String [] temp2 =  st.nextToken().split("");
            int [] temp3 = new int[M+1];
            for (int j = 1; j < temp3.length; j++) {
                temp3[j] = Integer.parseInt(temp2[j-1]);
            }

            miro[i] = temp3;

        }

        int start_x = 1;
        int start_y = 1;
        int depth = 1; // depth

        Integer[] start = new Integer[2];
        start[0] = start_x;
        start[1] = start_y;

        Queue<Integer[]> que = new LinkedList<>();

        que.add(start);
        miro_visited[start_x][start_y] = true;

        boolean same = false;

        while (!que.isEmpty()){
            Integer[] remove_XY = que.remove(); // 좌표 remove

            int x = remove_XY[0]; // x
            int y = remove_XY[1]; // y

            //위로 갈 경우
            if ( x > 0 && !miro_visited[x-1][y] && miro[x-1][y] == 1){
                Integer[] temp = new Integer[2];
                temp[0] = x-1;
                temp[1] = y;
                miro[x-1][y] = miro[x][y] + 1;
                que.add(temp);
                miro_visited[x-1][y] = true;
            }
            // 아래로 갈경우
            if ( x < N && !miro_visited[x+1][y] && miro[x+1][y] == 1){
                Integer[] temp = new Integer[2];
                temp[0] = x+1;
                temp[1] = y;
                miro[x+1][y] = miro[x][y] + 1;
                que.add(temp);
                miro_visited[x+1][y] = true;
            }
            // 왼쪽으로 갈 경우
            // 아래로 갈경우
            if ( y > 0 && !miro_visited[x][y-1] && miro[x][y-1] == 1){
                Integer[] temp = new Integer[2];
                temp[0] = x;
                temp[1] = y-1;
                miro[x][y-1] = miro[x][y] + 1;
                que.add(temp);
                miro_visited[x][y-1] = true;
            }
            // 오른쪽으로 갈 경우
            if ( y < M && !miro_visited[x][y+1] && miro[x][y+1] == 1){
                Integer[] temp = new Integer[2];
                temp[0] = x;
                temp[1] = y+1;
                miro[x][y+1] = miro[x][y] + 1;
                que.add(temp);
                miro_visited[x][y+1] = true;
            }

        }
        System.out.printf("" + miro[N][M]);

    }

}
