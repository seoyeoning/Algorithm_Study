package programmers.알고리즘고득점Kit.완전탐색.모음사전;

import java.util.*;

class Solution {

    String[] list = {"A","E","I","O","U"};
    int answer = 0;
    int count = 0;
    boolean found = false;

    public int solution(String word) {

        StringBuilder sb = new StringBuilder();

        dfs(sb,word);

        return answer;
    }

    void dfs(StringBuilder sb, String word) {
        if (found) return;
        if (sb.toString().equals(word)) {
            answer = count;
            found = true;
            return;
        }

        if (sb.length() == 5) return;

        for(int i=0; i<5; i++) {
            StringBuilder next = new StringBuilder(sb);
            next.append(list[i]);
            count++;
            dfs(next, word);
        }
    }
}
