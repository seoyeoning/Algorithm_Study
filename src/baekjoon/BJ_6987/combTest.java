package baekjoon.BJ_6987;

public class combTest {

    public static void main(String[] args) {
        int n = 4;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[4];

        comb(arr, visited, 0, 4, 3);
    }

    static void comb(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

}
