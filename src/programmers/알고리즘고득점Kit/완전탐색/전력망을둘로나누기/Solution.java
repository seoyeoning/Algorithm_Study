package programmers.알고리즘고득점Kit.완전탐색.전력망을둘로나누기;

import java.util.*;

class Solution {

    int min = Integer.MAX_VALUE;
    List<List<Integer>> list;

    public int solution(int n, int[][] wires) {

        list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            list.get(a).add(b);
            list.get(b).add(a);
        }

        // 하나씩 끊으면서 순회
        for(int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            // 끊기
            // remove의 값이 int이면 무조건 index로 인식함 -> Integer로 변환해야함
            // Integer.parseInt -> 문자열을 Integer로 변환
            // Integer.valueOf -> int를 Integer로 변환
            list.get(a).remove(Integer.valueOf(b));
            list.get(b).remove(Integer.valueOf(a));

            int count = dfs(1,new boolean[n+1]);
            int diff = Math.abs(count-(n-count));
            min = Math.min(min,diff);

            // 다시 붙이기
            list.get(a).add(b);
            list.get(b).add(a);

        }

        return min;
    }

    int dfs(int node, boolean[] visited) {
        visited[node] = true;
        int cnt = 1;

        for(Integer next : list.get(node))  {
            if(!visited[next]) {
                cnt += dfs(next,visited);
            }
        }
        return cnt;
    }
}
