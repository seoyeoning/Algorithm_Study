package 이코테.구현.게임개발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 북,서,남,동 (반시계 방향)
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int character_r = Integer.parseInt(st.nextToken());
        int character_c = Integer.parseInt(st.nextToken());
        int character_d = Integer.parseInt(st.nextToken());

        Character character = new Character(character_r, character_c, character_d);

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < 4; i++) {

        }


    }

}

class Character {
    int r;
    int c;
    int d;

    public Character(int r, int c, int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}
