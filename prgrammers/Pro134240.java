public class Pro134240 {
    public static void main(String[] args) {
        solution(new int[]{1 , 3 , 4 , 6 });
    }

    private static String solution( int [] food ){
        String answer = "";

        StringBuffer sbL = new StringBuffer();
        StringBuffer sbW = new StringBuffer();

        // food 음식 만큼 돌리기
        // 0은 물이니까 패스
        for (int i = 1; i < food.length ; i++) {
            // food 의 i 번째 개수에서 1번 반복 때마다
            // -2 를 해주고 값이 1보다 작아지면 stop  ( 1개 남았을 경우 양쪽에 음식 사용 못함으로 )
            for (int j = food[i]; j > 1 ; j = j - 2) {
                sbL.append(i); // 0 기준 왼쪽 숫자 붙히기
                sbW.append(i); // 0 기준 오른쪽 숫자 붙히기
            }
        }

        answer = sbL + "0" + sbW.reverse(); // 오른쪽 음식 reverse

        return answer;
    }


}
