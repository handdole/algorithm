import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Back2751RadixSort {

    static int BUCKET_NUM = 10;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int [] numbers = new int[N];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        Queue<Integer>[] bucket = new LinkedList[BUCKET_NUM];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new LinkedList<>();
        }

        int maxLen = maxDigitCount(numbers);
        int digitNumber = 0;
        int numbers_index = 0;

        for (int i = 0; i < maxLen; i++) {
            for (int j = 0; j < numbers.length; j++) {
                digitNumber = getDigit(numbers[j] , i);

                bucket[digitNumber].add(numbers[j]);
            }

            for (int j = 0; j < BUCKET_NUM; j++) {
                while (!bucket[j].isEmpty()){
                    numbers[numbers_index++] = bucket[j].remove();
                }
            }
            numbers_index = 0;
        }

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

    static int maxDigitCount(int[] arr){
        int max = 0;
        for (int i = 0; i < arr.length ; i++) {
            max = Math.max( max , digitCount(arr[i]));

        }
        return max;
    }


}
