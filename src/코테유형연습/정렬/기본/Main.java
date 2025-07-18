package 코테유형연습.정렬.기본;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 4, 3, 5, 1};
        Integer[] arr2 = {2, 4, 3, 5, 1};

        // 배열[] 정렬 - Arrays.sort()
        // 기본 오름차순 정렬
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 기본 내림치순 정렬
        // primitive 타입이 아닌 Wrapper 클래스 일 경우 arr 뒤에 추가로 Comparator를 인자로 전달하여 정렬 가능
//        Arrays.sort(arr2, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr2));

        // List 정렬 - Collections.sort()
        List<Integer> list = Arrays.asList(arr2); // Wrapper 클래스 배열일 경우만 변환 가능
        System.out.println(list);
        // 오름차순
//        Collections.sort(list); // 정렬만 하고 void 반환
//        System.out.println(list);
        // 내림차순
        Collections.reverseOrder();


        // 객체와 다중 조건 정렬

        Member m1 = new Member("a", 10);
        Member m2 = new Member("b",2);
        Member m3 = new Member("a", 3);
        Member m4 = new Member("c", 7);

        // 이름 오름차순, 이름 같으면 나이 내림차순 -> m1, m3, m2
        // 이름 오름차순, 이름 같으면 나이 오름차순 -> m3, m1, m2
        // 나이 오름차순 -> m2, m3, m4, m1
        // 나이 내림차순 -> m1, m4, m3, m2

        // comparator 과 comparable

    }

}

class Member {
    String name;
    int age;

    Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
