package baekjoon.BJ_3184;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class success {

    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}; // {행,열} 기준 상하좌우

    static int v;
    static int o;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        String[][] madang = new String[R][C];

        // 마당 입력 받기
        for (int i = 0; i < R; i++) {
            String string = br.readLine();
            for (int j = 0; j < C; j++) {
                madang[i][j] = String.valueOf(string.charAt(j));
            }
        }
        // 방문 배열 생성
        boolean[][] visited = new boolean[R][C];

        int sum_v = 0;
        int sum_o = 0;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                v = 0;
                o = 0;
                if (!madang[r][c].equals("#") && !visited[r][c]) {
                    dfs(r, c, madang, visited);
                    if (v >= o) sum_v += v;
                    else sum_o += o;
                }
            }
        }
        System.out.println(sum_o+" "+sum_v);
    }

    static public void dfs(int r, int c, String[][] madang, boolean[][] visited) {
        visited[r][c] = true;
        if (madang[r][c].equals("o")) o++;
        else if (madang[r][c].equals("v")) v++;

        for (int i = 0; i < 4; i++) {
            int nr = r + dir[i][0];
            int nc = c + dir[i][1];
            if (nr < 0 || nr > madang.length - 1 || nc < 0 || nc > madang[0].length - 1) continue;

            if (!madang[nr][nc].equals("#") && !visited[nr][nc]) {
                dfs(nr, nc, madang, visited);
            }
        }
    }

}

// 확인용
//        for (String[] ints : madang) {
//            System.out.println(Arrays.toString(ints));
//        }
//        for (boolean[] booleans : visited) {
//            System.out.println(Arrays.toString(booleans));
//        }