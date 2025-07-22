package programmers.알고리즘고득점Kit.힙.디스크컨트롤러;

import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int taskCnt = jobs.length;

        // jobs를 요청 시점 오름차순으로 정렬
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        // 작업 소요 시간 오름차순
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        int count = 0;
        int nowT = 0;
        int time = 0;
        while(count < taskCnt) {

            while (nowT < taskCnt && jobs[nowT][0] <= time) {
                q.offer(jobs[nowT]);
                nowT++;
            }

            if (q.isEmpty()) {
                time = jobs[nowT][0];
            } else {
                int[] task = q.poll();
                time += task[1];
                answer += (time - task[0]);
                count++;
            }

        }

        return answer/taskCnt;
    }
}