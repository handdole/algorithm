import java.util.Scanner;

public class Back2751 {

    /*


    수도코드
    main
        int N 수의 개수 받기
        int[] numbers 배열 생성

        for 0~numbers.len
            int[i] = sc.nextInt() 수 받아서 배열에 넣기

        foreach
            souf( ans )


    퀵 정렬 알고리즘 적용 함수
    quickSort ( int [] numbers, int start , int end )
        int part = partition( numbers , start , end )
        if ( start < part - 1 )
            quickSort ( numbers , start , part -1 )
        if ( part < end )
            quickSort ( numbers , part , end )

    partition( int[]numbers , int start , int end )
        int pivot = numbers[ start + end / 2 ]
        while ( start ≤ end )
            while( numbers[start] < pivot )
                start++
            while( numbers[end] > pivot )
                end—
            if( start ≤ end )
                swap( numbers , numbers[start] , numbers[end] )
                start++
                end —
        return start;

    swap ( int[] numbers , int i , int j )
        int temp = numbers[i]
        numbers[i] = numbers[j]
        number[j] = temp

    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int [] numbers = new int[N];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        quickSort(numbers , 0 , numbers.length -1);

        for (int ans: numbers
             ) {
            System.out.printf(ans+"\n");
        }



    }

    static void quickSort( int [] numbers , int start , int end ){
        int part = partition(numbers , start , end);

        if (start < part - 1) quickSort(numbers , start , part-1);
        if (end > part) quickSort(numbers , part , end);

    }

    static int partition( int [] numbers , int start , int end ) {
        int pivot_idx = (start+end) / 2;

        if (numbers[start] > numbers[pivot_idx]) swap(numbers , start , pivot_idx);
        if (numbers[start] > numbers[end]) swap(numbers , start , end);
        if (numbers[pivot_idx] > numbers[end]) swap(numbers , pivot_idx , end);

        int pivot = numbers[pivot_idx];

        while (start <= end){
            while ( numbers[start] < pivot ) start++;
            while ( numbers[end] > pivot) end--;
            if (start <= end){
                swap(numbers , start , end);
                start++;
                end--;
            }
        }

        return start;
    }

    static void swap ( int[]numbers , int i , int j ){
        int tmep = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = tmep;
    }

}
