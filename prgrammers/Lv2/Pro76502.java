package Lv2;

public class Pro76502 {

    public int solution(String s) {
        int answer = 0;

        StringBuffer sb = new StringBuffer(s);

        // 한바꾸 돌기
        for( char temp :  s.toCharArray() ){
            // 첫 문자열 지우고
            sb.deleteCharAt(0);
            // 뒤에 붙히기
            sb.append(temp);
            // 문자열
            s = sb.toString();
            // 괄호 체크
            // replace 했는데 둘이 길이가 같거나
            // 원래 배열이 0일 경우

            // flag true : 성공 false : 실패
            boolean flag = true;

            String newStr = "";

            while( true ){
                String oldStr = s;

                // 괄호 지우기
                s = s.replace( "()" , " " ).replace("{}" , " " ).replace( "[]" , " ");
                // 공백 지우기
                s = s.replace(" " , "");

                if( oldStr.length() == s.length() ){
                    break;
                }
            }

            if( s.length() == 0 ){
                answer++;
            }

        }


        return answer;
    }


    public int solution1(String s) {
        int answer = -1;

        // 닫는 괄호가 먼저 나오면
        // 그 케이스는 no count
        int len = s.length();
        int successCnt = 0;

        // 첫 인덱스부터 마지막 인덱스까지
        for( int i = 0; i < len ; i++ ){
            // 시작 인덱스
            int start_idx = i;
            // 실패 체크
            boolean failFlag = false;
            // 열린 괄호 카운트 0 : 소 , 1: 중 , 2: 대
            int[] openCnt = new int[3];
            // 닫힌 괄호 카운트 0 : 소 , 1: 중 , 2: 대
            int[] closeCnt = new int[3];
            // ex ) 0 ~ len | 4 ~ len + 4 | 시작한 곳부터 시작 전까지 돌기
            for( int j = start_idx ; j < len + start_idx ; j++ ){
                // len 넘어 갈 경우 0으로 돌아가는 연산
                char checkChar = s.charAt( j % len );
                // 닫힌 괄호나 왔을 경우
                if( ( checkChar == ')' ||
                        checkChar == '}' ||
                        checkChar == ']' ) ){
                    // 닫힌 괄호 카운트
                    if(checkChar == ')'){
                        closeCnt[0]++;
                        // 닫힌 괄호가 더 많을 경우
                        if( closeCnt[0] > openCnt[0] ) {
                            // 실패
                            failFlag = true;
                            break;
                        }
                    }
                    if(checkChar == '}'){
                        closeCnt[1]++;
                        // 닫힌 괄호가 더 많을 경우
                        if( closeCnt[1] > openCnt[1] ) {
                            // 실패
                            failFlag = true;
                            break;
                        }
                    }
                    if(checkChar == ']'){
                        closeCnt[2]++;
                        // 닫힌 괄호가 더 많을 경우
                        if( closeCnt[2] > openCnt[2] ) {
                            // 실패
                            failFlag = true;
                            break;
                        }
                    }
                }
                // 열린 괄호가 나왔을 경우
                else{
                    if(checkChar == '(') openCnt[0]++;
                    if(checkChar == '{') openCnt[1]++;
                    if(checkChar == '[') openCnt[2]++;
                }
            }

            // 탐색이 끝나고 나서
            // 개수가 같지 않은게 있다면
            if( openCnt[0] != closeCnt[0] ||
                    openCnt[1] != closeCnt[1] ||
                    openCnt[2] != closeCnt[2] ){
                failFlag = true;
            }
            // 실패한 적 없으면
            if( !failFlag ){
                // 성공 1 카운트
                successCnt++;
            }

        }

        answer = successCnt;

        return answer;
    }
}
