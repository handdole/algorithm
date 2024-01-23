package Lv2;

public class Pro12914 {
    public long solution(int n) {
        long answer = 0;

        // 점화식
        // f(n) = f(n-2) + f(n-1)

        // n 은 2000 이하의 수
        long [] answers = new long[2001];

        // init
        answers[0] = 0;
        answers[1] = 1;
        answers[2] = 2;

        // 3부터 점화식으로 정답 채워 넣기
        for( int i = 3 ; i < answers.length ; i++ ){
            answers[i] = ( answers[i-1] + answers[i-2] ) % 1234567; // MOD 연산해서 정답 넣기
        }

        answer = answers[n];

        return answer;
    }
}
