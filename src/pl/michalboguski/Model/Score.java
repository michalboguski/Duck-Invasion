package pl.michalboguski.Model;

public class Score {
    String playerName;
    int points = 0;


    public Score(String playerName, int points) {
        this.playerName = playerName;
        this.points = points;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
