package baekjoon.BJ_1929;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));

        List<Integer> list;

        for (int i = M; i <= N; i++) {
            list = new ArrayList<>();
            for (int j = 1; j * j <= i; j++) { // 약수 구하기
                if (i % j == 0) {
                    list.add(j);
                    if (i / j != j) {
                        list.add(i / j);
                    }
                }
            }

            if (list.size() == 2) { // 소수
                br.write(i + "\n");
            }
        }

        br.flush();
        br.close();

    }
}
