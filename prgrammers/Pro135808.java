import java.util.Arrays;

public class Pro135808 {
    public static void main(String[] args) {

        System.out.println(solution( 4 , 3 , new int [] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));

    }

    private static int solution(int k, int m, int[] score) {
        int answer = 0;

        // int 배열 Integer 로 변경
        Integer[] S = Arrays.stream(score).boxed().toArray(Integer[]::new);
        // score 내림 차순으로 정렬
        Arrays.sort( S , ( o1 , o2 ) -> o2 - o1);

        // 최소 금액 int
        int min = 0;

        // score 길이 나누기 m 하면 박스 개수 나옴
        for (int i = 0; i < S.length / m; i++) {
            min = S[i * m];
            for (int j = i*m; j < m*(i+1) ; j++) {
                if (min > S[j]){
                    min = S[j];
                }
            }
            answer = answer + ( min * m );
        }

        return answer;
    }


}
