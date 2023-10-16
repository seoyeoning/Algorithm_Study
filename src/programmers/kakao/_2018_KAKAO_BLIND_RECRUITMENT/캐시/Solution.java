package programmers.kakao._2018_KAKAO_BLIND_RECRUITMENT.캐시;

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();
        }

        List<String> cache = new ArrayList<>();

        if (cacheSize == 0) {
            answer = cities.length * 5;
        } else {
            for (int i = 0; i < cities.length; i++) {
                if (cache.contains(cities[i])) { // hit
                    // System.out.println("hit");
                    cache.remove(cities[i]);
                    cache.add(0,cities[i]);
                    answer++;
                } else {
                    if (cache.size() < cacheSize) {
                        // System.out.println("miss-그냥 넣기");
                        cache.add(0,cities[i]);
                    } else {
                        // System.out.println("miss-삭제하고 넣기");
                        cache.remove(cacheSize-1);
                        cache.add(0,cities[i]);
                    }
                    answer += 5;
                }
            }
        }

        return answer;
    }
}
