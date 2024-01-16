package Lv1;

public class Pro140108 {
    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("abracadabra"));
        System.out.println(solution("aaabbaccccabba"));
    }

    private static int solution(String s) {
        // 제일 처음에는 한 개의 요소이다.
        int answer = 1;

        String[] S = s.split("");

        int sameCnt= 0;
        int notSameCnt = 0;

        String x = S[0];

        for (int i = 0; i < S.length-1; i++) {
            if (x.equals(S[i])){
                sameCnt++;
            }
            else{
                notSameCnt++;
            }

            if (sameCnt == notSameCnt){
                answer++;
                x = S[i+1];
            }

        }

        return answer;
    }

}
