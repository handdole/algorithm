package Lv1;

import java.util.Arrays;

public class Pro42576 {
    public static void main(String[] args) {
        //solution(new String[]{"leo", "kiki", "eden"} , new String[]{"eden", "kiki"} );/
        solution(new String[]{"mislav", "stanko", "mislav", "ana"} , new String[]{"stanko", "ana", "mislav"} );
    }

    /*

    어째든 시간 복잡도를 줄이긴 위해서는
    for 문을 제일 적게 쓰는게 맞다...

    */

    static String solution ( String[] participant , String[] completion ) {
        String answer = "";

        Arrays.sort(participant);
        Arrays.sort(completion);


        int i;
        for (i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])){
                break;
            }
        }

        answer = participant[i];


        return answer;

    }

}
