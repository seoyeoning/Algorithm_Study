package programmers.알고리즘고득점Kit.힙.이중우선순위큐;

import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};

        List<Integer> list = new ArrayList<>();
        // 오름차순 -> 최댓값: list.remove(list.size()-1), 최솟값: list.remove(0)
        for(String str : operations) {

            String[] oper = str.split(" ");

            if (oper[0].equals("I")) {
                int num = Integer.parseInt(oper[1]);
                list.add(num);
            } else if (oper[0].equals("D")) {

                if (list.isEmpty()) continue;

                if (oper[1].equals("1")) { // 최댓값 삭제
                    Collections.sort(list);
                    list.remove(list.size()-1);
                } else if (oper[1].equals("-1")) { // 최솟값 삭제
                    Collections.sort(list);
                    list.remove(0);
                }

            }
        }

        // 마지막 정렬을 안 하면 틀림
        Collections.sort(list);

        if (list.isEmpty()) {
            return answer;
        } else {
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0);
            return answer;
        }

    }
}
