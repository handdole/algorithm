import java.util.Stack;

public class Pro64061 {

    public static void main(String[] args) {
        solution(new int [][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}} , new int[] {1,5,3,5,1,2,1,4} );
    }

    static int solution( int [][] board , int[] moves ){
        int answer = 0;

        Stack<Integer> baguni = new Stack<>();

        for (int i = 0; i < moves.length; i++) {
            int sero = moves[i]-1;
            for (int j = 0; j < board.length; j++) {
                int doll = board[j][sero];
                if (doll != 0){
                    if (!baguni.isEmpty()){
                        if (baguni.peek() == doll){
                            baguni.pop();
                            answer+=2;
                        }
                        else {
                            baguni.push(doll);
                        }
                    }
                    else {
                        baguni.push(doll);
                    }
                    board[j][sero] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    static int solution1( int [][] board , int[] moves ){
        int answer = 0;

        Stack<Integer> baguni = new Stack<Integer>();
        baguni.push(0);

        for (int i = 0; i < moves.length; i++) {
            int sero = moves[i]-1;
            for (int j = 0; j < board.length; j++) {
                int doll = board[j][sero];
                if (doll != 0){
                    if (baguni.peek() == doll){
                        baguni.pop();
                        answer += 2;
                    }
                    else {
                        baguni.push(doll);
                    }
                    board[j][sero] = 0;
                    break;
                }
            }
        }
        return answer;
    }


}
