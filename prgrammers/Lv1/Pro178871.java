package Lv1;

import java.util.HashMap;
public class Pro178871 {
    private static String[] solution(String[] players, String[] callings) {


        // 해설진은 바로 앞의 선수를 추월할 때 추월한 선수의 이름을 부름
        // 시간 복잡도
        // 탐색 잘해야될듯? 답은 Hash
        HashMap< String , Integer > playerMap = new HashMap<>();
        HashMap< Integer , String > rankMap = new HashMap<>();

        for( int i = 0 ; i < players.length ; i++ ){
            playerMap.put( players[i] , i );
            rankMap.put( i , players[i] );
        }

        for( int i = 0; i < callings.length ; i++ ){
            String callingPlayer = callings[i];
            Integer callIdx = playerMap.get(callingPlayer);

            String frontPlayer = rankMap.get(callIdx-1);

            // SWAP
            rankMap.put( callIdx-1 , callingPlayer);
            rankMap.put( callIdx , frontPlayer);

            // SWAP
            playerMap.put( callingPlayer , callIdx - 1);
            playerMap.put( frontPlayer , callIdx);
        }

        String[] answer = new String[rankMap.size()];

        for(int i = 0; i < answer.length ; i++ ){
            answer[i] = rankMap.get(i);
        }

        return answer;
    }
}
