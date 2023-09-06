package goorm.통신망분석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class fail {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

//        for (ArrayList<Integer> integers : list) {
//            System.out.println(integers);
//        }
        boolean[][] visited = new boolean[N + 1][N + 1];
        List<Integer> store = new ArrayList<>();

        float maxDensity = 0;
        List<Integer> maxCom = new ArrayList<>();
        int maxComNum = 0;
        int minCom = 0;

        for (int i = 1; i <= 1; i++) {
            if (!visited[i][i]) {
                int edgeNUM = bfs(i, list, visited,store);
                if (store.size() > 1) {
                    float density = (float) edgeNUM / store.size();
                    Collections.sort(store);

                    if (density > maxDensity) {
                        maxDensity = density;
                        maxCom.addAll(store);
                        maxComNum = store.size();
                        minCom = store.get(0);
                    } else if (density == maxDensity) {
                        if (store.size() < maxComNum) {
                            maxDensity = density;
                            maxCom.addAll(store);
                            maxComNum = store.size();
                            minCom = store.get(0);
                        } else if (store.size() == maxComNum) {
                            if (store.get(0) < minCom) {
                                maxDensity = density;
                                maxCom.addAll(store);
                                maxComNum = store.size();
                                minCom = store.get(0);
                            }
                        }
                    }
                }

                store.clear();
            }
        }

//        for (boolean[] booleans : visited) {
//            System.out.println(Arrays.toString(booleans));
//        }


        for (Integer integer : maxCom) {
            System.out.print(integer + " ");
        }


    }

    public static int bfs(int node, ArrayList<Integer>[] list, boolean[][] visited, List<Integer> store) {
        Queue<Integer> q = new LinkedList<>();
        visited[node][node] = true;
        q.add(node);
        store.add(node);

        int edgeNum = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int nextNode : list[now]) {
                if (!visited[now][nextNode] || !visited[nextNode][now]) {
                    edgeNum++;
                }
                visited[now][nextNode] = true;
                visited[nextNode][now] = true;

                if (!visited[nextNode][nextNode]) {
                    visited[nextNode][nextNode] = true;

                    q.add(nextNode);
                    store.add(nextNode);
                }
            }
        }

        return edgeNum;

    }


}
