package programmers.문자열나누기;

public class success {

    public int solution(String s) {
        int answer = 0;

        char start = s.charAt(0);

        int same = 1;
        int diff = 0;

        for (int i=1; i<s.length(); i++) {

            if (start == s.charAt(i)) {
                same++;
            } else {
                diff++;
            }

            if (same == diff) {
                answer++;
                if (i != s.length()-1) {
                    same = 1;
                    diff = 0;
                    start = s.charAt(i+1);
                    i += 1;
                }
            }

        }

        if (same != diff) {
            answer++;
        }

        return answer;
    }

}
