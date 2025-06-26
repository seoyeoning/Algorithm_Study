package programmers.알고리즘고득점Kit.스택_큐.주식가격;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        for(int i=0; i<n; i++) {
            int k = prices[i];
            for(int j=i+1; j<n; j++) {
                if (k <= prices[j]){
                    answer[i]++;
                } else {
                    answer[i]++;
                    break;
                }
            }
        }
        return answer;
    }
}
