package programmers.알고리즘고득점Kit.그리디.조이스틱;

import java.util.*;

class Solution {
    public int solution(String name) {
        int answer = 0;

        int n = name.length();
        int move = name.length()-1;

        for(int i=0; i<n; i++) {
            // 상하 계산
            answer += Math.min(name.charAt(i)-'A','Z'-name.charAt(i)+1);

            // A가 연속된는 구간
            int next = i+1;
            while(next < n && name.charAt(next) == 'A') next++;

            // 돌아가기, 순서대로 가기
            move = Math.min(move, (i*2) + (n-next));
            move = Math.min(move, (n-next)*2+i);
        }
        answer += move;

        return answer;
    }
}
