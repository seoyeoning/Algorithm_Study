package 코테유형연습.Hash;

import java.util.*;

public class hash {

    public static void main(String[] args) {

        Set<Integer> hs = new HashSet<>();

//        hs.add(1);
//        hs.add(2);
//        hs.add(3);
//
//        System.out.println(hs);

//        hs.remove(2);

//        System.out.println(hs);

//        hs.isEmpty();
//        hs.size();
//        hs.clear();

//        System.out.println(hs.contains(3));

//        for (int i : hs) {
//            System.out.println(i);
//        }

//        Integer[] hsList = hs.toArray(new Integer[2]);

        Map<Integer, String> hm = new HashMap<>();

        hm.put(1, "1");
        hm.put(2, "2");
        hm.put(3, "3");
        hm.put(4, "4");

        System.out.println(hm.replace(1, "11")); // old값 리턴
        System.out.println(hm);
        System.out.println(hm.replace(2, "2", "22"));
        System.out.println(hm);

        System.out.println(hm.get(3));
        System.out.println(hm.containsKey(1));
        System.out.println(hm.containsValue("22"));

        Set<Integer> keySet = hm.keySet();
        System.out.println(keySet);

        Set<Map.Entry<Integer, String>> mapSet = hm.entrySet();
        System.out.println(mapSet);

        for (Map.Entry<Integer, String> entry : mapSet) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

    }

}
