package programmers.알고리즘고득점Kit.DFS_BFS.여행경로;

import java.util.*;

// dfs, 백트래킹 -> ticket을 다 사용할 때까지
// ICN 시작
class Solution {

    List<String> list;
    boolean[] visited;

    public String[] solution(String[][] tickets) {

        list = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs("ICN","ICN",0,tickets);

        Collections.sort(list);

        return list.get(0).split(" ");
    }

    public void dfs(String start, String move, int count, String[][] tickets) {
        if (count == tickets.length) {
            list.add(move);
            return;
        }

        for(int i=0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(start)) {
                visited[i] = true;
                dfs(tickets[i][1], move + " " + tickets[i][1],count+1,tickets);
                visited[i] = false;
            }
        }
    }


}