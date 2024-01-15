public class gugudan {

    public static void main(String[] args) {

        String a = "123456789";
        StringBuffer sb = new StringBuffer(a);

        sb.deleteCharAt(3);
        sb.insert(3 , " ");


        System.out.println(sb.toString());


    }

    public static String solution(String s) {
        String answer = "";

        // 첫 문자가 대문자여야 하기 때문에 나머지 문자는 다 소문자로 치환
        s = s.toLowerCase();

        for( int i = 0; i < s.length() ; i++ ){


        }

        return answer;
    }

}
