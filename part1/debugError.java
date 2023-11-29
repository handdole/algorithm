import java.util.Scanner;

public class debugError {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        int answer = 0;
        int A[] = new int[10001];
        int B[] = new int[10001];


        for (int i = 0; i < 10000; i++) {
            A[i] = (int)(Math.random()*Integer.MAX_VALUE);
            B[i] = B[i-1] + A[i] ;
        }



    }
}
