import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Back12891 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String [] str_arr = br.readLine().split("");

        int[] acgt = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            acgt[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(S , P , str_arr , acgt));

    }


    public static int solution( int S , int P , String[] str_arr , int[] acgt){
        int answer = 0;

        int start_idx = 0;
        int end_idx = P-1; // 인덱스는 -1 해줘야함. 0 , 1 , 2 , .. , P-1 이 P 개임
        int[] acgt_check = new int[4]; // 첫번째 시도때 acgt에 맞게 몇개 나왔는지 확인

        String[] temp_arr = Arrays.copyOfRange(str_arr , start_idx , end_idx + 1); // 부분 배열 복제 <- to 가 번째로 인식함.

        for (String a: temp_arr
             ) {
            if (a.equals("A")){ acgt_check[0]++; }
            if (a.equals("C")){ acgt_check[1]++; }
            if (a.equals("G")){ acgt_check[2]++; }
            if (a.equals("T")){ acgt_check[3]++; }
        }

        if (acgt[0] <= acgt_check[0] &&
                acgt[1] <= acgt_check[1] &&
                acgt[2] <= acgt_check[2] &&
                acgt[3] <= acgt_check[3] ){  // 한개도 acgt 보다 작은게 없으면 비밀번호 채택
            answer++;
        }
        //  첫번째 시도 완료


        while (true){ // 두번째 시도 부터는 원본 배열의 값에서 start_idx ++ 하고 end_idx ++ 해서 agct_check 배열의 값들의 변경치로 계산
            end_idx++;
            if (end_idx == S ) { break; }

            if (str_arr[end_idx].equals("A")){ acgt_check[0]++; }
            if (str_arr[end_idx].equals("C")){ acgt_check[1]++; }
            if (str_arr[end_idx].equals("G")){ acgt_check[2]++; }
            if (str_arr[end_idx].equals("T")){ acgt_check[3]++; }

            if (str_arr[start_idx].equals("A")){ acgt_check[0]--; }
            if (str_arr[start_idx].equals("C")){ acgt_check[1]--; }
            if (str_arr[start_idx].equals("G")){ acgt_check[2]--; }
            if (str_arr[start_idx].equals("T")){ acgt_check[3]--; }

            start_idx++;



            if (acgt[0] <= acgt_check[0] &&
                    acgt[1] <= acgt_check[1] &&
                    acgt[2] <= acgt_check[2] &&
                    acgt[3] <= acgt_check[3] ){
                answer++;
            }
        }




        return answer;
    }

}
