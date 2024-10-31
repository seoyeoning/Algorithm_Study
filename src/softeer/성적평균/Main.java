package softeer.성적평균;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] scoreList = new int[N];

        for (int i=0; i<N; i++) {
            scoreList[i] = Integer.parseInt(st.nextToken());
        }

        // System.out.println(Arrays.toString(scoreList));

        // int[][] range = new int[K][2];
        double[] result = new double[K];

        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            int start = Integer.parseInt(st.nextToken()) - 1;
            int last = Integer.parseInt(st.nextToken()) - 1;
            float div = last-start+1;

            for(int j=start; j<=last; j++) {
                sum += scoreList[j];
            }

            // result[i] = Math.round((sum/div)*100)/100.0;
            result[i] = sum/div;
        }

        for (double d : result) {
            System.out.printf("%.2f\n",d);
        }


    }
}
