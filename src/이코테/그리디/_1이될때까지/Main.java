package 이코테.그리디._1이될때까지;

import java.io.*;
import java.util.*;

// n이 k의 배수가 될때까지 1을 빼줘야 하는 비효율적인 코드
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int result = 0;

        while (true) {

            if (n % k == 0) {
                n /= k;
            } else {
                n--;
            }
            result++;
            if (n == 1) {
                break;
            }

        }

        System.out.println(result);


    }

}
