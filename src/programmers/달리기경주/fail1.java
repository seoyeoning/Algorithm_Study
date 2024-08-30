package programmers.달리기경주;

import java.util.Arrays;

public class fail1 {

    public String[] solution(String[] players, String[] callings) {
        // String[] answer = {};

        System.out.println(Arrays.asList(players).indexOf("soe"));

        System.out.println(callings.length);

        int win_index = -1;
        String loser = "";

        for (int i=0; i < callings.length; i++) {

            win_index = Arrays.asList(players).indexOf(callings[i]);
            // System.out.println(call_index);

            loser = players[win_index-1];

            players[win_index] = loser;
            players[win_index-1] = callings[i];

        }

        return players;
    }

}
