import java.util.Scanner;

public class Back11047My {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // int N , long K 받기
        int N = sc.nextInt();
        Long K = sc.nextLong();

        // 동전 가치 배열로 받기
        int [] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        // long 남은 돈
        long charge = K;

        //동전 개수
        int cnt = 0;
        // 제일 큰 값부터 작은 값 순으로
        // for 문
        for (int i = A.length - 1; i >= 0 ; i--) {

            if (A[i] <= charge ){ // Aj의 값이 K 보다 작거나 같다
                // 동전 개수 += K / Aj
                cnt += charge/A[i];
                // 남은돈 = K % Aj
                charge = charge % A[i];
                // 남은 돈이 0 이라면
                if (charge == 0){
                    // for 문 종료
                    break;
                }
            }
        }

        System.out.printf("" + cnt);


    }

}
