package baekjoon.BJ_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();

        while (st.hasMoreTokens()) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int sum = 0;
        int result = 0;
        for (Integer i : list) {
            sum += i;
            result += sum;
        }

        System.out.println(result);

    }

}
