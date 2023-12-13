import jdk.jshell.EvalException;

import java.util.Scanner;

public class GCDFunc {

    // 최대 공약수 구하는 함수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        System.out.println(GCD( M , N ));

    }


    static long GCD( long M , long N){
        if (M % N == 0){
            return N;
        }
        return GCD( N , M % N );
    }

}
