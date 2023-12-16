import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Dijkstra {
    /*
    *
    * 첫째줄 노드 V 간선 개수 E 주어짐
    * 둘째줄 부터 V1 V2 가중치 주어짐
    * 마지막줄에 S , E 주어짐 최단 거리 구하시오
    *
    *
    * */
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);

        ArrayList<Node>[] arr = new ArrayList[V+1]; // 인접 리스트 배열

        // 인접 리스트 init
        for (int i = 1; i <= V; i++) {
            arr[i] = new ArrayList<>();
        }
        boolean[] visited = new boolean[V+1];
        int[] short_dis = new int[V+1]; // 최단 거리 배열

        //최단 거리 배열 init
        for (int i = 1; i < short_dis.length; i++) {
            short_dis[i] = (int) Math.pow(2 , 31);
        }

        // 인접 리스트에 데이터 넣기
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int V1 = Integer.parseInt(s[0]);
            int V2 = Integer.parseInt(s[1]);
            int W = Integer.parseInt(s[2]);

            arr[V1].add(new Node(V2,W));
        }

        s = br.readLine().split(" ");
        int start = Integer.parseInt(s[0]); // 시작 점
        int end = Integer.parseInt(s[1]); // 도착 점

        Queue<Node>que = new LinkedList<>(); // 큐 생성

        short_dis[start] = 0; // 시작점 선정
        visited[start] = true;

        for (Node next : arr[start]
             ) {
            // 시작점 에서 이어져 있는 노드 que에 넣기
            que.add(next);
            // 최단거리 배열에 최단거리 넣기
            if (short_dis[next.getNode()] > short_dis[start] + next.getWeight() ){
                short_dis[next.getNode()] = short_dis[start] + next.getWeight();
            }
        }

        // que가 모두 빌때까지
        while (!que.isEmpty()){
            Node now = que.poll(); // 현재 노드 값 poll
            int now_node = now.getNode();
            if (!visited[now_node]){ // 방문하지 않았다면
                for (Node next : arr[now_node] // 현재 노드와 연결되어 있는 노드 for문
                     ) {
                    que.add(next); // 큐에 넣고
                    int next_node = next.getNode();
                    int next_w = next.getWeight();
                    // 최단거리 배열에 최단거리 넣기
                    if (short_dis[next_node] > short_dis[now_node] + next_w ){
                        short_dis[next_node] = short_dis[now_node] + next_w;
                    }
                }
            }
            visited[now_node] = true; // 방문 처리 이게 포인트인가..
        }

        for (int a: short_dis
             ) {
            System.out.printf(" " + a);
        }
        System.out.println("\n");
        System.out.printf("" + short_dis[end]);


    }

    private static class Node{
        private int node;
        private int weight;

        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        public int getNode() {
            return node;
        }

        public void setNode(int node) {
            this.node = node;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }


}
