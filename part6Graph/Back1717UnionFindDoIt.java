import java.util.Scanner;

public class Back1717UnionFindDoIt {

    static int [] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // N  원소 개수 M 질의 개수
        int N = sc.nextInt();
        int M = sc.nextInt();
        // parent ( 대표 노드 저장 배열 )
        parent = new int[N+1];

        // 수열 배열 채우기
        // for N 만큼 반복
        for (int i = 0; i < N+1; i++) {
            // 대표 노드 자기 자신으로 init
            parent[i] = i;
        }

        // for M 만큼 반복
        for (int i = 0; i < M; i++) {
            int question = sc.nextInt();
            int a = sc.nextInt();
            int b = sc.nextInt();
            // if 0 이면 집합 합치기 - union
            if ( question == 0 ){
                union( a , b );
            }
            // else 같은 집합원소인지 확인하고 결과 값 출력
            else{
                if (checkSame(a , b)){
                    System.out.println("YES");
                }
                else {
                    System.out.println("NO");
                }
            }
        }
    }


    // union 연산
    private static void union( int a, int b ){
        a = find( a );
        b = find ( b );
        if ( a != b ) parent[b] = a; // 두개 연결
    }

    // find 연산
    private static int find( int a ){
        if ( a == parent[a]) return a; // 대표 노드와 index 값이 같다면
        // 다르면
        else{
            return parent[a] = find(parent[a]); // 재귀함수 빠져 나가면서 update 쳐주는 방식
        }
    }

    // checkSame 두 원소 가 같은 집합 인지 확인
    private static boolean checkSame( int a , int b ){
        a = find(a);
        b = find(b);
        return a == b ? true : false;
    }

}
