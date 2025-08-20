package programmers.kakao._2023_KAKAO_BLIND_RECRUITMENT.미로탈출명령어;

import java.util.*;

class Solution {

    // 사전순 d l u r
    int[] dr = {1,0,-1,0};
    int[] dc = {0,-1,0,1};
    String[] dir = {"d","l","u","r"};
    int n;
    int m;
    int r;
    int c;
    List<String> results;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {


        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;

        // (x,y)->(r,c)
        // 거리: k
        // 중복 방문 가능
        // l-왼쪽, r-오른쪽, u-위, d-아래
        // 탈출 못 하면 impossible

        String[] list = new String[k];

        int minDist = Math.abs(x-r) + Math.abs(y-c);

        if (minDist > k)

            check(list,0, x, y);


        // result 계산 로직
        Collections.sort(results);
        return results.get(0);

        // for(String str : results){
        //     System.out.println(str);
        // }

    }

    void check(String[] list, int depth, int nowR, int nowC) {
        if (depth == list.length) { // 거리가 k로 도착지 도착
            if(nowR == r && nowC == c) {
                String result = "";
                for(int j=0; j<list.length; j++) {
                    result += list[j];
                }
                results.add(result);
            }
            return;
        }

        for(int i=0; i<4; i++) {
            int nextR = nowR + dr[i];
            int nextC = nowC + dc[i];

            if (nextR < 1 || nextR > n || nextC < 1 || nextC > m) continue; // 격자 바깥

            if(i==0) {
                list[depth] = "u";
            } else if (i==1) {
                list[depth] = "r";
            } else if (i==2) {
                list[depth] = "d";
            } else if (i==3) {
                list[depth] = "l";
            }

            check(list,depth+1,nextR,nextC);
        }

    }
}
