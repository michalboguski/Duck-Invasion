package pl.michalboguski.Controler;

import pl.michalboguski.Model.DificulyLevel;
import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.Model.TimeLapse;
import pl.michalboguski.View.DownPanel;
import pl.michalboguski.View.Duck;
import pl.michalboguski.View.PlayPanel;
import pl.michalboguski.View.UpPanel;

public class GameControler {
    public static int lives = 10;
    public static int points = 0;
    PlayPanel playPanel;
    UpPanel up;
    DownPanel dp;
    DuckControler dc;
    TimeLapse tl;
    DificulyLevel dl;


    public GameControler(GameConstants.Levels gameLevel) {
        new DificulyLevel(5, gameLevel);

        if (gameLevel == GameConstants.Levels.EASY) Duck.speed = 3;
        if (gameLevel == GameConstants.Levels.NORMAL) Duck.speed = 5;
        if (gameLevel == GameConstants.Levels.HARD) Duck.speed = 7;


    }

    public void play() {


    }


}
