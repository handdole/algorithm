import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Back3197 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] hosu = new String[R][C];

        for (int i = 0; i < hosu.length; i++) {
            String [] temp = br.readLine().split("");
            for (int j = 0; j < hosu[i].length; j++) {
                hosu[i][j] = temp[j];
            }
        }




    }




}
