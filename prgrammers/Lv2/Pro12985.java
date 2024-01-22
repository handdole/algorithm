package Lv2;

public class Pro12985 {
    public int solution(int n, int a, int b)
    {
        int answer = 0;

        // N 명이 참가
        // 토너먼트 형식
        // 이진트리 ?

        // 2로 나눠서 반올림 한 수를 다음 수로 배정 받게 됨.
        // ex )
        // 4 / 2 = 2       | 7 / 2 = 3.5 = 4
        // 2 /2 = 1        | 4 / 2 = 2
        // 1 / 2 = 0.5 = 1 | 2 / 2 = 1 <- 3번 째

        // a 와 b 가 같으면 만났다는 뜻.
        while( a != b ) {
            // a 의 다음 순번
            // a 가 2로 안나눠 질 경우
            // 나누고 1 더하기
            if( a % 2 == 1 ) a = ( a / 2 ) + 1;
                // 아닐 경우 2 나누기
            else a = a / 2 ;

            // b 의 다음 순번
            // b 가 2로 안 나눠 질 경우
            if( b % 2 == 1 ) b = ( b / 2 ) + 1;
                // 아닐 경우 2로 나누기
            else b = b / 2;


            answer++;
        }

        return answer;
    }
}
