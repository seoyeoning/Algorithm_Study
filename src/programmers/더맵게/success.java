package programmers.더맵게;

import java.util.*;
class success {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int x = -1;
        int y = -1;
        int new_sco = -1;

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for(Integer sco: scoville) {
            q.offer(sco);
        }

        while ( q.peek() < K ) {
            x = q.poll();
            y = q.poll();
            new_sco = x + ( y * 2 );
            q.offer(new_sco);
            answer++;

             if ( q.size() == 1 && q.peek() < K ) {
                 answer = -1;
                 break;
             }
        }
        return answer;
    }
}
