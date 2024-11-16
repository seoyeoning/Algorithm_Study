package 이코테.BFS_DFS.미로탈출;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    // 북,동,남,서
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] board;
    static Node[][] move;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        move = new Node[N][M];

        bfs();

        System.out.println(move[N-1][M-1].cnt);


    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        Node start_node = new Node(0, 0, 1);

        queue.offer(start_node);
        move[0][0] = start_node;

        while (!queue.isEmpty()) {
            Node now_node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = now_node.r + dr[i];
                int nc = now_node.c + dc[i];

                if (nr < 0 || nr > board.length - 1 || nc < 0 || nc > board[0].length - 1) {
                    continue;
                }
                if (board[nr][nc] == 0) {
                    continue;
                }
                if (move[nr][nc] == null || now_node.cnt + 1 < move[nr][nc].cnt) {
                    Node next_node = new Node(nr, nc, now_node.cnt + 1);
                    move[nr][nc] = next_node;
                    queue.offer(next_node);
                }
            }

        }
    }

}

class Node{
    int r;
    int c;
    int cnt = 0;

    public Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}
