package programmers.알고리즘고득점Kit.해시.폰켓몬;

import java.util.*;

class Solution {
    public int solution(int[] nums) {

        int num = nums.length / 2;

        Set<Integer> hs = new HashSet<Integer>();

        // hs에 nums 넣어서 중복 제거하기
        for (int i=0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        int pokemon_nums = hs.size();

        if (pokemon_nums <= num) {
            return pokemon_nums;
        } else {
            return num;
        }

    }
}
