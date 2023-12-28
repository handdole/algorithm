public class Pro136798 {

    public static void main(String[] args) {
        System.out.println(solution(10,3,2));
    }

    private static int solution(int number, int limit, int power) {
        int answer = 0;

        // for N 배열 각 배열의 인덱스의 약수 개수 저장
        for (int i = 1; i < number + 1; i++) {
            int cnt = 0;
            int sqrt = (int) Math.sqrt(i);
            // 약수 개수 구하기
            for (int j = 1; j <= sqrt; j++) {
                if ( j*j == i ){
                    cnt++;
                }
                else if( i % j == 0 ){
                    cnt += 2;
                }
            }
            // 각 배열의 값이 limit 보다 크다면 power 로 제한
            if (cnt > limit){
                answer += power;
            }
            else{
                answer += cnt;
            }
        }

        return answer;
    }


}
