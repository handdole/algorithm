package Lv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public class Pro12981 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> preWords = new ArrayList<>();
        HashMap<Integer , List<String> > map = new HashMap<>();

        // map 으로 key : n번째 사람 value : n번째 사람이 말한 단어
        for( int i = 0; i < n ; i++ ){
            List<String> say = new ArrayList<>();
            map.put( i + 1 , say );
        }

        //words for 문 돌면서 조건 체크
        // 1. 한글자 단어를 말했는가?
        // 2. 이전에 등장했던 단어를 말했는가?
        // 3. 이전 사람이 말했던 단어의 마지막 단어를 말했는가?
        for ( int i = 0; i < words.length ; i++ ){
            // i : 0 1 2 3 4 5 6 7 8 9
            // t : 1 2 3 1 2 3 1 2 3 1
            int talker = ( i % n ) + 1;
            List<String> talkList = map.get(talker);

            // 말하는 단어가 1글자일 경우
            if( words[i].length() == 1){
                // 본인 차례인 사람
                answer[0] = talker;
                // 본인의 차례
                answer[1] = talkList.size()+1;
                break;
            }

            //이전에 등장한 단어를 말한 경우
            if( preWords.contains(words[i]) ){
                // 본인 차례인 사람
                answer[0] = talker;
                // 본인의 차례
                answer[1] = talkList.size()+1;
                break;
            }

            //마지막 단어 이어 말했는지?
            if ( i >= 1 &&
                    words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                // 본인 차례인 사람
                answer[0] = talker;
                // 본인의 차례
                answer[1] = talkList.size()+1;
                break;
            }

            talkList.add(words[i]);
            map.put(talker , talkList);
            preWords.add(words[i]);
        }

        return answer;
    }
}
