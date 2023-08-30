package goorm.발전기;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] board = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1 && !visited[i][j]) {
                    result++;
                    dfs(i, j, board, visited);
                }
            }
        }

        System.out.println(result);

    }

    public static void dfs(int r, int c, int[][] board, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board.length - 1) continue;

            if (board[nr][nc] == 1 && !visited[nr][nc]) {
                dfs(nr, nc, board, visited);
            }
        }
    }

}
