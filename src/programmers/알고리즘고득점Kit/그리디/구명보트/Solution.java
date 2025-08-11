package programmers.알고리즘고득점Kit.그리디.구명보트;

import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int idx = 0; // 가장 가벼운 무게 기준
        for(int i=people.length-1; i>=idx; i--) {
            if (people[i]+people[idx] <= limit) {
                answer++;
                idx++;
            } else {
                answer++;
            }
        }

        return answer;
    }
}
