package programmers.여행경로;

import java.util.*;

class fail_v2 {
    // 제출용 list
    static ArrayList<String> result = new ArrayList<>();

    public String[] solution(String[][] tickets) {

        Map<String,Integer> visited = new HashMap<>();
        Map<String,List<String>> move = new HashMap<>();

        visited.put("ICN",1);
        move.put("ICN",new ArrayList<>());

        // visited 채우기
        for(String[] t : tickets) {
            visited.put(t[1] ,visited.getOrDefault(t[1], 0) + 1);
            move.put(t[1],new ArrayList<>()); // 반복되어도 하나만 만들어지나?
        }
        // 처음 확인용 visited
        for(String key : visited.keySet()) {
            System.out.println(key + " : " + visited.get(key));
        }
        // move 채우기
        for(String[] t : tickets) {
            move.get(t[0]).add(t[1]);
        }

        // 오름차순
        for(String key : move.keySet()) {
            //visited.get(key).sort(Collections.naturalOrder());
            Collections.sort(move.get(key));
        }

        System.out.println("----------------- 처음 인접 리스트");
        for(String key : move.keySet()) {
            System.out.println(key + " : " + move.get(key));
        }
        System.out.println("-----------------");

        dfs("ICN", visited, move);

        // 확인용 (마지막 visited)
        for(String key : visited.keySet()) {
            System.out.println(key + " : " + visited.get(key));
        }

        String[] answer = result.toArray(new String[result.size()]);

        return answer;
    }

    public static void dfs(String airport, Map<String,Integer> visited, Map<String,List<String>> move) {
        result.add(airport);
        System.out.println("airport : " + airport);
        visited.replace(airport,visited.get(airport) - 1);

        // 인접리스트 직접 삭제 방법2
        boolean zero = false;
        for(int value : visited.values()) {
            if(value != 0) {
                zero = true;
                break;
            }
        }

        //System.out.println(zero);
        //System.out.println(move.get(airport).size());

        if (move.get(airport).size() == 0 && zero == true) {
            return; // break 했더니 에러남
        } else {
            for (Iterator<String> iterator = move.get(airport).iterator(); iterator.hasNext();) {

                String item = iterator.next();
                System.out.println(item);
                iterator.remove();

                for(String key : visited.keySet()) {
                    System.out.println(key + " : " + visited.get(key));
                }


                System.out.println("*****************");
                for(String key : move.keySet()) {
                    System.out.println(key + " : " + move.get(key));
                }
                System.out.println("*****************");


                dfs(item, visited, move);
            }
        }
    }
}