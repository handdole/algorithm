public class Pro72410 {
    private static String solution(String new_id) {
        String answer = "";

        // 1단계 new_id 의 모든 대문자를 대응하는 소문자로 치환
        new_id = new_id.toLowerCase();

        // 2단계 new_id 에서 알파벳 소문자 , 숫자 , 빼기 , 밑줄 , 마침표를 제외한 모든 문자 제거
        new_id = new_id.replaceAll("[^a-z\\d\\-_.]" , "");

        //3단계 new_id에서 마침표가 두 번 이상 연속된 부분을 하나의 마침표로 치환
        while( new_id.contains("..") ){
            new_id = new_id.replace(".." , ".");
        }

        // 4단계 new_id 에서 마침표가 처음이나 끝에 위치한다면 제거
        if( new_id.startsWith(".")){
            new_id = new_id.substring( 1 , new_id.length());
        }
        if( new_id.endsWith(".")){
            new_id = new_id.substring( 0 , new_id.length() - 1 );
        }

        // 5단계 new_id 가 빈 문자열이라면 , new_id 에 "a"를 대입
        if(new_id.isEmpty()){
            new_id = "a";
        }

        // 6단계 new_id 의 길이가 16자 이상이면 , new_id 의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거
        // 만약 제거 후 마침표가 new_id 의 끝에 위치한다면 위치한 마침표 문자를 제거
        if( new_id.length() >= 16 ){
            new_id = new_id.substring( 0 , 15 );
            if( new_id.lastIndexOf(".") == new_id.length() - 1) {
                new_id = new_id.substring( 0 , new_id.length() - 1 );
            }
        }

        //7단계 new_id 의 길이가 2자 이하라면 , new_id의 마지막 문자를 new_id의 길이가 3이 될때까지 반복
        while( new_id.length() <= 2 ){
            new_id = new_id + new_id.charAt(new_id.length() - 1);
        }

        answer = new_id;

        return answer;
    }
}
