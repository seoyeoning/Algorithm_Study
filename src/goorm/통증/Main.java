package goorm.통증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;

        result += N/14;

        result += (N%14)/7;

        result += ((N%14)%7);

        System.out.println(result);

    }

}
