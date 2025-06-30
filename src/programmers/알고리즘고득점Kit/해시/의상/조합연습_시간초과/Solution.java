package programmers.알고리즘고득점Kit.해시.의상.조합연습_시간초과;

// 종류별로 Map에 넣기 -> n종류
// 1부터 n까지 선택 (조합으로 곱하기)
// 이 문제로 공부할 것 : hashMap 문법, 조합
import java.util.*;

// 시간초과
class Solution {

    Map<String,Integer> hm;

    public int solution(String[][] clothes) {
        int answer = 0;

        hm = new HashMap<>();
        List<String> list = new ArrayList<>();

        for(String[] cloth : clothes) {
            if (hm.get(cloth[1]) == null) {
                hm.put(cloth[1],1);
                list.add(cloth[1]);
            } else {
                hm.put(cloth[1],hm.get(cloth[1])+1);
            }
        }

        int n = list.size();
        for(int i=1; i <= n; i++) { // 1부터 n까지
            boolean[] visited = new boolean[n];
            int result = comb(list,visited,0,i,n);
            System.out.println(result);
            answer += result;
        }

        return answer;
    }

    public int comb(List<String> list, boolean[] visited, int start, int r, int n) {

        if (r == 0) {
            int sum = 1;
            for(int i=0; i <n; i++) {
                if(visited[i]) {
                    sum *= hm.get(list.get(i));
                }
            }
            return sum;
        }
        int total = 0;
        for(int i=start; i < n; i++) {
            visited[i] = true;
            total += comb(list,visited,i+1,r-1,n);
            visited[i] = false;
        }

        return total;

    }

}
