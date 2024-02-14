package pl.michalboguski.Controler;

import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.View.Duck;
import pl.michalboguski.View.DuckColor;
import pl.michalboguski.View.PlayPanel;
import pl.michalboguski.View.UpPanel;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class GameControler implements Runnable, TimeLapseListener, PointsListener, LivesListener{

    private int lives;
    private int minutes;
    private int seconds;
    private int points;
    UpPanel statPanel;
    JPanel playPanel;
    public Set<Duck> ducks = new HashSet<>();
    boolean gameOver;



    public GameControler(GameConstants.Levels gameLevel, UpPanel statPanel, JPanel playPanel) {
        this.gameOver = false;
        if (gameLevel == GameConstants.Levels.EASY) Duck.speed = 3;
        if (gameLevel == GameConstants.Levels.NORMAL) Duck.speed = 5;
        if (gameLevel == GameConstants.Levels.HARD) Duck.speed = 7;
        this.statPanel = statPanel;
        this.playPanel = playPanel;
        this.lives = 10;
        this.minutes = 0;
        this.seconds = 0;
        this.points = 0;
        new Thread(this).start();
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double FPS = 60.0;
        double ns = 1000000000 / FPS;
        double delta = 0;
        int updates = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int levelPoints = 5;
        while (!gameOver) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                ///////////////////

               // checkDucks(ducks);

                ///////////////////
                updates++;
                delta--;
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                seconds++;
                if (seconds % 5 == 0) {
                    createDucksByPoints(++levelPoints);
                }
                timer += 1000;
            }
            if (seconds >= 60) {
                System.out.println(seconds);
                minutes++;
                seconds = 0;
            }

           // System.out.println(updates + " Ticks, Fps " + frames);
            updates = 0;
            frames = 0;
        }
    }

    public void createDucksByPoints(int duckPoints) {
        while (duckPoints > 0) {
            Duck duck = null;
            if ((duckPoints / 25) >= 1) {
                duck = new Duck(DuckColor.GREY);
                duckPoints -= 5;
            }
            if ((duckPoints / 16) >= 1) {
                duck = new Duck(DuckColor.BLUE);
                duckPoints -= 4;
            }
            if ((duckPoints / 15) >= 1) {
                duck = new Duck(DuckColor.GREEN);
                duckPoints -= 3;
            }
            if ((duckPoints / 10) >= 1) {
                duck = new Duck(DuckColor.RED);
                duckPoints -= 2;
            } else {
                duck = new Duck(DuckColor.YELLOW);
                duckPoints -= 1;
                duckPoints -= 1;
            }
            playPanel.add(duck);
        }
    }


    public void checkDucks(Set<Duck> ducks) {
        for (Duck duck : ducks) {
         //   if ((duck.getX() > 1200) || (duck.getX() < -80)) duck.setFlyAway(true);
         //   if (duck.isFlyAway()) ;
            if (!duck.isAlaive()) updateLives();
        }
        ducks.removeIf(d -> !d.isAlaive() || d.isFlyAway());

    }

    @Override
    public void updateLives() {
        statPanel.setLives(--lives);
    }

    @Override
    public void updatePoints() {
        statPanel.setPoints(++points);
    }

    @Override
    public void updateTime() {
        seconds++;
        if (seconds >= 59) {
            seconds = 0;
            minutes++;
        }
        statPanel.setTime(minutes,seconds);
    }
}

