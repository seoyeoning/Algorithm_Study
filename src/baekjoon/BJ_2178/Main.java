package baekjoon.BJ_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 상,우,하,좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        int[][] board = new int[n][m];

        String line;

        for (int i = 0; i < n; i++) {
            line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        Node[][] move_board = new Node[n][m];

        // 도착지, n-1, m-1
        Queue<Node> queue = new LinkedList<>();

        Node start = new Node(0, 0, 1);
        queue.offer(start);
        move_board[0][0] = start;

        while (!queue.isEmpty()) {
            Node nowNode = queue.poll();

//            if (nowNode.r == n - 1 && nowNode.c == m - 1) break;

            for (int i = 0; i < 4; i++) {
                int next_r = nowNode.r + dr[i];
                int next_c = nowNode.c + dc[i];

                if (next_r < 0 || next_r > n - 1 || next_c < 0 || next_c > m - 1) continue;
                if (board[next_r][next_c] == 0) continue;
                if (move_board[next_r][next_c] == null) {
                    Node next_node = new Node(next_r, next_c, nowNode.depth + 1);
                    queue.offer(next_node);
                    move_board[next_r][next_c] = next_node;
                } else if (move_board[next_r][next_c].depth > nowNode.depth + 1) {
                    Node next_node = new Node(next_r, next_c, nowNode.depth + 1);
                    queue.offer(next_node);
                    move_board[next_r][next_c] = next_node;
                }

            }
        }

        System.out.println(move_board[n - 1][m - 1].depth);

    }

}

class Node {

    int r;
    int c;
    int depth;

    Node(int r, int c, int depth) {
        this.r = r;
        this.c = c;
        this.depth = depth;
    }
}
