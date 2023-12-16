import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Back2252TopologicalSortingDoIt {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 학생 수만큼 인접 리스트 init
        ArrayList<Integer>[] A = new ArrayList[N+1];
        for (int i = 0; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }
        // 진입 차수 배열 init
        int[] indegree = new int[N+1];

        // for 학생수 만큼
        for (int i = 0; i < M; i++) {
            int S = sc.nextInt();
            int E = sc.nextInt();
            // 인접 리스트 데이터 저장
            A[S].add(E);
            // 진입 차수 배열 초기 데이터 저장
            indegree[E]++;
        }

        // 큐 생성
        Queue<Integer> que = new LinkedList<>();

        // for 학생수
        for (int i = 1; i <= N; i++) {
            // 진입 차수 배열의 값이 0 인 학생을 큐에 삽입
            if (indegree[i] == 0){
                que.add(i);
            }
        }

        //while 큐가 빌 때까지
        while (!que.isEmpty()){
            // 현재 노드 = 큐에서 데이터 poll
            int now = que.poll();
            // 현재 노드값 출력
            System.out.printf(now + " ");
            // for 현재 노드에서 갈 수 있는 노드의 개수
            for (int next : A[now] ) {
                // 타깃 노드 진입 차수 배열 --
                indegree[next]--;
                // if 타깃 노드의 진입 차수가 0 이면
                if (indegree[next] == 0){
                    // 큐에 타깃 노드 추가
                    que.add(next);
                }
            }
        }
    }

}
