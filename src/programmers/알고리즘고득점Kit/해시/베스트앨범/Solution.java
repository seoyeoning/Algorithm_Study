package programmers.알고리즘고득점Kit.해시.베스트앨범;
import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String,Integer> hm = new HashMap<>();

        for(int i=0; i < genres.length; i++) {
            hm.put(genres[i],hm.getOrDefault(genres[i],0)+plays[i]);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(hm.entrySet());

        entries.sort((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()));

        // for(String key : hm.keySet()) {
        //     System.out.println(key+": "+hm.get(key));
        // }

        // System.out.println(entries.get(0).getKey());

        for (Map.Entry<String, Integer> entry : entries) {
            String key = entry.getKey();

        }


        return answer;
    }
}
