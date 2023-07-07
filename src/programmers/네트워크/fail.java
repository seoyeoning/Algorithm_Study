package programmers.네트워크;

import java.util.*;

class fail {
    static int count = 0;

    public static void main(String[] args) {
        int n = 3;
        int[][] computers1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] computers2 = {{1,1,0},{1,1,1},{0,1,1}};

        System.out.println(solution(n,computers1));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];
        System.out.println("처음 visited");
        System.out.println(Arrays.toString(visited));
        System.out.println();

        dfs(0,computers, visited);
        System.out.println();
        System.out.println("dfs 후 visited");
        System.out.println(Arrays.toString(visited));
        answer = count;
        return answer;
    }

    public static void dfs(int start, int[][] computers, boolean[] visited) {
        visited[start] = true;

        System.out.println("current_node: " + start);
        int[] check = computers[start];
        for(int i=0; i < check.length; i++) {
            if(i == start) continue;
            if(!visited[i] && check[i] == 1) {
                dfs(i,computers, visited);
            }
        }
    }
}
