package 이코테.구현.상하좌우;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String move_input = br.readLine();

        String[] moves = move_input.split(" ");

//        System.out.println(Arrays.toString(moves));

        Node node = new Node(1, 1);

        for (String move : moves) {

            int next_r = 0;
            int next_c = 0;

            if (move.equals("R")) {
                next_r = node.r;
                next_c = node.c + 1;
            } else if (move.equals("L")) {
                next_r = node.r;
                next_c = node.c - 1;
            } else if (move.equals("U")) {
                next_r = node.r - 1;
                next_c = node.c;
            } else if (move.equals("D")) {
                next_r = node.r + 1;
                next_c = node.c;
            }

            if (next_r < 1 || next_r > N || next_c < 1 || next_c > N) {
                continue;
            }

            node.r = next_r;
            node.c = next_c;

        }

        System.out.println(node.r + " " + node.c);

    }

}

class Node {
    int r;
    int c;

    Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}