package 코테유형연습.정렬.기본;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[] arr = {2, 4, 3, 5, 1};
        Integer[] arr2 = {2, 4, 3, 5, 1};

        // 배열[] 정렬 - Arrays.sort()
        // 기본 오름차순 정렬
        Arrays.sort(arr);

        // 기본 내림치순 정렬
        // primitive 타입이 아닌 Wrapper 클래스 일 경우 arr 뒤에 추가로 Comparator를 인자로 전달하여 정렬 가능
        Arrays.sort(arr2, Collections.reverseOrder());

        // List 정렬 - Collections.sort()
        List<Integer> list = Arrays.asList(arr2); // Wrapper 클래스 배열일 경우만 변환 가능
        // 오름차순
        Collections.sort(list); // 정렬만 하고 void 반환
        list.sort(Comparator.naturalOrder());
        // 내림차순
        Collections.sort(list, Collections.reverseOrder());
        list.sort(Comparator.reverseOrder());

        // 객체와 다중 조건 정렬
        Member m1 = new Member("a", 10);
        Member m2 = new Member("bb",2);
        Member m3 = new Member("a", 3);
        Member m4 = new Member("ccc", 7);

        // 이름 오름차순, 이름 같으면 나이 내림차순 -> m1, m3, m2
        // 이름 오름차순, 이름 같으면 나이 오름차순 -> m3, m1, m2
        // 나이 오름차순 -> m2, m3, m4, m1
        // 나이 내림차순 -> m1, m4, m3, m2

        List<Member> memberList = new ArrayList<>();
        memberList.add(m1);
        memberList.add(m2);
        memberList.add(m3);
        memberList.add(m4);

        // 비교: 음수(-1) -> 오름차순 (1,2,3일 때 1-2 = -1),  양수(1) -> 내림차순 (3,2,1일 때 3-2 = 1), 0 -> 같음 (1,1일 때 1-1=0)
        // comparator 과 comparable
        // Comparator - compare
            // 기본형 - 오름차순
        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return m1.age - m2.age;
            }
        });
        Collections.sort(memberList, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return Integer.compare(o1.age, o2.age);
            }
        });
            // 기본형 - 내림차순
        memberList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return m2.age - m1.age;
            }
        });
            // 기본형 - 다중 조건 (이름 오름차순-이름 같으면 나이 내림차순)
        memberList.sort(new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                if (o1.name.equals(o2.name)) {
                    return Integer.compare(o2.age, o1.age);
                }
                return o1.name.compareTo(o2.name);
            }
        });

            // 람다 - 오름차순
        memberList.sort(((o1, o2) -> o1.age - o2.age));
        memberList.sort(Comparator.comparingInt(o -> o.age));
        memberList.sort(Comparator.comparingInt(Member::getAge));
            // 람다 - 내림차순
        memberList.sort((o1, o2) -> o2.age - o1.age);
        // memberList.sort(Comparator.comparing(o -> o.age).reversed()); -> 안됨
        memberList.sort(Comparator.comparingInt(Member::getAge).reversed());
            // 람다 - 다중 정렬
        memberList.sort((o1, o2) -> {
            if (o1.name.equals(o2.name)) {
                return Integer.compare(o2.age, o1.age);
            }
            return o1.name.compareTo(o2.name);
        });
            // 람다 - name 길이순 정렬
        memberList.sort(((o1, o2) -> Integer.compare(o1.name.length(), o2.name.length())));
        memberList.sort(Comparator.comparingInt(o -> o.name.length()));

        // 스트림 comparingInt, thenComparing 등 사용
            // Comparator를 사용하면 메서드 체이닝을 통해 다중 조건을 쉽게 설정할 수 있습니다.
        memberList.sort(Comparator
                .comparing(Member::getName).reversed()
                .thenComparingInt(o -> o.age));
//        for (Member member : memberList) {
//            System.out.println(member.name + ": " + member.age);
//        }

            // 원시 자료형 배열 (int[], double[] 등) 정렬
            // 오름차순
        int[] resultArrASC = Arrays.stream(arr)
                .map(i -> i * 2)
                .sorted()
                .toArray();
        System.out.println(Arrays.toString(resultArrASC));
            // 내림차순
        Integer[] resultArrDESC = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);

        // Comparable - compareTo
        Member2 M1 = new Member2("a", 10);
        Member2 M2 = new Member2("bb",2);
        Member2 M3 = new Member2("a", 3);
        Member2 M4 = new Member2("ccc", 7);

        // 이름 오름차순, 이름 같으면 나이 내림차순 -> m1, m3, m2
        // 이름 오름차순, 이름 같으면 나이 오름차순 -> m3, m1, m2
        // 나이 오름차순 -> m2, m3, m4, m1
        // 나이 내림차순 -> m1, m4, m3, m2

        List<Member2> memberList2 = new ArrayList<>();
        memberList2.add(M1);
        memberList2.add(M2);
        memberList2.add(M3);
        memberList2.add(M4);

        Collections.sort(memberList2);
        for (Member2 member : memberList2) {
            System.out.println(member.name + ": " + member.age);
        }

    }

}

class Member {
    String name;
    int age;

    Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

    int getAge() {
        return age;
    }

    public String getName() {
        return name;
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
        if (o.name.equals(this.name)) {
            return Integer.compare(this.age, o.age); // 이름 같으면 나이 오름차순
        }
        return o.name.compareTo(this.name); // 이름 내림차순
    }
}


