import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1940 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int [] sources = new int[N];
        for (int i = 0; i < N; i++) {
            sources[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        System.out.println(solution(N , M , sources));

    }

    /*
    *  N개의 재료로
    *  M 번호의 고유 번호를 두 재료가 합쳐져서 만들어짐
    *
    *  10
    *  23
    *  3  14  7  9  20  11  12  1  15  4
    *
    *  nums[front_idx] , nums[back_idx] -> sum < M ?
    *  nums[front_idx] , nums[back_idx] -> sum = M ?
    *  nums[front_idx] , nums[back_idx] -> sum > M ?
    *
    * 1 , 20 -> 21 < M => front_idx++
    * 3 , 20 -> 23 = M => front_idx++ , back_idx-- , cnt++
    * 4 , 15 -> 19 < M => front_idx++
    * 7 , 15 -> 22 < M => front_idx++
    * 9 , 15 -> 24 > M => back_idx--
    * 9 , 14 -> 23 = M => front_idx++ , back_idx-- , cnt++
    * 11 , 12 -> 23 = M => front_idx++ , back_idx-- , cnt++
    *
    * */

    public static long solution( int N , int M , int[]sources ) {
        int count = 0;

        int front_idx = 0;
        int end_idx = N-1;

        // 정렬
        Arrays.sort(sources);

        while(end_idx > front_idx){
            if (sources[front_idx] + sources[end_idx] == M){
                front_idx++; end_idx--; count++; continue;
            }
            if (sources[front_idx] + sources[end_idx] > M){
                end_idx--; continue;
            }
            if (sources[front_idx] + sources[end_idx] < M){
                front_idx++; continue;
            }
        }





        return count;
    }


}
