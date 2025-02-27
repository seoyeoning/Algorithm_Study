package programmers.알고리즘고득점Kit.DP.정수삼각형.DP;

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        int[][] dp = new int[n][n];

        dp[0][0] = triangle[0][0];

        for(int i=0; i<n-1; i++) {
            for (int j=0; j<=i; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }

        for(int d : dp[n-1]) {
            answer = Math.max(answer,d);
        }

        return answer;
    }
}
