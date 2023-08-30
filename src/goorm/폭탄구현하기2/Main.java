package goorm.폭탄구현하기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String[][] ground = new String[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                ground[i][j] = st.nextToken();
            }
        }

        int[][] bomb = new int[K][2];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                bomb[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] afterBomb = new int[N + 1][N + 1];
        for (int[] b : bomb) {
            explode(b[0], b[1], ground, afterBomb);
        }

        for (int[] ints : afterBomb) {
            System.out.println(Arrays.toString(ints));
        }

        int result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result = Math.max(result, afterBomb[i][j]);
            }
        }

        System.out.println(result);

    }

    public static void explode(int r, int c, String[][] ground, int[][] afterBomb) {
        if (ground[r][c].equals("0")) {
            afterBomb[r][c] += 1;
        } else if (ground[r][c].equals("@")) {
            afterBomb[r][c] += 2;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 1 || nr > ground.length-1 || nc < 1 || nc > ground.length-1) continue;
            if (ground[nr][nc].equals("0")) {
                afterBomb[nr][nc] += 1;
            } else if (ground[nr][nc].equals("@")) {
                afterBomb[nr][nc] += 2;
            }
        }

    }

}
