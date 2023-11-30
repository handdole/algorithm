import java.util.Scanner;

public class Back1546 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = sc.nextInt();

        //String[] str_score_arr = sc.next().split(" ");

        int [] score_arr = new int[cnt];

        for (int i = 0; i < score_arr.length ; i++) {
            score_arr[i] = Integer.parseInt(sc.next());
        }

        System.out.println(solution(cnt , score_arr ));

    }

    public static double solution( int cnt , int[] score_arr ){
        int max_score = 0;

        for (int i = 0; i < score_arr.length; i++) {
            if (max_score < score_arr[i]){
                max_score = score_arr[i] ;
            }
        }

        double answer = 0.0;

        for (int i = 0; i < score_arr.length; i++) {
            answer += score_arr[i] * 100 / (double) max_score;
        }



        return answer / cnt;
    }

}
