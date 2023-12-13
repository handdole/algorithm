import java.util.Scanner;

public class Back1929MySieveOfEratosthenes {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        int[] Ns = new int[N+1];

        for (int i = 0; i < Ns.length; i++) {
            Ns[i] = i;
        }

        // 1은 소수가 아님
        Ns[1] = 0;

        // N 을 A * B 로 나타낼 수 있음
        // N 은 루트 N * 루트 N
        // 따라서 무조건 루트 N < A 이면 루트 N > B
        // 즉 루트 N 전까지만 돌려도 됨

        for (int i = 2; i < Ns.length; i++) {
            if (i > Ns.length / 2){
                break;
            }
            if (Ns[i] != 0){
                for (int j = i+i ; j < Ns.length; j=j+i ) {
                    Ns[j] = 0;
                }
            }
            else{
                continue;
            }
        }

        StringBuffer sb = new StringBuffer();

        for (int i = M; i <= N; i++) {
            if (Ns[i] != 0){
                sb.append(Ns[i]+"\n");
            }
            else{
                continue;
            }
        }

        System.out.printf(sb.toString());

    }


}
