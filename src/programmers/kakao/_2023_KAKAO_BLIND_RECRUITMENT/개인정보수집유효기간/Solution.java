package programmers.kakao._2023_KAKAO_BLIND_RECRUITMENT.개인정보수집유효기간;

import java.util.*;

class Solution {
    public Integer[] solution(String today, String[] terms, String[] privacies) {

        ArrayList<Integer> result = new ArrayList<>();

        // 2022, 05, 19
        int today_y = Integer.parseInt(today.split("\\.")[0]);
        int today_m = Integer.parseInt(today.split("\\.")[1]);
        int today_d = Integer.parseInt(today.split("\\.")[2]);

        // A-6, B-12, C-3
        Map<String,Integer> terms_map = new HashMap<>();
        for(String term : terms) {
            terms_map.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
        }

        for(int i=0; i < privacies.length; i++) {

            // date =  [2021,05,02] , type = A
            String date = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];

            // 2021, 5, 2 (int 형태)
            int y = Integer.parseInt(date.split("\\.")[0]);
            int m = Integer.parseInt(date.split("\\.")[1]) + terms_map.get(type); // m + 유효기간
            int d = Integer.parseInt(date.split("\\.")[2]);

            // m 처리
            if (m > 12 && (m % 12) != 0) { // ex) m = 40
                y += (m/12); // 40/12 = 3
                m = (m%12); // 40%12 = 4
            } else if (m > 12 && (m % 12) ==0) { // ex) m = 24 --> 17번
                y += (m/12) -1;
                m = 12;
            }

            // d 처리
            if (d == 1 && m != 1 ) {
                m -= 1;
                d = 28;
            } else if (d == 1 && m == 1) {
                y -= 1;
                m = 12;
                d = 28;
            } else {
                d -= 1;
            }
            // System.out.println(y);
            // System.out.println(m);
            // System.out.println(d);

            if (y < today_y) {
                result.add(i+1);
            } else if (y == today_y && m < today_m) {
                result.add(i+1);
            } else if(y == today_y && m == today_m && d < today_d) {
                result.add(i+1);
            }
        }

        Integer[] answer = result.toArray(new Integer[0]);

        return answer;
    }
}
