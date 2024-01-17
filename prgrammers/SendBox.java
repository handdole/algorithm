public class SendBox {

    public static void main(String[] args) {

        int n = 100000;
        int answer = 0;

        // 피보나치 수 배열생성
        int[] fi = new int[100001];

        // init
        fi[0] = 0;
        fi[1] = 1;

        // for 문을 통해 피보나치 수 배열에 저장
        for( int i = 2; i < fi.length ; i++ ){
            fi[i] = fi[i-1] + fi[i-2];
        }

        System.out.println("fi[100000] : " + fi[100000]);
        System.out.println("fi[80400] : " + fi[80400]);
        System.out.println("fi[90000] : " + fi[90000]);
        System.out.println("fi[70000] : " + fi[70000]);

        // n번째 피보나치 수 1234567 로 나눈 나머지 구하기
        answer = (fi[n] % 1234567);
        System.out.println(answer);

    }

    public static int solution(int n) {
        int answer = 0 ;

        return answer;
    }

    public static int solution1(int n) {
        int answer = n+1;

        // n의 다음 큰 숫자는
        // 1. n 보다 큰 자연수 <- for 문을 n+1 부터 실행
        // 2. n을 2진수로 변환 했을 때 1의 갯수가 같음. <- n 의 1의 개수 == next 의 1의 개수
        // 3. 조건 1 , 2 를 만족 하는 수 중 가장 작은 수  <- for문으로 돌려서 제일 먼저 나온 수 채택

        // 이진 변환 했을 때의 1의 개수 저장하는 변수
        int nOneCnt = 0;
        int nextOneCnt = 0;

        // 반복문 들어가기전 1이 한개인 숫자들 우선 체크
        // 1,000,000 이하 중 제일 큰 2의 n제곱의 수는 20이다.
        // 2의 21승 만큼 while 문이 돌아가야하기 때문에 2의 k승과 n 이 같을경우 2의 k+1 을 다음 큰수로 반환
        // int 는 2의 31승 만큼이 최대 값임
        for( int i = 0 ; i <= 31 ; i ++ ){
            // 1의 개수가 1개인 케이스
            if( n == Math.pow( 2 , i ) ){
                return (int) Math.pow( 2 , i + 1 );
            }

            if( n < Math.pow( 2 , i ) ) break;
        }

        // 위 1,2,3 조건이 만족하면 break 로 탈출~
        while(true){

            // n의 이진수 String 저장
            String nBinary = Integer.toBinaryString(n);
            // n 의 이진수 1의 개수 저장
            nOneCnt = nBinary.length() - nBinary.replace("1" , "").length();

            // 예비 다음수에 대한 이진수 String 저장
            String ansBinary = Integer.toBinaryString(answer);
            // 예비 다음수의 이진수 1의 개수 저장
            nextOneCnt = ansBinary.length() - ansBinary.replace("1" , "").length();

            System.out.println("nOneCnt [ " + nOneCnt + " ] nextOneCnt [ " + nextOneCnt + " ] nBinary [ " + nBinary + " ] ansBinary [ " + ansBinary + " ] ");

            // 조건 2가 만족될 경우 다음 큰 숫자 확정
            if( nOneCnt == nextOneCnt ){
                break;
            }

            // 아닐 경우 +1 하여 확인
            answer++;
        }

        return answer;
    }


}
