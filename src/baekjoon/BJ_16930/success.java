//package baekjoon.BJ_16930;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class success {
//
//    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int R = Integer.parseInt(st.nextToken());
//        int C = Integer.parseInt(st.nextToken());
//        int K = Integer.parseInt(st.nextToken());
//
//        String[][] board = new String[R][C];
//
//        for (int i = 0; i < R; i++) {
//            String string = br.readLine();
//            for (int j = 0; j < C; j++) {
//                board[i][j] = String.valueOf(string.charAt(j));
//            }
//        }
//
//        for (String[] strings : board) {
//            System.out.println(Arrays.toString(strings));
//        }
//
//        //st = new StringTokenizer(br.readLine());
//
//        int[][] visited = new int[R][C];
//
//        bfs(0,0,board,visited);
//    }
//
//    static public void bfs(int r, int c, String[][] borad, int[][] visited) {
//        Queue<String> q = new LinkedList<>();
//        visited[r][c]++;
//        q.add()
//
//        while (!q.isEmpty()) {
//
//        }
//    }
//}
