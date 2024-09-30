package 코테유형연습.DP;

// DP(Dynamic Programming, 동적 계획법) : 하나의 큰 문제를 여러 개의 작은 문제로 나눈 후 그 결과를 저장하여 다시 큰 문제를 해결하는 것)
// 쪼갠 작은 문제를 저장해뒀다가 재활용!

//DP의 사용 조건
//1. Overlapping Subproblems (겹치는 부분 문제)
//2. Optimal Substructure (최적 부분 구조)

//1. DP로 풀 수 있는 문제인지 확인
//2. 문제의 변수 파악
//3. 변수 간 관계식(점화식) 만들기
//4. 메모하기(Memoization or tabulation)
//5. 기저 상태 파악하기 f(0) = 0, f(1) = 1 ,초기값
//6. 구현하기

//DP의 핵심은 메모이제이션(memoization)

import java.util.Arrays;

public class fibo {

    static int[] bottomup = new int[6];
    static int[] topdown = new int[6];

    public static void main(String[] args) {

        // 피보나치 수열 - 반복문
//        System.out.println(fibo_loop(6));

        // 피보나치 수열 - 재귀
//        System.out.println(fibo_recursion(6));

        // 피보나치 수열 - DP BottomUp 방식
//        System.out.println(fibo_dp_topdown(5));

        // 피보나치 수열 - DP TopDown 방식
        System.out.println(fibo_dp_bottopup(5));

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

    static int fibo_dp_bottopup(int n) {
//        bottomup[0] = 0;
        bottomup[1] = 1;

        for (int i = 2; i <= n; i++) {
            bottomup[i] = bottomup[i - 1] + bottomup[i - 2];
        }

        return bottomup[n];

    }

    static int fibo_dp_topdown(int n) {
        System.out.println(n);
        System.out.println(Arrays.toString(topdown));
        // 기저상태
        if (n < 2)  {
            System.out.println("여기1");
            return topdown[n] = n;
        }

        if (topdown[n] > 0) {
            System.out.println("여기2");
            return topdown[n];
        }

        topdown[n] = fibo_dp_topdown(n-1) + fibo_dp_topdown(n-2);

        return topdown[n];

    }
}
