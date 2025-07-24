package programmers.알고리즘고득점Kit.그래프.가장먼노드;

import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;

        List<List<Integer>> g = new ArrayList<>();

        for(int i=0; i<=n; i++) {
            g.add(new ArrayList<>());
        }

        for(int[] e : edge) {
            g.get(e[0]).add(e[1]);
            g.get(e[1]).add(e[0]);
        }

        int maxDepth = 0;

        //bfs
        Queue<int[]> q = new LinkedList<>();
        Queue<int[]> store = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(new int[]{1,0});
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            for(int i : g.get(node[0])) {
                if(!visited[i]) {
                    q.offer(new int[]{i,node[1]+1});
                    store.offer(new int[]{i,node[1]+1});
                    maxDepth = Math.max(maxDepth,node[1]+1);
                    visited[i] = true;
                }
            }
        }

        while(!store.isEmpty()) {
            int[] node = store.poll();
            if (node[1] == maxDepth) answer++;
        }

        return answer;
    }
}
