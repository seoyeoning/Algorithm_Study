package baekjoon.BJ_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class success {

    static int[] dr = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        List<int[]> store = new ArrayList<>();
        List<Integer> air_cleaner = new ArrayList<>();

        int[][] home = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                home[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < R; r++) {
            if (home[r][0] == -1) {
                air_cleaner.add(r);
            }
        }

        int[] acw_start = {air_cleaner.get(0) - 1, 0}; // 고정
        int[] cw_start = {air_cleaner.get(1) + 1, 0}; // 고정

        for (int i = 0; i < T; i++) {
            move(R, C, home, store); // 확산
            acw(home, acw_start[0], acw_start[1], 0, air_cleaner.get(0)); // 위쪽 공기 청정기 - 반시계 방향
            cw(home, cw_start[0], cw_start[1], 1, air_cleaner.get(1)); // 아래쪽 공기 청정기 - 시계 방향
        }

        int result = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (home[i][j] != -1) {
                    result += home[i][j];
                }
            }
        }

        System.out.println(result);
    }

//    static int[] dr = {-1, 1, 0, 0}; // 상(0) 하(1) 좌(2) 우(3)
//    static int[] dc = {0, 0, -1, 1};
    static void acw(int[][] home, int now_r, int now_c, int dir, int air_cleaner_row) {
        int nr = now_r + dr[dir];
        int nc = now_c + dc[dir];

        if (nr < 0) { // 상 -> 우
            dir = 3;
            nr = now_r + dr[dir];
            nc = now_c + dc[dir];
            home[now_r][now_c] = home[nr][nc];
            acw(home,nr,nc,dir,air_cleaner_row);
        } else if (nc > home[0].length - 1) { // 우 -> 하
            dir = 1;
            nr = now_r + dr[dir];
            nc = now_c + dc[dir];
            home[now_r][now_c] = home[nr][nc];
            acw(home,nr,nc,dir,air_cleaner_row);
        } else if (nr > air_cleaner_row) { // 하 -> 좌
            dir = 2;
            nr = now_r + dr[dir];
            nc = now_c + dc[dir];
            home[now_r][now_c] = home[nr][nc];
            acw(home,nr,nc,dir,air_cleaner_row);
        } else { // 원래 방향으로
            if (home[nr][nc] == -1) {
                home[now_r][now_c] = 0;
                return;
            }
            home[now_r][now_c] = home[nr][nc];
            acw(home,nr,nc,dir,air_cleaner_row);
        }
    }

    static void cw(int[][] home, int now_r, int now_c, int dir, int air_cleaner_row) {
        int nr = now_r + dr[dir];
        int nc = now_c + dc[dir];

        if (nr > home.length - 1) { // 하 -> 우
            dir = 3;
            nr = now_r + dr[dir];
            nc = now_c + dc[dir];
            home[now_r][now_c] = home[nr][nc];
            cw(home,nr,nc,dir,air_cleaner_row);
        } else if (nc > home[0].length - 1) { // 우 -> 상
            dir = 0;
            nr = now_r + dr[dir];
            nc = now_c + dc[dir];
            home[now_r][now_c] = home[nr][nc];
            cw(home,nr,nc,dir,air_cleaner_row);
        } else if (nr < air_cleaner_row) { // 상 -> 좌
            dir = 2;
            nr = now_r + dr[dir];
            nc = now_c + dc[dir];
            home[now_r][now_c] = home[nr][nc];
            cw(home, nr, nc, dir, air_cleaner_row);
        } else { // 원래 방향으로
            if (home[nr][nc] == -1) {
                home[now_r][now_c] = 0;
                return;
            }
            home[now_r][now_c] = home[nr][nc];
            cw(home,nr,nc,dir,air_cleaner_row);
        }

    }

    static void move(int R, int C, int[][] home, List<int[]> store) {

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (home[i][j] > 0) {
                    store.add(new int[]{i, j, home[i][j]});
                    home[i][j] = 0;
                }
            }
        }

        for (int[] dust : store) {
            int small_dust = dust[2] / 5; // 확산되는 양
            int move_count = 0;
            for (int i = 0; i < 4; i++) {
                int nr = dust[0] + dr[i];
                int nc = dust[1] + dc[i];

                if (nr<0 || nr > R-1 || nc <0 || nc > C-1) continue;
                if (home[nr][nc] == -1) continue;

                home[nr][nc] += small_dust;
                move_count++;
            }
            home[dust[0]][dust[1]] += dust[2] - (small_dust * move_count);
        }
        store.clear();
    }


}


//3 3 1
//0 30 7
//-1 10 0
//-1 0 20