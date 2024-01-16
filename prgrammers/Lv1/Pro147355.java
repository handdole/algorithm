package Lv1;

public class Pro147355 {

    public static void main(String[] args) {
        System.out.println(solution("3141592" , "271"));
        System.out.println(solution("500220839878" , "7"));
        System.out.println(solution("10203" , "15"));

    }
    
    private static int solution( String t , String p ) {
        int answer = 0 ;

        long t_long = 0L;
        long p_long = Long.parseLong(p);

        //for 문 ( t 길이 - p 길이 만큼 )
        for (int i = 0; i <= t.length() - p.length() ; i++) {
            //p의 길이 만큼 t 배열 substring
            t_long = Long.parseLong(t.substring( i , p.length() + i ));
            //if t_int 가 p_int 보다 작거나 같다.
            if ( t_long <= p_long ) {
                answer ++ ; // count
            }
        }

        return answer;
    }


}
