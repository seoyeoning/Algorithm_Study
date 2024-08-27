package programmers.카드뭉치;

import java.util.*;

public class success {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";

        int c1 = 0;
        int c2 = 0;

        for (int i=0; i < goal.length; i++) {
            if (c1 < cards1.length && goal[i].equals(cards1[c1])) {
                c1++;
            } else if (c2 < cards2.length && goal[i].equals(cards2[c2])) {
                c2++;
            } else {
                answer = "No";
            }
        }

        return answer;
    }

}
