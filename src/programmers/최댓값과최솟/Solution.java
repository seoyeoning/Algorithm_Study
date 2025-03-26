package programmers.최댓값과최솟;

import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";

        String[] sList = s.split(" ");

        List<Integer> list = new ArrayList<>();

        for(String str : sList) {
            list.add(Integer.parseInt(str));
        }

        Collections.sort(list);

        int minNum = list.get(0);
        int maxNum = list.get(list.size()-1);

        return minNum+" "+maxNum;
    }
}
