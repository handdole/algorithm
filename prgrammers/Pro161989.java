public class Pro161989 {

    public static void main(String[] args) {
        System.out.println(solution( 8 , 4 , new int[] {2, 3, 6}));
    }

    private static int solution(int n, int m, int[] section) {
        boolean [] C = new boolean[n + 1]; // 칠 해야하는 곳 T 로 넣을 배열

        boolean flag = false; // m 길이 만큼 체크 했을 때 페인트 질을 했는가? T 했음 F 안했음
        int answer = 0 ; // 칠한 횟수
        for (int i = 0; i < section.length; i++) {
            C[section[i]] = true; // 칠 해야하는 곳 true 값 삽입
        }

        // select 의 요소로 체크
        for (int i = 0; i < section.length; i++) {
            int idx = section[i];
            // 순서대로 진행했을 때 배열 out of index 나지 않는 범위
            if ( n - m > section[i] && C[idx]){
                // 페인트의 길이 만큼
                for (int j = 0; j < m; j++) {
                    if (C[idx+j]){
                        flag = true;
                        C[idx+j] = false;
                    }
                }
                if (flag) flag = false; answer++;
            }
            // 뒤에서 확인하는 부분
            else if ( n - m < section[i]){
                for (int j = C.length - 1; j < C.length - 1 - m ; j--) {
                    if (C[j]){
                        flag = true;
                        C[j] = false;
                    }
                    if (flag) flag = false; answer++;
                }
            }
        }

        return answer;
    }


}
