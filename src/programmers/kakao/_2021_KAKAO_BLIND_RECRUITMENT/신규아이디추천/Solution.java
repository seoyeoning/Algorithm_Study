package programmers.kakao._2021_KAKAO_BLIND_RECRUITMENT.신규아이디추천;

class Solution {
    public String solution(String new_id) {

        new_id = step1(new_id);
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);

        return new_id;
    }

    public static String step1(String id) {

        id = id.toLowerCase();

        return id;
    }
    public static String step2(String id) {

        id = id.replaceAll("[^0-9a-z\\.\\-\\_]","");

        return id;
    }
    public static String step3(String id) {

        id = id.replaceAll("\\.{2,}",".");

        return id;
    }
    public static String step4(String id) {

        if (id.length() == 1 && id.charAt(0) == '.') {
            id = "";
        } else {
            if (id.charAt(0) == '.') {
                id = id.substring(1);
            }
            if (id.charAt(id.length()-1) == '.') {
                id = id.substring(0,id.length()-1);
            }
        }

        return id;
    }
    public static String step5(String id) {

        if (id.equals("")) {
            id = "a";
        }

        return id;
    }
    public static String step6(String id) {

        if (id.length() >= 16) {
            id = id.substring(0,15);
            id = step4(id);
        }

        return id;
    }
    public static String step7(String id) {

        if (id.length() <= 2) {
            String last = String.valueOf(id.charAt(id.length()-1));
            while(id.length() != 3) {
                id += last;
            }
        }

        return id;
    }
}
