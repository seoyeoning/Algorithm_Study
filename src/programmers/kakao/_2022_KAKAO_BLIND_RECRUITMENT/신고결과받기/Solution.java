package programmers.kakao._2022_KAKAO_BLIND_RECRUITMENT.신고결과받기;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> repo = new HashMap<>();
        Map<String, List<String>> repo_detail = new HashMap<>();

        for (String str : report) {
            String a = str.split(" ")[0];
            String b = str.split(" ")[1];

            if (!repo_detail.containsKey(a)) {
                repo_detail.put(a, new LinkedList<String>());
            }

            if (!repo_detail.get(a).contains(b)) {
                repo_detail.get(a).add(b);
                repo.put(b, repo.getOrDefault(b, 0) + 1);
            }

        }

        for (String key : repo.keySet()) {

            if (repo.get(key) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (repo_detail.containsKey(id_list[i]) && repo_detail.get(id_list[i]).contains(key)) {
                        answer[i]++;
                    }
                }
            }
        }

        for (String key : repo_detail.keySet()) {
            System.out.println("[Key]:" + key + " [Value]:" + repo_detail.get(key));
        }

        for (String key : repo.keySet()) {
            System.out.println("[Key]:" + key + " [Value]:" + repo.get(key));
        }

        return answer;
    }
}


