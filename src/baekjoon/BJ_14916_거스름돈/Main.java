package baekjoon.BJ_14916_거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;

        while (true) {

            if (n % 5 == 0) {
                count += n / 5;
                n %= 5;
                break;
            } else {
                n -= 2;
                count++;
            }

            if (n < 2) {
                break;
            }

        }

        if (n == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }

    }

}
