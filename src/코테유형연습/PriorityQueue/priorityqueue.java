package 코테유형연습.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SimpleTimeZone;

// 힙 : 최댓값 또는 최솟값을 빠르게 찾아내기위해 완전이진트리 형태로 만들어진 자료구조
// 우선순위 큐 : FIFO 구조가 아닌 우선순위가 높은 순서대로 꺼내는 구조, 우선순위가 같을 때 선입 선출 방식
public class priorityqueue {

    public static void main(String[] args) {

        // Comparable - compareTo 이용
        PriorityQueue<Student1> queue1 = new PriorityQueue<>();

        queue1.offer(new Student1(2, "aaa"));
        queue1.offer(new Student1(4, "ddd"));
        queue1.offer(new Student1(1, "ccc"));
        queue1.offer(new Student1(2, "eee"));

//        while (!queue1.isEmpty()) {
//            System.out.println(queue1.poll().toString());
//        }

        // 람다식 이용
        PriorityQueue<Student2> queue2 = new PriorityQueue<>(
                (o1, o2) -> {
                    if (o1.age == o2.age) {
                        return o2.name.compareTo(o1.name);
                    }
                    return o1.age - o2.age;
                }
        );

        queue2.offer(new Student2(2, "aaa"));
        queue2.offer(new Student2(4, "ddd"));
        queue2.offer(new Student2(1, "ccc"));
        queue2.offer(new Student2(2, "eee"));

//        while (!queue2.isEmpty()) {
//            System.out.println(queue2.poll().toString());
//        }

        // Comparator - compare 이용
        PriorityQueue<Student2> queue3 = new PriorityQueue<>(new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                if (o1.age == o2.age) {
                    return o2.name.compareTo(o1.name);
                }
                return o1.age - o2.age;
            }
        });

        queue3.offer(new Student2(2, "aaa"));
        queue3.offer(new Student2(4, "ddd"));
        queue3.offer(new Student2(1, "ccc"));
        queue3.offer(new Student2(2, "eee"));

        while (!queue3.isEmpty()) {
            System.out.println(queue3.poll().toString());
        }


    }

}

class Student2 {
    int age;
    String name;

    Student2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return age + ", " + name;
    }
}

class Student1 implements Comparable<Student1> {

    int age;
    String name;

    Student1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Student1 o) {
        if (this.age == o.age) {
            return o.name.compareTo(this.name); // 이름 내림차순
        } else {
            return this.age - o.age;
        }
    }

    @Override
    public String toString() {
        return age + ", " + name;
    }
}
