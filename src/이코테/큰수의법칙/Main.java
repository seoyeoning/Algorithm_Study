package etc.큰수의법칙;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Integer[] nums = new Integer[N];

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums, Collections.reverseOrder());

        int first = nums[0];
        int second = nums[1];

        int sum = 0;

        while (true) {

            for (int i = 0; i < K; i++) {
                if (M == 0) {
                    break;
                }

                sum += first;
                M--;
            }
            if (M == 0) {
                break;
            }
            sum += second;
            M--;

        }

        System.out.println(sum);

    }

}
