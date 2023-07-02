package programmers.최소직사각형;

public class success_v2 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int max = 0, min = 0;
        int m, n;

        for (int i = 0; i < sizes.length; i++) {
            m = Math.max(sizes[i][0], sizes[i][1]);
            n = Math.min(sizes[i][0], sizes[i][1]);

            max = Math.max(max, m);
            min = Math.max(min, n);
        }
        answer = max * min;
        return answer;
    }
}
