package goorm.연합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.SyncFailedException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];

        // 인접 리스트 초기화
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }

//        for (ArrayList<Integer> integers : list) {
//            System.out.println(integers);
//        }
        boolean[] visited = new boolean[N + 1];

        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                result++;
                bfs(i,list,visited);
            }
        }

        System.out.println(result);
    }

    public static void bfs(int node, ArrayList<Integer>[] list, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[node] = true;
        q.add(node);

        while (!q.isEmpty()) {
            int now = q.poll();

            for (int nextNode : list[now]) {
                boolean team = false;
                for (int againNode : list[nextNode]) {
                    if (againNode == now) team = true;
                }

                if (team && !visited[nextNode]) {
                    visited[nextNode] = true;
                    q.add(nextNode);
                }
            }

        }


    }
}
