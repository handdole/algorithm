import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Back11724 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//
//        visited = new boolean[n+1];
//        A = new ArrayList[n+1];
//
//        for (int i = 1; i < n+1; i++) {
//            A[i] = new ArrayList<Integer>();
//        }
//
//        for (int i = 0; i < m; i++) {
//            st = new StringTokenizer(br.readLine());
//            int v1 = Integer.parseInt(st.nextToken());
//            int v2 = Integer.parseInt(st.nextToken());
//
//            A[v1].add(v2);
//            A[v2].add(v1);
//        }
//        int count = 0;
//
//        for (int i = 1; i < n+1; i++) {
//            if (!visited[i]){
//                count++;
//                ArrDFS(i);
//            }
//
//        }
//
//        System.out.printf(""+count);


        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[][] graph = new int[V+1][V+1];

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        boolean[] visited = new boolean[V+1];

        int count = 0;

        for (int i = 1; i < V+1; i++) {
            if (!visited[i]){ // 방문 안한 곳 부터 다시 돌리기
                DFS(graph , visited , i);
                count++;
            }
        }

        System.out.printf(count+"");




    }

    // 인접 리스트 적용한 DFS
    static void ArrDFS(int v) {
        if (visited[v]){
            return;
        }
        else{
            visited[v] = true;
            for (int i : A[v]) {
                if (!visited[i]){
                    ArrDFS(i);
                }
            }
        }
    }

    static void DFS(   int[][] graph  , boolean [] visited , int v  ){
        int n = graph.length;
        visited[v] = true;

        for (int i = 1; i < n ; i++) { // 배열 개수 만큼 돌려야함.
            if (graph[v][i] == 1 && !visited[i] ) DFS(graph , visited , i);
        }
    }

}
