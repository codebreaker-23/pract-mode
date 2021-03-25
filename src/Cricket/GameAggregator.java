package Cricket;

import Cricket.Dao.PlayerDao;
import Cricket.Dao.TeamDao;

import java.util.List;

public class GameAggregator implements Game{

    final private PlayerDao playerData;
    final private TeamDao teamData;

    private Team battingTeam;
    private Team bowlingTeam;

    private Player onStrike;
    private Player offStrike;
    private Player bowler;

    private Team winner;

    private int totalInningsOvers;
    private int totalBallsMade;


    public GameAggregator(PlayerDao pDao, TeamDao tDao){
        this.playerData = pDao;
        this.teamData = tDao;

        this.totalInningsOvers = 2;
        this.totalBallsMade = 0;
        this.winner = null;
    }

    @Override
    public void registerTeam(String tName, List<String> players) {
        //validate.
        Team t = new Team(tName, players);

        teamData.setTeamData(t);

        for(Player p : t.getPlayers())
            playerData.setPlayerData(p);
    }

    @Override
    public void initGame(int totalOvers, String battingTeam, String bowlingTeam) {
        try{
            this.battingTeam = teamData.getTeamData(battingTeam);
            this.bowlingTeam = teamData.getTeamData(bowlingTeam);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        totalInningsOvers = totalOvers;
        onStrike = playerData.getPlayerData(this.battingTeam.nextPlayer().getName());
        offStrike = playerData.getPlayerData(this.battingTeam.nextPlayer().getName());
    }

    @Override
    public void bowl(String hitRuns, String bowler) {
        switch (hitRuns){
            case "W" :
            break;

            case "Wd" :
            break;

            default:
                totalBallsMade++;

                int run = Integer.valueOf(hitRuns);
                onStrike.ballsPlayed++;
                onStrike.score+=run;

                if(run == 4)
                    onStrike.totalFours++;
                else if(run == 6)
                    onStrike.totalSix++;
                else if(run%2 != 0 || totalBallsMade%6 == 0){
                    Player t = onStrike;
                    onStrike = offStrike;
                    offStrike = t;
                }
            break;
        }
    }

    @Override
    public String getScoreCard() {
        StringBuilder sb = new StringBuilder();
        for(Player p : battingTeam.getPlayers()){
            sb.append(playerData.getPlayerData(p.getName()).toString("bat"));
        }

        return sb.toString();
    }

    @Override
    public String getResult() {
        return null;
    }
}
