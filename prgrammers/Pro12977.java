public class Pro12977 {

    /*
     프로그래머스
     https://school.programmers.co.kr/learn/courses/30/lessons/12977

     재귀 함수
        param ( int []nums , int start_idx , int set_idx , int answer )

        int sum
        for ( i = start_idx ; i < nums.len - start_idx - 2 ; i++ )
            sum = num[start_idx] + num[start_idx+1] + num[start_idx + 2]
     */
    public static void main(String[] args) {
        System.out.printf(solution(new int[] {1,2,3,4}) + "");
    }


    public static int solution( int[] nums){
        int sum = 0;
        int c1 = 0;
        int c2 = 0;
        int c3 = 0;
        int answer = 0;
        boolean flag = false;

        for (int i = 0; i < nums.length; i++) {
            c1 = nums[i];
            for (int j = i+1; j < nums.length; j++) {
                c2 = nums[j];
                for (int k = j+1; k < nums.length ; k++) {
                    flag = false;
                    c3 = nums[k];
                    sum = c1+c2+c3;
                    for (int a = 2; a < sum; a++) {
                        if (sum % a == 0){
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) answer++;
                }
            }
        }

        return answer;
    }



}
