import java.util.Scanner;

public class Back2750 {

    /*수도코드

    int N ← N 받기
    A[] ← 배열 생성
    boolean change;
    for( N 번 )
        A[i] = 받은 숫자

    for( i = A.len-1 ; i >0 ; i - - )
        change = false;
        for ( j = 0; j < i ; j++ )
            if ( A[j] > a[j+1] )
                int temp = A[j] ;
                A[j] = A[j+1] ;
                A[j+1] = temp;
                change = true;
        if ( !change )
            break;

    foreach
        sout( answer )*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        boolean change;

        for (int i = 0; i < N ; i++) {
            A[i] = sc.nextInt();
        }

        //버블 정렬
        for (int i = A.length -1 ; i > 0 ; i--) {
            change = false;
            for (int j = 0; j < i ; j ++ ){
                if (A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                    change = true;
                }
            }
            if (!change){
                break;
            }
        }

        for (int ans: A
             ) {
            System.out.println(ans);
        }

    }

    public static void another(){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int A[] = new int[N];

        for (int i = 0 ; i < N ; i++){
            A[i] = sc.nextInt();
        }

        // 버블 정렬
        for (int i = 0; i < N-1; i++) {
            for (int j =0 ; j < N - 1 - i ; j++){
                if (A[j] > A[j+1]){
                    int temp = A[j];
                    A[j] = A[j+1];
                    A[j+1] = temp;
                }
            }
        }
        for (int ans: A
             ) {
            System.out.println(ans);
        }


    }


}
