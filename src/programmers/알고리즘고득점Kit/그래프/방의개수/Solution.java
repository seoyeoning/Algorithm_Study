package programmers.알고리즘고득점Kit.그래프.방의개수;

import java.util.*;

class Solution {

    int[] dr = {-1,-1,0,1,1,1,0,-1};
    int[] dc = {0,1,1,1,0,-1,-1,-1};

    public int solution(int[] arrows) {
        int answer = 0;

        Map<Node,ArrayList<Node>> map = new HashMap<>();
        Node nowNode = new Node(0,0);
        map.put(nowNode,new ArrayList<>());

        for(int arrow : arrows) {
            for(int i=0; i<2; i++) {

                Node nextNode = new Node(nowNode.r + dr[arrow], nowNode.c + dc[arrow]);

                // next가 첫 방문인지 검사
                if (!map.containsKey(nextNode)) { // 첫 방문 -> map에 추가
                    map.put(nextNode,new ArrayList<>());

                    map.get(nowNode).add(nextNode);
                    map.get(nextNode).add(nowNode);
                } else if (!map.get(nextNode).contains(nowNode)) { // 재방문 -> 새로운 간선 검사
                    map.get(nowNode).add(nextNode);
                    map.get(nextNode).add(nowNode);

                    answer++;
                }
                nowNode = nextNode;
            }
        }
        return answer;
    }
}

class Node {
    int r;
    int c;

    Node (int r, int c) {
        this.r = r;
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return r == node.r && c == node.c;
    }

    @Override
    public int hashCode() {
        return Objects.hash(r,c);
    }
}
