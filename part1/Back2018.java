import java.util.Scanner;

public class Back2018 {

    public static void main(String[] args)  {
        // -> 받는 데이터가 적기 때문에 스캐너 사용
        //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));

    }


    /*
    *
    * 자연수  N
    * 몇 개의 연속된 자연수의 합으로 나타낼 수 있음.
    *
    *
    *  0  1  2  3   4  5   6   7   8   9   10   11   12   13   14   15
    *  0  1  3  6  10 15  21  28   36 45   55   66   78   91   105  120
    *
    *  ( I , J ) -> S[I] - S[J]
    *
    *  ( 1 , 0 ) -> 1 - 0 = 1  < N  ( N 이 같거나 크면 I + 1 )
    *  ( 2 , 0 ) -> 3 - 0 = 3  < N
    *  ( 3 , 0 ) -> 6 - 0 = 6  < N
    *  ( 4 , 0 ) -> 10 - 0 = 10 < N
    *  ( 5 , 0 ) -> 15 - 0 = 15 = N  ( N 이 같거나 크면 I + 1 )
    *  ( 6 , 0 ) -> 21 - 0 = 21 > N  ( N 이 작으면 J+1 )
    *  ( 6 , 1 ) -> 21 - 1 = 20 > N
    *  ( 6 , 2 ) -> 21 - 3 = 18 > N
    *  ( 6 , 3 ) -> 21 - 6 = 15 = N
    *  ( 6 , 4 ) -> 21 - 10 = 11 < N
    *  ( 7 , 4 ) -> 28 - 10 = 18 > N
    *  ( 7 , 5 ) -> 28 - 15 = 13 < N
    *  ( 8 , 5 ) -> 36 - 15 = 21 > N
    *  ( 8 , 6 ) -> 36 - 21 = 15 = N
    *  ( 9 , 6 ) -> 45 - 21 = 24 > N
    *  ( 9 , 7 ) -> 45 - 28 = 17 > N
    *  ( 9,  8 ) -> 45 - 36 = 9 < N
    *
    *  ... ( 중략 )
    *
    *
    * */
// ------------ 내가 접근을 한번 더 꼼 그냥 바로 간단하게 sum , start_idx , end_idx 해서 진행해야하는데.. 메모리 제한이 32 MB 임
//    public static int solution(int N){
//        int answer = 0;
//        int I = 0 , J = 0 ; // 투 포인터 정의
//
//        long sum = 0L; // 합 구할 변수 선언
//        long [] sum_arr = new long[N+1]; // 합배열 선언
//
//        for (int i = 1; i <= N ; i++) {
//            sum += i;
//            sum_arr[i] = sum;
//        }
//
//        while( I <= N ){ // I 가 N 보다 커지면? 크거나 같으면 I 가 플러스니까
//
//
//            if (sum_arr[I] - sum_arr[J] == N){ answer++; I++; continue; } // continue 이거 붙혀야 다음으로 넘어가쥬 ?
//
//            if (sum_arr[I] - sum_arr[J] > N) { J++; continue; }
//
//            if (sum_arr[I] - sum_arr[J] < N) { I++; continue; }
//
//
//        }
//
//
//        return answer;
//    }


    /*
    *
    *  1  2  3  4  5  6  7  8  9  10  11  12  13  14  15
    *
    *
    *  1 , 1  -> sum = 1 < N -> sum = sum + J , J++
    *  1 , 2  -> sum = 3 < N -> sum = sum + J , J++
    *  1 , 3  -> sum = 6 < N -> sum = sum + J , J++
    *  1 , 4  -> sum = 10 < N ->  sum = sum + J , J++
    *  1 , 5  -> sum = 15 = N -> sum = sum + J , J++ ,  cnt++
    *  1 , 6  -> sum = 21 > N -> sum = sum - I , I++
    *  2 , 6  -> sum = 20 > N -> sum = sum - I , I++
    *  3 , 6  -> sum = 18 > N -> sum = sum - I , I++
    *  4 , 6  -> sum = 14 < N -> sum = sum + J , J++
    *
    *
    *
    * */
    public static int solution(int N){

        int start_idx = 1 , end_idx = 1 ; // 투 포인터 정의
        int cnt = 1;

        long sum = 1L; // 합 구할 변수 선언

        while ( end_idx != N){

            if ( sum < N ){
                end_idx++;  sum = sum + end_idx ;
            }
            else if (sum > N) {
                sum = sum - start_idx;
                start_idx++;
            }
            else if (sum == N) {
                cnt++; end_idx++;  sum = sum + end_idx ;
            }


        }

        return cnt;
    }



}
