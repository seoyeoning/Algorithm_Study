package baekjoon.BJ_21610;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class success {

    static int[][] dir = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] moves = new int[M][2];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                moves[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited;

        List<int[]> cloud = new ArrayList<>(); // 비구름을 저장하는 곳
        cloud.add(new int[]{N, 1});
        cloud.add(new int[]{N, 2});
        cloud.add(new int[]{N - 1, 1});
        cloud.add(new int[]{N - 1, 2});
        
        for (int[] move : moves) {

            go(move,cloud,N); // 이동
            rain(board, cloud); // 비 내리기 ( 1씩 증가 )
            magic(board, cloud); // 대각선 계산해서 비바라기 마법

            visited = new boolean[N+1][N+1];
            next_cloud(board, cloud, visited);
        }

        int result = 0;
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board.length; j++) {
                result += board[i][j];
            }
        }

        System.out.println(result);
    }

    static void go(int[] move, List<int[]> cloud, int N) {

        for (int[] ints : cloud) {
            ints[0] = ints[0] + (dir[move[0]][0] * move[1]);
            ints[1] = ints[1] + (dir[move[0]][1] * move[1]);
        }

        for (int[] ints : cloud) {
            if (ints[0] <= 0) { // 음수일 때 N 더해줌
                while (ints[0] <= 0 ) {
                    ints[0] = ints[0] + N;
                }
            } else if (ints[0] > N) { // N보다 클 때 N 빼줌
                while (ints[0] > N) {
                    ints[0] = ints[0] - N;
                }
            }
            if (ints[1] <= 0) { // 음수일 때 N 더해줌
                while (ints[1] <= 0) {
                    ints[1] = ints[1] + N;
                }
            } else if (ints[1] > N) { // N보다 클 때 N 빼줌
                while (ints[1] > N) {
                    ints[1] = ints[1] - N;
                }
            }
        }
    }

    static void rain(int[][] board, List<int[]> cloud) {
        for (int[] ints : cloud) {
            board[ints[0]][ints[1]] += 1;
        }
    }

    static void magic(int[][] board, List<int[]> cloud) {
        for (int[] ints : cloud) {
            int count = 0;
            for (int i = 1; i <= 8; i++) {
                if (i % 2 == 0) { // 짝수일때가 대각선 방향
                    int nr = ints[0] + dir[i][0];
                    int nc = ints[1] + dir[i][1];

                    if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board.length - 1) continue;

                    if (board[nr][nc] != 0) {
                        count++;
                    }
                }
            }
            board[ints[0]][ints[1]] += count;
        }
    }

    static void next_cloud(int[][] board, List<int[]> cloud, boolean[][] visited) {
        for (int[] ints : cloud) {
            visited[ints[0]][ints[1]] = true;
        }
        cloud.clear();

        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (visited[i][j]) continue;
                if (board[i][j] >= 2) {
                    board[i][j] -= 2;
                    cloud.add(new int[]{i, j});
                }
            }
        }
    }

}
