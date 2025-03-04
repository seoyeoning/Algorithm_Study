package programmers.알고리즘고득점Kit.DP.N으로표현;

import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;

        List<Set<Integer>> allList = new ArrayList<>();

        for(int i=1; i<=8; i++) {
            allList.add(new HashSet<>());
        }

        allList.get(1).add(N);

        // System.out.println(allList.get(1));

        for(int i=2; i<=8; i++) {
            for(int j=1; i<j; j++) {

                for(int pre : allList.get(i)) {
                    for(int post : allList.get(i-j)) {

                    }
                }

            }
        }



        return answer;
    }
}
