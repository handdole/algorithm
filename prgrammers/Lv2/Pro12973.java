package Lv2;

import java.util.ArrayDeque;
import java.util.Deque;
public class Pro12973 {
    public int solution(String s)
    {
        int answer = 1;

        // 같은 알파벳이 2개 붙어있는 짝을 찾는다.
        // 그 둘을 제거
        // 앞뒤로 문자열을 이어 붙인다.
        // 모두 제거된다면 1 아니면 0 리턴

        // 큐로 풀어보자
        // 문자열 배열 만들고
        // 한개씩 큐에 넣으면서 처리

        String[] S = s.split("");

        Deque<String> stack = new ArrayDeque<String>();

        for( int i = 0; i < S.length ; i++ ){
            // stack 이 비워져 있을 경우
            if( stack.isEmpty() ){
                // stack 에 저장
                stack.push(S[i]);
            }
            else{
                // 제일 위에 있는 값 저장
                String preStr = stack.peek();
                // 제일 위에 있는 값과 새로 들어올려는 값이 같을 경우
                if( preStr.equals(S[i])){
                    // 제일 위에 있는 값 제거 후 다음 값 받기
                    stack.pop();
                }
                // 제일 위에 있는 값과 새로 들어올려는 값이 다를 경우
                else{
                    // stack 에 저장
                    stack.push(S[i]);
                }
            }
        }

        // 스택이 비워져있으면 성공
        if( stack.isEmpty()){
            answer = 1;
        }
        // 스택이 채워져있으면 실패
        else{
            answer = 0;
        }

        return answer;
    }
}
