package programmers.알고리즘고득점Kit.정렬.가장큰수;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {

        List<String> list = new ArrayList<>();
        for(int n : numbers) {
            list.add(String.valueOf(n));
        }

        list.sort((o1,o2) -> (o2+o1).compareTo(o1+o2));

        if(list.get(0).equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for(String str : list) {
            answer.append(str);
        }

        return answer.toString();
    }
}
