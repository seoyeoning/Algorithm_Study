package programmers.올바른괄호;
import java.util.*;
class success {
    boolean solution(String s) {

        Stack<String> st = new Stack<String>();

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                st.push("(");
            } else {
                st.pop();
            }
        }

        return st.empty();

//         try {
//             Stack<String> st = new Stack<String>();

//             for (int i=0; i < s.length(); i++) {
//                 char c = s.charAt(i);

//                 if (c == '(') {
//                     st.push("(");
//                 } else {
//                     st.pop();
//                 }
//             }

//             return st.empty();

//         } catch (EmptyStackException e) {
//             return false;
//         }

    }
}
