package Lv2;

public class Pro70129 {
    public int[] solution(String s) {
        int[] answer = new int[2];

        int change_cnt = 0;
        int replace_zero = 0;

        while( !s.equals("1")){
            // 0 제거 및 개수 확인
            String old_s = s.replace("0" , "");
            // 제거된 개수 더해주기
            replace_zero += s.length() - old_s.length();
            // 제거 시키기
            s = s.replace("0" , "");
            //변환된 횟수 카운트
            change_cnt++;

            //s 길이만큼 이진수로 변환
            s = Integer.toBinaryString(s.length());
        }

        // 정답 제출
        answer[0] = change_cnt;
        answer[1] = replace_zero;

        return answer;
    }
}
