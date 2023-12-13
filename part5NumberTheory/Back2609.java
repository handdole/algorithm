import java.util.Scanner;

public class Back2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long M = sc.nextLong();
        long N = sc.nextLong();

        System.out.println(GCD(M , N));
        System.out.printf(LCM(M , N) + "");
    }

    static long GCD( long M , long N){
        if (M % N == 0){
            return N;
        }
        return GCD( N , M % N );
    }

    static long LCM( long M , long N ) {
        return M * N / GCD( M , N );
    }

}
