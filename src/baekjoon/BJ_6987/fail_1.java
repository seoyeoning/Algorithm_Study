package baekjoon.BJ_6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class fail_1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String result1 = br.readLine();
        String result2 = br.readLine();
        String result3 = br.readLine();
        String result4 = br.readLine();

        int[][] board1 = new int[6][3];
        int[][] board2 = new int[6][3];
        int[][] board3 = new int[6][3];
        int[][] board4 = new int[6][3];

        make_board(result1, board1);
        make_board(result2, board2);
        make_board(result3, board3);
        make_board(result4, board4);

        int judge1 = check_result(board1);
        int judge2 = check_result(board2);
        int judge3 = check_result(board3);
        int judge4 = check_result(board4);

        for (int[] ints : board1) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(judge1 + " " + judge2 + " " + judge3 + " " + judge4);

    }

    public static void make_board(String result, int[][] board) {
        StringTokenizer st = new StringTokenizer(result);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int check_result(int[][] board) {
        // 각 승,무,패 합이 5인지 확인
        for (int i = 0; i < 6; i++) {
            int check_sum_5 = 0;
            for (int j = 0; j < 3; j++) {
                check_sum_5 += board[i][j];
            }
            if (check_sum_5 != 5) {
                return 0;
            }
        }

        // 승 15 확인
        int win = 0;
        for (int i = 0; i < 6; i++) {
            win += board[i][0];
        }
        // 패 15 확인
        int lose = 0;
        for (int i = 0; i < 6; i++) {
            lose += board[i][2];
        }

        if (win != lose) {
            return 0;
        } else if (win == 15 && lose ==15) {
            return 1;
        } else {
            int[] tie = new int[6];
            for (int i = 0; i < 6; i++) {
                tie[i] = board[i][1];
            }
            for (int i = 0; i < 6; i++) {
                if (tie[i] > 0) {
                    int k = tie[i];
                    tie[i] = 0;
                    for (int j = 0; j < 6; j++) {
                        if (k == 0) {
                            break;
                        }
                        if (tie[j] > 0) {
                            tie[j]--;
                            k--;
                        }
                    }
                    if (k != 0) {
                        return 0;
                    }
                }
            }
            return 1;
        }
    }
}

//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
//4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
//5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
//5 0 0 3 1 1 2 1 1 2 0 3 0 0 5 1 0 4