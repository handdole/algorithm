import java.util.Scanner;

public class DFSimpl {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = 8; // 정점
        int E = 9; // 간선

        int[][] a = new int[V+1][E+1];
        boolean[] visited = new boolean[V+1];

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            a[v1][v2] = 1; // v1 과 v2 는 연결되어 있다 , v1 점과 v2 점은 연결되어 있다.
            a[v2][v1] = 1; //  연결되어 있다는건 v2 과 v1 는 연결되어 있다도 맞는말

        }   // V 개의 정점이 있고 E 개의 간선이 있을 때 V * V 평면에 서로 연결된 관계를 나타낸 평면

        dfs(a , visited , 1);

    }


    static void dfs( int[][] a , boolean[] visited , int v){
        int n = a.length ;

        visited[v] = true; // v 노드 방문 처리

        System.out.print( v + " ");

        for( int i = 1; i <= n; i++){
            if (a[v][i] == 1 && !visited[i]) dfs(a , visited , i);
        }

    }


}
