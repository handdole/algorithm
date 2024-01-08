public class Pro77484 {
    private static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];

        // Y:win_nums에 있다. N : win_nums에 없다. Z: 지워진 수다.
        String[] lottoStatus = new String[6] ;
        boolean flag = false;

        //lottoStatus init
        for( int i = 0; i < lottos.length ; i++ ){
            flag = false;
            // 지워진 번호 일 경우
            if( lottos[i] == 0){
                lottoStatus[i] = "Z";
            }
            else{
                // lottos 와 win_nums 비교
                for( int j = 0; j < win_nums.length ; j++ ){
                    if( lottos[i] == win_nums[j] ){
                        lottoStatus[i] = "Y";
                        flag = true;
                    }
                }
                if( !flag ){
                    lottoStatus[i] = "N";
                }
            }
        }

        int cnt = 0;

        // 최대 등수 구현
        // 지워진 수가 모두 맞았을 경우
        for( int i = 0; i < lottoStatus.length ; i++ ){
            System.out.println("maxValue -> " + lottoStatus[i]);
            if( "Y".equals(lottoStatus[i]) ){
                cnt++;
            }
            else if ("Z".equals(lottoStatus[i])){
                cnt++;
            }
        }

        // 2개 번호보다 낮게 맞췄을 경우 모두 6등 그 외에는 7 - 맞춘 숫자 개수
        answer[0] = cnt < 2 ? 6 : 7 - cnt;

        //cnt 값 초기화
        cnt = 0;

        // 최소 등수 구현
        // 지워진 수가 모두 틀렸을 경우
        for( int i = 0; i < lottoStatus.length ; i++ ){
            System.out.println("minValue -> " + lottoStatus[i]);
            if( "Y".equals(lottoStatus[i]) ){
                cnt++;
            }
        }

        // 2개 번호보다 낮게 맞췄을 경우 모두 6등 그 외에는 7 - 맞춘 숫자 개수
        answer[1] = cnt < 2 ? 6 : 7 - cnt;

        return answer;
    }
}
