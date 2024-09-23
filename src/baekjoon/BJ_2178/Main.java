package baekjoon.BJ_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        int[][] bored = new int[n][m];

        String line;

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                bored[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        int start_r = 0;
        int start_c = 0;

        int end_r = n - 1;
        int end_c = m - 1;

        int move = 1;

        Queue<Integer> queue = new LinkedList<>();

//        for (int[] ints : bored) {
//            System.out.println(Arrays.toString(ints));
//        }


    }

}

class Node {
    int r;
    int c;
}
