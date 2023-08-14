package baekjoon.BJ_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class success {

    static int Max = Integer.MIN_VALUE;
    static int Min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        int[] operator = new int[4];
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num, operator, 0,num[0]);

        System.out.println(Max);
        System.out.println(Min);

    }

    // operator +, - , *, /
    public static void dfs(int[] num, int[] operator, int now, int now_num) {

        if (now == num.length - 1) { // now = depth
            Max = Math.max(Max, now_num);
            Min = Math.min(Min, now_num);
            return;
        }

        int next_num = num[now + 1]; // now_num = num[0] = 5, num[1] = 6

        int now_result = 0;

        for (int i = 0; i < 4; i++) {

            if (operator[i] != 0) {

                operator[i]--;

                if (i == 0) {
                    now_result = now_num + next_num;
                } else if (i == 1) {
                    now_result = now_num - next_num;
                } else if (i == 2) {
                    now_result = now_num * next_num;
                } else if (i == 3) {
                    now_result = now_num / next_num;
                }

                dfs(num,operator, now + 1, now_result);

                operator[i]++;

            }

        }


    }
}
