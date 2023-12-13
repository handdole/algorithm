import java.util.Scanner;

public class Back11689EulersPhiFunc {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long cnt = N;

        for (int k = 2; k <= Math.sqrt(N) ; k++) { // N 의 소수중 두번째로 큰 소수는 N 제곱근 보다 작거나 같다. ***
            if (N % k == 0){ // 나눠지면
                cnt = cnt - cnt / k; // 나눠진 숫자의 배수들 다 삭제
            }
            while (N % k == 0) N /= k; // 배수들 다 제거
        }

        if (N > 1) cnt = cnt - cnt/N; // 제일 큰 소수 처리

        System.out.printf(""+cnt);

    }

}
