package programmers.크레인인형뽑기게임;

import java.util.Arrays;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> st = new Stack<>();
//         확인용
        System.out.println("처음");
         for (int[] b : board) {
             System.out.println(Arrays.toString(b));
         }

        int r = board.length;
        for (int i=0; i < moves.length; i++) {

            int c = moves[i]-1; // moves 기준을 바꿔줌 (열)

            for (int j=0; j < r; j++) { // 열을 위에서 아래로 이동 (인형뽑기처럼)
                if (board[j][c] != 0) {
                    if (st.empty()) {
                        System.out.println("비어서 그냥 넣음");
                        st.push(board[j][c]); // 비었을 때 그냥 넣기
                        board[j][c] = 0;
                    } else {
                        if (board[j][c] == st.peek()) {
                            System.out.println("같아서 뺌");
                            st.pop();
                            board[j][c] = 0;
                            answer += 2;
                        } else {
                            System.out.println("다름");
                            st.push(board[j][c]);
                            board[j][c] = 0;
                        }
                    }
                    break;
                }
            }
             for (int[] b : board) {
                 System.out.println(Arrays.toString(b));
             }
        }

        return answer;
    }
}
