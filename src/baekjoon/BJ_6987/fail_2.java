package baekjoon.BJ_6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class fail_2 {

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

        // 승을 기준으로 내림차순
        Arrays.sort(board1, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        Arrays.sort(board2, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        Arrays.sort(board3, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        Arrays.sort(board4, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });

        System.out.println(result4);
        for (int[] ints : board4) {
            System.out.println(Arrays.toString(ints));
        }

        int judge1 = check_result(board1);
        int judge2 = check_result(board2);
        int judge3 = check_result(board3);
        int judge4 = check_result(board4);

        System.out.println(judge1 + " " + judge2 + " " + judge3 + " " + judge4);

//        System.out.println(judge4);

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
//                System.out.println("*");
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
//            System.out.println("**");
            return 0;
        }  else {
            // 승,패
            for (int i = 0; i < 6; i++) {
                if (board[i][0] > 0) {
//                    System.out.println("i는 : " + i + " board[i][0]" + board[i][0]);
                    int n = board[i][0];
                    for (int j = 5; j > -1 ; j--) {
                        if (n == 0) {
                            break;
                        }
                        if (j == i) {
                            continue;
                        }
                        if (board[j][2] > 0) {
                            board[j][2]--;
                            n--;
                        }
                    }
//                     확인용
//                    for (int[] ints : board) {
//                        System.out.println(Arrays.toString(ints));
//                    }
//                    System.out.println("n = " + n);
                    if (n != 0) {
//                        System.out.println("***");
                        return 0;
                    }
                }
            }
            /////// 무승부!!
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
//                        System.out.println("****");
                        return 0;
                    }
                }
            }
//            System.out.println("*****");
            return 1;
        }
    }
}


//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
//4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
//5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
//5 0 0 3 1 1 2 1 1 2 0 3 0 0 5 1 0 4
//1 1 0 0

//3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
//3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
//3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
//3 1 1 1 0 4 1 1 3 3 0 2 3 0 2 3 0 2
// 1 1 1 1

//5 0 0 5 0 0 5 0 0 0 0 5 0 0 5 0 0 5
//5 0 0 4 0 1 4 0 1 1 0 4 1 0 4 0 0 5
//0 5 0 5 0 0 0 0 5 0 5 0 0 5 0 0 5 0
//0 5 0 0 5 0 3 0 2 2 0 3 4 0 1 1 0 4
//0 0 0 0

//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
//5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
//1 1 1 1