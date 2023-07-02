package baekjoon.BJ_10808;

import java.util.*;

public class success {
    public static void main(String[] args) {
        int[] result = new int[26];

        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (int i=0; i < str.length(); i++) {
            char c = str.charAt(i);

            int num = (byte)c - 97;

            result[num] += 1;
        }

        for(int i=0; i < 25; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.print(result[25]);

    }
}
