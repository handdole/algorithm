import java.io.*;
import java.util.StringTokenizer;

public class Back11657 {

    private static class Edge{
        int start;
        int end;
        long weight;


        public Edge(int start, int end, long weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

    }

    private static int MAX = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 도시 개수
        int M = Integer.parseInt(s[1]); // 버스 개수



        // 최소거리 배열 & 엣지 리스트 초기화
        long[] D = new long[N + 1];
        for (int i = 1; i <= N ; i++) {
            D[i] = MAX;
        }

        D[1] = 0; // 시작점 1

        // 에지 배열 초기화
        Edge[] E = new Edge[M];
        // 에지 배열 데이터 삽입
        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]); // 출발지
            int B = Integer.parseInt(s[1]); // 도착지
            int C = Integer.parseInt(s[2]); // 걸리는 시간
            E[i] = new Edge( A , B , C );
        }

        //bellmenFord();
        boolean loopTF = false; // 싸이클 존재 유무

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < M ; j++) {
                Edge now = E[j];

                if (D[now.start]  == MAX ) continue;

                if (D[now.end] > D[now.start] + now.weight ){
                    D[now.end] = D[now.start] + now.weight;
                    if ( i == N ){
                        loopTF = true;
                        break;
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        if (loopTF){
            bw.write(-1+"\n");
        }
        else{
            for (int i = 2; i < D.length; i++) {
                if (D[i] != MAX){
                    bw.write(D[i] + "\n");
                }
                else{
                    bw.write(-1 + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }




}


