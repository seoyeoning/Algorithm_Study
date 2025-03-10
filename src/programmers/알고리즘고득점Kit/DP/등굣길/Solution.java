package programmers.알고리즘고득점Kit.DP.등굣길;

import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 점화식 board[i][j] = board[i-1][j] + board[i][j-1];

        int[][] dp = new int[m][n];

        for(int[] p : puddles) {
            dp[p[0]-1][p[1]-1] = -1;
        }

        dp[0][0] = 1;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                } // 위 (-1,0) 왼 (0,-1)
                if(i > 0) {
                    dp[i][j] += dp[i-1][j] % 1000000007;
                }
                if(j >0) {
                    dp[i][j] += dp[i][j-1] % 1000000007;
                }
            }
        }

        return dp[m-1][n-1] % 1000000007;
    }
}
