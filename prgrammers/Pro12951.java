public class Pro12951 {

    private String solution(String s) {
        String answer = "";

        // 첫 문자가 대문자여야 하기 때문에 나머지 문자는 다 소문자로 치환
        s = s.toLowerCase();

        StringBuffer sb = new StringBuffer(s);

        // 아래 for문에서 i - 1 로 비교하기 때문에 0 은 우선 처리
        if( s.charAt(0) != ' ' ) {
            String firstStr = String.valueOf(s.charAt(0));
            sb.deleteCharAt(0);
            sb.insert( 0 , firstStr.toUpperCase() );
        }

        // s  문자열 길이 만큼
        for( int i = 1; i < s.length() ; i++ ){

            // 이전 문자열이 공백이고 현재 문자열이 공백이 아니면 첫 단어라고 볼 수 있다.
            if( s.charAt( i - 1 ) == ' ' && s.charAt(i) != ' '){
                String firstStr = String.valueOf(s.charAt(i));
                // 현재 문자열 삭제
                sb.deleteCharAt(i);
                // 대문자 삽입
                sb.insert( i , firstStr.toUpperCase() ) ;
            }

        }

        answer = sb.toString();
        return answer;
    }

}
