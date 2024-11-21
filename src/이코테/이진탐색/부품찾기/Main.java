package 이코테.이진탐색.부품찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[N];

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int[] order_list = new int[M];

        for (int i = 0; i < M; i++) {
            order_list[i] = Integer.parseInt(st.nextToken());
        }

        // list 오름차순 정렬
        Arrays.sort(list);

        for (int target : order_list) {
            boolean result = binary_search(list, target, 0, list.length - 1);

            if (result) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }

    }

    // 재귀 이진탐색
    public static boolean binary_search(int[] list, int target, int start_index, int end_index) {

        if (start_index > end_index) { // 찾는 값이 없음
            return false;
        }

        int mid_index = (start_index + end_index) / 2;

        if (target == list[mid_index]) {
            return true;
        } else if (target > list[mid_index]) {
            return binary_search(list, target, mid_index + 1, end_index);
        } else {
            return binary_search(list, target, start_index, mid_index - 1);
        }

    }

}
