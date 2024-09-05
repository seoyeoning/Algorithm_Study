package programmers.햄버거만들기;

import java.util.*;
// import java.util.stream.Collectors;

public class success {

    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> st = new Stack<Integer>();

        for (int in : ingredient) {

            st.push(in);

            if (st.size() >= 4) {
                if (st.get(st.size() - 4) == 1
                        && st.get(st.size() - 3) == 2
                        && st.get(st.size() - 2) == 3
                        && st.get(st.size() - 1) == 1) {

                    answer++;
                    st.pop();
                    st.pop();
                    st.pop();
                    st.pop();
                }
            }

        }

        return answer;
    }

}

//         List<Integer> hamburger =
//             Arrays.stream(ingredient)
//             .boxed()
//             .collect(Collectors.toList());

//         System.out.println(hamburger.size());
