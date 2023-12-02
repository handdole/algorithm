import java.io.BufferedReader;
import java.util.Scanner;
import java.util.Stack;

public class Back1847 {


    /*
     *
     * stack_num = 1
     * arr { 4 3 6 8 7 5 2 1 }  + - + - +++
     * arr_idx = 0
     *
     * String answer = "";
     *
     * stack
     *
     * while()
     *
     *
     * stack_num = 1
     * arr <- 입력된 수열
     * arr_idx < 수열 index
     * String answer 선언
     * stack 선언
     *
     * while(stack_num != N + 1)
     *  stack.push( stack_num )
     *  arr[arr_idx] > stack.peek => stack_num++  , answer += "+"
     *  arr[arr_idx] == stack.peek => stack.pop , arr_idx++ , answer += "-"
     *  arr[arr_idx] < stack.peek => answer = "NO"
     *
     *
     *
     * stack.empty() <- 이거
     * 예시 )
     *  5
     *  1 2 3 4 5
     *
     *  +-+-+-+-
     *
     * */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[]A = new int[N];

        for (int i = 0; i < N ; i++) {
            A[i] = sc.nextInt();
        }
        Stack<Integer> stack = new Stack<>() ;

        int num = 1;

        StringBuffer bf = new StringBuffer();

        for (int i = 0; i < A.length ; i++) {
            int su = A[i];
            if (su >= num){
                while (su >= num) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                int n = stack.pop();
                if ( n > su ){
                    System.out.println("NO");
                    return;
                }
                else {
                    bf.append("-\n");
                }
            }
        }
        System.out.println(bf.toString());

    }


}
