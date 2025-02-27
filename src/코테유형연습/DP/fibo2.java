package 코테유형연습.DP;

public class fibo2 {

    static int[] bottomup = new int[6];
    static int[] topdown = new int[6];

    public static void main(String[] args) {

        // 피보나치 수열 - 반복분
        // 피보나치 수열 - 재귀
        // 피보나치 수열 - DP BottomUp
        // 피보나치 수열 - DP TopDown

    }

    static int fibo_loop(int n) {
        if (n < 2) {
            return n;
        } else {
            int num0 = 0;
            int num1 = 1;
            int sum = 0;

            for (int i = 2; i <= n; i++) {
                sum = num0 + num1;
                num0 = num1;
                num1 = sum;
            }
            return sum;
        }
    }

    static int fibo_recursion(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo_recursion(n - 1) + fibo_recursion(n - 2);
        }
    }

    static int fibo_dp_bottomup(int n) {
        bottomup[1] = 1;

        for (int i = 2; i <= n; i++) {
            bottomup[i] = bottomup[i - 1] + bottomup[i - 2];
        }
        return bottomup[n];
    }

    static int fibo_dp_topdown(int n) {
        if (n < 2) {
            return n;
        }
        if (topdown[n] > 0) {
            return topdown[n];
        }
        topdown[n] = fibo_dp_topdown(n - 1) + fibo_dp_topdown(n - 2);
        return topdown[n];
    }



}
