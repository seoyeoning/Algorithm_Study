package baekjoon.BJ_16953;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class success {

    static int sum = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Long begin = Long.parseLong(st.nextToken());
        Long target = Long.parseLong(st.nextToken());

        int count = 0;
        dfs(begin, target,count);

        if (sum == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum+1);
        }

    }

    public static void dfs(Long num, Long target, int count) {

        if (num.equals(target)) {
//            System.out.println("타겟!!");
            sum = Math.min(sum, count);
        } else if (num > target) {
        } else {
            dfs(num * 2, target,count+1);
            dfs(Long.parseLong(num+"1"), target,count+1);
        }
    }
}

// 나는 혹시 ? 처음에 1을 붙이는게 아니라 1을 더해줌..
//        System.out.println("dfs 들어옴");
//        System.out.println("num = " + num);
//        System.out.println("count = " + count);
//        System.out.println("sum = " + sum);