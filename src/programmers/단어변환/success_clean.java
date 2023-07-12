package programmers.단어변환;

import java.util.*;

class success_clean {

    static int result = 50;
    static int count = 0;

    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        int begin_size = begin.length();
        boolean[] visited = new boolean[words.length];

        for(int i=0; i < begin_size; i++) {
            dfs(i,begin,target,words,visited);
        }

        if(result == 50) {
            return 0;
        } else {
            return result;
        }
    }
    // dfs(0, "hit", "cog",words, visited)
    static public void dfs(int index, String word, String target, String[] words, boolean[] visited) {
        if(word.equals(target)) {
            result = Math.min(result,count);
            return;
        }

        if (index == 0) {
            String index_first = word.substring(1);
            for(int i=0; i < words.length; i++) {
                if(words[i].substring(1).equals(index_first) && !visited[i]) {
                    count++;
                    visited[i] = true;
                    for(int j=0; j < target.length(); j++) {
                        dfs(j,words[i],target,words,visited);
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
            for(int i=0; i < words.length; i++) {
                if (words[i].substring(0,target.length()-1).equals(index_last) && !visited[i]) {
                    count++;
                    visited[i] = true;
                    for(int j=0; j < target.length(); j++) {
                        dfs(j,words[i],target,words,visited);
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
        } else {
            String index_middle = word.substring(0,index) + word.substring(index+1);
            for(int i=0; i < words.length; i++) {
                if ((words[i].substring(0,index) + words[i].substring(index+1)).equals(index_middle) && !visited[i]) {
                    count++;
                    visited[i] = true;
                    for(int j=0; j < target.length(); j++) {
                        dfs(j,words[i],target,words,visited);
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
    }
}


