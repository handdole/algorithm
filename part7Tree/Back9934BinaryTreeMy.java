import java.io.*;

public class Back9934BinaryTreeMy {

    private static int[] B;
    private static int K;
    private static boolean [] V;
    private static BufferedReader br;
    private static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));

        // depth
        K = Integer.parseInt(br.readLine());

        B = new int[(int) Math.pow(2 , K)]; // 이진 트리 배열
        V = new boolean[(int) Math.pow(2 , K)]; // 방문 배열

        int loc_idx = 1; // root 노드에 위치
        int input_idx = 0; //

        String[] s = br.readLine().split(" ");
        while (true){

            // 현재 빌딩의 왼쪽 자식에 있는 빌딩에 아직 들어가지 않았으면
            if (B[ 2 * loc_idx] == 0){
                // 왼쪽 자식으로 이동
                loc_idx = 2*loc_idx;
            }
            // 현재 있는 노드가 왼쪽 자식을 가지고 있지 않거나 왼쪽 자식에 있는 빌딩을 이미 들어갔다면
            if (2*loc_idx < (int) Math.pow(2 , K-1) || B[2*loc_idx] != 0 ){
                // 현재 노드에 있는 빌딩을 들어가고 번호를 적는다
                B[loc_idx] = Integer.parseInt(s[input_idx++]); // input_idx 증가
                // 주어진 노드 키의 개수 보다 크면
                if (input_idx > s.length){
                    // 반복문 종료
                    break;
                }
            }
            // 현재 빌딩을 이미 들어갔다 온 상태이고 , 오른쪽 자식을 가지고 있는 경우
            if (B[loc_idx] != 0 && 2*loc_idx + 1 < (int) Math.pow( 2 , K)){
                // 오른쪽 자식으로 이동
                loc_idx = 2*loc_idx + 1;
            }
            // 왼쪽 오른쪽 자식에 있는 빌딩을 모두 방문했다면
            if (( B[2*loc_idx] != 0 && B[2*loc_idx+1] != 0) || 2*loc_idx < (int) Math.pow( 2 , K )){
                // 부모 노드로 이동
                loc_idx = loc_idx / 2 ;
            }
        }

        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i <= B.length ; i++) {
            for (int j = i-1; j < (int) Math.pow( 2, j ); j++) {
                bw.write(B[i] + " ");
            }
            bw.write("\n");
        }

        bw.flush();

        bw.close();
        br.close();


    }

}
