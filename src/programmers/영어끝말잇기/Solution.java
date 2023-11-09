package programmers.영어끝말잇기;

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Set<String> hs = new HashSet<>();

        int index = 1; // 몇 번째 사람
        int turn = 1;  // 몇 번째 차례

        for (int i=0; i < words.length; i++) {

            if (i != 0) {
                // 앞사람 단어의 마지막 문자로 시작 안할 때
                if (words[i].charAt(0) != words[i-1].charAt(words[i-1].length()-1)) {
                    answer[0] = index;
                    answer[1] = turn;
                    return answer;
                }
            }

            // 이전에 등장한 단어일 때
            if (hs.contains(words[i])) {
                answer[0] = index;
                answer[1] = turn;
                return answer;
            }

            // 모두 통과
            hs.add(words[i]);
            index++;

            if (index == n+1) {
                index = 1;
                turn++;
            }
        }

        return answer;
    }
}
