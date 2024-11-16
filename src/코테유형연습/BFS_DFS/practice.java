package 코테유형연습.BFS_DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import javax.management.Query;

public class practice {

    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.get(s).add(e);
            list.get(e).add(s);
        }

        for (ArrayList<Integer> integers : list) {
            Collections.sort(integers);
        }

        dfs(start);

    }

    public static void dfs(int node) {
        System.out.println(node);

        visited[node] = true;

        for (Integer integer : list.get(node)) {
            if (!visited[integer]) {
                dfs(integer);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (true) {
            int nowNode = queue.poll();

            System.out.println(node);

            for (Integer integer : list.get(nowNode)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    queue.offer(integer);
                }
            }
        }
    }

}
