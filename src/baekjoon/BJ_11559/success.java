package baekjoon.BJ_11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class success {

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int count = 0;

    public static void main(String[] args) throws IOException {
        /// 뿌요 담아줌
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] puyo = new String[12][6];
        for (int i = 0; i < 12; i++) {
            String st = br.readLine();
            for (int j = 0; j < 6; j++) {
                puyo[i][j] = String.valueOf(st.charAt(j));
            }
        }
        ////////////
        boolean[][] visited = new boolean[12][6];
        List<Integer[]> store = new ArrayList<>();

        int k = 72;
        boolean check = false;
        while (k > 0) {
            int y = -1;
            int x = -1;
            for (int r = 11; r >= 0; r--) {
                for (int c = 0; c < 6; c++) {
                    if (!puyo[r][c].equals(".")) {
                        dfs(r, c, puyo, visited, store);
                        ///////////////////////////////
//                        for (Integer[] integers : store) {
//                            System.out.print(Arrays.toString(integers));
//                        }
                        if (store.size() >= 4) {
                            check = true;
                            for (Integer[] integers : store) {
                                y = integers[0];
                                x = integers[1];
                                puyo[y][x] = ".";
                                visited[y][x] = false;
                            }
                            store.clear();
                        } else {
                            for (Integer[] integers : store) {
                                y = integers[0];
                                x = integers[1];
                                visited[y][x] = false;
                            }
                            store.clear();
                        }
                    }
                }
            }
//            System.out.println("******** 터진 직후 뿌요 판");
//            for (String[] strings : puyo) {
//                System.out.println(Arrays.toString(strings));
//            }
//            System.out.println("********");
            if (check) {
                count++;
                for (int j = 11; j >= 0; j--) {
                    for (int i = 0; i < 6; i++) {
                        if (puyo[j][i].equals(".")) {
                            move(j, i, puyo, j);
                        }
                    }
                }
            } else {
                break;
            }
//            System.out.println("******** 터진 후 밑으로 이동한 뿌요 판");
//            for (String[] strings : puyo) {
//                System.out.println(Arrays.toString(strings));
//            }
//            System.out.println("********");
            check = false;
            k--;
        }
        System.out.println(count);
    }

    public static void dfs(int r, int c, String[][] puyo, boolean[][] visited, List<Integer[]> store) {
        String color = puyo[r][c];
        visited[r][c] = true;
        store.add(new Integer[]{r, c});

        for (int j = 0; j < 4; j++) {
            int nr = r + dr[j];
            int nc = c + dc[j];

            if (nr < 0 || nr > 11 || nc < 0 || nc > 5) {
                continue;
            }
            if (puyo[nr][nc].equals(color) && !visited[nr][nc]) {
                dfs(nr,nc,puyo,visited,store);
            }
        }
    }

    // r : 지금 방문한 좌표, move_r : 옮길 좌표 (그 열의 가장 밑!)
    public static void move(int r,int c, String[][] puyo, int move_r) {
        if (r < 0) {
            return;
        }
        if (puyo[r][c].equals(".")) {
            move(r-1, c, puyo, move_r);
        } else {
            puyo[move_r][c] = puyo[r][c];
            puyo[r][c] = ".";
            move(r-1,c,puyo, move_r - 1);
        }
    }
}

//......
//......
//.YGB..
//.BGY..
//.BGY..
//.BGY..
//.GBY..
//.GBBY.
//.BGGG.
//.YGGY.
//.YGGY.
//.YBBB.

//......
//......
//......
//......
//......
//......
//......
//......
//.Y....
//.YG...
//RRYG..
//RRYGG.
