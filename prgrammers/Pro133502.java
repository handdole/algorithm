import java.util.ArrayList;
import java.util.List;

public class Pro133502 {
    public static void main(String[] args) {


    }

    private static int solution2(int[] ingredient) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for( int a : ingredient ){
            list.add(a);

            while( list.size() >= 4 ){
                int idx = list.size();
                if( list.get( idx -1 ) == 1
                        && list.get(idx - 2 ) == 3
                        && list.get(idx - 3 ) == 2
                        && list.get(idx - 4 ) == 1){
                    answer++;
                    list.remove(idx-1);
                    list.remove(idx-2);
                    list.remove(idx-3);
                    list.remove(idx-4);
                }
                else{
                    break;
                }
            }
        }

        return answer;
    }

    private static int solution(int[] ingredient) {
        int answer = 0;
        StringBuffer sb = new StringBuffer();
        // 원래 있던 재료 모음
        String source = "";
        // 핸버거 만든 후 있는 재료 모음
        String rSource = "";

        // 재료 모음 배열을 String 으로 변환
        for ( int temp : ingredient) {
            sb.append(String.valueOf(temp));
        }

        source = sb.toString();

        //대체 했는데 길이 변화가 없을 경우 -> 햄버거를 못 만든다.
        while( true ) {
            // 1231 순으로 햄버거 완성
            rSource = source.replace("1231" , "");

            // 길이가 다르다 -> 변화가 있다. -> 햄버거를 만들었다.
            if ( source.length() != rSource.length() ){
                answer += ( source.length() - rSource.length() ) / 4;
                source = rSource;
                rSource = "";
            }
            else{
                break;
            }
        }

        return answer;
    }
}
