package Lv1;

import java.util.HashMap;

public class Pro176963 {
    public static void main(String[] args) {

    }

    private static int[] solution( String[] name, int[] yearning, String[][] photo ){
        int[] answer = new int[photo.length];

        HashMap<String , Integer> map = new HashMap<>();

        // 두 배열 hashmap 으로 연관성 맺어주기
        for (int i = 0; i < name.length; i++) {
            map.put(name[i] , yearning[i]);
        }

        for (int i = 0; i < photo.length; i++) {
            for (String N : photo[i]
                 ) {
                if (map.containsKey(N)){
                    answer[i] = answer[i] + map.get(N);
                }
            }
        }
        return answer;
    }


}
