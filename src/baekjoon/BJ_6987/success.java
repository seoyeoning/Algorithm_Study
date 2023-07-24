package baekjoon.BJ_6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class success {

    static List<int[]> comb_list = new ArrayList<>();

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

        boolean[][] visited_all = new boolean[6][6];

        int judge1 = check_result(board1, visited_all);
//        int judge2 = check_result(board2);
//        int judge3 = check_result(board3);
//        int judge4 = check_result(board4);

        for (int[] ints : board1) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(judge1);

//        System.out.println(judge1 + " " + judge2 + " " + judge3 + " " + judge4);

    }

    public static void make_board(String result, int[][] board) {
        StringTokenizer st = new StringTokenizer(result);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    public static int check_result(int[][] board, boolean[][] visited_all) {
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
        if (win != lose) return 0;

        ///////////
        for (int i = 0; i < 1; i++) { // 6
            // i번째 나라(0,1,2,3,4,5) n:5 (자기 나라 제외) , r: board[i][0] (승리한 횟수)

            boolean[] visited = new boolean[5];
            List<Integer> arr = new ArrayList<>();
            for (int k = 0; k < 6; k++) {
                if (k != i) {
                    arr.add(k);
                }
            }

//            for (Integer integer : arr) {
//                System.out.print(integer + " ");
//            }
//            System.out.println();
            int r_size = board[i][0];
            if (board[i][0] != 0) {
                comb(arr, visited, 0, 5, board[i][0], r_size);
                for (int j = 0; j < comb_list.size(); j++) {
//                    comb_list.get(j); // [1,2,3,4,5]
                    for (int n = 0; n < comb_list.get(j).length; n++) {
                        visited_all[i][comb_list.get(j)[n]] = true;
                        visited_all[comb_list.get(j)[n]][i] = true;
                    }
                    //
                }
                for (boolean[] booleans : visited_all) {
                    System.out.println(Arrays.toString(booleans));
                }
            }
//            comb(arr, visited, 0, 5, board[i][0], result);
            for (int[] integers : comb_list) {
                System.out.println(Arrays.toString(integers));
            }
            comb_list.clear();
            System.out.println("************");
        }

        return 9;
    }

    static void comb(List<Integer> arr, boolean[] visited, int start, int n, int r, int r_size) {
        if (r == 0) {
//            for (int i = 0; i < n; i++) {
//                if (visited[i]) {
//                    System.out.print(arr.get(i) + " ");
//                }
//            }
//            System.out.println();
            int[] result = new int[r_size];
            int p = 0;
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    result[p] = arr.get(i);
                    p++;
                }
            }

            comb_list.add(result);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1,r_size);
            visited[i] = false;
        }

    }

}

