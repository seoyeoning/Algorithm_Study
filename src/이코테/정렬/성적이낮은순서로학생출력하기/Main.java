package 이코테.정렬.성적이낮은순서로학생출력하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        List<Student> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = String.valueOf(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            list.add(new Student(name, score));
        }

        Collections.sort(list);

        for (Student student : list) {
            System.out.print(student.name + " ");
        }


    }

}

class Student implements Comparable<Student> {

    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }
}

