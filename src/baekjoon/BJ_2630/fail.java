package baekjoon.BJ_2630;

import java.util.*;
import java.io.*;

// 하나로 합치다가 실패함
public class fail {
    public static int[][] board;
    public static int w;
    public static int b;

    public static boolean color = true;

    public static void main(String[] args) throws IOException {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        board = new int[N][N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 재귀함수 적기 (매개변수 생각하면서)
        rec(0, 0, N);
        // 3. 출력 생각하면서 미리 적기
        // 1: blue, 0: white
        System.out.println(w);
        System.out.println(b);

        br.close();
    }
    // 4. 매개변수 생각하면서 먼저 적고 안에 함수 구체화 하기
    public static void rec (int x, int y, int size) {

        // 확인용
        for (int k = x; k < x + size; k++) {
            for (int h = y; h < y + size; h++) {
                System.out.print(board[k][h] + " ");
            }
            System.out.println();
        }
        // 같은 색 확인
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != board[x][y]) {
                    size = size / 2;
                    rec(x, y, size);
                    rec(x, y + size, size);
                    rec(x + size, y, size);
                    rec(x + size, y + size, size);
                }
            }
        }

        if (color && board[x][y] == 1) {
            System.out.println("b 더해짐");
            b++;
        } else {
            System.out.println("w 더해짐");
            w++;
        }

    }
}