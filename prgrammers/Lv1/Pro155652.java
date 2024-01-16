package Lv1;

import java.util.Stack;

public class Pro155652 {
    public static void main(String[] args) {
    }


    public String solution(String s, String skip, int index) {
        String answer = "";
        StringBuffer sb = new StringBuffer();
        //기존 a-z 까지 변수 생성
        String abc = "abcdefghijklmnopqrstuvwxyz";
        String[] SKIP = skip.split("");

        //abc 변수에 skip 되는 부분들 삭제
        for ( int i = 0 ; i < SKIP.length ; i ++ ){
            abc = abc.replace( SKIP[i] , "");
        }

        //abc 변수 배열로 변환
        String [] ABC = abc.split("");

        // s 문자열 배열로 변환
        String[] S = s.split("");

        // s 문자열 배열 비교
        for( int i = 0 ; i < S.length; i ++ ){
            // 해독 된 문자열
            String realStr = "";
            for( int j = 0 ; j < ABC.length ; j++ ){
                if( S[i].equals(ABC[j])){
                    // ABC 의 길이보다 더 길 경우를 대비하기 위해 MOD 연산
                    realStr = ABC[ ( j + index ) % ABC.length ];
                    // 차례대로 붙혀주기
                    sb.append(realStr);
                }
            }
        }

        answer = sb.toString();

        return answer;
    }
}
