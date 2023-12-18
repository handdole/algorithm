import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Back1197MSTMy {

    private static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        public Edge ( int start , int end , int weight){
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo( Edge edge ){
            if (edge.weight < weight) return 1;
            else if (edge.weight > weight) return -1;
            return 0;
        }

    }

    private static int[] parent; // 대표 노드 배열

    private static Edge[] E;
    private static int V;
    private static int L;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] s = br.readLine().split(" ");
        V = Integer.parseInt(s[0]);
        L = Integer.parseInt(s[1]);

        // 엣지 리스트 초기화
        E = new Edge[L];
        for (int i = 0; i < L; i++) {
            s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);
            int C = Integer.parseInt(s[2]);
            E[i] = new Edge( A , B , C );
        }

        // 대표 노드 배열 초기화
        parent = new int[V+1];

        for (int i = 1; i <= V; i++) {
            parent[i] = i ;
        }

        // 엣지 리스트 가중치 오름차순 정렬
        Arrays.sort(E);

        int low_cost = 0;

        // MST 알고리즘
        for (int i = 0; i < E.length; i++) {
            Edge now = E[i];
            if (!checkSame(find(now.start) , find(now.end))){ // 대표 노드가 서로 다를 경우
                // 두 노드 연결 처리
                union(now.start , now.end);
                // 연결한 노드에 대한 가중치 합산
                low_cost += now.weight;
            }
        }

        System.out.println(low_cost);

    }

    // union 연산
    private static void union( int a, int b ){
        a = find( a );
        b = find ( b );
        if ( a != b ) parent[b] = a; // 두개 연결
    }

    // find 연산
    private static int find( int a ){
        if ( a == parent[a]) return a; // 대표 노드와 index 값이 같다면
            // 다르면
        else{
            return parent[a] = find(parent[a]); // 재귀함수 빠져 나가면서 update 쳐주는 방식
        }
    }

    // checkSame 두 원소 가 같은 집합 인지 확인
    private static boolean checkSame( int a , int b ){
        a = find(a);
        b = find(b);
        return a == b ? true : false;
    }

}
