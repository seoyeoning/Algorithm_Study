package goorm.운동중독플레이어;

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        float r = Float.parseFloat(st.nextToken());

        float x = w * (1 + (r/30));

        int result = (int) x;

        System.out.println(result);

    }
}
