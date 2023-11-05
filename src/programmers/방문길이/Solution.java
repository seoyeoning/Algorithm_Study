package programmers.방문길이;
import java.util.*;

class Solution {

    static int[] dr = {-1,1,0,0}; // U,D,L,R (상하좌우)
    static int[] dc = {0,0,-1,1};
    static Set<Character>[][] board = new HashSet[11][11];

    static int r = 5;
    static int c = 5;
    static int next_r = -1;
    static int next_c = -1;

    static boolean check = false;

    public int solution(String dirs) {
        int answer = 0;

        for (int i=0; i < dirs.length(); i++) {
            char dir = dirs.charAt(i);

            checkAndCreatSet(r,c);

            if (dir == 'U') {
                move_U();
            } else if (dir == 'D') {
                move_D();
            } else if (dir == 'L') {
                move_L();
            } else if (dir == 'R') {
                move_R();
            }

            if (!check && !board[r][c].contains(dir)) { // 존재 안함.
                answer++;

                board[r][c].add(dir);

                if (dir == 'U') {
                    board[next_r][next_c].add('D');
                } else if (dir == 'D') {
                    board[next_r][next_c].add('U');
                } else if (dir == 'L') {
                    board[next_r][next_c].add('R');
                } else if (dir == 'R') {
                    board[next_r][next_c].add('L');
                }

            }
            if (check) {
                check = false;
            }

            r = next_r;
            c = next_c;

        }

        return answer;
    }

    public void move_U() {

        next_r = r + dr[0];
        next_c = c + dc[0];

        if (next_r < 0 || next_c < 0 || next_r > board.length -1 || next_c > board.length -1) {
            next_r = r;
            next_c = c;
            check = true;
            return;
        }

        checkAndCreatSet(next_r,next_c);
    }
    public void move_D() {
        next_r = r + dr[1];
        next_c = c + dc[1];

        if (next_r < 0 || next_c < 0 || next_r > board.length -1 || next_c > board.length -1) {
            next_r = r;
            next_c = c;
            check = true;
            return;
        }

        checkAndCreatSet(next_r,next_c);
    }

    public void move_L() {
        next_r = r + dr[2];
        next_c = c + dc[2];

        if (next_r < 0 || next_c < 0 || next_r > board.length -1 || next_c > board.length -1) {
            next_r = r;
            next_c = c;
            check = true;
            return;
        }

        checkAndCreatSet(next_r,next_c);
    }

    public void move_R() {
        next_r = r + dr[3];
        next_c = c + dc[3];

        if (next_r < 0 || next_c < 0 || next_r > board.length -1 || next_c > board.length -1) {
            next_r = r;
            next_c = c;
            check = true;
            return;
        }

        checkAndCreatSet(next_r,next_c);
    }

    public void checkAndCreatSet(int r,int c) {
        if (board[r][c] == null) {
            board[r][c] = new HashSet<>();
        }
    }

}


