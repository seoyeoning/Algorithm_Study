package 코테문법연습.Lambda와Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class streamTest {

    public static void main(String[] args) {

        Integer[] list = {3, 5, 1, 4, 2};
        List<Integer> arr = Arrays.asList(list);

        Stream<Integer> listSt = Arrays.stream(list);
        Stream<Integer> arrSt = arr.stream();

        List<Integer> result = listSt
                .filter(i -> i % 2 == 0)
                .sorted(Collections.reverseOrder())
                .toList();

        System.out.println(result);


    }

}
