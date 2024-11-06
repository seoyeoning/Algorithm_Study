package 이코테.구현.왕실의나이트;

// String -> int 변환 (아스키코드)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    // 상,우,하,좌 (시계방향)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int now_c = (int) input.charAt(0) - 96;
        int now_r = Character.getNumericValue(input.charAt(1));

        int first_next_r;
        int first_next_c;

        int second_next_r;
        int second_next_c;

        int[] row = {0, 2};
        int[] col = {1, 3};

        int result = 0;

        for (int i = 0; i < 4; i++) {
            first_next_r = now_r + dr[i] * 2;
            first_next_c = now_c + dc[i] * 2;

            if (i % 2 == 0) {
                // 짝수 (상,하)
                for (int i1 : col) {
                    second_next_r = first_next_r + dr[i1];
                    second_next_c = first_next_c + dc[i1];
                    if (out_check(second_next_r, second_next_c)) {
                        result++;
                    }
                }

            } else {
                // 홀수 (우,좌)
                for (int i1 : row) {
                    second_next_r = first_next_r + dr[i1];
                    second_next_c = first_next_c + dc[i1];
                    if (out_check(second_next_r, second_next_c)) {
                        result++;
                    }
                }
            }
        }

        System.out.println(result);

    }

    public static boolean out_check(int r, int c) {
        if (r < 1 || r > 8 || c < 1 || c > 8) {
            return false;
        }
        return true;
    }

}
