package programmers.kakao._2023_KAKAO_BLIND_RECRUITMENT.이몬티콘할인행사;

import java.util.*;

class Solution {

    int[] answer;
    int[] discount;
    int[][] users;
    int[] emoticons;

    public int[] solution(int[][] users, int[] emoticons) {
        // 1. 이몬티콘 플러스 가입자 최대
        // 2. 이몬티콘 판매액 최대

        // 완탐 할까? 이몬티콘 최대 7개, 유저 최대 100명
        answer = new int[2];

        discount = new int[]{10,20,30,40};
        int[] visited = new int[emoticons.length];
        this.users = users;
        this.emoticons = emoticons;
        check(visited, 0);

        return answer;
    }

    void check(int[] visited, int depth) {
        if(depth == visited.length) {
            calc(visited);
            return;
        }

        for(int i=0; i< discount.length; i++) {
            visited[depth] = discount[i];
            check(visited, depth+1);
        }
    }

    void calc(int[] visited) {

        int emoPlus = 0;
        int totalPrice = 0;

        for(int i=0; i<users.length; i++) {
            int price = 0;
            for(int j=0; j < visited.length; j++) {
                if (visited[j] >= users[i][0]) {
                    price += (100-visited[j])*emoticons[j]/100;
                }
            }

            if (price >= users[i][1]) { // 플러스 구매
                emoPlus++;
            } else {
                totalPrice += price;
            }
        }

        if (emoPlus > answer[0]) {
            answer[0] = emoPlus;
            answer[1] = totalPrice;
            return;
        }
        if (emoPlus == answer[0] && totalPrice > answer[1]) {
            answer[1] = totalPrice;
            return;
        }

    }
}
