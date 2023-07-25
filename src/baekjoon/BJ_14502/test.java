package baekjoon.BJ_14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int max_safe = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[][] labo = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                labo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int[] ints : labo) {
            System.out.println(Arrays.toString(ints));
        }

        boolean[][] visited = new boolean[R][C];

//        comb(labo, 0, 3, R, C, visited);

        labo[1][0] = 1;
        labo[0][1] = 1;
        labo[3][5] = 1;
        System.out.println("**");
        for (int[] ints : labo) {
            System.out.println(Arrays.toString(ints));
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (labo[i][j] == 2) {
                    dfs(labo, i, j, visited);
                }
            }
        }
        System.out.println("**");
        for (int[] ints : labo) {
            System.out.println(Arrays.toString(ints));
        }

        int safe = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (labo[i][j] == 0 && !visited[i][j]) {
                    labo[i][j] = 8;
                    safe++;
                }
            }
        }

        System.out.println(safe);
    }

    static void comb(int[][] labo, int start, int depth, int R, int C, boolean[][] visited) {
        if (depth == 3) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (labo[i][j] == 2) {
                        dfs(labo, i, j, visited);
                    }
                }
            }
            int safe = 0;
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (labo[i][j] == 0 && !visited[i][j]) {
                        safe++;
                    }
                }
            }

            max_safe = Math.max(max_safe, safe);
        }

        for (int i = 0; i < R*C; i++) {
            int r = i / C;
            int c = i % C;

            if (labo[r][c] == 0) {
                labo[r][c] = 1;
                comb(labo, i + 1, depth + 1, R, C, visited);
                labo[r][c] = 0;
            }
        }
    }

    static void dfs(int[][] labo, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr > labo.length - 1 || nc < 0 || nc > labo[0].length - 1) continue;

            if (labo[nr][nc] == 0 && !visited[nr][nc]) {
                labo[nr][nc] = 2;
                dfs(labo, nr, nc, visited);
            }
        }
    }



}
