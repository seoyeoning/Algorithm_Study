package programmers.게임맵최단거리;

import java.util.*;
public class test_bfs {

    static List<Integer>[] nodeList;
    static boolean[] visited;

    public static void main(String[] args) {
        int n = 6;
        int[][] node = {{1,2},{1,3},{2,4},{2,5}};

        nodeList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            nodeList[i] = new ArrayList<>();
        }

        visited = new boolean[n];

        // 무방향 저장
        for (int[] e : node) {
            nodeList[e[0]].add(e[1]);
            nodeList[e[1]].add(e[0]);
        }

        bfs(1);
    }

    static public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int now_node = queue.poll();
            System.out.print(now_node + " ");
            for (int i : nodeList[now_node]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
