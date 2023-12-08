import java.time.temporal.IsoFields;
import java.util.*;

public class Pro42576 {
    public static void main(String[] args) {
        //solution(new String[]{"leo", "kiki", "eden"} , new String[]{"eden", "kiki"} );/
        solution(new String[]{"mislav", "stanko", "mislav", "ana"} , new String[]{"stanko", "ana", "mislav"} );
    }

    static String solution ( String[] participant , String[] completion ) {
        String answer = "";

        List<String> list = new ArrayList<>(Arrays.asList(participant));

        for (String s: completion
             ) {
            list.remove(s);
        }

        for( String s : list){
            answer = s;
        }

        return answer;

    }

}
