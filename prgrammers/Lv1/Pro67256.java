package Lv1;

import java.util.LinkedList;
import java.util.Queue;

public class Pro67256 {

    public static void main(String[] args) {
        System.out.printf(solution(new int[] { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2} , "left"));
    }

    static String solution( int[] numbers , String hand ){
        String answer = "";

        int r_node = 10; // *
        int l_node = 11; // #

        StringBuffer sb = new StringBuffer();

        int[][] graph = new int[12][12];
        graph = init(graph);




        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7){
                l_node = numbers[i];
                sb.append("L");
            }
            else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
                r_node = numbers[i];
                sb.append("R");
            }
            else{
                int target = numbers[i];
                int r_depth = BFS( r_node , target , graph );
                int l_depth = BFS( l_node , target , graph );
                if (r_depth > l_depth){
                    l_node = numbers[i];
                    sb.append("L");
                }
                else if (l_depth > r_depth){
                    r_node = numbers[i];
                    sb.append("R");
                }
                else{
                    if ("left".equals(hand)){
                        l_node = numbers[i];
                        sb.append("L");
                    }
                    else {
                        r_node = numbers[i];
                        sb.append("R");
                    }
                }
            }
        }


        return sb.toString();
    }

    static int BFS ( int start , int target , int[][] graph ){
        boolean[] visited = new boolean[12];
        Queue<Integer> que = new LinkedList<>();

        que.add(start); // BFS 전 세팅
        visited[start] = true; // 탐색 전 방문

        int depth = 0;

        while (!que.isEmpty()){
            int len = que.size();

            for (int q = 0; q < len; q++) {  // 여기에 que.size 하니까 변수가 계속 바뀐다;
                int remove_node = que.remove();
                if (remove_node == target ){
                    return depth;
                }
                for (int i = 0; i < graph.length; i++) {
                    if (!visited[i] && graph[remove_node][i] == 1){
                        que.add(i);
                        visited[i] = true;
                    }
                }
            }
            depth++;
        }

        return depth;
    }

    static int[][] init( int[][] graph ){
        graph = new int[12][12];
        graph[0][10] = 1;
        graph[0][11] = 1;
        graph[0][8] = 1;
        graph[1][2] = 1;
        graph[1][4] = 1;
        graph[2][1] = 1;
        graph[2][3] = 1;
        graph[2][5] = 1;
        graph[3][2] = 1;
        graph[3][6] = 1;
        graph[4][1] = 1;
        graph[4][5] = 1;
        graph[4][7] = 1;
        graph[5][2] = 1;
        graph[5][4] = 1;
        graph[5][6] = 1;
        graph[5][8] = 1;
        graph[6][3] = 1;
        graph[6][5] = 1;
        graph[6][9] = 1;
        graph[7][4] = 1;
        graph[7][8] = 1;
        graph[7][10] = 1;
        graph[8][5] = 1;
        graph[8][7] = 1;
        graph[8][9] = 1;
        graph[8][0] = 1;
        graph[9][6] = 1;
        graph[9][8] = 1;
        graph[9][11] = 1;
        graph[10][7] = 1;
        graph[10][0] = 1;
        graph[11][9] = 1;
        graph[11][0] = 1;
        return graph;
    }


}
