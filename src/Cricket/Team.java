package Cricket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Team {
    String tName;
    List<Player> players;
    Iterator pIterator;
    int totalScore;

    Extras battingExtras;
    Extras bowlingExtras;

    public Team(String tName, List<String> pNames) {
        this.tName = tName;
        this.players = new ArrayList<>();

        for(String p : pNames){
            Player player = new Player(p, tName);
            players.add(player);
        }

        pIterator = players.iterator();
    }

    public String gettName() {
        return tName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Player nextPlayer() {
        if(pIterator.hasNext())
            return (Player) pIterator.next();
        return null;
    }
}
