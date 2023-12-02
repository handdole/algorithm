import java.util.PriorityQueue;
import java.util.Scanner;

public class Back11286 {


    static class RealAbsNum implements Comparable<RealAbsNum>{
        private int real_value;
        private int abs_value;

        public RealAbsNum( int real_value , int abs_value ){
            this.real_value = real_value;
            this.abs_value = abs_value;
        }

        public int getReal_value(){
            return this.real_value;
        }

        public int getAbs_value(){
            return this.abs_value;
        }


        @Override
        public int compareTo(RealAbsNum o) {
            if (this.abs_value < o.getAbs_value()) return -1;
            if (this.abs_value > o.getAbs_value()) return 1;
            if (this.abs_value == o.getAbs_value()){
                if (this.real_value < o.getReal_value()) return -1; // 음수 리턴이면 오름차순
                if (this.real_value > o.getReal_value()) return 1; // 양수 리턴하면 내림차순
            }
            return 0;
        }
    }

    /*
        수도 코드

        클래스 생성
        비교 함수 절대값이 작으면 우선순위 갖도록
        -----
        우선순위 큐 생성  ← 절대값이 작은 것부터 우선순위 갖는 큐
        int N 입력되는 숫자 수
        string buffer 생성 ( 답 )
        for ( N만큼 )
            int number ← i 번째 수 받기
            if ( number == 0 )
                if ( que.poll() == null )
                    buffer = “0\n”
                else
                    buffer = que.poll().getRealValue() + “\n”
            else
                Number realAbsNum = new Number( number , | number | );
                que.add
        string buffer 출력

    */

    public static void main(String[] args) {
        PriorityQueue<RealAbsNum> que = new PriorityQueue<RealAbsNum>();

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < N; i++) {
            int number = sc.nextInt();
            if (number == 0 ){
                if (que.peek() == null){ // 첫번째 값 뭔지 확인 비워져 있으면 0 아니면 꺼내서 출력
                    sb.append("0\n");
                }
                else{
                    sb.append(que.poll().getReal_value() + "\n");
                }
            }
            else{
                RealAbsNum realAbsNum = new RealAbsNum( number , number > 0 ? number : -number );
                que.add(realAbsNum);
            }
        }
        System.out.printf(sb.toString());

    }





}
