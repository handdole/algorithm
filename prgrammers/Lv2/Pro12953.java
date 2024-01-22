package Lv2;

public class Pro12953 {
    public int solution(int[] arr) {
        int answer = 0;

        int lcm = 0;

        for( int i = 1; i < arr.length ; i++ ){
            // 배열 0 , 1 의 최소 공배수 저장
            if( i == 1 ){
                lcm = LCM(arr[1] , arr[0]);
                continue;
            }
            // 최소 공배수 = ( 직전 최소 공배수 , 새로운 수 ) <- 최소 공배수
            lcm = LCM( lcm , arr[i] );
        }

        answer = lcm;
        return answer;
    }

    // 최대 공배수 구하는 함수
    static int GCD ( int M , int N ) {
        if( M % N == 0 ) {
            return N ;
        }
        return GCD( N , M % N );
    }

    // 최소 공약수 구하는 함수
    static int LCM ( int M , int N ) {
        return M * N / GCD( M , N );
    }
}
