package programmers.시저암호;
import java.util.*;

public class success {
    public String solution(String s, int n) {
        String answer = "";

        int s_len = s.length();

        int char_to_num = -1;

        if (s_len != 0) {
            for (int i=0; i < s_len; i++) {

                char_to_num = (int) s.charAt(i);

                char_to_num += n;

                if (Character.isUpperCase(s.charAt(i))) {
                    if (char_to_num > 90 && char_to_num < 116) {
                        char_to_num = char_to_num - 90 + 64;
                    }
                } else if (Character.isLowerCase(s.charAt(i)))  {
                    if (char_to_num > 122) {
                        char_to_num = char_to_num - 122 + 96;
                    }
                } else {
                    char_to_num = 32;
                }

                answer += (char) char_to_num;

            }
        }

        return answer;
    }
}

// char[] upper = {'A','B','C','D','E','F','G','H','I','J','K',
//                          'L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
//         char[] lower = {'a','b','c','d','e','f','g','h','i','j','k',
//                          'l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};