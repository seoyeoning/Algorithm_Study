package programmers.정수삼각형;

import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        int n = triangle.length;

        int[][] board = new int[n][n];

        board[0][0] = triangle[0][0];

        for (int i=0; i < n-1; i++) {
            for (int j=0; j <=i; j++) {
                int left = board[i][j] + triangle[i+1][j];
                int right = board[i][j] + triangle[i+1][j+1];

                board[i+1][j] = Math.max(left,board[i+1][j]);
                board[i+1][j+1] = Math.max(right,board[i+1][j+1]);
            }
        }

        for (int i : board[n-1]) {
            answer = Math.max(answer,i);
        }

        return answer;
    }

}
