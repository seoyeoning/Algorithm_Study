package baekjoon.BJ_2933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class clean {

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static int max_h = 100;

    public static void main(String[] args) throws IOException {
        //////// 초기 세팅
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt((st.nextToken()));
        String[][] cave = new String[R][C];
        for (int r = 0; r < R; r++) {
            String string = br.readLine();
            for (int c = 0; c < C; c++) {
                cave[r][c] = String.valueOf(string.charAt(c));
            }
        }
        boolean[][] visited = new boolean[R][C];
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] sticks = new int[N];
        for (int i = 0; i < N; i++) {
            sticks[i] = (R-1) - (Integer.parseInt(st.nextToken())-1); // 높이 맞춰주기
        }
        System.out.println(Arrays.toString(sticks)); //[2,2,4,5,7]
        /////////
        List<Integer[]> store = new ArrayList<>();

        // sticks.length로 바꾸고 예제2에서 i=4로 바꾸고 (끊기는 부분)
        for (int i = 0; i < sticks.length; i++) {
            if (i % 2 == 0) { // 왼쪽부터 시작
                for (int c = 0; c < C; c++) { // 막대 던지는 for문
                    if (cave[sticks[i]][c].equals("x")) {
                        cave[sticks[i]][c] = ".";
                        System.out.println("****** 막대로 던지기");
                        for (String[] strings : cave) {
                            System.out.println(Arrays.toString(strings));
                        }
                        System.out.println("******");
                        break;
                    }
                }

                // 전체 dfs
                int entire_dfs = entire(R,C, 0, cave, visited);
                visited = new boolean[R][C]; // 방문 배열 초기화
                // 바닥만 dfs
                int bottom_dfs = bottom(R,C, 0, cave, visited);
                visited = new boolean[R][C]; // 방문 배열 초기화

                if (entire_dfs - bottom_dfs == 1) {
                    for (int r = R-1; r >= 0; r--) {
                        for (int c = 0; c < C; c++) {
                            if (cave[r][c].equals("x") && !visited[r][c]){
                                if (r == R - 1) {
                                    dfs(r, c, cave, visited);
                                } else {
                                    int max_low = r;
                                    store_dfs(r, c, max_low, cave, visited, store); // 지금 여기 하는중!!!!!!!!!!
//                                    for (Integer[] integers : store) {
//                                        System.out.println(Arrays.toString(integers));
//                                    }
                                    for (Integer[] integers : store) {
                                        int y = integers[0];
                                        int x = integers[1];
                                        cave[y + max_h][x] = "x";
                                    }
                                    System.out.println("##### 이동 후");
                                    for (String[] strings : cave) {
                                        System.out.println(Arrays.toString(strings));
                                    }
                                    System.out.println("#####");
                                    max_h = 0;
                                    store.clear();
                                    visited = new boolean[R][C]; // 방문 배열 초기화
                                }
                            }
                        }
                    }
                }
            } else { // 오른쪽부터 시작
                for (int c = C - 1; c >= 0; c--) { // 막대 던지는 for문
                    if (cave[sticks[i]][c].equals("x")) {
                        cave[sticks[i]][c] = ".";
                        break;
                    }
                }
                System.out.println("****** 막대로 던지기");
                for (String[] strings : cave) {
                    System.out.println(Arrays.toString(strings));
                }
                System.out.println("******");
                // 전체 dfs
                int entire_dfs = entire(R,C, 0, cave, visited);
                visited = new boolean[R][C]; // 방문 배열 초기화
                // 바닥만 dfs
                int bottom_dfs = bottom(R,C, 0, cave, visited);
                visited = new boolean[R][C]; // 방문 배열 초기화

                if (entire_dfs - bottom_dfs == 1) {
                    // dfs 시작
                    loop:
                    for (int r = R-1; r >= 0; r--) {
                        for (int c = 0; c < C; c++) {
                            if (cave[r][c].equals("x") && !visited[r][c]){
                                if (r == R - 1) {
                                    dfs(r, c, cave, visited);
                                } else {
                                    int max_low = r;
                                    store_dfs(r, c, max_low, cave, visited, store); // 지금 여기 하는중!!!!!!!!!!
                                    for (Integer[] integers : store) {
                                        System.out.println(Arrays.toString(integers));
                                    }
                                    for (Integer[] integers : store) {
                                        int y = integers[0];
                                        int x = integers[1];
                                        cave[y + max_h][x] = "x";
                                    }
                                    System.out.println("##### 이동 후");
                                    for (String[] strings : cave) {
                                        System.out.println(Arrays.toString(strings));
                                    }
                                    System.out.println("#####");
                                    max_h = 0;
                                    store.clear();
                                    visited = new boolean[R][C]; // 방문 배열 초기화
                                    break loop;
                                }
                            }
                        }
                    }
                }
            }
//            System.out.println("******");
//            for (String[] strings : cave) {
//                System.out.println(Arrays.toString(strings));
//            }
//            System.out.println("******");
        }

        // 결과
//        for (String[] strings : cave) {
//            for (String string : strings) {
//                System.out.print(string);
//            }
//            System.out.println();
//        }
    }

    public static void store_dfs(int r, int c, int max_low, String[][] cave, boolean[][] visited, List<Integer[]> store) {
        visited[r][c] = true;
        store.add(new Integer[]{r, c});
        cave[r][c] = ".";

        int h = 0;
        if (r == max_low) {
            for (int i = r+1; i < cave.length ; i++) {
                if (cave[i][c].equals("x")) {
                    break;
                }
                ++h;
            }
            max_h = Math.min(max_h,h);
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr > cave.length - 1 || nc < 0 || nc > cave[0].length - 1) continue;
            if (cave[nr][nc].equals("x") && !visited[nr][nc]) {
                store_dfs(nr, nc, max_low, cave, visited, store);
            }
        }
    }

    public static int bottom(int R, int C, int bottom_dfs, String[][] cave, boolean[][] visited) {
        for (int c = 0; c < C; c++) {
            if (cave[R-1][c].equals("x") && !visited[R-1][c]){
                dfs(R-1, c, cave, visited);
                bottom_dfs++;
            }
        }
        return bottom_dfs;
    }

    public static int entire(int R, int C, int entire_dfs, String[][] cave, boolean[][] visited) {
        for (int r = R-1; r >= 0; r--) {
            for (int c = 0; c < C; c++) {
                if (cave[r][c].equals("x") && !visited[r][c]){
                    dfs(r, c, cave, visited);
                    entire_dfs++;
                }
            }
        }
        return entire_dfs;
    }

    public static void dfs(int r, int c, String[][] cave, boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < 0 || nr > cave.length - 1 || nc < 0 || nc > cave[0].length - 1) continue;
            if (cave[nr][nc].equals("x") && !visited[nr][nc]) {
                dfs(nr,nc,cave,visited);
            }
        }
    }
}


//7 5
//.....
//.xxx.
//.x...
//xx.xx
//x...x
//x...x
//x...x
//1
//4