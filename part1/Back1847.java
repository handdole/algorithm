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

        int stack_num = 1;
        Stack<Integer> stack = new Stack<Integer>();

        int[]arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int arr_idx = 0;


        stack.push(stack_num);

        String answer = "+";

        while(N != arr_idx){
            if (stack.empty()) { stack_num++; stack.push(stack_num);   answer += "+"; continue; } // empty 처리 잘 해야겠다..
            if (arr[arr_idx] > stack.peek()) { stack_num++; answer += "+"; stack.push(stack_num); continue; }
            if (arr[arr_idx] == stack.peek()){ arr_idx++; answer += "-"; stack.pop(); continue; }
            if (arr[arr_idx] < stack.peek()) { answer = "NO"; System.out.println("NO"); return; }
        }

        for (String a: answer.split("")
             ) {
            System.out.println(a);
        }


    }


}
