package goorm.GameJam;

import java.io.*;
import java.rmi.activation.ActivationGroup_Stub;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    static int[] dr = {-1, 1, 0, 0}; // 상,하,좌,우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] goorm_start = new int[2];
        goorm_start[0] = Integer.parseInt(st.nextToken()) - 1;
        goorm_start[1] = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        int[] player_start = new int[2];
        player_start[0] = Integer.parseInt(st.nextToken()) - 1;
        player_start[1] = Integer.parseInt(st.nextToken()) - 1;

        String[][][] board = new String[N][N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                String m = st.nextToken();
                board[i][j][0] = String.valueOf(m.charAt(0));
                board[i][j][1] = String.valueOf(m.charAt(1));
            }
        }

        boolean[][] goorm_visited = new boolean[N][N];
        boolean[][] player_visited = new boolean[N][N];

        int goorm_score = game(goorm_start[0], goorm_start[1], board, goorm_visited,"",0,1);
        int player_score = game(player_start[0], player_start[1], board, player_visited,"",0,1);

        if (goorm_score > player_score) {
            System.out.println("goorm " + goorm_score);
        } else {
            System.out.println("player " + player_score);
        }


    }

    public static int game(int r, int c, String[][][] board, boolean[][] visited,String direction,int count,int score) {

        if (visited[r][c]) { // 방문했던 칸에 왔을 때
            return score - 1;
        } else {
            visited[r][c] = true;
            if (count == 0) {
                int[] next_dir = next_direction(r, c, board[r][c][1],board.length);
//                System.out.println(board[r][c][1]);
//                System.out.println("현재 좌표 방향");
//                System.out.println("r: " + next_dir[0]);
//                System.out.println("c: " + next_dir[1]);
                return game(next_dir[0], next_dir[1], board, visited, board[r][c][1], Integer.parseInt(board[r][c][0]) - 1, score+1);
            } else {
                int[] next_dir = next_direction(r, c, direction,board.length);
//                System.out.println("그대로 방향");
//                System.out.println("r: " + next_dir[0]);
//                System.out.println("c: " + next_dir[1]);
                return game(next_dir[0],next_dir[1],board,visited,direction,count-1,score+1);
            }
        }

    }

    public static int[] next_direction(int r, int c,String direction,int N) {

        int[] next_dir = new int[2];

        switch (direction) {
            case "U":
                next_dir[0] = r + dr[0];
                next_dir[1] = c + dc[0];
                break;
            case "D":
                next_dir[0] = r + dr[1];
                next_dir[1] = c + dc[1];
                break;
            case "R":
                next_dir[0] = r + dr[3];
                next_dir[1] = c + dc[3];
                break;
            case "L":
                next_dir[0] = r + dr[2];
                next_dir[1] = c + dc[2];
                break;
        }
//        System.out.println("*"+next_dir[0]);
//        System.out.println("*"+next_dir[1]);

        if (next_dir[0] < 0) next_dir[0] = N - 1;
        else if (next_dir[0] > N - 1) next_dir[0] = 0;

        if (next_dir[1] < 0) next_dir[1] = N - 1;
        else if (next_dir[1] > N - 1) next_dir[1] = 0;

        return next_dir;

        }
}