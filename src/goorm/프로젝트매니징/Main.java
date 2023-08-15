package goorm.프로젝트매니징;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int sum = 0;
        for (int i=0; i < N; i++) {
            int c = Integer.parseInt(br.readLine());
            sum += c;
        }

        int h = (sum + M) / 60;
        int m = (sum + M) % 60; // 0 <= m <= 59

        int result = (h+T) % 24;

        System.out.print(result + " ");
        System.out.print(m);
    }
}
