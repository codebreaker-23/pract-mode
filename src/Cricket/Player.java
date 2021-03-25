package Cricket;

public class Player {
    String name;
    String teamName;

    /*batting stats*/
    int score;
    int totalFours;
    int totalSix;
    int ballsPlayed;

    /*bowling stats*/
    int ballsBowled;
    int runsConceded;
    int wicketsTaken;
    int maidens;
    int dotBalls;

    public Player(String name, String teamName){
        this.name = name;
        this.teamName = teamName;
    }

    public String getName() {
        return name;
    }

    public String toString(String statType) {
        switch (statType) {
            case "bat":
                return "Player{" +
                    "name='" + name +
                    ", score=" + score +
                    ", totalFours=" + totalFours +
                    ", totalSix=" + totalSix +
                    ", ballsPlayed=" + ballsPlayed +
                    '}' + "\n";
            case "bowl":
                return "Player{" +
                    "name='" + name + '\'' +
                    ", ballsBowled=" + ballsBowled +
                    ", runsConceded=" + runsConceded +
                    ", wicketsTaken=" + wicketsTaken +
                    ", maidens=" + maidens +
                    ", dotBalls=" + dotBalls+ "}" + "\n";
        }

        return "";
    }
}
