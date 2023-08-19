package goorm.완벽한햄버거만들기;

import java.io.*;
import java.util.*;

class Main {
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
        boolean result_1 = true;
        for (int i=0; i < max_num; i++) {
            if (burger[i] > burger[i+1]) {
                result_1 = false;
                break;
            }
        }
        boolean result_2 = true;
        for (int i=max_num; i < N-1; i++) {
            if (burger[i] < burger[i+1]) {
                result_2 = false;
                break;
            }
        }
        int sum=0;
        if (result_1 && result_2) {
            for (int i=0; i < N; i++) {
                sum += burger[i];
            }
            System.out.println(sum);
        } else {
            System.out.println(sum);
        }
    }
}
