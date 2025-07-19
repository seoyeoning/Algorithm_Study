package 코테유형연습.PriorityQueue;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        // 기본 오름차순
        PriorityQueue<Integer> q1 = new PriorityQueue<>();
        q1.offer(2);
        q1.offer(3);
        q1.offer(1);

        // 기본 내림차순
        PriorityQueue<Integer> q2 = new PriorityQueue<>(Collections.reverseOrder());
        q2.offer(2);
        q2.offer(3);
        q2.offer(1);

        // 객체 다중 조건
        // Comparator - 람다
        Member1 m1 = new Member1("a", 10);
        Member1 m2 = new Member1("bb",2);
        Member1 m3 = new Member1("a", 3);
        Member1 m4 = new Member1("ccc", 7);

        PriorityQueue<Member1> q3 = new PriorityQueue<>((o1, o2) -> {
            if (o1.name.equals(o2.name)) {
                return Integer.compare(o2.age, o1.age); // 이름 같으면 나이 내림차순
            }
            return o1.name.compareTo(o2.name); // 이름 오름차순
        });

        q3.offer(m1);
        q3.offer(m2);
        q3.offer(m3);
        q3.offer(m4);

        while (!q3.isEmpty()) {
            Member1 member1 = q3.poll();
            System.out.println(member1.name + " : " + member1.age);
        }

        // Comparator - comparing
        PriorityQueue<Member1> q4 = new PriorityQueue<>(Comparator
                .comparing(Member1::getName).reversed() // 이름 내림차순
                .thenComparingInt(o -> o.age)); // 나이 오름차순

        q4.offer(m1);
        q4.offer(m2);
        q4.offer(m3);
        q4.offer(m4);

        System.out.println("------------------------------------");
        while (!q4.isEmpty()) {
            Member1 member1 = q4.poll();
            System.out.println(member1.name + " : " + member1.age);
        }

        // Comparable - 클래스에서부터 정의
        Member2 m11 = new Member2("a", 10);
        Member2 m22 = new Member2("bb",2);
        Member2 m33 = new Member2("a", 3);
        Member2 m44 = new Member2("ccc", 7);

        PriorityQueue<Member2> q5 = new PriorityQueue<>();

        q5.offer(m11);
        q5.offer(m22);
        q5.offer(m33);
        q5.offer(m44);

        System.out.println("------------------------------------");
        while (!q5.isEmpty()) {
            Member2 member2 = q5.poll();
            System.out.println(member2.name + " : " + member2.age);
        }

    }
}

class Member1 {
    String name;
    int age;

    String getName() {
        return name;
    }

    Member1(String name, int age) {
        this.name = name;
        this.age = age;
    }

}

class Member2 implements Comparable<Member2>{
    String name;
    int age;

    Member2(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Member2 o) {
        if (this.name.equals(o.name)) {
            return Integer.compare(this.age, o.age); // 이름 같으면 나이 오름차순
        }
        return this.name.compareTo(o.name); // 이름 오름차순
    }
}