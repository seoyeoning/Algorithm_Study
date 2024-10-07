package baekjoon.BJ_2468;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상우하좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[][] board = new Node[N][N];
        boolean[][] visited = new boolean[N][N];

        int max_depth = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int depth = Integer.parseInt(st.nextToken());
                max_depth = Math.max(max_depth, depth);
                board[i][j] = new Node(i, j, depth);
            }
        }

        int max_area = 0;
        int safe_area = 0;

        // i가 0부터 시작이어야 함 (비가 안 오는 경우)
        for (int i = 0; i <= max_depth; i++) {

            for (Node[] nodes : board) {
                for (Node node : nodes) {
                    if (node.d <= i) visited[node.r][node.c] = true;
                }
            }

            // dfs 풀이
//            for (Node[] nodes : board) {
//                for (Node node : nodes) {
//                    if (!visited[node.r][node.c]) {
//                        safe_area++;
//                        dfs(node, board, visited);
//                    }
//                }
//            }

            // bfs 풀이
            for (Node[] nodes : board) {
                for (Node node : nodes) {
                    if (!visited[node.r][node.c]) {
                        safe_area++;
                        bfs(node, board, visited);
                    }
                }
            }

            max_area = Math.max(max_area, safe_area);
            safe_area = 0;
            visited = new boolean[N][N];

        }



        System.out.println(max_area);


    }

    static void dfs(Node now_node, Node[][] board, boolean[][] visited) {
        visited[now_node.r][now_node.c] = true;

        for (int i = 0; i < 4; i++) {

            int next_r = now_node.r + dr[i];
            int next_c = now_node.c + dc[i];

            if (next_r < 0 || next_r > board.length - 1 || next_c < 0 || next_c > board.length - 1) continue;

            if (visited[next_r][next_c]) continue;

            dfs(new Node(next_r, next_c, board[next_r][next_c].d), board, visited);

        }

    }

    static void bfs(Node now_node, Node[][] board, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(now_node);
        visited[now_node.r][now_node.c] = true;

        while (!queue.isEmpty()) {

            Node now = queue.poll();

            for (int i = 0; i < 4; i++) {

                int next_r = now.r + dr[i];
                int next_c = now.c + dc[i];

                if (next_r < 0 || next_r > board.length - 1 || next_c < 0 || next_c > board.length - 1) continue;

                if (visited[next_r][next_c]) continue;

                queue.offer(new Node(next_r, next_c, board[next_r][next_c].d));
                visited[next_r][next_c] = true;


            }
        }

    }

}

class Node {
    int r;
    int c;
    int d;

    Node(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
