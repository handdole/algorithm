package Lv1;

public class Pro142086 {

    public static void main(String[] args) {
        System.out.println(solution("banana"));
        System.out.println(solution("foobar"));
        System.out.println(solution("anmsgononoergntrgoergjifdjglkfdngodfgnoerafgegoenogfnepgpjgtiorgjofjgfdjoa"));
        System.out.println(solution("abbbabbabbaba"));

    }

    private static int[] solution( String s ){
        int[] answer = new int[s.length()]; // answer 배열 선언
        int cnt = 0 ; // count 변수 선언
        String[] S = s.split(""); // s 문자열 배열화
        boolean flag = false;
        answer[0] = -1; // 0 번째 인덱스는 무조건 -1의 값을 갖는다.

        for (int i = 1; i < s.length(); i++) {
            cnt = 0;
            flag = false;
            for (int j = i - 1 ; j >= 0 ; j-- ) { // 0 보다 작아지면 안됨. 비교 대상 기준으로 앞으로 인덱싱 해야함.
                cnt++;
                if (S[i].equals(S[j])){
                    flag = true; // 같은 것이 있으면 t 없으면 f
                    break; // for 문 탈출
                }
            }
            if (!flag) answer[i] = -1;
            else answer[i] = cnt;
        }
        return answer;
    }


}
