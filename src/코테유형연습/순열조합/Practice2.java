package 코테유형연습.순열조합;

import java.util.Arrays;

public class Practice2 {

    public static void main(String[] args) {



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

    // 중복 순열
    public static void permutation_dup(int[] arr, int[] out, int depth, int r) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            out[depth] = arr[i];
            permutation_dup(arr, out, depth + 1, r);
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

    // 중복 조합
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
