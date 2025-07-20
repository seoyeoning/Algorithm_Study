package programmers.알고리즘고득점Kit.정렬.가장큰수;

import java.util.*;

class fail {

    int answer;

    public String solution(int[] numbers) {

        // 순열 numbers.length개 중에 numbers.length개 뽑기
        int n = numbers.length;
        pm(numbers, new int[n], new boolean[n], 0, n);

        return String.valueOf(answer);
    }

    public void pm(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if(depth == r) {
            String str = "";
            for(int o : out) {
                str += o;
            }
            int sum = Integer.parseInt(str);
            answer = Math.max(sum,answer);
            return;
        }

        for(int i=0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                pm(arr,out,visited, depth+1, r);
                visited[i] = false;
            }
        }
    }


}
