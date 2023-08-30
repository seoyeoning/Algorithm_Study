package goorm.구름찾기깃발;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[][] dir = {{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] cloud = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                cloud[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] flag = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (cloud[i][j] != 1) {
                    doFlag(i, j, cloud, flag);
                }
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (flag[i][j] == K) {
                    result++;
                }
            }
        }

        System.out.println(result);

        for (int[] ints : flag) {
            System.out.println(Arrays.toString(ints));
        }

//        for (int[] ints : cloud) {
//            System.out.println(Arrays.toString(ints));
//        }
    }

    public static void doFlag(int dr,int dc, int[][] cloud, int[][] flag) {
        int cloudCnt = 0;

        for (int i = 0; i < 8; i++) {
            int nr = dr + dir[i][0];
            int nc = dc + dir[i][1];

            if (nr < 0 || nr > cloud.length - 1 || nc < 0 || nc > cloud.length - 1) continue;

            if (cloud[nr][nc] == 1) {
                cloudCnt++;
            }
        }

        flag[dr][dc] = cloudCnt;

    }


}
