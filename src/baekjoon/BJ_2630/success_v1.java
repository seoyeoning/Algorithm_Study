package baekjoon.BJ_2630;

import java.util.*;
import java.io.*;

public class success_v1 {
    public static int[][] board;
    public static int w;
    public static int b;

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
        if(colorCheck(x,y,size)) {
            if(board[x][y] == 1) b++;
            else w++;
        } else {
            size = size / 2;
            rec(x, y, size);
            rec(x, y + size, size);
            rec(x + size, y, size);
            rec(x + size, y + size, size);
        }
    }
    public static boolean colorCheck(int x, int y, int size) {
        if (size == 1) {
            return true;
        } else {
            for(int i=x; i < x + size; i++) {
                for(int j = y; j < y + size; j++) {
                    if(board[i][j] != board[x][y]){
                        return false;
                    }
                }
            }
            return true;
        }
    }

}