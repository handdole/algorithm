package Lv2;

public class Pro12945 {
    public int solution(int n) {
        int answer = 0;

        // 피보나치 수 배열생성
        int[] fi = new int[1000001];

        // init
        fi[0] = 0;
        fi[1] = 1;

        // for 문을 통해 피보나치 수 배열에 저장
        for( int i = 2; i < fi.length ; i++ ){
            // 정답을 다 배열에 넣는 개념이기 때문에
            // 구할 때마다 배열에 넣어야함.
            fi[i] = ( fi[i-1] + fi[i-2] ) % 1234567;
        }

        answer = fi[n];

        return answer;
    }
}
