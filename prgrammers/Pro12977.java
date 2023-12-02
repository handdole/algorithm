public class Pro12977 {

    /*
     재귀 함수
        param ( int []nums , int start_idx , int set_idx , int answer )

        int sum
        for ( i = start_idx ; i < nums.len - start_idx - 2 ; i++ )
            sum = num[start_idx] + num[start_idx+1] + num[start_idx + 2]
     */
    public static void main(String[] args) {

        int sum = 0;
        int start_idx = 0;
        int set_idx = 0;
        int answer = 0;
        int [] nums = { 1 ,2 , 3 , 4 , 5 , 6};




    }
    /*

    문제
        주어진 숫자 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 함.
        숫자들이 들어있는 배열 nums 가 매개변수로 주어짐
        nums 에 있는 숫자들 서로 다른 3개 골라 더했을 때
        소수가 되는 경우의 개수 return

    제한 사항
        nums 에 들어있는 숫자의 개수는 3개 이상 50개 이하
        nums 의 각 원소는 1~1000 자연수 , 중복 숫자 x

    시간 복잡도
        50 * 49 * 48 이 1억번은 안넘음 ( 1초 미만 )
        nCr 구하는 알고리즘 적용해보자

        1 2 3 4 5 6
        1 2 3
        1 3 4
        1 4 5
        1 5 6 4번
        2 3 4
        2 4 5
        2 5 6 3번
        3 4 5
        3 5 6 2번
        4 5 6 1번

        len - start_idx - 2
        6 - 0 - 2
        6 - 1 - 2
        6 - 2 - 2
        6 - 3 - 1

    수도코드
        int answer
        int[] nums

        int r




    재귀 함수
        param ( int []nums , int start_idx , int set_idx , int answer )

        int sum
        for ( i = start_idx ; i < nums.len - start_idx - 2 ; i++ )
            sum = num[start_idx] + num[start_idx+1] + num[start_idx + 2]




     */


    public static int solution( int[] num){
        int answer = 0;


        return answer;
    }




}
