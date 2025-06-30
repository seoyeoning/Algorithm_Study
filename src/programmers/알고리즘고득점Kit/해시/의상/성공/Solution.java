package programmers.알고리즘고득점Kit.해시.의상.성공;

import java.util.*;

class Solution {

    Map<String,Integer> hm;

    public int solution(String[][] clothes) {
        int answer = 1;

        hm = new HashMap<>();

        for(String[] cloth : clothes) {
            if (hm.get(cloth[1]) == null) {
                hm.put(cloth[1],1);
            } else {
                hm.put(cloth[1],hm.get(cloth[1])+1);
            }
        }

        for(String key : hm.keySet()) {
            answer *= (hm.get(key)+1);// 안 입는 경우 포함
        }

        answer -= 1; // 아무것도 안 입는 경우 제외

        return answer;
    }

}
