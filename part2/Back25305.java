import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back25305 {

    /*


    int N
    int k
    int[] scores
    for ( i = scores.len / 2 ; i < scores.len , i++ )
        int target = a[i]
        int j = i - 1
        while ( j ≥ 0 && target > a[j] )
            a[j+1] = a[j]
            j—
        a[j+1] = target

    souf ( scoures[k-1] )

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] scores = new int[N];

        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }

        br.close();

        // 이렇게 쓸려면 scores.length / 2 이전의 값들이 기준에 맞는 정렬 되어있다는 가정이 있어야힘.
        for (int i = 1 ; i < scores.length ; i++) {
            int target = scores[i];
            int j = i - 1;
            while ( j >= 0 && target > scores[j]){
                scores[j+1] = scores[j];
                j -- ;
            }
            scores[j+1] = target;
        }

        System.out.println(scores[k-1] + "");


    }


}
