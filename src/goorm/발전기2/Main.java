package goorm.발전기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1,};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][N];
        Set<Integer> hs = new HashSet<>();
        boolean[][] visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                board[i][j] = x;
                hs.add(x);
            }
        }

        int danjiNum = 0;
        int maxDanjiNum = 0;
        int maxDanji = 0;
        for (Integer h : hs) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == h && !visited[i][j]) {
                        int buildingNum = bfs(i, j, h, board, visited);
                        if (buildingNum >= K) {
                            danjiNum++;
                        }
                    }
                }
            }
            if (danjiNum > maxDanjiNum) {
                maxDanjiNum = danjiNum;
                maxDanji = h;
            } else if (danjiNum == maxDanjiNum) {
                if (h > maxDanji) {
                    maxDanji = h;
                }
            }
            danjiNum = 0;
        }

        System.out.println(maxDanji);

    }

    public static int bfs(int r, int c, int homeNum, int[][] board, boolean[][] visited) {
        Queue<int[]> q = new LinkedList();
        q.add(new int[]{r, c});
        visited[r][c] = true;

        int buildingNum = 1;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now[0] + dr[i];
                int nc = now[1] + dc[i];

                if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board.length - 1) continue;

                if (board[nr][nc] == homeNum && !visited[nr][nc]) {
                    buildingNum++;
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
        }

        return buildingNum;

    }

}
