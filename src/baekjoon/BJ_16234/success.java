package baekjoon.BJ_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class success {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int days = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][N];
        boolean[][] visited;
        List<int[]> store = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][N];
            boolean union = move(L, R, ground, visited, store);
            if (union) {
                days++;
            } else {
                break;
            }
        }

        System.out.println(days);

    }

    static boolean move(int L, int R, int[][] ground, boolean[][] visited, List<int[]> store) {
        boolean union = false;
        for (int r = 0; r < ground.length; r++) {
            for (int c = 0; c < ground.length; c++) {
                if (!visited[r][c]) {
                    dfs(r, c, L, R, ground, visited,store);
                    // store에 담긴게 1 보다 클 때 연합
                    if (store.size() > 1) {
                        union = true;
                        int sum = 0;
                        for (int[] ints : store) {
                            sum += ground[ints[0]][ints[1]];
                        }
                        int p = sum/store.size();
                        for (int[] ints : store) {
                            ground[ints[0]][ints[1]] = p;
                        }
                    }
                    store.clear();
                }
            }
        }
        return union;
    }

    static void dfs(int r, int c, int L, int R, int[][] ground, boolean[][] visited, List<int[]> store) {
        visited[r][c] = true;
        store.add(new int[]{r, c});

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr < 0 || nr > ground.length - 1 || nc < 0 || nc > ground.length - 1) continue;

            int diff = Math.abs(ground[r][c] - ground[nr][nc]);
            if (diff >= L && diff <= R && !visited[nr][nc]) {
                dfs(nr, nc, L, R, ground, visited,store);
            }
        }
    }

}

//            for (int[] ints : ground) {
//                System.out.println(Arrays.toString(ints));
//            }
//            System.out.println("**");