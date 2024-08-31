package programmers.달리기경주;
import java.util.*;

public class success {

    public String[] solution(String[] players, String[] callings) {

        Map<String,Integer> hm = new HashMap<String,Integer>();

        for (int i=0; i < players.length; i++) {

            hm.put(players[i],i);

        }

        Integer win_index = -1;
        String winner = "";
        String loser = "";

        for (int i=0; i < callings.length; i++) {

            winner = callings[i];

            win_index = hm.get(winner);

            loser = players[win_index-1];

            players[win_index] = loser;
            players[win_index-1] = winner;

            hm.replace(winner,win_index-1);
            hm.replace(loser,win_index);

        }

        return players;
    }

}
