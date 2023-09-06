package goorm.중첩점;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][][] board = new int[N + 1][N + 1][2]; // (가로,세로)

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            switch (dir) {
                case "U":
                    move_U(r,c,board);
                    break;
                case "D":
                    move_D(r,c,board);
                    break;
                case "R":
                    move_R(r,c,board);
                    break;
                case "L":
                    move_L(r,c,board);
                    break;
            }
        }

//        for (int[][] ints : board) {
//            System.out.println();
//            for (int[] anInt : ints) {
//                System.out.print(Arrays.toString(anInt));
//            }
//        }

        long result = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                result += (long) board[i][j][0] * board[i][j][1];
            }
        }

        System.out.println(result);


    }

    public static void move_U(int r, int c, int[][][] board) {
        while (r > 0) {
            board[r][c][0]++;
            r--;
        }
    }

    public static void move_D(int r, int c, int[][][] board) {
        while (r < board.length ) {
            board[r][c][0]++;
            r++;
        }
    }

    public static void move_R(int r, int c, int[][][] board) {
        while (c < board.length ) {
            board[r][c][1]++;
            c++;
        }
    }

    public static void move_L(int r, int c, int[][][] board) {
        while (c > 0) {
            board[r][c][1]++;
            c--;
        }
    }


}
