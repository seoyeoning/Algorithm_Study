package 코테유형연습.순열조합;

import java.security.PublicKey;
import java.util.Arrays;

public class Combination {

    // 조합 : 서로 다른 n개에서 순서 없이 r개를 뽑는 경우의 수
    // 중복 조합 : 서로 다른 n개에서 중복이 가능하게 r개를 뽑는 경우의 수 (뽑았던 거 다시 뽑기 가능)
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;

//        combination(arr, new boolean[arr.length], 0, 0, r);

        combination_dupl(arr, new int[r], 0, 0, r);
    }

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
            if (!visited[i]) {
                visited[i] = true;
                combination(arr, visited, i + 1, depth + 1, r);
                visited[i] = false;
            }
        }
    }

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
