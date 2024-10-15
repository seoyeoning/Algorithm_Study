package 코테문법연습;

// Comparator의 compare() : 두 매개변수 객체 비교
// Comparable의 compareTo() : 자기자신과 매개변수 객체 비교
// return 1 (양수) : 위치를 변경하지 않음, 즉 o1이 o2보다 앞에 위치
// return -1 (음수) : 위치 변경, 즉 o1이 o2보다 뒤에 위치
// return 0 : return 1과 비슷하거나 같음, 위치 변경 않함

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

//        Comparator<Student3> comp = new

    }
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
