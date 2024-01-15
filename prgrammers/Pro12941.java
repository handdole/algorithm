import java.util.*;

public class Pro12941 {

    // 제일 깔끔한 풀이방법
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);

        for( int i = 0; i < A.length ; i++ ){

            System.out.println( "A[i] : " + A[i] + " B[i] : " + B[B.length - 1 - i] );

            answer += A[i] * B[B.length - 1 - i];
        }
        return answer;
    }



    // 첫번째 풀이
    // 틀렷음. 시간 복잡도 계산 시 n제곱 나옴
    public int solution1(int []A, int []B)
    {
        int answer = 0;

        for( int i = 0 ; i < A.length ; i++ ){
            int min = Integer.MAX_VALUE;
            int min_idx = 0;
            int max = Integer.MIN_VALUE;
            int max_idx = 0;
            // A 최솟 값 구하기
            for( int a = 0; a < A.length ; a++ ){
                if( min > A[a] ){
                    // 최솟 값 SWAP
                    min = A[a];
                    min_idx = a;
                }
            }

            // B 최댓 값 구하기
            for( int b = 0; b < B.length ; b++ ){
                if( max < B[b] ){
                    // 최댓 값 SWAP
                    max = B[b];
                    max_idx = b;
                }
            }

            answer += max * min ;

            A[min_idx] = Integer.MAX_VALUE;
            B[max_idx] = Integer.MIN_VALUE;

        }

        return answer;
    }

    // 두번째 풀이
    // 맞았음 reverseSort 아이디어 굳 정렬 후 앞뒤 순서 바꾸기
    public int solution2(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        reverseSort(B);

        for( int i = 0; i < A.length ; i++ ){

            System.out.println( "A[i] : " + A[i] + " B[i] : " + B[i] );

            answer += A[i] * B[i];
        }

        return answer;
    }

    public static void reverseSort(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }
}
