package Lv1;

public class Pro42862 {
    public static void main(String[] args) {
        System.out.println(solution(5 , new int[] {2, 4} , new int[] {1, 3, 5}));
        System.out.println(solution(5 , new int[] {2, 4} , new int[] {3}));
        System.out.println(solution(3 , new int[] {3} , new int[] {1}));
        System.out.println(solution(5 , new int[] {1 , 2 , 3 , 4 } , new int[] {2 , 3 , 4 , 5}));
        System.out.println(solution(20 , new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20} , new int[] {20}));
        System.out.println(solution(20 , new int[] {18,19,20} , new int[] {17 ,20}));
    }

    private static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        int[] N = new int[n+1];

        // 체육복을 한개 씩 가지고 있다.
        for (int i = 1; i < N.length; i++) {
            N[i] = 1;
        }

        // 잃어버린 체육복 반영
        for (int i = 0; i < lost.length; i++) {
            N[lost[i]]--;
        }

        // 여분있는 체육복 반영
        for (int i = 0; i < reserve.length; i++) {
            N[reserve[i]]++;
        }

        // 체육복이 2개인 학생만 자기 앞 혹은 자기 뒤 학생에게 체육 복을 줄 수 있다.
        for (int i = 1; i < N.length; i++) {
            // i번 학생이 2벌일 경우
            if (N[i] == 2){
                // i번 학생이 1번 학생일 때 2번만 챙기면 된다.
                if (i == 1){
                    // 앞에 학생이 체육복이 없다.
                    if (N[i+1] < 1) {
                        N[i]--; // 체육복 하나를
                        N[i+1]++; // 빌려 준다.
                    }
                    continue;
                }
                // i번 학생이 N 번 학생일 때 N-1 번 학생만 챙기면 된다.
                if (i==n){
                    // 뒤에 학생이 체육복이 없다.
                    if (N[i-1] < 1) {
                        N[i]--; // 체육복 하나를
                        N[i-1]++; // 빌려 준다.
                    }
                    continue;
                }
                // 그 외
                // 뒤에 학생이 체육복이 없으면
                if (N[i-1] < 1) {
                    N[i]--; // 체육복 하나를
                    N[i-1]++; // 빌려 준다.
                    continue;
                }
                // 앞에 학생이 체육복이 없다.
                if (N[i+1] < 1) {
                    N[i]--; // 체육복 하나를
                    N[i+1]++; // 빌려 준다.
                }
            }
        }

        // 체육복이 1개 이상인 학생들 count
        for (int a : N
             ) {
            if (a >= 1){
                answer++;
            }
        }

        return answer;
    }

}
