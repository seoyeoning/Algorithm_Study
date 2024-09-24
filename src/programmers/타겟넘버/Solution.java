package programmers.타겟넘버;

public class Solution {

    static int answer = 0;

    public int solution(int[] numbers, int target) {

        cal(numbers,numbers[0],target,0);
        cal(numbers,-numbers[0],target,0);

        return answer;
    }

    void cal(int[] numbers, int now, int target, int i) {
        if (i == numbers.length - 1 && now == target) {
            answer++;
        } else if (i == numbers.length - 1 && now != target){
            return;
        } else {
            ++i;
            cal(numbers, now+numbers[i], target, i);
            cal(numbers, now-numbers[i], target, i);
        }
    }
}
