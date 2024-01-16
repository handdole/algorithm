package Lv1;

public class Pro172928 {
    private static int[] solution(String[] park, String[] routes) {
        int[] answer = new int[2];

        // 공원의 세로 길이
        int SE = park.length;
        // 공원의 가로 길이
        int GA = park[0].split("").length;
        System.out.println( "SE : " + SE + " GA : " + GA );
        // 공원 이중 배열로 표시
        String[][] P = new String[SE][GA];

        // 시작 위치 세팅
        for( int i = 0; i < park.length ; i++ ){
            String [] parkN = park[i].split("");
            for( int j = 0 ; j < parkN.length ; j++ ){
                // 값 삽입
                P[i][j] = parkN[j];
                if( "S".equals(parkN[j])){
                    // 시작 점 answer 배열에 넣기
                    answer[0] = i; // 세로
                    answer[1] = j; // 가로

                }
            }
        }



        for( String route : routes ){
            char op = route.charAt(0);
            int n = Integer.parseInt(route.substring( 2 , 3 ));
            boolean okFlag = true;
            // 현재 위치
            int now_se = answer[0];
            int now_ga = answer[1];
            for( int cnt = 0; cnt < n ; cnt++ ){
                //동쪽으로 n 번갈 때
                if(op == 'E') {
                    // 밖으로 벗어나지 않고 장애물이 없을 때
                    if( now_ga + 1 < GA && !P[now_se][now_ga+1].equals("X") ){
                        now_ga++;
                    }
                    // 밖으로 나가거나 장애물이 있다면
                    else{
                        okFlag = false;
                        break;
                    }
                }
                // 서쪽으로 n 번 갈 때
                if(op == 'W'){
                    // 밖으로 벗어나지 않고 장애물이 없을 때
                    // ( 0, 0 ) 까지 허용임으로 0 보다 크거나 같다라고 표시해야함.
                    if( now_ga - 1 >= 0 && !P[now_se][now_ga-1].equals("X") ){
                        now_ga--;
                    }
                    // 밖으로 나가거나 장애물이 있다면
                    else{
                        okFlag = false;
                        break;
                    }
                }
                // 남쪽으로 n 번 갈 때
                if(op == 'S'){

                    // 밖으로 벗어나지 않고 장애물이 없을 때
                    if( now_se + 1 < SE && !P[now_se+1][now_ga].equals("X") ){
                        now_se++;
                    }
                    // 밖으로 나가거나 장애물이 있다면
                    else{
                        okFlag = false;
                        break;
                    }
                }
                // 남쪽으로 n 번 갈 때
                if(op == 'N'){
                    // 밖으로 벗어나지 않고 장애물이 없을 때
                    // ( 0, 0 ) 까지 허용임으로 0 보다 크거나 같다라고 표시해야함.
                    if( now_se - 1 >= 0 && !P[now_se-1][now_ga].equals("X") ){
                        now_se--;
                    }
                    // 밖으로 나가거나 장애물이 있다면
                    else{
                        okFlag = false;
                        break;
                    }
                }
            }

            if(okFlag){
                answer[0] = now_se;
                answer[1] = now_ga;
            }
        }

        return answer;
    }
}
