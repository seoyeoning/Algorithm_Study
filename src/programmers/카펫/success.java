package programmers.카펫;
class success {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int max = 0, min = 0, cal = 0;

        int sqrt = (int) Math.sqrt(yellow);

        for(int i=1; i <= sqrt; i++) {
            if(yellow % i == 0) {
                max = Math.max(i,yellow/i);
                min = Math.min(i,yellow/i);
            }
            cal = (max+2)*2 + min*2;
            if(cal == brown) {
                answer[0] = max + 2;
                answer[1] = min + 2;
                break;
            }
        }
        return answer;
    }
}