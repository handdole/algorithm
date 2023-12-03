import java.util.Scanner;

public class Back1427 {


    /*
    수도코드

    long N ← 숫자 받기
    각 자리수 배열에 삽입

    int[] numbers
    int idx =0;
    while ( value < 0 )
        remain = value % 10;
        value /= 10;
        numbers[idx] = reamin;
        idx++;

    for( i = 0 ; i < numbers.len ; i++ )
        int max = 0;
        for( j =i ; j < numbers.len; j++)
            if( numbers[j] > max )
                max = numbers[j]
        numbers[i] = max ;

    foreach
        souf ( numbers)
*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();

        int[]numbers = new int[(int)Math.log10(N)+1]; // long N 의 자리수

        int idx = 0;
        int remain = 0;
        while ( N > 0 ){
            remain = (int) N % 10;
            N /= 10;
            numbers[idx] = remain;
            idx++;
        }
        for (int i = 0; i < numbers.length; i++) {
            int max= 0;
            int change_idx = 0;
            for (int j=i ; j < numbers.length; j++){
                if (numbers[j] > max){
                    max = numbers[j];
                    change_idx = j;
                }
            }
            //swap
            int temp = numbers[i];
            numbers[i] = max;
            numbers[change_idx] = temp;


        }

        for (int ans: numbers
             ) {
            System.out.printf(ans+"");
        }
    }

    // 내 풀이 틀렸다고 나옴 ;;;
    // max 의 값을 저장하는게 아니라 인덱스를 가져와서 swap 해야됨

    /*

        str ( 정렬할 수 )
        A 자리수로 구분해 저장한 배열
        for ( str 길이만큼 반복 )
            A 배열 저장 -> substring 사용

        for ( i : 0 ~ str 길이만큼 )
            for ( j : 1 ~ str 길이만큼 반복 )
                현재 범위에서 Max 값 찾기
            현재 i의 값과 Max 값 중 Max 값이 더 크면 swap 수행

        출력

    */


    // 선택 정렬
    public static void solution(){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int A[] = new int[str.length()];
        for (int i = 0; i < str.length() ; i++) {
            A[i] = Integer.parseInt(str.substring(i , i+1));
        }
        for (int i = 0; i <  str.length(); i++) {
            int max = i;
            for (int j = i+1; j < str.length(); j++){
                if (A[j] > A[max]){
                    max = j;
                }
            }
            if (A[i] < A[max]){
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for (int a: A
             ) {
            System.out.printf(a+"");
        }

    }

}
