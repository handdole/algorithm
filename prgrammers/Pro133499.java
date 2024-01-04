public class Pro133499 {

    public static void main(String[] args) {
        System.out.println(solution(new String[] { "aya", "yee", "u", "maa" } ));
        System.out.println(solution(new String[] { "ayaye", "uuu", "yeye", "yemawoo", "ayaayaa" } ));
        System.out.println(solution(new String[] { "woowoowoo", "ayamayaa", "yeye", "mamamama", "yewoomaayamaya" } ));
    }

    private static int solution(String[] babbling){
        int answer = 0 ;

        // babbling 요소 체크
        for (String temp_babbling : babbling
             ) {
            String checkString = temp_babbling ;
            // 연속된 발음을 힘들어함. 있으면 바로 패스
            if (checkString.contains("ayaaya") || checkString.contains("yeye") || checkString.contains("woowoo") || checkString.contains("mama")){
                continue;
            }
            // 각 옹알이 단어 빈칸으로 대체
            // ayamayaa 이런 예시라면 "".equals() 함수로 매칭할 수 없다.
            // 따라서 공백을 넣고 blank 로 쇼부
            checkString = checkString.replace("aya" , " ").replace("ye" , " ")
                    .replace("woo" , " ").replace("ma" , " ");

            // 빈칸인 단어 count
            if (checkString.isBlank()){
                answer++;
            }
        }

        return answer;
    }



}
