package programmers.알고리즘고득점Kit.DP.정수삼각형.재귀;

import java.util.*;

class Solution {

    int n;
    int answer;

    public int solution(int[][] triangle) {

        n = triangle.length;

        int[][] board = new int[n][n];

        recur(triangle,0,0,0,1);

        return answer;
    }

    public void recur(int[][] triangle, int r, int c, int sum, int d) {
        sum += triangle[r][c];

        if (d == n) {
            answer = Math.max(answer, sum);
            return;
        }

        recur(triangle,r+1,c,sum,d+1);
        recur(triangle,r+1,c+1,sum,d+1);

    }
}
