import java.util.Arrays;

public class Pro138477 {

    public static void main(String[] args) {

        solution(4 , new int[] { 0, 300 , 40 , 300 , 20 , 70 , 150 , 50 , 500 , 1000});
    }

    private static int[] solution( int k , int[] score ){
        int[] answer = new int[score.length];
        int[] K = new int[k];

        for (int i = 0; i < K.length; i++) {
            K[i] = -1;
        }

        // 0일 차 setting
        K[0] = score[0];
        answer[0] = K[0];
        Arrays.sort(K);


        for (int i = 1; i < score.length; i++) {
            int A = -1;
            // 제일 작은 수보다 크거나 같다
            if (score[i] > K[0] ){
                // 제일 작은 수를 뺴고 배열에 넣기
                K[0] = score[i];
            }
            Arrays.sort(K);
            for (int j = 0; j < K.length; j++) {
                if (K[j] != A ){
                    A = K[j];
                    break;
                }
            }
            answer[i] = A;
        }


        return answer;
    }


}
