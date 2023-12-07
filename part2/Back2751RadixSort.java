import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Back2751RadixSort {

    static int BUCKET_NUM = 10;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int [] numbers = new int[N];

        for (int i = 0; i < numbers.length; i++) {
            int temp = sc.nextInt();
            if (temp < 0)
            numbers[i] = sc.nextInt();
        }

        //quickSort(numbers , 0 , numbers.length -1);

        for (int ans: numbers
        ) {
            buf.write( String.valueOf(ans) + "\n");
        }

        buf.flush();
    }

    // 숫자의 자릿수 반환
    static int getDigit( int num , int index ){
        return (int) Math.floor(Math.abs(num) / Math.pow( 10 , index)) % 10;
    }

    static int digitCount( int num ){
        if ( num == 0 ){
            return 1;
        }
        return (int) Math.floor(Math.log10(Math.abs(num)))+1;
    }


}
