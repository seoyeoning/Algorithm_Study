package baekjoon.BJ_1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] list; // 인접리스트
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int  i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list[s].add(e);
            list[e].add(s);
        }

        for (ArrayList<Integer> integers : list) {
            Collections.sort(integers);
        }

        dfs_recursion(start);
//        dfs_stack(start);
        System.out.println();

        visited = new boolean[N+1]; // 방문 노드 초기화

        bfs(start);

    }

    static void dfs_recursion(int node) {

        System.out.print(node+" ");

        visited[node] = true;

        for (int i : list[node]) {
            if (!visited[i]) {
                dfs_recursion(i);
            }
        }
    }

    static void dfs_stack(int node) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);

        while (!stack.isEmpty()) {
            int nowNode = stack.pop();
            if (!visited[nowNode]) {
                System.out.print(nowNode+" ");
                visited[nowNode] = true;
            }
            for (int i = list[nowNode].size() - 1; i >= 0; i--) {
                int nextNode = list[nowNode].get(i);
                if (!visited[nextNode]) {
                    stack.push(nextNode);
                }
            }
        }
    }

    static void bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int nowNode = queue.poll();

            System.out.print(nowNode+" ");

            for (int i : list[nowNode]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

}


