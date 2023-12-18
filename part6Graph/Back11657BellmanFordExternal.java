import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back11657BellmanFordExternal {

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
    private static int N;
    private static int M;
    private static BufferedReader br;
    private static StringTokenizer st;

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader( System.in));
        BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ));

        st = new StringTokenizer(br.readLine() , " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long[] D = new long[N+1];
        Arrays.fill(D , MAX);
        D[1] = 0;

        boolean loopTF = bellmanFord( D );

        if (loopTF){
            bw.write(-1+"\n");
        }
        else{
            for (int i = 2; i < D.length ; i++) {
                if (D[i] == MAX ){
                    bw.write(-1+"\n");
                }
                else{
                    bw.write(D[i]+"\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();

    }


    public static boolean bellmanFord( long[] D ) throws Exception {
        boolean loop = false;

        Edge[] E = new Edge[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine() , " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            E[i] = new Edge( start , end , w );
        }

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M; j++) {
                Edge now = E[j];

                if (D[now.start] == MAX ){
                    continue;
                }

                if (D[now.end] > D[now.start] + now.weight){
                    D[now.end] = D[now.start] + now.weight;

                    if (i == N) {
                        loop = true;
                        break;
                    }
                }
            }
        }

        return loop;
    }


}