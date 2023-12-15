import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Back1717UnionFind {

    static private int [] A;
    public static void main(String[] args) throws IOException {

        // 데이터 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);

         A = new int[n+1]; // 집합 init

        // 대표 노드 init 세팅
        for (int i = 0; i < n+1; i++) {
            A[i] = i;
        }

        StringBuffer sb = new StringBuffer();

        // m 번 동안의 연산
        for (int i = 0; i < m; i++) {
            s = br.readLine().split(" "); // idx 0 : 연산 1 : a  2 : b
            // 합집합 연산
            if (s[0].equals("0")){
                union(Integer.parseInt(s[1]) , Integer.parseInt(s[2]));
            }
            // find(a) == find(b) 인지
            else{
                // find(a) == find(b) 이면 YES 아니면 NO
                if (find(Integer.parseInt(s[1])) == find(Integer.parseInt(s[2]))){
                    sb.append("YES\n");
                }
                else{
                    sb.append("NO\n");
                }
            }
        }

        System.out.println(sb.toString());
    }

    // 유니온
    static void union( int a , int b ){
        int x = find(a);
        int y = find(b);
        int S = x <= y ? x : y;
        int B = S == x ? y : x;
        if (A[B] != S){
            A[B] = S;
        }
    }


    // 파인드

    static int find( int a ){
        int value = A[a] ;
        if (A[a] != a){
            find(A[a]);
        }
        return value;
    }

}
