package programmers.알고리즘고득점Kit.그래프.순위;

import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;

        int[][] board = new int[n+1][n+1];

        for(int[] result : results) {
            board[result[0]][result[1]] = 1;
            board[result[1]][result[0]] = -1;
        }

        // 플로이드 워셜
        // A > B, B > C -> A > C 모순이 없다.
        // board[i][j] -> board[i][k], board[k][j]
        for(int k=1; k <=n; k++) { // 중간
            for(int i=1; i<=n; i++) {
                for(int j=1; j<=n; j++) {
                    if (board[i][k] == 1 && board[k][j] == 1) {
                        board[i][j] = 1;
                        board[j][i] = -1;
                    }
                    if (board[i][k] == -1 && board[k][j] == -1) {
                        board[i][j] = -1;
                        board[j][i] = 1;
                    }
                }
            }
        }

        // 순위 계산
        for(int i=1; i<=n; i++) {
            int check = 0;
            for(int j=1; j<=n; j++) {
                if (board[i][j] == 1 || board[i][j] == -1) check++;
            }
            if (check == n-1) answer++;
        }

        return answer;
    }
}
