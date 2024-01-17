package Lv2;

public class Pro42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        // yellow 개수를 기준으로 brown 개수를 예상할 수 있음.
        // ex) yellow 가 24개이면
        // | 24 , 1 | 12 , 2 | 8 , 3 | 6 , 4 |
        // | 26 , 3 | 14 , 4 | 10 , 5| 8 , 6 |
        // 이런식으로 케이스를 나눠서 생각 가능.

        int x = 0; // 가로
        int y = 0; // 세로

        for( int i = 1; i <= yellow ; i ++ ){
            // x * y = yellow 로 표현 못하는 케이스는 버림 ( 가로 세로는 정수다. )
            // 가로가 더 길기 때문에 i 제곱이 yellow 보다 크지 못함
            if( yellow % i != 0 || Math.pow( i , 2 ) > yellow ){
                continue;
            }

            // x , y 지정
            x = yellow / i; // 가로
            y = i; // 세로

            // 브라운은 옐로우의 x 길이 + 2 와 y의 길이 +2 를 곱한것에 yellow 를 뺀 것과 같다.
            // 같으면 x+2 , y+2 제출
            if( brown == ( (x + 2) * ( y + 2 ) - yellow ) ) {
                answer[0] = x+2;
                answer[1] = y+2;
            }

        }


        return answer;
    }
}
