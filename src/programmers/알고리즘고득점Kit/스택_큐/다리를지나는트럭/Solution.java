package programmers.알고리즘고득점Kit.스택_큐.다리를지나는트럭;

import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<bridge_length-1; i++) {
            q.offer(0);
        }
        // 첫 트럭 넣기
        q.offer(truck_weights[0]);
        // 다리 위 트럭 무게 합
        int weightSum = truck_weights[0];

        int index = 1;
        answer += 1;

        while(!q.isEmpty()) {
            answer++;
            int popT = q.poll();
            weightSum -= popT;

            if (index < truck_weights.length) { // 대기 트럭 존재
                if(truck_weights[index] > (weight-weightSum)) { // 무게 초과
                    q.offer(0);
                } else { // 트럭 넣기
                    q.offer(truck_weights[index]);
                    weightSum += truck_weights[index];
                    index++;
                }
            }

        }

        return answer;
    }
}
