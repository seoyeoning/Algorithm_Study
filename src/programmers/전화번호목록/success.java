package programmers.전화번호목록;

import java.util.*;

// 틀린 생각 : 119가 어떤 곳의 접두어일까?
// 맞은 생각 : 119의 접두어가 존재할까?
class success {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        Set<String> hs = new HashSet<String>();

        for(String num : phone_book) {
            hs.add(num);
        }

        // System.out.println(hs.toString());

        for(String phone : phone_book) {
            for(int i=1; i < phone.length(); i++) {
                if (hs.contains(phone.substring(0,i))){
                    answer = false;
                }
            }
        }
        //System.out.println(Arrays.toString(phone_book));
        return answer;
    }

}
