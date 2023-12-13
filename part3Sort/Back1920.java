import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back1920 {


    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(st.nextToken());
        int [] numbers_temp = new int[N];
        int [] numbers = new int[N];

        st = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            numbers_temp[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bufferedReader.readLine());
        int M = Integer.parseInt(st.nextToken());
        int [] itzy = new int[M];

        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < itzy.length; i++) {
            itzy[i] = Integer.parseInt(st.nextToken());
        }
        // 이거 시간 복잡도 n 제곱이라 1초만에 못 품는 구라고 둘다 됨 ;
        Arrays.sort(numbers_temp);

        // 병합 정렬
        //mergeSort(numbers_temp , numbers , 0 , numbers.length - 1);

        StringBuffer sb = new StringBuffer();

        for (int i: itzy
             ) {
            sb.append(binarySearch(numbers_temp , i , 0 ,numbers_temp.length - 1) + " ");
        }


        System.out.printf(sb.toString() + "");

    }

    static void mergeSort( int [] numbers , int[] sorted , int start , int end ){
        if ( start < end ){
            int mid = ( start + end ) / 2 ;

            mergeSort(numbers , sorted , start , mid);
            mergeSort(numbers , sorted , mid + 1 , end);

            int left = start;
            int right = mid+1;

            int index = left;

            while ( left <= mid || right <= end ){
                if ( right > end || ( left <= mid && numbers[left] < numbers[right])){
                    sorted[index++] = numbers[left++];
                }
                else{
                    sorted[index++] = numbers[right++];
                }

            }

            for (int i = start; i <= end ; i++) {
                numbers[i] = sorted[i];
            }

        }

    }

    static int binarySearch( int[] numbers , int key , int low , int high){
        int mid;

        if( low <= high ){
            mid = ( low + high ) / 2;

            if (key == numbers[mid]){
                return 1;
            }
            else if ( key < numbers[mid]){
                return binarySearch(numbers , key , low , mid - 1);
            } else {
                return binarySearch( numbers , key , mid+1 , high);
            }
        }

        return 0;
    }


}
