package programmers.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<task> q = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            q.offer(new task(progresses[i],speeds[i]));
        }

        // System.out.println(q.isEmpty());

//         for(task t : q) {
//             System.out.println(t.progress);
//         }

//         for (task t : q) {
//                 t.progress += t.speed;
//             }
//         for(task t : q) {
//             System.out.println(t.progress);
//         }




        while (!q.isEmpty()) {

            int finish_task = 0;

            for (task t : q) {
                t.progress += t.speed;
            }

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
