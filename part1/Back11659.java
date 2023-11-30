import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back11659 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 배열의 개수
        int N = Integer.parseInt(stringTokenizer.nextToken());
        // 질의 개수
        int M = Integer.parseInt(stringTokenizer.nextToken());

        long[] S = new long[N+1]; // index 가 0번째는 0으로 가정
        long sum = 0L;

        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= N; i++) {
            sum += Integer.parseInt(stringTokenizer.nextToken());
            S[i] = sum;
        }

        long[] answer = new long[M];

        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int I = Integer.parseInt(stringTokenizer.nextToken());
            int J = Integer.parseInt(stringTokenizer.nextToken());

            /*
             *  0 5 4  3  2  1
             *  0 5 9 12 14 15
             *   1번째부터 3번째 수까지 합  -> ( 1 , 3 ) -> S[3] - S[0] = 12 - 0 = 12
             *   2번째부터 4번째 수까지 합  -> ( 2 , 4 ) -> S[4] - S[1] = 14 - 5 = 9
             *   5번째부터 5번째 수까지 합  -> ( 5 , 5 ) -> S[5] - S[4] = 15 - 14 = 1
             *   I번째부터 J번째 수까지 합  -> ( I , J ) -> S[J] - S[I-1]
             * */

            answer[i] = S[J] - S[I-1];


        }

        for (long ans : answer
             ) {
            System.out.println(ans);
        }

    }
}
