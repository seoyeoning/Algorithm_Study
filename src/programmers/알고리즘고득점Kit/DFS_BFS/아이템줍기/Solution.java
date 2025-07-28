package programmers.알고리즘고득점Kit.DFS_BFS.아이템줍기;

import java.util.*;

class Solution {

    int[] dx = {0,1,0,-1};
    int[] dy = {-1,0,1,0};

    // 2배로 늘리는게 핵심
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;

        int[][] board = new int[101][101];
        boolean[][] visited = new boolean[101][101];

        // 모서리는 1, 내부는 2
        for (int[] rec : rectangle) {
            for(int i=rec[0]*2; i <= rec[2]*2; i++) {
                for(int j=rec[1]*2; j <= rec[3]*2; j++) {
                    if (i==rec[0]*2 || i==rec[2]*2 || j==rec[1]*2 || j==rec[3]*2) {
                        if (board[i][j] == 2) {
                            continue;
                        }
                        board[i][j] = 1;
                        continue;
                    }
                    board[i][j] = 2;
                }
            }
        }

        int cx = characterX*2;
        int cy = characterY*2;
        int ix = itemX*2;
        int iy = itemY*2;

        // BFS 시작
        Queue<Node> q = new LinkedList<>();
        Node start = new Node(cx,cy,0);
        q.offer(start);
        visited[cx][cy] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();

            if (node.x == ix && node.y == iy) {
                answer = node.moveCnt/2;
                break;
            }

            for(int i=0; i <4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx>=1 && nx <=100 && ny>=1 && ny<=100) {
                    if (board[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new Node(nx,ny,node.moveCnt+1));
                        visited[nx][ny] = true;
                    }
                }

            }
        }


        return answer;
    }
}

class Node {
    int x;
    int y;
    int moveCnt;

    Node(int x, int y, int moveCnt) {
        this.x = x;
        this.y = y;
        this.moveCnt = moveCnt;
    }
}
