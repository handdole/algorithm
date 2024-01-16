package Lv1;

public class Pro131128 {
    public static void main(String[] args) {
        System.out.println(solution("1000000000000" , "210000000000"));
        System.out.println(solution("100" , "203045"));
        System.out.println(solution("100" , "123450"));
        System.out.println(solution("12321" , "42531"));
        System.out.println(solution("5525" , "1255"));
    }

    private static String solution(String X, String Y) {
        StringBuffer answer = new StringBuffer();

        // 각 문자열에 0~9이 몇개 있는지 확인하는 배열
        int cntIntX [] = new int[10];
        int cntIntY [] = new int[10];

        // 문자열 배열 화
        String[] x = X.split("");
        String[] y = Y.split("");

        // 각각 자리별 숫자 확인 후 배열에 삽입
        for (int i = 0; i < x.length ; i++) {
            cntIntX[Integer.parseInt(x[i])]++;
        }

        for (int i = 0; i < y.length ; i++) {
            cntIntY[Integer.parseInt(y[i])]++;
        }

        // 9 부터 0 순으로 채워 넣음
        for (int i = 9; i >= 0; i--) {

            // 둘 중 하나가 다 줄어들 때 까지 진행
            while (cntIntX[i] >= 1 && cntIntY[i] >= 1){
                // 앞에 붙이고 -1 씩
                answer.append(i);

                cntIntX[i]--;
                cntIntY[i]--;
            }
        }

        // 짝궁이 없는 case 처리
        if ("".equals(answer.toString())) return "-1";
        // 짝이 0이 하나 이상인 case 처리
        // 0이 하나 이상이다 즉 , 제일 앞 자리 문자열이 0 이다 .
        else if (answer.toString().startsWith("0")) return "0";
        else return answer.toString();
    }


}
