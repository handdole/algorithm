package Lv2;

import java.util.HashSet;
import java.util.Set;
public class Pro131701 {

    public int solution(int[] elements) {
        int answer = 0;

        Set<Integer> sumSet = new HashSet<>();

        int length = elements.length;
        // 1 ~ elements.length 의 개수 만큼 for 문 ( 1개인 case , 2개인 케이스 , ... , elements.lenght 개 인 케이스)
        // 시작점 정해주는 for 문
        // sum 구하는 for문
        // 삼중 포문 이거 케이스 적어서 할 수 있지
        // 케이스 10배만 많아도 이중 배열로 탐색 성능 올려야될 것 같은데...
        for( int size = 1; size <= length ; size ++ ){
            int sum = 0;
            int start = 0;
            // 첫 케이스
            for( int i = 0; i < size ; i++ ){
                sum += elements[i];
            }
            sumSet.add(sum);

            while( start < length - 1 ){
                // sum 에서 빼고
                sum -= elements[start];
                // 새로 추가되는 녀석 추가
                // 최대 길이가 넘어가면 다시 0으로 돌아오게 MOD 연산
                sum += elements[(start+size)%length];
                // 시작점 옮기기
                start++;
                // 새로운 총합 추기
                sumSet.add(sum);

            }

        }


        answer = sumSet.size();
        return answer;
    }
}
