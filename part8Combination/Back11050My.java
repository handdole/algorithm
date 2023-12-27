import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back11050My {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String [] s = br.readLine().split(" ");

        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        System.out.printf("" + Comb( N , K ) );
    }

    static int Comb( int n , int r ){
        if (n == r){
            return 1;
        }
        if (r == 1){
            return n;
        }
        return Comb( n - 1 , r - 1 ) + Comb( n-1 , r );
    }


}
