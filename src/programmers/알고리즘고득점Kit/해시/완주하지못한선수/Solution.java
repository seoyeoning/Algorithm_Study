package programmers.알고리즘고득점Kit.해시.완주하지못한선수;

// 1. hashmap으로 만들기 (hashmap 사용 이유: 동명이인)
// 2. 존재하면 없애기
// 3. 남은 사람 리턴하기

// 처음 생각: key: 인덱스, value: 선수이름 -> 실패함
// 두번째 상각: key: 선수이름, value: 몇명인지

import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String,Integer> hm = new HashMap<String, Integer>();

        for(int i=0; i < participant.length; i++) {
            if ( hm.containsKey(participant[i]) ) {
                int put_num = hm.get(participant[i]);
                hm.replace(participant[i], put_num+1);
            } else {
                hm.put(participant[i], 1 );
            }
        }
        System.out.println(hm.toString()); // map에 잘 들어갔나 확인

        for(int i=0; i < completion.length; i++) {
            int rm_num = hm.get(completion[i]);
            hm.replace(completion[i], rm_num-1);
        }
        System.out.println(hm.toString()); // 완주한 선수 제거 확인

        for(int i=0; i < participant.length; i++) {
            if ( hm.get(participant[i]) == 1 ) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
