import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Back1753Dijkstra {

    private static int MAX = Integer.MAX_VALUE;
    private static int[] D ;
    private static ArrayList<Node>[] A;
    private static boolean[] visited ;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int V = Integer.parseInt(s[0]);
        int E = Integer.parseInt(s[1]);

        // 방문 배열 init
        visited = new boolean[V+1];

        // 시작 노드 최단거리 처리
        int K = Integer.parseInt(br.readLine());

        // 연결 리스트 init
        A = new ArrayList[V+1];
        for (int i = 1; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }

        // 연결 리스트 데이터 삽입
        for (int i = 0; i < E; i++) {
            s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);
            int w = Integer.parseInt(s[2]);

            A[u].add(new Node( v , w ));
        }

        // 최단 거리 배열 init
        D = new int[V+1];
        for (int i = 1; i < D.length ; i++) {
            D[i] = MAX;
        }

        // 다익스트라 알고리즘 사용
        dijkstra( K );

        StringBuffer sb = new StringBuffer();


        for (int i = 1; i < D.length; i++) {
            if (D[i] == MAX ){
                sb.append("INF\n");
            }
            else{
                sb.append(D[i] + "\n");
            }
        }

        System.out.printf(sb.toString());

    }

    static void dijkstra( int start ){
        PriorityQueue<Node> que = new PriorityQueue<>( ( (o1, o2) -> o1.getWeight() - o2.getWeight()));
        // 시작 노드 set
        D[start] = 0;
        que.add(new Node( start , 0));


        while (!que.isEmpty()){
            Node now = que.poll();
            if (!visited[now.getNum()]){
                visited[now.getNum()] = true; // 방문 처리
                for (Node next : A[now.getNum()]
                     ) {
                    // 연결 되어 있는 노드의 최단 거리 업데이트
                    // 다음에 있는 노드까지의 최단 거리가 현재 노드까지의 최단거리 + 다음 노드에 대한 가중치보다 크면
                    if (D[next.getNum()] > D[now.getNum()] + next.getWeight()){
                        // 다음 노드까지의 최단 거리는 현재 노드까지의 최단거리 + 다음 노드에 대한 가중치
                        D[next.getNum()] = D[now.getNum()] + next.getWeight();
                        que.add(next);
                    }
                }
            }
        }
    }


    private static class Node{
        int num;
        int weight;

        public Node(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

    }


}
