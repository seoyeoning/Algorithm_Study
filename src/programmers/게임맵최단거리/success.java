package programmers.게임맵최단거리;
import java.util.*;
class success {

    // 상하좌우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) {

        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};

        int answer = 0;

        // 방문 맵 체크용 맵 생성
        int[][] visited = new int[maps.length][maps[0].length];
        // 확인용
        //System.out.println(Arrays.deepToString(visited));

        bfs(maps, visited);

        answer = visited[maps.length - 1][maps[0].length - 1];

        if (answer == 0) {
            answer = -1;
        }

        System.out.println(answer);
    }

    public static void bfs(int[][] maps, int[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        visited[0][0] = 1;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            int r = current[0];
            int c = current[1];

            for(int i=0; i < 4; i++) {
                int mr = r + dr[i];
                int mc = c + dc[i];

                if(mr < 0 || mr > maps.length -1 || mc < 0 || mc > maps[0].length -1 ) {
                    continue;
                }

                if(visited[mr][mc] == 0 && maps[mr][mc] == 1) {
                    visited[mr][mc] = visited[r][c] + 1;
                    q.add(new int[]{mr, mc});
                }
            }
        }
    }
}
