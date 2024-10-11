package programmers.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {

        List<Integer> list = new LinkedList<>();

        Queue<task> q = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            q.offer(new task(progresses[i],speeds[i]));
        }

        while (!q.isEmpty()) {

            int finish_task = 0;

            for (task t : q) {
                t.progress += t.speed;
            }

            int count = q.size();

            for (int i=0; i<count; i++) {
                if (q.peek().progress >= 100) {
                    q.remove();
                    finish_task++;
                } else {
                    break;
                }
            }

            if (finish_task > 0) {
                list.add(finish_task);
            }

        }

        int[] answer = new int[list.size()];

        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}

class task {
    int progress;
    int speed;

    task(int progress, int speed) {
        this.progress = progress;
        this.speed = speed;
    }
}
