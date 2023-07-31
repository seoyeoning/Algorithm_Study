package baekjoon.BJ_20061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class success {

    static int score = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] info = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] board = new int[10][10];

        //[1,1,1] [2,3,0]
        for (int[] block : info) {
            move_blue(block, board);
            move_green(block,board);

            remove_blue(board);
            remove_green(board);

            light_blue(board);
            light_green(board);

//            System.out.println(block[0]+"-"+"("+block[1]+","+block[2]+")");
//            for (int[] ints : board) {
//                System.out.println(Arrays.toString(ints));
//            }
//            System.out.println("**");
        }

        int block_count=0;
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (board[r][c] == 1) {
                    block_count++;
                }
            }
        }

        System.out.println(score);
        System.out.println(block_count);
    }

    static void move_blue(int[] block, int[][] board) {
        if (block[0] == 1) {
            int i;
            for (i = block[2]; i < 10; i++) {
                if (i == 9) break;
                if (board[block[1]][i+1] != 0) break;
            }
            board[block[1]][i] = 1;
        } else if (block[0] == 2) {
            // (3,0) (3,1)
            int i;
            for (i = block[2] + 1; i < 10; i++) {
                if (i == 9) break;
                if (board[block[1]][i+1]!=0) break;
            }
            board[block[1]][i] = 1;
            board[block[1]][i - 1] = 1;
        } else if (block[0] == 3) {
            int i;
            for (i = block[2]; i < 10; i++) {
                if (i==9) break;
                if (board[block[1]][i+1] !=0 || board[block[1]+1][i+1] != 0) break;
            }
            board[block[1]][i] = 1;
            board[block[1]+1][i] = 1;
        }
    }

    static void move_green(int[] block, int[][] board) {
        if (block[0] == 1) {
            int i;
            for (i = block[1]; i < 10; i++) { // 행을 늘리기
                if (i == 9) break;
                if (board[i+1][block[2]] != 0) break;
            }
            board[i][block[2]] = 1;
        } else if (block[0] == 2) { //(3,0 (3,1)
            int i;
            for (i = block[1]; i < 10; i++) { // 행을 늘리기
                if (i == 9) break;
                if (board[i + 1][block[2]] != 0 || board[i + 1][block[2] + 1] != 0) break; // i+1 : 다음에 이동할 행
            }
            board[i][block[2]] = 1;
            board[i][block[2] + 1] = 1;
        } else if (block[0] == 3) { // 행을 늘리기
            int i;
            for (i = block[1] + 1; i < 10; i++) {
                if (i==9) break;
                if (board[i + 1][block[2]] != 0) break;
            }
            board[i][block[2]] = 1;
            board[i - 1][block[2]] = 1;
        }
    }

    static void remove_blue(int[][] board) {
        int remove_c =0;
        int remove_count=0;
        for (int c = 9; c >= 6; c--) {
            int count = 0;
            for (int r = 0; r < 4; r++) {
                if (board[r][c] == 1) count++;
            }
            if (count == 4) {
                remove_c = c;
                remove_count++;
                for (int r = 0; r < 4; r++) {
                    board[r][c] =0;
                }
            }
        }
        score += remove_count;

        if (remove_count > 0) {
            for (int c = remove_c -1; c >= 4; c--) {
                for (int r = 0; r < 4; r++) {
                    if (board[r][c] == 1) {
                        board[r][c+remove_count] = 1;
                        board[r][c] = 0;
                    }
                }
            }
        }


    }

    static void remove_green(int[][] board) {
        int remove_r =0; // 마지막으로 지운 행
        int remove_count=0; // 몇개의 행을 지웠는지

        for (int r = 9; r>=6; r--) {
            int count = 0;
            for (int c = 0; c < 4; c++) {
                if (board[r][c] == 1) count++;
            }
            if (count == 4) {
                remove_r = r;
                remove_count++;
                for (int c = 0; c < 4; c++) {
                    board[r][c] =0;
                }
            }
        }
        score += remove_count;

        if (remove_count > 0) { // 지운 행만큼 옮겨주기
            for (int r = remove_r -1; r >= 4; r--) { // r = 8 - 1 = 7
                for (int c = 0; c < 4; c++) {
                    if (board[r][c] == 1) {
                        board[r+remove_count][c] = 1;
                        board[r][c] = 0;
                    }
                }
            }
        }

    }

    static void light_blue(int[][] board) {
        int light_c = 0; // 몇개의 열을 옮길껀지
        for (int c = 4; c <= 5; c++) {
            for (int r = 0; r < 4; r++) {
                if (board[r][c] == 1) {
                    light_c++;
                    break; // 한개라도 있으면 끝내기!
                }
            }
        }
        if (light_c > 0) { // 연한 열 있으면 옮기기
            for (int c = 9; c > 9 - light_c; c--) { // 지워주기 9 - 1 = 8 (9만 지워주기)
                for (int r = 0; r < 4; r++) {
                    board[r][c] = 0;
                }
            }
            for (int c = 9 - light_c; c >= 4; c--) { // 끝에서부터 연할 열 개수만큼 옮겨주기
                for (int r = 0; r < 4; r++) {
                    if (board[r][c] == 1) {
                        board[r][c+light_c] = 1;
                        board[r][c] = 0;
                    }
                }
            }
        }
    }

    static void light_green(int[][] board) {
        int light_r = 0;
        for (int r = 4; r <= 5; r++) {
            for (int c = 0; c < 4; c++) {
                if (board[r][c] == 1) {
                    light_r++;
                    break;
                }
            }
        }

        if (light_r > 0) {
            for (int r = 9; r > 9 - light_r; r--) {
                for (int c = 0; c < 4; c++) {
                    board[r][c] = 0;
                }
            }
            for (int r = 9 - light_r; r >= 4; r--) {
                for (int c = 0; c < 4; c++) {
                    if (board[r][c] == 1) {
                        board[r+light_r][c] = 1;
                        board[r][c] = 0;
                    }
                }
            }
        }
    }

}



//7
//2 3 0
//1 3 3
//3 2 0
//2 2 2
//2 2 2
//2 2 2
//3 2 1

//5
//2 3 0
//1 3 3
//3 2 0
//2 2 2
//2 2 2

//9
//2 1 0
//2 1 0
//2 1 0
//2 1 0
//2 1 0
//3 0 2
//3 0 2
//3 0 3
//3 0 3

//8
//3 1 0
//3 0 1
//1 2 1
//1 0 0
//3 2 1
//3 0 1
//1 3 1
//2 2 1