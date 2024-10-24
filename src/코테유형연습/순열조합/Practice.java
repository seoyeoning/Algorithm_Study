package 코테유형연습.순열조합;

import java.util.Arrays;

public class Practice {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;

        permutation(arr, new int[r], new boolean[arr.length], 0, r);

        System.out.println("-----------------");

        permutation_dupl(arr, new int[r], 0, r);

        System.out.println("-----------------");

        combination(arr, new boolean[arr.length], 0, 0, r);

        System.out.println("-----------------");

        combination_dupl(arr, new int[r], 0, 0, r);

    }

    // 순열
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

    // 중복순열
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

    // 조합
    public static void combination(int[] arr, boolean[] visited, int start, int depth, int r) {
        if (depth == r) {
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + ", ");
                }
            }
            System.out.println();
            return;
        }

        for (int i = start; i < arr.length; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, depth + 1, r);
            visited[i] = false;
        }
    }

    // 중복조함
    public static void combination_dupl(int[] arr, int[] out, int start, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = start; i < arr.length; i++) {
            out[depth] = arr[i];
            combination_dupl(arr, out, i, depth + 1, r);
        }
    }
}
