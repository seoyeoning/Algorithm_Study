package programmers.명예의전당1;
import java.util.*;

public class fail {
    public int[] solution(int k, int[] score) {

        int score_length = score.length;

        int[] answer = new int[score_length];

        PriorityQueue<Integer> best = new PriorityQueue<>();

        for (int i=0; i < score_length; i++) {

            if (i < k) {
                best.add(score[i]);
            } else {

            }

        }

        return answer;
    }
}
