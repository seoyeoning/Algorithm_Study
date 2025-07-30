package programmers.알고리즘고득점Kit.DFS_BFS.퍼즐조각채우기;

import java.util.*;

// BFS
// *정규화*가 포인트인 문제
// 회전을 구현하는 법
class Solution {

    int[] dr = {1,0,-1,0};
    int[] dc = {0,1,0,-1};
    boolean[][] visited;
    int row;
    int col;
    List<List<int[]>> gb;
    List<List<int[]>> ta;
    boolean[] taVisited;

    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;

        row = game_board.length;
        col = game_board[0].length;
        visited = new boolean[row][col];
        gb = new ArrayList<>();
        ta = new ArrayList<>();

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if (game_board[i][j]==0 && !visited[i][j]) {
                    gb.add(bfs(i,j,game_board,0));
                }
            }
        }
        visited = new boolean[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if (table[i][j]==1 && !visited[i][j]) {
                    ta.add(bfs(i,j,table,1));
                }
            }
        }

        taVisited = new boolean[ta.size()];
        for(List<int[]> g : gb) {
            int cnt = check(g);
            answer += cnt;
        }

        return answer;
    }

    List<int[]> bfs(int startR, int startC, int[][] store, int target) {
        List<int[]> result = new ArrayList<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR,startC});
        visited[startR][startC] = true;

        while(!q.isEmpty()) {
            int[] now = q.poll();
            result.add(now);
            for(int i=0; i<4; i++) {
                int nextR = now[0] + dr[i];
                int nextC = now[1] + dc[i];

                if(nextR>=0 && nextR<row && nextC>=0 && nextC<col) {
                    if (store[nextR][nextC] == target && !visited[nextR][nextC]) {
                        q.offer(new int[]{nextR,nextC});
                        visited[nextR][nextC] = true;
                    }
                }

            }
        }
        return normalize(result);
    }

    List<int[]> normalize(List<int[]> result) {

        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;

        for(int[] re : result) {
            minR = Math.min(minR,re[0]);
            minC = Math.min(minC,re[1]);
        }

        for(int[] re : result) {
            re[0] -= minR;
            re[1] -= minC;
        }

        return result;
    }

    int check(List<int[]> g) {
        for(int i=0; i<ta.size(); i++) {
            List<int[]> t = ta.get(i);
            if (taVisited[i] || g.size() != t.size()) continue;

            // 4번 회전 검사
            List<int[]> rotated = t;
            for(int j=0; j<4; j++) {
                if(compare(g,rotated)) { // 같은지 비교
                    taVisited[i] = true;
                    return g.size();
                }

                rotated = rotate(rotated); // 회전
            }
        }
        return 0;
    }

    boolean compare(List<int[]> g, List<int[]> t) {
        // 오름차순 정렬
        Collections.sort(g, (o1,o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);
        Collections.sort(t, (o1,o2) -> o1[0] == o2[0] ? o1[1]-o2[1] : o1[0]-o2[0]);

        for(int i=0; i<g.size(); i++) {
            int[] gg = g.get(i);
            int[] tt = t.get(i);

            if (gg[0] != tt[0] || gg[1] != tt[1]) return false;
        }
        return true;
    }

    List<int[]> rotate(List<int[]> rotated) {
        // (r,c) -> (c,-r), 정규화
        List<int[]> result = new ArrayList<>();
        for(int[] r : rotated) {
            int rr = r[1];
            int rc = -r[0];

            result.add(new int[]{rr,rc});
        }
        return normalize(result);
    }

}
