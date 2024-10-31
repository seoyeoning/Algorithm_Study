package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class test {

    public static void main(String[] args) throws IOException {

//        test1 t = new test1(5);
//
//        t.setAa(6);

        Set<Integer> hs = new HashSet<>();

        hs.add(1);
        for (Integer h : hs) {
            System.out.println(h);
        }

        hsTest(hs);
        System.out.println("--");

        for (Integer h : hs) {
            System.out.println(h);
        }

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
}