public class Pro161990 {
    class Solution {
        public int[] solution(String[] wallpaper) {
            int[] answer = new int[4];

            int min_lux = Integer.MAX_VALUE; // 시작점의 가로측 최솟값
            int max_rdx = 0; // 도착점의 가로측 최댓값
            int min_luy = Integer.MAX_VALUE; // 시작점의 세로측 최솟값
            int max_rdy = 0; // 도착점의 세로측 최댓값

            // 그래프를 나타내는 이중 배열
            int[][] graph = new int[wallpaper.length][wallpaper[0].split("").length];

            // 그래프 init
            for( int i = 0 ; i < graph.length ; i++ ){
                String[] row = wallpaper[i].split("");
                for( int j = 0; j < graph[i].length ; j++ ){
                    if( "#".equals(row[j]) ){
                        graph[i][j] = 1;
                    }
                    else{
                        graph[i][j] = 0;
                    }
                }
            }

            // 그래프 탐색
            for( int i = 0; i < graph.length ; i++ ){
                for( int j = 0; j < graph[i].length ; j++ ){
                    // 파일이 있는 케이스가 나올 경우 최소 최대 값 탐색
                    if( graph[i][j] == 1 ) {
                        // 가로측 최솟 값 체크
                        if( min_lux > i ){
                            min_lux = i;
                        }
                        // 가로측 최댓 값 체크
                        if( max_rdx < i ){
                            max_rdx = i;
                        }
                        // 세로측 최솟 값 체크
                        if( min_luy > j ){
                            min_luy = j;
                        }
                        // 세로측 최대 값 체크
                        if( max_rdy < j ){
                            max_rdy = j;
                        }
                    }
                }
            }


            answer[0] = min_lux;
            answer[1] = min_luy;
            answer[2] = max_rdx+1; // 도착점 이기 때문에 +1
            answer[3] = max_rdy+1; // 도착점 이기 때문에 +1

            return answer;
        }
    }
}
