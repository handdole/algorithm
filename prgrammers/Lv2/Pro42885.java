package Lv2;

import java.util.Arrays;
public class Pro42885 {
    public int solution(int[] people, int limit) {
        int answer = 0;

        // 무인도에 갇힌 사람들 구출
        // 1. 한번에 최대 2명 탑승 가능
        // 2. 무게 제한 있음 ( 초과 불가 )
        // 구명보트 최대한 적게 사용하여 모든 사람 구출
        //  40 >= 사람 몸무게 >= 240
        // 40 >= 구명보트 무게제한 >= 240

        Arrays.sort(people);

        int start = 0;
        for( int end = people.length - 1 ; end >= start ; end-- ){
            if( people[end] + people[start] <= limit ){
                answer++;
                start++;
            }
            else{
                answer++;
            }
        }

        return answer;
    }

    // 너무 어렵게 접근한 것 같음.
    public int solution1(int[] people, int limit) {
        int answer = 0;

        // 무인도에 갇힌 사람들 구출
        // 1. 한번에 최대 2명 탑승 가능
        // 2. 무게 제한 있음 ( 초과 불가 )
        // 구명보트 최대한 적게 사용하여 모든 사람 구출
        //  40 >= 사람 몸무게 >= 240
        // 40 >= 구명보트 무게제한 >= 240

        // 사람들 몸무게 낮은 순으로 정렬
        Arrays.sort( people );



        for( int i = 0 ; i < people.length; i++ ){
            boolean flag = false; // 같이 탈출 했는가? t : 예 f : 아니오
            int max = 0; // 범위내에 있는 사람중 몸무게 최대값인 사람 선정
            // 0이면 나간 사람이니까 패스
            if( people[i] == 0 ) continue;
            // 제일 무게가 덜 나가는 사람 우선 탑승
            // 현재 탑승 무게 가능 무게 n
            // limit - people[i] >= n >= 40 ( 사람 최소 몸무게 )
            for( int j = people.length - 1 ; j >= i+1 ; j -- ){
                if( people[i] == 0 ) continue;
                if( limit >= people[j] + people[i] && people[j] >= 40  ){
                    // 정렬을 이용했음으로 최댓값은 항상 먼저 나오는 순서.
                    people[j] = 0; // 탈출
                    answer++;
                    flag = true; // 같이 탈출
                    break;
                }
            }

            if( flag ){
                // 탈출
                people[i] = 0;
                // answer 카운트는 위에서 함
            }
            else{
                // 탈출
                people[i] = 0;
                // answer 카운트는 위에서 안하니 여기서 함
                answer++;
            }

        }


        return answer;
    }
}
