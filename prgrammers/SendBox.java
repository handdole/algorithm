import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendBox {

    public static void main(String[] args) {
        Map<String , Integer> map = new HashMap<>();

        map.put("한솔1" , 23);
        map.put("한솔2" , 4);
        map.put("한솔3" , 2);
        map.put("한솔4" , 8);
        map.put("한솔5" , 10);
        map.put("한솔6" , 43);
        map.put("한솔7" , 251);
        map.put("한솔8" , 9);
        map.put("한솔9" , 74);
        map.put("한솔10" , 51);

        List<String> keyList = new ArrayList<>(map.keySet());

        // 오름 차순 ( default )
        keyList.sort((o1, o2) -> map.get(o1) - map.get(o2));

        // 내림 차순
        keyList.sort((o1, o2) -> ones(map.get(o2)) - ones(map.get(o1)) );

        keyList.stream().forEach(key -> System.out.println(map.get(key)));


        //System.out.println(ones(251));


    }

    /*
    * Param : int n
    * return : n 의 1의 자리 수
    *
    * */
    static int ones( int n ){
        if( n < 10 ){
            return n;
        }
        return ones( n % 10 );
    }


    /*
     * Param : int n
     * return : n 의 맨 앞자리 수
     *
     * */
    static int firsts( int n ){
        if( n < 10 ){
            return n;
        }
        return ones( n / 10 );
    }


}
