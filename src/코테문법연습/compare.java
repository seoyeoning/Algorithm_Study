package 코테문법연습;

// Comparator의 compare() : 두 매개변수 객체 비교
// Comparable의 compareTo() : 자기자신과 매개변수 객체 비교
// return 1 (양수) : 선행이 후행보다 크다 7,5 -> 7-5 = 2
// return -1 (음수) : 선행이 후행보다 작다, 3,5 -> 3-5 = -2
// return 0

// 오름차순 : 음수-교환 안함, 양수-교환
// this.o1 - Student.o1
// Student.o1 - Student.o2
// 내림차순 : 음수-교환, 양수-교환 안함
// Students.o1 - this.o1
// Student.o2 - Student.o1

import java.util.Collections;
import java.util.Comparator;

public class compare {

    public static void main(String[] args) {

        Student a = new Student(5, 1);
        Student b = new Student(7, 2);

        System.out.println(a.compareTo(b));

        Student2 a2 = new Student2(5, 1);
        Student2 b2 = new Student2(7, 2);

        System.out.println(a2.compare(a2,b2));

        Student3 a3 = new Student3(5, 1);
        Student3 b3 = new Student3(7, 2);

        // 익명 클래스 구현 1
        Comparator<Student3> comp1 = new Comparator<>() {
            @Override
            public int compare(Student3 o1, Student3 o2) {
                return o1.age - o2.age;
            }
        };

        System.out.println(comp1.compare(a3, b3));

        System.out.println(comp2.compare(a3, b3));

    }

    static Comparator<Student3> comp2 = new Comparator<Student3>() {
        @Override
        public int compare(Student3 o1, Student3 o2) {
            return o1.age - o2.age;
        }
    };

    static Comparator<Student3> comp3 = new Comparator<>() {
        @Override
        public int compare(Student3 o1, Student3 o2) {
            return o1.number - o2.number;
        }
    };

}

class Student3 {
    int age;
    int number;

    public Student3(int age, int number) {
        this.age = age;
        this.number = number;
    }
}

class Student2 implements Comparator<Student2> {

    int age;
    int number;

    public Student2(int age, int number) {
        this.age = age;
        this.number = number;
    }

    @Override
    public int compare(Student2 o1, Student2 o2) {
        return o1.age - o2.age;
    }
}

class Student implements Comparable<Student> {

    int age;
    int number;

    public Student(int age, int number) {
        this.age = age;
        this.number = number;
    }

    @Override
    public int compareTo(Student o) {

        return this.age - o.age;

    }

//    @Override
//    public int compareTo(Student o) {
//
//        if (this.age > o.age) {
//            return 1;
//        } else if (this.age == o.age) {
//            return 0;
//        } else {
//            return -1;
//        }
//
//    }
}
