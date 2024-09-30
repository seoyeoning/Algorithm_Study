package 코테문법연습;

import java.util.*;

public class basic {

    public static void main(String[] args) {

        String str = "abcde";

        int len = str.length(); // 문자열 길이
        boolean isEmpty = str.isEmpty(); // 문자열 길이 0이면 true

        char charAt = str.charAt(2); // 인덱스로 문자열 찾기
        int indexOf = str.indexOf('b'); // 문자로 첫번째 인덱스 찾기
        int lastIndexOf = str.lastIndexOf('d'); // 문자로 마지막 인덱스 찾기

        String substring_1 = str.substring(2, 4); // 2-3사이의 문자열 반환
        String substring_2 = str.substring(3); // 3부터 끝까지 문자열 반환

        str = str.replace('a', 'n'); // str = str.replace 형태

        boolean same = str.equals("nbcde");
        boolean contains = str.contains("nb");

        String str_long = "a b c d e f";
        String[] split_1 = str_long.split(" ");

        String[] split_2 = str_long.split(""); // 띄어쓰기 없이 한 문자씩 배열에 넣기 [a,  , b,  , c,  , d,  , e,  , f]

        String str_trim = "  dfdsf    ";
        String trim = str_trim.trim();

        String str_up_down = "aBcDe";
//        System.out.println(str_up_down.toUpperCase());
//        System.out.println(str_up_down.toLowerCase());

        String com1 = "abc";
        String com2 = "abg";

//        System.out.println(com2.compareTo(com1));
        // 사전순 앞 : -1, 사전순 뒤 : 1, 같을 때 : 0, 마지막 문자만 다르면 마지막 문자의 사전 순 차이 반환

        String num = "100";

        int str_to_num_1 = Integer.parseInt(num);
        System.out.println(str_to_num_1);

        int str_num = 1000;
        String num_to_str_1 = Integer.toString(str_num);
        String num_to_str_2 = String.valueOf(str_num);
        System.out.println(num_to_str_1);
        System.out.println(num_to_str_2);

        // max, min 값 찾기
        int a = 1;
        int b = 2;
        System.out.println(Math.max(a, b));
        System.out.println(Math.min(a, b));

    }

}