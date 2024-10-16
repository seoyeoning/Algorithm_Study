package 코테문법연습;

// Arrays.sort() : 배열 정렬
// Collections.sort() : 객체 정렬

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sort {

    public static void main(String[] args) {

        // 배열 정렬
        int[] list = new int[10];

        for (int i = 0; i < 10; i++) {
            list[i] = (int) (Math.random() * 10);
        }

        System.out.println(Arrays.toString(list));

        Arrays.sort(list);

        // 배열 오름차순 정렬
        System.out.println(Arrays.toString(list));

        // primitive 타입에서 사용 불가 -> Integer로 변경 후 내림차순
//        Arrays.sort(list, Collections.reverseOrder());

        ////////////////////////////////////////////////////////////////////

        List<Test1> testList = new ArrayList<>();
        testList.add(new Test1(1, 1));
        testList.add(new Test1(3, 2));
        testList.add(new Test1(2, 5));
        testList.add(new Test1(2, 1));
        testList.add(new Test1(1, 7));
        testList.add(new Test1(3, 1));

        for (Test1 test1 : testList) {
            System.out.println(test1.toString());
        }

        Collections.sort(testList);
        System.out.println("///");

        for (Test1 test1 : testList) {
            System.out.println(test1.toString());
        }




    }

}

class Test1 implements Comparable<Test1>{
    int age;
    int grade;

    Test1(int age, int grade) {
        this.age = age;
        this.grade = grade;
    }

    // age 오름차순, age 같으면 grade 내림차순
    @Override
    public int compareTo(Test1 o1) {

        if (this.age == o1.age) {
            return o1.grade - this.grade;
        }

        return this.age - o1.age;
    }

    @Override
    public String toString() {
        return age + " - " + grade;
    }
}