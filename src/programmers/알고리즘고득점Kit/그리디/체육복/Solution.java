package programmers.알고리즘고득점Kit.그리디.체육복;

import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        int[] list = new int[n];

        // lost
        for(int i : lost) list[i-1]--;
        // reserve
        for(int i : reserve) list[i-1]++;

        for(int i=0; i<n; i++) {
            // 체육복 없을 때
            if (list[i] == -1) {
                if (i > 0 && list[i-1] == 1) { // 앞 사람 체육복 빌리기
                    list[i]++;
                    list[i-1]--;
                } else if (i<n-1 && list[i+1]==1) { // 뒷 사람 체육복 빌리기
                    list[i]++;
                    list[i+1]--;
                }
            }
            if(list[i] >=0) answer++;
        }

        return answer;
    }
}
