import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSImpl {

    public static void main(String[] args) {
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

        int start = 1;

        boolean[] visited = new boolean[V+1];
        Queue<Integer> que = new LinkedList<>();

        // start 값 세팅
        que.add(start);
        visited[start] = true;


        while (!que.isEmpty()){ // queue 안에 값 없을때 까지 진행
            int remove_node = que.remove(); // 세팅 값부터 시작
            System.out.printf(remove_node + " ");

            for (int i = 1; i < graph.length; i++) { // 1부터 끝까지
                if (!visited[i] && graph[remove_node][i] == 1){ // i 노드에 방문 하지 않았고 remove_node 와 연결되어 있으면
                    que.add(i); // 큐에 넣고
                    visited[i] = true; // visit 처리
                }
            }

        }

    }


}
