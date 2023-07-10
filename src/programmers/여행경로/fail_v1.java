package programmers.여행경로;

import java.util.*;

class fail_v1 {
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

        // visited 조절 방법1
         List<String> port = move.get(airport);
         for(int i=0; i < port.size(); i++) {

             System.out.println(port.get(i));

             String next = port.get(i);

             if(visited.get(next) != 0) {
                  for(String key : visited.keySet()) {
                     System.out.println(key + " : " + visited.get(key));
                 }


                 System.out.println("*****************");
                 for(String key : move.keySet()) {
                     System.out.println(key + " : " + move.get(key));
                 }
                 System.out.println("*****************");

                 // 실행 dfs
                 dfs(next, visited, move);
             }
         }

        // for(String port : move.get(airport)) {
        //     System.out.println(port);

        //dfs(port, visited, move);

        // move.get(airport).remove(new String(port));
        // dfs(port, visited, move);

        // if(visited.get(port) != 0) {
        //     //System.out.println(port);
        //     //move.get(airport).remove(new String(port));
        //     //move.get(airport).removeIf(item -> item.equals(port));
        //     dfs(port, visited, move);
        // }
        //}

    }
}