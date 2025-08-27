package programmers.kakao._2022_KAKAO_BLIND_RECRUITMENT.k진수에서소수개수구하기;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        // n을 k진수로 변환하기 Integer.toString(n,k)
        // 변화한 값 중 소수를 찾기

        String changeNum = Integer.toString(n,k);

        String num = "";
        for(int i=0; i<changeNum.length(); i++) {
            if (changeNum.charAt(i) != '0') {
                num += changeNum.charAt(i);
            } else {
                if (num.length() != 0 && isPrime(Long.parseLong(num))) {
                    answer++;
                }
                num = "";
            }
        }
        if (num.length() != 0 && isPrime(Long.parseLong(num))) {
            answer++;
        }

        return answer;
    }

    public boolean isPrime(long num) {
        if (num <= 1) return false;

        for(long i=2; i*i <= num; i++) {
            if (num%i == 0) {
                return false;
            }
        }

        return true;
    }
}


