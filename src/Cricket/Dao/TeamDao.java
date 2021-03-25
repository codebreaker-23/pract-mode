package Cricket.Dao;

import Cricket.Team;

import java.util.HashMap;
import java.util.Map;

public class TeamDao {
    final Map<String, Team> teamData;

    public TeamDao(){
        teamData = new HashMap<>();
    }

    public Team getTeamData(String tName) throws Exception {
        if(!teamData.containsKey(tName))
            throw new Exception("team not found");

        return teamData.get(tName);
    }

    public void setTeamData(Team t){
        teamData.put(t.gettName(), t);
    }
}
