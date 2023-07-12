package programmers.단어변환;

import java.util.*;

class success {

    static int result = 50;
    static int count = 0;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        // System.out.println(Arrays.toString(words));
        // System.out.println();

        int begin_size = begin.length();
        boolean[] visited = new boolean[words.length];

        for(int i=0; i < begin_size; i++) {
            System.out.println("시작!!!!!");
            dfs(i,begin,target,words,visited);
        }

        // String index_middle = begin.substring(0,1) + begin.substring(1+1);
        // System.out.println(index_middle);
        // for(int i=0; i < words.length; i++) {
        //     System.out.println(words[i].substring(0,1) + words[i].substring(1+1));
        // }

        if(result == 50) {
            return 0;
        } else {
            return result;
        }
    }

    static public void dfs(int index, String word, String target, String[] words, boolean[] visited) {
        System.out.println("dfs들어옴 == " + word);
        System.out.println("index: " + index);
        if(word.equals(target)) {
            System.out.println("타겟!");
            result = Math.min(result,count);
            System.out.println("****현재 result : " + result);
            //count--;
            // for(int i=0; i < visited.length; i++) {
            //     visited[i] = true;
            // }
            return;
        }

        if (index == 0) {
            String index_first = word.substring(1);
            System.out.println("index 첫번째 검사중인 substring : " + index_first);
            for(int i=0; i < words.length; i++) {
                System.out.println(words[i].substring(1));
                System.out.println("word는 : " + word);
                System.out.println("비교할 word는 : " + words[i]);
                if(words[i].substring(1).equals(index_first) && !visited[i]) {
                    System.out.println("지금 : " + words[i]);
                    count++;
                    System.out.println("count : " + count);
                    visited[i] = true;
                    for(int j=0; j < target.length(); j++) {
                        dfs(j,words[i],target,words,visited);
                        System.out.println("dfs 끝나고 다시 돌아옴 : " + words[i] );
                        System.out.println(count);
                        if(words[i].equals(target)) {
                            visited[i] = false;
                            count--;
                            return;
                        }
                    }
                    visited[i]=false;
                }
            }
        } else if (index == target.length()-1) {
            String index_last = word.substring(0,target.length()-1);
            System.out.println("index 마지막 검사중인 substring : " + index_last);
            for(int i=0; i < words.length; i++) {
                System.out.println(words[i].substring(0,target.length()-1));
                System.out.println("word는 : " + word);
                System.out.println("비교할 word는 : " + words[i]);
                if (words[i].substring(0,target.length()-1).equals(index_last) && !visited[i]) {
                    System.out.println("지금 : " + words[i]);
                    count++;
                    System.out.println("count : " + count);
                    visited[i] = true;
                    for(int j=0; j < target.length(); j++) {
                        dfs(j,words[i],target,words,visited);
                        System.out.println("dfs 끝나고 다시 돌아옴 : " + words[i] );
                        System.out.println(count);
                        if(words[i].equals(target)) {
                            visited[i] = false;
                            count--;
                            return;
                        }
                    }
                    visited[i]=false;
                }
            }
            count--;
            System.out.println("없어서 줄어드는 count : " + count);
        } else {
            String index_middle = word.substring(0,index) + word.substring(index+1);
            System.out.println("인덱스 중간 검사중인 substring : " + index_middle);
            for(int i=0; i < words.length; i++) {
                System.out.println((words[i].substring(0,index) + words[i].substring(index+1)));
                System.out.println("word는 : " + word);
                System.out.println("비교할 word는 : " + words[i]);
                if ((words[i].substring(0,index) + words[i].substring(index+1)).equals(index_middle) && !visited[i]) {
                    System.out.println("지금 : " + words[i]);
                    count++;
                    System.out.println("count : " + count);
                    visited[i] = true;
                    for(int j=0; j < target.length(); j++) {
                        dfs(j,words[i],target,words,visited);
                        System.out.println("dfs 끝나고 다시 돌아옴 : " + words[i] );
                        System.out.println(count);
                        if(words[i].equals(target)) {
                            visited[i] = false;
                            count--;
                            return;
                        }
                    }
                    visited[i]=false;
                }
            }
        }
        // count--;
        // System.out.println("없어서 줄어드는 count : " + count);
    }
}

