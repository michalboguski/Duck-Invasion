package pl.michalboguski.Controler;

import pl.michalboguski.Model.DificulyLevel;
import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.Model.TimeLapse;
import pl.michalboguski.View.DownPanel;
import pl.michalboguski.View.Duck;
import pl.michalboguski.View.PlayPanel;
import pl.michalboguski.View.UpPanel;

public class GameControler implements Runnable{
    public int lives;
    public int points;
    boolean gameOver;


    public GameControler(GameConstants.Levels gameLevel) {
        if (gameLevel == GameConstants.Levels.EASY) Duck.speed = 3;
        if (gameLevel == GameConstants.Levels.NORMAL) Duck.speed = 5;
        if (gameLevel == GameConstants.Levels.HARD) Duck.speed = 7;


    }


    @Override
    public void run() {
        while (!gameOver) {


        }
    }
}
