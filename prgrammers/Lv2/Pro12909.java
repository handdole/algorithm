package Lv2;

public class Pro12909 {
    boolean solution(String s) {
        boolean answer = true;
        // left : 왼쪽 괄호 카운트 right : 오른쪽 괄호 카운트
        int left = 0;
        int right = 0;

        // 시간 복잡도  n
        for( int i = 0 ; i < s.length() ; i++ ){
            // 왼쪽 괄호 카운트
            if( s.charAt(i) == '('){
                left++;
            }
            // 오른쪽 괄호 카운트
            else{
                right++;
            }

            // 왼쪽에서부터 카운팅 할 때 왼쪽 괄호보다 오른쪽 괄호가 더 많이나오면 false
            if( right > left ){
                // false 반환 함수 종료
                return answer = false;
            }
        }

        // 마지막에 두 괄호의 수가 일치하지 않으면 false
        if( right != left ){
            answer = false;
        }

        return answer;
    }
}
