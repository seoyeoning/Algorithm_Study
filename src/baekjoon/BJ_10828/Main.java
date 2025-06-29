package baekjoon.BJ_10828;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Stack<Integer> stack = new Stack<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch (str) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        bw.write(-1+"\n");
                    } else {
                        bw.write(stack.pop()+"\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size()+"\n");
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        bw.write(1+"\n");
                    } else {
                        bw.write(0+"\n");
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        bw.write(-1+"\n");
                    } else {
                        bw.write(stack.peek()+"\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();

    }

}
