package programmers.알고리즘고득점Kit.이분탐색.입국심사;
import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);

        long start = 1;
        long end = times[times.length-1]*(long)n; // (long) 캐스팅 무조건 필수
        // 최소 시간 : 1, 최대 시간 : times[times.length-1]*n

        while (start <= end) {
            long mid = (start + end) / 2;
            long sum = 0;

            for(int time : times) {
                sum += (mid/time);
            }

            if (sum >= n) {
                answer = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return answer;
    }
}
