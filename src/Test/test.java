package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class test {

    public static void main(String[] args) throws IOException {

//        test1 t = new test1(5);
//
//        t.setAa(6);

//        Set<Integer> hs = new HashSet<>();
//
//        hs.add(1);
//        for (Integer h : hs) {
//            System.out.println(h);
//        }
//
//        hsTest(hs);
//        System.out.println("--");
//
//        for (Integer h : hs) {
//            System.out.println(h);
//        }
//
//        String str = "aaa";
//        str.length();
//        str.isEmpty();
//
//        PriorityQueue<Student3> queue = new  PriorityQueue<>(
//                (o1,o2) -> {
//                    if (o1.age == o2.age) {
//                        return o2.name.compareTo(o1.name);
//                    }
//                    return o1.age - o2.age;
//                }
//                );

        String str = "11";
        String[] test = str.split(",");
        System.out.println(Arrays.toString(test));
    }

    static void hsTest(Set<Integer> hs) {
        hs.add(2);
    }

    static class B {
        int b;
    }

}

class A {
    int a;

    A(int a) {
        this.a = a;
    }
}

class Student3 {
    int age;
    String name;

    Student3(int age, String name) {
        this.age = age;
        this.name = name;
    }
}