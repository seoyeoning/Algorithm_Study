package goorm.연결요소제거하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        String[][] board = new String[N][N];
        for (int i = 0; i < N; i++) {
            String string = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = String.valueOf(string.charAt(j));
            }
        }

//        for (String[] strings : board) {
//            System.out.println(Arrays.toString(strings));
//        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            String alphabet = st.nextToken();

            board[r][c] = alphabet;
            boolean[][] visited;
            List<int[]> store = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    visited = new boolean[N][N];
                    if (!visited[j][k] && !board[j][k].equals(".")) {
                        String alpha = board[j][k];
                        dfs(j, k, alpha, board, visited,store);
                        if (store.size() >= K) {
                            for (int[] ints : store) {
                                board[ints[0]][ints[1]] = ".";
                            }
                        }
                        store.clear();
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println();
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j]);
            }
        }


    }

    public static void dfs(int r, int c, String alpha, String[][] board, boolean[][] visited,List<int[]> store) {

        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.add(new int[]{r, c});
        store.add(new int[]{r, c});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int now_r = now[0];
            int now_c = now[1];

            for (int i = 0; i < 4; i++) {

                int nr = now_r + dr[i];
                int nc = now_c + dc[i];

                if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board.length - 1) continue;

                if (board[nr][nc].equals(alpha) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.add(new int[]{nr, nc});
                    store.add(new int[]{nr, nc});
                }

            }
        }
    }

}

//5 5 6
//AB..C
//BBAZZ
//....A
//BBB.B
//CCBAB
