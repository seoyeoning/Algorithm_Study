package programmers.네트워크;

import java.util.*;

class success_bfs {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers1 = {{1,1,0},{1,1,0},{0,0,1}};
        int[][] computers2 = {{1,1,0},{1,1,1},{0,1,1}};

        long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        System.out.println(beforeTime);
        System.out.println(solution(n,computers1));

        long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
        System.out.println(afterTime);
        long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
        System.out.println("시간차이(m) : "+secDiffTime);
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                bfs(i, computers, visited);
            }
        }
        return answer;
    }

    public static void bfs(int start, int[][] computers, boolean[] visited) {
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {
            int now_node = q.poll();
            int[] check = computers[now_node];
            for (int i = 0; i < check.length; i++) {
                if (i == start) continue;
                if (!visited[i] && check[i] == 1) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }
}