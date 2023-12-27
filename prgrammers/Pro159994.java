public class Pro159994 {


    public static void main(String[] args) {
        System.out.println(solution(new String[] {"want", "to"} , new String[] {"i", "water", "drink"} , new String[] {"i", "want", "to", "drink", "water"} ));
    }

    private static String solution(String[] cards1, String[] cards2, String[] goal){
        String answer = "Yes";

        int c1i = 0;
        int c2i = 0;
        boolean flag1 = false;
        boolean flag2 = false;

        for (int i = 0; i < goal.length; i++) {
            if (!flag1 && goal[i].equals(cards1[c1i])){
                c1i++;
                if (c1i >= cards1.length) flag1 = true;
            }
            else if (!flag2 && goal[i].equals(cards2[c2i])){
                c2i++;
                if (c2i >= cards2.length) flag2 = true;
            }
            else{
                answer = "No";
                break;
            }
        }
        return answer;
    }

    private static String solution1(String[] cards1, String[] cards2, String[] goal){
        String answer = "Yes";

        int c1i = 0;
        int c2i = 0;

        for (int i = 0; i < goal.length; i++) {
            // 두 카드 더미의 카드가 모두 있을 경우
            if (c1i < cards1.length && c2i < cards2.length ){
                // cards 1 , 2 두 배열의 맨 앞에 있는 카드가 goals 의 카드와 일치하지 않는다면
                if (!goal[i].equals(cards1[c1i]) && !goal[i].equals(cards2[c2i]) ){
                    answer = "No"; // 만들 수 없음
                    break;
                }
                else{
                    // 만약 카드 1번 더미와 같다면
                    if (goal[i] == cards1[c1i]){
                        c1i++; // 하나 추가
                    }
                    // 만약 카드 2번 더미와 같다면
                    if (goal[i] == cards2[c2i]){
                        c2i++;
                    }
                }
            }
            // 두 카드 더미 중 한개의 더미를 다 사용했을 경우
            else{
                // cards1 더미가 남아 있으면
                if (c1i < cards1.length ){
                    // cards2 의 카드와 같지 않은 경우
                    if (!goal[i].equals(cards1[c1i])){
                        answer = "No"; // 만들 수 없음
                        break;
                    }
                    // 같은 경우
                    else {
                        c1i++;
                    }
                }
                // cards2 더미가 남아있으면
                if (c2i < cards2.length ){
                    // cards1 의 카드와 같지 않은 경우
                    if (!goal[i].equals(cards2[c2i])){
                        answer = "No"; // 만들 수 없음
                        break;
                    }
                    // 같은 경우
                    else {
                        c2i++;
                    }
                }
            }
        }
        return answer;
    }

}
