import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Back1920DoIt {


    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc. nextInt();
        int [] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);

        int M = sc.nextInt();
        int[] B = new int[M];

        for (int i = 0; i < M; i++) {
            boolean flag = false;
            int target = sc.nextInt();

            int start = 0;
            int end = A.length - 1;

            while ( start <= end ){
                int mid_idx = ( start + end ) / 2;
                int mid_value = A[mid_idx];
                if ( mid_value > target ){
                    end = mid_idx - 1;
                }
                else if ( mid_value < target ) {
                    start = mid_idx + 1 ;
                }
                else{
                    flag = true;
                    break;
                }
            }
            if (flag){
                System.out.printf("1 ");
            }
            else{
                System.out.printf("0 ");
            }
        }
    }


}
