package goorm.완벽한햄버거만들기;

import java.io.*;
import java.util.*;
class fail {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] burger = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i < N; i++) {
            burger[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int max_num = 0;
        for (int i=0; i < N; i++) {
            if (burger[i] > max) {
                max = burger[i];
                max_num = i;
            }
        }

        int result = 0;
        for (int i=0; i < N; i++) {
            if (i <= max_num ) {
                if (burger[i] <= burger[i+1]) {
                    result += burger[i];
                } else {
                    result = 0;
                    break;
                }
            } else {
                if (i == N-1) {
                    result += burger[i];
                    break;
                }
                if (burger[i] >= burger[i+1]) {
                    result += burger[i];
                } else {
                    result = 0;
                    break;
                }
            }
        }

        System.out.println(result);

    }
}
