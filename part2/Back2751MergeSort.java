import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Back2751MergeSort {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter buf = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();
        int [] numbers = new int[N];
        int[] sorted = new int[N];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        mergeSort(numbers , sorted , 0 , numbers.length - 1);

        for (int ans: sorted
             ) {
            buf.write( String.valueOf(ans) + "\n");
        }

        buf.flush();
    }


    /*
    *
    * 병합 정렬
    *
    * */

    static void mergeSort( int[] numbers , int[] sorted , int start , int end ){
        if ( start < end ){
            int mid = ( start + end ) / 2;

            mergeSort( numbers , sorted , start , mid);
            mergeSort(  numbers , sorted , mid + 1 , end);

            int left = start;
            int right = mid+1;

            int index = left;

            while ( left <= mid || right <= end){
                if ( right > end || ( left <= mid && numbers[left] < numbers[right] )) {
                    sorted[index++] = numbers[left++];
                }
                else{ // right <= end && ( left > mid || numbers[left] > numbers[right] )
                    sorted[index++] = numbers[right++];
                }
            }

            for (int i = start ; i <= end ; i++) {
                numbers[i] = sorted[i];
            }

        }

    }



}
