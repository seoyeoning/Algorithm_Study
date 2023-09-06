package goorm.통신망분석;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 성공
 * but 중요한 문법 (정렬, 이너 클래스 등 다시 공부하기)
 */
public class Main {

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
        boolean[] visited = new boolean[N + 1];

        List<Component> comList = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i, list, visited,comList);
            }
        }


        Collections.sort(comList, new Comparator<Component>() {

            @Override
            public int compare(Component o1, Component o2) {
                if (o1.getDensity() < o2.getDensity()) {
                    return 1;
                } else if (o1.getDensity() > o2.getDensity()) {
                    return -1;
                } else {
                    if (o1.getComNum() > o2.getComNum()) {
                        return 1;
                    } else if (o1.getComNum() < o2.getComNum()) {
                        return -1;
                    } else {
                        if (o1.getMinCom() > o2.getMinCom()) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        });



//        for (boolean[] booleans : visited) {
//            System.out.println(Arrays.toString(booleans));
//        }

//        for (Component component : comList) {
//            System.out.println(component.getComputers());
//            System.out.println(component.getDensity());
//            System.out.println(component.comNum);
//            System.out.println(component.minCom);
//        }

        for (int c : comList.get(0).computers) {
            System.out.print(c + " ");
        }




    }

    public static void bfs(int node, ArrayList<Integer>[] list, boolean[] visited, List<Component> comList) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> store = new ArrayList<>();
        visited[node] = true;
        q.add(node);
        store.add(node);

        int edgeNum = 0;
        while (!q.isEmpty()) {
            int now = q.poll();

            for (int nextNode : list[now]) {
                edgeNum++;
                if (!visited[nextNode]) {
                    visited[nextNode] = true;

                    q.add(nextNode);
                    store.add(nextNode);
                }
            }
        }

//        System.out.println("%% : " +edgeNum);

        if (store.size() > 1) {
            float density = (float) (edgeNum/2) / store.size();
            Collections.sort(store);

            comList.add(new Component(store, density));
        }

    }

    static class Component{

        private List<Integer> computers;
        private final float density;
        private final int comNum;
        private final int minCom;


        public Component(List<Integer> computers, float density) {
            this.computers = computers;
            this.density = density;
            this.comNum = computers.size();
            this.minCom = computers.get(0);
        }

        public List<Integer> getComputers() {
            return computers;
        }

        public float getDensity() {
            return density;
        }

        public int getComNum() {
            return comNum;
        }

        public int getMinCom() {
            return minCom;
        }

    }

}

// 밀도 내림차순
// 컴포넌트 수 오름차순
// 컴퓨터 번호 오름차순

//15 15
//1 5
//2 4
//6 3
//10 9
//6 5
//3 5
//5 2
//4 9
//8 7
//15 12
//13 11
//7 13
//13 14
//15 11
//12 8