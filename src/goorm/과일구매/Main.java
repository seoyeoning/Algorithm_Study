package goorm.과일구매;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        int[][] fruit = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int onePrice = c/p;
            fruit[i][0] = onePrice;
            fruit[i][1] = p;
            fruit[i][2] = c;
        }

        Arrays.sort(fruit,((o1, o2) -> {
            return o2[0] - o1[0];
        }));

//        for (int[] ints : fruit) {
//            System.out.println(Arrays.toString(ints));
//        }

        long cSum = 0;
        for (int i = 0; i < N; i++) {
            if (K >= fruit[i][1]) {
                cSum += fruit[i][2];
                K -= fruit[i][1];
//                System.out.println("cSum : " + cSum);
//                System.out.println("K : " + K);
            } else {
                cSum += fruit[i][0] * K;
//                System.out.println(cSum);
                K = 0;
            }
        }

        System.out.println(cSum);

    }

}
