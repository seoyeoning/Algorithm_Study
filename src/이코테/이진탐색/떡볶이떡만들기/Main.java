package 이코테.이진탐색.떡볶이떡만들기;

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

        Integer[] list = new Integer[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list, Collections.reverseOrder());

        System.out.println(binary_search(list, 0, list[0], M));

    }

    static public int binary_search(Integer[] list, int start, int end, int target) {

        if (start > end) {
            return -1;
        }

        int mid = (start + end) / 2;

        int sum = 0;

        for (Integer integer : list) {
            if (integer > mid) {
                sum += (integer - mid);
            }
        }

        if (sum == target) {
            return mid;
        } else if (sum > target) {
            return binary_search(list, mid + 1, end, target);
        } else {
            return binary_search(list, start, mid - 1, target);
        }

    }

}
