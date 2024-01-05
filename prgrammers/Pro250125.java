public class Pro250125 {
    public static void main(String[] args) {

    }

    private static int solution(String[][] board, int h, int w) {
        int answer = 0;
        // 1번
        int n = board.length;
        // 2번
        int count = 0;

        //3번
        int[] dh = { 0 , 1 , -1 , 0 };
        int[] dw = { 1 , 0 , 0 , -1 };

        //4번
        for( int i = 0 ; i < 4 ; i ++ ){
            int h_check = h + dh[i];
            int w_check = w + dw[i];

            if( h_check >= 0 && h_check < n && w_check >= 0 && w_check < n ){
                if( board[h][w].equals(board[h_check][w_check])){
                    count++;
                }
            }
        }
        answer = count;
        return answer;
    }

}
