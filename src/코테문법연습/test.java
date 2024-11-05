package 코테문법연습;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class test {

    public static void main(String[] args) {
//        String str = "dd";
//        String[] list = str.split(",");
//        System.out.println(Arrays.toString(list));

        List<String> list = Arrays.asList("L", "I", "S", "T", "T", "T");
         Set<String> set = Set.copyOf(list);

        System.out.println(set);
    }

}
