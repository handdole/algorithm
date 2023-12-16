import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Back2252TopologicalSorting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]); // 학생 수
        int M = Integer.parseInt(s[1]); // 비교한 케이스 개수

        //진입 차수 배열
        int[] jc = new int[N+1];
        // 인접 리스트
        ArrayList<Integer>[] arr = new ArrayList[N+1];
        // list init
        for (int i = 1; i < arr.length; i++) {
            arr[i] = new ArrayList<>();
        }

        // 위상 정렬 배열
        int[] top_arr = new int[N];

        for (int i = 0; i < M; i++) {
            s = br.readLine().split(" ");
            int A = Integer.parseInt(s[0]);
            int B = Integer.parseInt(s[1]);

            arr[A].add(B); // 방향이 있으니까 하나만 해도됨 + 키 작은 사람이 앞 키큰 사람이 뒤
            jc[B]++; // 진입 차수 +1 하기

        }

        int idx = 0;
        int time = 0;

        for (int i = 1; i < jc.length; i++) {
            if (time == N) break;
            if (jc[i] == 0){
                top_arr[idx++] = i;
                time++;
                for ( int temp : arr[i]
                     ) {
                    jc[temp]--;
                    if (jc[temp] == 0){
                        top_arr[idx++] = temp;
                        time++;
                    }
                }

            }
        }

        for (int a: top_arr
             ) {
            System.out.printf(a + " ");
        }

    }


    static void topSort( ArrayList<Integer>[] arr , int[] jc , int[] top_arr ) {


    }

}
