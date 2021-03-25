package Cricket;

import Cricket.Dao.PlayerDao;
import Cricket.Dao.TeamDao;

import java.util.Arrays;
import java.util.Map;

public class Driver {

    public static void main(String[] args) {
        PlayerDao playerDao = new PlayerDao();
        TeamDao teamDao = new TeamDao();
        Game g = new GameAggregator(playerDao, teamDao);

        g.registerTeam("t1", Arrays.asList("a", "b", "c"));
        g.registerTeam("t2", Arrays.asList("x", "y", "z"));
        g.initGame(2, "t1", "t2");

        g.bowl("2", "x");
//        System.out.println(g.getScoreCard());

        g.bowl("1", "x");
        g.bowl("4", "x");
//        System.out.println(g.getScoreCard());

        for(Map.Entry<String, Player> e : playerDao.getPlayerData().entrySet())
                System.out.println(e.getValue().toString("bat"));
    }
}
