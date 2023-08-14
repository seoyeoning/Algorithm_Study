package programmers;

import java.util.HashMap;
import java.util.Map;

public class test {

    public static void main(String[] args) {
        Map<String, String> t = new HashMap<>();

        t.put("a","b");
        t.put("a", "aa");

        for (String s : t.keySet()) {
            System.out.println(t.get(s));
        }
    }
}
