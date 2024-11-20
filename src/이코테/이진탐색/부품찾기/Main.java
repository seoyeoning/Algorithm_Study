package 이코테.이진탐색.부품찾기;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        float f = 4.4F;

        int i = (int) f;

        int j = Math.round(f);

        System.out.println(i);
        System.out.println(j);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);

        Integer[] list = queue.toArray(new Integer[0]);

        System.out.println(Arrays.toString(list));

//        List<Integer> list1 = Arrays.asList(list);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(list));
        list1.add(4);
        System.out.println(list1);

    }

}
