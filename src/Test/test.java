package Test;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {

        test1 t = new test1(5);

        t.setAa(6);

        String a = "가나다라마";
        String b = "abcde";

        System.out.println(a.length());
        System.out.println(b.length());
    }

    static class B {
        int b;
    }

}

class A {
    int a;
}