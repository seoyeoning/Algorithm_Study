package programmers.알고리즘고득점Kit.그리디.큰수만들기;

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for(int i=0; i<number.length()-k; i++) { // number.length() - k 만큼 뽑힘
            int max = 0;
            for(int j=idx; j <= i+k; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    idx = j + 1;
                }
            }
            sb.append(max);
        }

        return sb.toString();
    }
}
