package 이코테.정렬.위에서아래로;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Integer N = sc.nextInt();

        Integer[] list = new Integer[N];

        for (int i = 0; i < N; i++) {
            list[i] = sc.nextInt();
        }

        Arrays.sort(list, Collections.reverseOrder());

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }

    }

}
