package programmers.같은숫자는싫어;

import java.util.*;
public class success {
    public int[] solution(int []arr) {

        Stack<Integer> st = new Stack<Integer>();

        for(int i=0; i < arr.length; i++) {
            if ( st.empty() ) {
                st.push(arr[i]);
            } else if (st.peek() != arr[i]) {
                st.push(arr[i]);
            } else {
                continue;
            }
        }

        int stSize = st.size();
        int[] answer = new int[stSize];

        for(int i=stSize-1; i > -1; i--) {
            answer[i] = st.pop();
        }

        return answer;
    }
}
