package 이코테.BFS_DFS.음료수얼려먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 북,동,남,서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    static boolean[][] visited;
    static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
//                    dfs(i, j, board);
                    bfs(i, j, board);
                    result++;
                }
            }
        }

        System.out.println(result);


    }

    public static void dfs(int now_r, int now_c, int[][] board) {
        visited[now_r][now_c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = now_r + dr[i];
            int nc = now_c + dc[i];

            if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board[0].length - 1) {
                continue;
            }
            if (visited[nr][nc] || board[nr][nc] == 1) {
                continue;
            }

            dfs(nr, nc, board);

        }
    }

    public static void bfs(int now_r, int now_c, int[][] board) {
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(now_r, now_c));
        visited[now_r][now_c] = true;

        while (!queue.isEmpty()) {
            Node now_node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now_node.r + dr[i];
                int nc = now_node.c + dc[i];

                if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board[0].length - 1) {
                    continue;
                }
                if (visited[nr][nc] || board[nr][nc] == 1) {
                    continue;
                }

                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc));

            }


        }




    }

}

class Node {

    int r;
    int c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }

}
