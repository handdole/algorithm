import java.util.Scanner;

public class Back11659 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        long [] arr = new long[N];

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = sc.nextLong();
        }

        long [] sum_arr = new long[arr.length];
        long sum = 0L;

        for (int i = 0; i < sum_arr.length; i++) {
            sum += arr[i];
            sum_arr[i] = sum;
        }

        long [] answer = new long[M];

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            answer[i] = sum_arr[to] - sum_arr[from-1];
        }

        for (long a : answer) {
            System.out.println(a);
        }


    }

}
