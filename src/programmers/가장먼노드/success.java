package programmers.가장먼노드;
import java.util.*;
class success {

    static boolean visited[];
    static ArrayList<Integer>[] A;

    public int solution(int n, int[][] edge) {
        int answer = 0;

        // n : 노드 개수
        // edge.length = m : 에지 개수

        int m = edge.length;
        A = new ArrayList[n+1];

        for(int i=1; i <= n; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for(int[] e : edge) {
            A[e[0]].add(e[1]);
            A[e[1]].add(e[0]);
        }

        System.out.println(Arrays.deepToString(A));

        for(int i=1; i < n; i++) {
            Collections.sort(A[i]);
        }

        System.out.println(Arrays.deepToString(A));

        visited = new boolean[n+1];

        System.out.println(Arrays.toString(visited));

        //dfs(1,count+1);
        //System.out.println(count);
        //bfs(1);

        for(int i=0; i < A[1].size(); i++) {
            System.out.println(A[1].get(i));
        }


        int count = 0;

        return answer;
    }

    public static void dfs(int node, int count) {
        //mSystem.out.print(node +" ");
        visited[node] = true;
        for(int i : A[node]) {
            if(!visited[i]) {
                // count ++;
                //dfs(i);
            }
        }
    }

    public static void bfs(int node) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        visited[node] = true;

        while(!q.isEmpty()) {
            int now_node = q.poll();
            System.out.println(now_node +" ");
            for(int i : A[now_node]) {
                if(!visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
