package programmers.거리두기확인하기;

import java.util.*;

class Solution {

    int[] dr = {-1,1,0,0,-2,2,0,0,-1,1,1,-1,0,0,1,-1}; // 상하좌우
    int[] dc = {0,0,-1,1,0,0,-2,2,-1,1,-1,1,-1,1,0,0};


    public int[] solution(String[][] places) {
        int[] answer = {1,1,1,1,1};

        for (int k=0; k < 5; k++) {

            String[][] board = new String[5][5];
            boolean p_check = false;
            for (int i=0; i < 5; i++) {
                for (int j=0; j < 5; j++) {
                    if (places[k][i].charAt(j) == 'P') p_check = true;
                    board[i][j] = String.valueOf(places[k][i].charAt(j));
                }
            }
            for (String[] str : board) {
                System.out.println(Arrays.toString(str));
            }

            if (!p_check) { // 응시자가 없을 때 -> 1
                continue;
            }

            Loop1 :
            for (int i=0; i < 5; i++) {
                for (int j=0; j < 5; j++) {
                    if (board[i][j].equals("P")) {

                        int now_r = i;
                        int now_c = j;
                        for (int l=0; l < 4; l++) {
                            //상하좌우 P -> 무조건 0
                            int next_r_v1 = now_r + dr[l];
                            int next_c_v1 = now_c + dc[l];

                            if (next_r_v1 < 0 || next_r_v1 > 4 || next_c_v1 < 0 || next_c_v1 > 4) continue;

                            if (board[next_r_v1][next_c_v1].equals("P")) {
                                answer[k] = 0;
                                break Loop1;
                            }

                            // 상하좌우 멘해튼 거리 2 -> 파티션 검사
                            int next_r_v2 = now_r + dr[l+4];
                            int next_c_v2 = now_c + dc[l+4];
                            if (next_r_v2 < 0 || next_r_v2 > 4 || next_c_v2 < 0 || next_c_v2 > 4) continue;

                            if (board[next_r_v2][next_c_v2].equals("P")) {
                                if (!board[next_r_v1][next_c_v1].equals("X")) {
                                    answer[k] = 0;
                                    break Loop1;
                                }
                            }

                            // 대각선 맨해튼 거리 2 -> 파티션 검사
                            int next_r_v3 = now_r + dr[l+8];
                            int next_c_v3 = now_c + dc[l+8];
                            if (next_r_v3 < 0 || next_r_v3 > 4 || next_c_v3 < 0 || next_c_v3 > 4) continue;

                            if (board[next_r_v3][next_c_v3].equals("P")) {
                                int check_r = now_r + dr[l+12];
                                int check_c = now_c + dc[l+12];
                                if (check_r < 0 || check_r > 4 || check_c < 0 || check_c > 4) continue;
                                if (!board[next_r_v1][next_c_v1].equals("X") || !board[check_r][check_c].equals("X")) {
                                    answer[k] = 0;
                                    break Loop1;
                                }
                            }

                        }
                    }
                }
            }
        }
        return answer;
    }
}