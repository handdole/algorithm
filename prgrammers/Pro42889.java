import java.util.ArrayList;
import java.util.Comparator;
import java.util.UUID;

public class Pro42889 {

    public static void main(String[] args) {

        System.out.println(solution(5 , new int[]{4 , 4 , 4 , 4  ,4 }));

    }

    private static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        int [] stayPlayerCnts = new int[N+2];
        ArrayList<Obj> list = new ArrayList<Obj>();

        int sumP = 0; // 스테이지에 도달한 플레이어 수

        // stayPlayer 값 세팅 ( idx 는 스테이지 의미 , 각 원소는 해당 인덱스 스테이지에 머물러 있는 user의 수 )
        for (int i = 0; i < stages.length; i++) {
            stayPlayerCnts[stages[i]]++;
        }



        for (int i = 1; i < N+1; i++) {
            int stayPlayerCnt = stayPlayerCnts[i];
            list.add(new Obj( i , Double.isNaN( (double)  stayPlayerCnt / ( stages.length - sumP ) ) ? 0.0 : (double)  stayPlayerCnt / ( stages.length - sumP ) ));
            sumP = sumP + stayPlayerCnt;
        }

        list.sort(Comparator.comparing(Obj::getFail_rate).reversed().thenComparing(Obj::getStage));

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).getStage();
        }

        return answer;
    }

    private static class Obj {
        int stage;
        double fail_rate;

        public int getStage() {
            return stage;
        }

        public void setStage(int stage) {
            this.stage = stage;
        }

        public double getFail_rate() {
            return fail_rate;
        }

        public void setFail_rate(double fail_rate) {
            this.fail_rate = fail_rate;
        }

        public Obj(int stage, double fail_rate) {
            this.stage = stage;
            this.fail_rate = fail_rate;
        }

    }



}
