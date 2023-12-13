import java.util.Scanner;

public class EulersPhiFunc {
    public static void main(String[] args) {

        // 오일러피 함수

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] Ns = new int[N+1]; // idx n 이 숫자 n 을 표현하도록

        for (int i = 0; i < Ns.length; i++) { // 숫자 배열에 삽입
            Ns[i] = i;
        }

        // 현재 배열의 값고 인덱스가 같으면 선택된 숫자 K의 배수에 해당하는 수를 배열 끝까지 탐색
        for (int i = 2; i < Ns.length ; i++) {
            if (Ns[i] == i){ // 배열의 값과 선택된 인덱스의 크기가 같을 경우
                // 선택된 값의 배수에 해당하는 수를  배열 끝까지 탐색하여 P[i] = P[i] - P[i] / (선택된 인덱스) 실행
                for (int j = i; j < Ns.length ; j = j + i) {
                    Ns[j] = Ns[j] - ( Ns[j] / i );
                }
            }
        }


        for (int i = 0; i < Ns.length; i++) {
            System.out.println( "P["+i+"]" + "  [ " + Ns[i] + " ] " );
        }


    }
}
