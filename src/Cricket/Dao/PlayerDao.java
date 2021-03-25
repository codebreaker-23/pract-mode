package Cricket.Dao;

import Cricket.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerDao {
    final Map<String, Player> playerData;

    public PlayerDao(){
        playerData = new HashMap<>();
    }

    public Map<String, Player> getPlayerData() {
        return playerData;
    }

    public Player getPlayerData(String name){
        if (!playerData.containsKey(name))
            new Exception("Player not found");

        return playerData.get(name);
    }


    public void setPlayerData(Player p){
        playerData.put(p.getName(), p);
    }

}
