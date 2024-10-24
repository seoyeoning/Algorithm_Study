package 코테유형연습.순열조합;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Permutation {

    // 순열 : 서로 다른 n개에서 r개를 뽑아 정렬하는 경우의 수
    // 중복 순열: 서로 다른 n개에서 중복이 가능하게 r개를 뽑아서 정렬 (같은 거 또 뽑기 가능)
    public static void main(String[] args) {


        int[] arr = {1, 2, 3};
        int r = 2;

        // 4P2 4개중 2개 선택해서 정렬
        permutation(arr, new int[r], new boolean[arr.length], 0, r);

        permutation_dupl(arr, new int[r], 0, r);

    }

    public static void permutation(int[] arr, int[] out, boolean[] visited, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, out, visited, depth + 1, r);
                visited[i] = false;
            }
        }
    }

    public static void permutation_dupl(int[] arr, int[] out, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            out[depth] = arr[i];
            permutation_dupl(arr, out, depth + 1, r);
        }
    }



}
