package 코테문법연습.Lambda와Stream;

public class test1 {

    public static void main(String[] args) {

    // 익명 이너 클래스
    InterfaceA interfaceA1 = new InterfaceA() {
        @Override
        public void method() {
            System.out.println("hello");
        }
    };
    interfaceA1.method();

    // 익명 이너 클래스 -> 람다식
    InterfaceA interfaceA2 = () -> {
        System.out.println("hello2");
    };
    interfaceA2.method();

    InterfaceA interfaceA3 = () -> System.out.println("hello3");

    interfaceA3.method();

    }

    static class A {
        int a;
    }

}

class B {
    int b;
}

interface InterfaceA {

    void method();

}