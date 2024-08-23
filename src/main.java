public class main {

    public static void main(String[] args) {

        boolean answer_ac_equals;

        String a = "aa";
        String b = "bb";
        String c = "aa";

        answer_ac_equals = a.equals(a);

        System.out.println(answer_ac_equals);

        if (a==c) System.out.println("같다");
        else System.out.println("다르다");

    }
}
