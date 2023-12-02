import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Back2164 {
    /*
    슈도 코드

    큐 생성
    큐에 숫자 넣기 1 부터 N 까지
    while ( queue.size == 1 )
        poll() ← 제일 위에있는 카드 바닥에 버림
        int temp = poll() ← 제일 위에 있는 카드를
        add(temp) ← 밑으로 옮김
    마지막 남은 값 출력
    */
    public static void main(String[] args) {

        Queue<Integer> que = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 1; i <= N ; i++) {
            que.add(i);
        }

        while (que.size() != 1) {
            que.poll();
            int temp = que.poll();
            que.add(temp);
        }

        System.out.println(que.poll());

    }




}
