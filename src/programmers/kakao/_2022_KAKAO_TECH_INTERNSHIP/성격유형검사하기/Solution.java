package programmers.kakao._2022_KAKAO_TECH_INTERNSHIP.성격유형검사하기;

import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";

        Map<String,Integer> map = new HashMap<>();

        int[] score = {3,2,1,0,1,2,3};

        for (int i=0; i < survey.length; i++) {

            String first = String.valueOf(survey[i].charAt(0));
            String second = String.valueOf(survey[i].charAt(1));

            int s = choices[i];

            if (s < 4) { // first
                map.put(first, map.getOrDefault(first,0) + score[s-1]);
            } else if (s > 4) { // second
                map.put(second, map.getOrDefault(second,0) + score[s-1]);
            }

        }

        for(String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + " : " + value);
        }

        answer = check("R","T",map) + check("C","F",map) + check("J","M",map) + check("A","N",map);


        return answer;
    }

    public static String check(String first, String second, Map<String,Integer> map) {

        if (map.getOrDefault(first,0) > map.getOrDefault(second,0)) {
            return first;
        } else if (map.getOrDefault(first,0) == map.getOrDefault(second,0)) {
            int first_as = (int) first.charAt(0);
            int second_as = (int) second.charAt(0);
            if (first_as < second_as) {
                return first;
            } else {
                return second;
            }
        } else {
            return second;
        }

    }

}


