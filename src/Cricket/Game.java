package Cricket;

import java.util.List;

public interface Game {
    void registerTeam(String tName, List<String> players);
    void initGame(int totalOvers, String battingTeam, String bowlingTeam);
    void bowl(String hitRuns, String bowler);
    String getScoreCard();
    String getResult();
}
