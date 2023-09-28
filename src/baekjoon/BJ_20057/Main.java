package baekjoon.BJ_20057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}}; // L, D, R, U

    static int[][] store_L = {{0, -2, 5}, {-1, -1, 10}, {1, -1, 10}, {-1, 0, 7}, {1, 0, 7}, {-2, 0, 2}, {2, 0, 2}, {-1, 1, 1}, {1, 1, 1}};
    static int[][] store_D = {{2, 0, 5}, {1, -1, 10}, {1, 1, 10}, {0, -1, 7}, {0, 1, 7}, {0, -2, 2}, {0, 2, 2}, {-1, -1, 1}, {-1, 1, 1}};
    static int[][] store_R = {{0, 2, 5}, {-1, 1, 10}, {1, 1, 10}, {-1, 0, 7}, {1, 0, 7}, {-2, 0, 2}, {2, 0, 2}, {-1, -1, 1}, {1, -1, 1}};
    static int[][] store_U = {{-2, 0, 5}, {-1, -1, 10}, {-1, 1, 10}, {0, -1, 7}, {0, 1, 7}, {0, -2, 2}, {0, 2, 2}, {1, -1, 1}, {1, 1, 1}};

    static int sum = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        /////////////////////////////////////// 이동하는 부분
        int start_r = N / 2;
        int start_c = N / 2;

        int count = 0;
        int move_cnt = 1;
        int initial_d = 0;

        for (int j = 0; j < 4; j++) {  // 방향

            System.out.println("현재 방향 j :" +j);

            for (int k = 0; k < move_cnt; k++) {
                start_r += dir[j][0];
                start_c += dir[j][1];
//                System.out.println("r: " + start_r +"," + "c: " + start_c);
                if (board[start_r][start_c] != 0) { // 0이면 그냥 토네이도만 이동 (모래 이동 x)
//                    System.out.println("현재 방향 j :" +j);
                    move(start_r, start_c, board, j);
                    System.out.println("////////");
                    for (int[] ints : board) {
                        System.out.println(Arrays.toString(ints));
                    }
                    System.out.println("////////");
                }
            }
            count++;
            if (count == 2) {
                move_cnt++;
                count = 0;
            }

            if (j == 3) {
                j = -1;
            }
            initial_d++;
            if (initial_d == (N - 1) * 2) {
                break;
            }
//            System.out.println("방향 바꿈");
        }
        for (int i = 0; i < N - 1; i++) { // 마지막은 무조건 왼쪽
            start_r += dir[0][0];
            start_c += dir[0][1];
            if (board[start_r][start_c] != 0) { // 0이면 그냥 토네이도만 이동 (모래 이동 x)
                move(start_r, start_c, board, 0);
                System.out.println("////////");
                for (int[] ints : board) {
                    System.out.println(Arrays.toString(ints));
                }
                System.out.println("////////");
            }
//            System.out.println("r: " + start_r +"," + "c: " + start_c);
        }
        ////////////////////////////////////////

        System.out.println(sum);

    }

    public static void move(int r, int c, int[][] board, int d) {

        int send_amount = board[r][c];
        if (send_amount*0.1 < 1) {

            System.out.println("direction은 : " + d);

            int nr = r + dir[d][0];
            int nc = c + dir[d][1];
            if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board.length - 1) {
                sum += board[r][c];
            } else {
                board[nr][nc] += board[r][c];
            }
            board[r][c] = 0;
            return;
        }

        if (d == 0) { // 좌 - store_L
            move_detail(r, c, d, board, store_L);
        } else if (d == 1) { // 하 store_D
            move_detail(r, c, d, board, store_D);
        } else if (d == 2) { // 우 store_R
            move_detail(r, c, d, board, store_R);
        } else { // 상 store_U
            move_detail(r, c, d, board, store_U);
        }

    }

    public static void move_detail(int r, int c,int d, int[][] board, int[][] store) {

        int send_amount = board[r][c];

        int mr;
        int mc;

        int new_amount = 0;

        for (int[] ints : store) {
            mr = r + ints[0];
            mc = c + ints[1];
            if (mr < 0 || mr > board.length - 1 || mc < 0 || mc > board.length - 1) continue;

            if (ints[2] == 5) {
                new_amount = (int) (send_amount * 0.05);
                board[mr][mc] += new_amount;
                board[r][c] -= new_amount;
            } else if (ints[2] == 10) {
                new_amount = (int) (send_amount * 0.1);
                board[mr][mc] += new_amount;
                board[r][c] -= new_amount;
            } else if (ints[2] == 7) {
                new_amount = (int) (send_amount * 0.07);
                board[mr][mc] += new_amount;
                board[r][c] -= new_amount;
            } else if (ints[2] == 2) {
                new_amount = (int) (send_amount * 0.02);
                board[mr][mc] += new_amount;
                board[r][c] -= new_amount;
            } else if (ints[2] == 1) {
                new_amount = (int) (send_amount * 0.01);
                board[mr][mc] += new_amount;
                board[r][c] -= new_amount;
            }
        }

        int nr = r + dir[d][0];
        int nc = c + dir[d][1];
//        System.out.println("nr: " + dir[d][0]);
//        System.out.println("nc: " + dir[d][1]);

        if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board.length - 1) {
            sum += board[r][c];
        } else {
            board[nr][nc] += board[r][c];
        }
        board[r][c] = 0;

    }

}
