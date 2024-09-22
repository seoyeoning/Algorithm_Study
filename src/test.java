
public class test {

    public static void main(String[] args) {

        A a1 = new A();
        A a2 = new A();

        a1.a = 11;
        a2.a = 12;

        System.out.println(a1.a);
        System.out.println(a2.a);

        System.out.println(B.bb);

        int tt = B.bb; // tt = 2
        B.bb = 88;

        System.out.println(tt);
        System.out.println(B.bb);

    }

    static class B {
        static int bb = 2;
    }

}

class A {
    int a = 1;
}
