import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Back1707BipariteGraph {
    public static void main(String[] args) throws IOException {

        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int K = Integer.parseInt(st.nextToken()); // 테스트 케이스 받기

        // 테스트 케이스 별로 판단
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 노드의 개수
            int E = Integer.parseInt(st.nextToken()); // 간선의 개수
            ArrayList<Integer>[] arr = new ArrayList[V+1]; // 노드 개수 만큼 arraylist로 배열 생성
            for (int j = 0; j < arr.length; j++) {
                arr[j] = new ArrayList<Integer>();
            }
            // u 노드에서 v 노드가 연결되어 있는 것 표시
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                // 노드와 노드 이어지는 표시
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                arr[u].add(v); // 양방향 연결 체크
                arr[v].add(u); // 양방향 연결 체크
            }

            boolean[] visited = new boolean[V+1];
            String[] node_color = new String[V+1];
            visited[1] = true;
            node_color[1] = "r"; // depth 가 0 이라고 가정하고 depth 가 2로 나누었을 때 0 이면 r 아니면 b
            // 비연결 그래프 일 경우 방문 안 한 곳 부터 다시 탐색
            for (int j = 0; j < visited.length; j++) {
                if (!visited[j]){
                    BFS(arr , visited , node_color);
                }
            }

            String YorN = "YES"; // YES or NO 출력 값
            // 모든 node 탐색
            for (int j = 1; j < arr.length ; j++) {
                // j 노드에서 temp 노드로 연결되어 있는 애들 중
                for (int temp : arr[j]
                     ) {
                    // 색깔이 같으면 NO
                    if (node_color[j].equals(node_color[temp])){
                        YorN ="NO";
                    }
                }
            }

            sb.append(YorN+"\n");

        }
        System.out.println(sb.toString());


    }

    static void BFS( ArrayList<Integer>[] arr , boolean[] visited , String[] node_color  ){
        // 뎁스
        int depth = 1;
        Queue<Integer> que = new LinkedList<>(); // BFS 전 세팅 , 큐 생성
        que.add(1); // BFS 전 세팅 , 큐에 데이터 넣기

        while (!que.isEmpty()){
            int len = que.size(); // depth 판단을 위해 que size 측정

            // 큐에서 나온 Node가 갖은 arraylist의 사이즈 만큼
            for (int i = 0; i < len; i++) {
                int select_node = que.remove(); // que 에서 노드 빼기
                ArrayList<Integer> list = arr[select_node]; // 선택된 노드가 이어져 있는 노드 값 가져오기
                // 해당 노드들 가져와서 red , blue 처리 및 큐에 넣기
                for (int temp : list
                     ) {
                    if (!visited[temp]){
                        que.add(temp); // 큐에 넣기
                        visited[temp] = true; // 방문 처리
                        node_color[temp] = depth % 2 == 0 ? "r" : "b" ; // 색깔 처리
                    }
                }
            }
            depth++;
        }
    }






}
