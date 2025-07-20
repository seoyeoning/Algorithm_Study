package programmers.알고리즘고득점Kit.정렬.K번째수;

import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int i=0;
        for(int[] command : commands) {
            int[] arr = Arrays.copyOfRange(array, command[0] - 1, command[1]);
            Arrays.sort(arr);
            answer[i] = arr[command[2]-1];
            i++;
        }
        return answer;
    }
}
