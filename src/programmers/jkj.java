//import java.util.*;
//
//class Solution {
//    public String[] solution(String[] record) {
//        String[] answer = {};
//
//        // System.out.println(Arrays.toString(record));
//
//        // int enter_and_leave_count = 0;
//
//        int record_cnt = record.length;
//        System.out.println(record_cnt);
//
//        String[][] record_list  = new String[record_cnt][3];
//
//        for (int i=0; i < record_cnt; i++) {
//            String str = record[i];
//            record_list[i] = str.split("\\s");
//        }
//        for(String[] a : record_list) {
//            System.out.println(Arrays.toString(a));
//        }
//        System.out.println("***");
//
//
//        for(String[] r : record_list) {
//            if (r[0].equals("Change")) {
//                change_nick_C(r, record_list);
//            } else if (r[0].equals("Enter")) {
//                // change_nick_E(r, record_list);
//            }
//        }
//
//        for(String[] a : record_list) {
//            System.out.println(Arrays.toString(a));
//        }
//
//        return answer;
//    }
//
//    static void change_nick_C(String[] change,String[][] record_list) {
//        // [Change uid4567 Ryan]
//        for(String[] r : record_list) {
//            if (!r[0].equals("Change") && change[1].equals(r[1])) {
//                r[2] = change[2];
//            }
//        }
//    }
//
//    static void change_nick_E(String[] change,String[][] record_list) {
//        for(String[] r : record_list) {
//            if (!r[0].equals("Change") && change[1].equals(r[1])) {
//                r[2] = change[2];
//            }
//        }
//    }
//
//
//}