package pl.michalboguski.Controler;

import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.View.Duck;
import pl.michalboguski.View.DuckColor;
import pl.michalboguski.View.PlayPanel;
import pl.michalboguski.View.StatsPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GameControler implements Runnable {

    public Set<Duck> ducks = new HashSet<>();
    StatsPanel statPanel;
    PlayPanel playPanel;
    boolean gameOver;
    private int lives;
    private int minutes;
    private int seconds;
    private int points;


    public GameControler(GameConstants.Levels gameLevel, StatsPanel statPanel, PlayPanel playPanel) {
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
        Random r = new Random();
        int levelPoints = 5;
        final int FPS = 20;
        long sllepTime = 1000 / FPS;
        int tick = 1;

        while (!gameOver) {
            if (lives <= 0) {gameOver = true; break;}
            try {
                Thread.sleep(sllepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            checkDucks(ducks);
            ducks.forEach(Duck::move);
            if (r.nextInt(10)  > 8)
                ducks.forEach(Duck::animate);
            tick++;

            if (tick % FPS == 0) {
                seconds++;
                if (seconds % 5 == 0) {
                    createDucksByPoints(++levelPoints);
                }

                if (seconds % 60 == 0) {
                    minutes++;
                    seconds = 0;
                }
                updateTime();
            }
        }
        System.out.println("GAME OVER");
    }

    private void createDucksByPoints(int points) {
        System.out.println("punkty: "+ points);
        int duckPoints = points;
        while (duckPoints > 0) {
            Duck duck;
            if ((duckPoints / 5) >= 1) {
                duck = new Duck(DuckColor.GREY);
                duckPoints -= 5;
            }
            else if ((duckPoints / 4) >= 1) {
                duck = new Duck(DuckColor.BLUE);
                duckPoints -= 4;
            }
            else if ((duckPoints / 3) >= 1) {
                duck = new Duck(DuckColor.GREEN);
                duckPoints -= 3;
            }
            else if ((duckPoints / 2) >= 1) {
                duck = new Duck(DuckColor.RED);
                duckPoints -= 2;
            } else {
                duck = new Duck(DuckColor.YELLOW);
                duckPoints -= 1;
            }
            playPanel.add(duck);
            ducks.add(duck);
        }
    }


    private void checkDucks(Set<Duck> ducks) {
        for (Duck duck : ducks) {
            if (((duck.getX() > 1280) && ("Right".equals(duck.getDirection()))) ||
                    ((duck.getX() < -80)) && ("Left".equals(duck.getDirection()))) duck.setFlyAway(true);
            if (duck.isFlyAway()) updateLives();
            if (!duck.isAlaive()) updatePoints(duck.getValuePoints());
        }
        ducks.removeIf(d -> !d.isAlaive() || d.isFlyAway());
    }

    private void updateLives() {
        statPanel.setLives(--lives);
    }

    private void updatePoints(int p) {
        statPanel.setPoints(points += p);
    }

    private void updateTime() {
        seconds++;
        if (seconds >= 59) {
            seconds = 0;
            minutes++;
        }
        statPanel.setTime(minutes, seconds);
    }
}

