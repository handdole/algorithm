import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back2178DFS {

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


        int[] start = new int[2];
        start[0] = start_x;
        start[1] = start_y;

        int cnt = 0; // 이동한 횟수

        dfs(miro , miro_visited , start  , cnt );



    }

    // 아 이거 너무 깊어서 메모리 full 날 듯
    static void dfs( int[][]miro , boolean[][] miro_visited , int[] node , int cnt ){
        int x = node[0];
        int y = node[1];
        miro_visited[x][y] = true;
        cnt++;

        //위로 갈 경우
        if ( x > 0 && !miro_visited[x-1][y] && miro[x-1][y] == 1){
            int[] temp = new int[2];
            temp[0] = x-1;
            temp[1] = y;
            miro_visited[x-1][y] = true;
            dfs(miro , miro_visited , temp  , cnt );
        }
        // 아래로 갈경우
        if ( x < miro.length - 1 && !miro_visited[x+1][y] && miro[x+1][y] == 1){
            int[] temp = new int[2];
            temp[0] = x+1;
            temp[1] = y;
            miro_visited[x+1][y] = true;
            dfs(miro , miro_visited , temp , cnt );
        }
        // 왼쪽으로 갈 경우
        if ( y > 0 && !miro_visited[x][y-1] && miro[x][y-1] == 1){
            int[] temp = new int[2];
            temp[0] = x;
            temp[1] = y-1;
            miro_visited[x][y-1] = true;
            dfs(miro , miro_visited , temp  , cnt );
        }
        // 오른쪽으로 갈 경우
        if ( y < miro[x].length - 1 && !miro_visited[x][y+1] && miro[x][y+1] == 1){
            int[] temp = new int[2];
            temp[0] = x;
            temp[1] = y+1;
            miro_visited[x][y+1] = true;
            dfs(miro , miro_visited , temp , cnt );
        }

        if (x == miro.length - 1 && y == miro[x].length -1 ) System.out.printf(cnt+"");
    }


}
