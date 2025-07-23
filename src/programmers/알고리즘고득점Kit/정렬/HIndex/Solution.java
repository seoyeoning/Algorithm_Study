package programmers.알고리즘고득점Kit.정렬.HIndex;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        // 오름차순 정렬
        Arrays.sort(citations);

        for(int i=0; i<citations.length; i++) {
            // 인용 논문 수
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
