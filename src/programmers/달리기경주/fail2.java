package programmers.달리기경주;
import java.util.*;

public class fail2 {

    public String[] solution(String[] players, String[] callings) {

        Map<String,Integer> hm = new HashMap<String,Integer>();

        for (int i=0; i < players.length; i++) {

            hm.put(players[i],i);

        }

        Integer win_index = -1;
        String winner = "";

        for (int i=0; i < callings.length; i++) {

            winner = callings[i];

            win_index = hm.get(winner);

            players[win_index] = players[win_index-1];
            players[win_index-1] = winner;

        }

        return players;
    }

}
