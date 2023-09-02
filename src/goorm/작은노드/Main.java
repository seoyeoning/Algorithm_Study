package goorm.작은노드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int visited_node_num = 1;
    static List<Integer> visited_node = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 노드 수
        int M = Integer.parseInt(st.nextToken()); // 간선 수
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N+1];
        boolean[] visited = new boolean[N + 1];
        for (int i = 0; i < N+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        // 인접 리스트 오름차순 정렬
        for (int i = 0; i < N + 1; i++) {
            Collections.sort(list[i]);
        }

        System.out.println(Arrays.toString(list));

        dfs(K, list, visited);

//        System.out.println(visited_node_num);
        System.out.println(visited_node);
//        System.out.println(visited_node.get(0));

        System.out.println(visited_node_num + " " + visited_node.get(0));

//        for (int b : list[2]) {
//            System.out.println(b);
//        }

    }

    public static void dfs(int node, ArrayList<Integer>[] list, boolean[] visited) {

        visited[node] = true;

        int count = 1;

        for (int next_node : list[node]) {
            if (!visited[next_node] && count == 1){
//                System.out.println("nexe_node : " + next_node );
                visited_node_num++;
                count--;
                dfs(next_node,list,visited);
            }
        }
        visited_node.add(node);
    }


}
