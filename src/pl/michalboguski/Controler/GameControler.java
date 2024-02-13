package pl.michalboguski.Controler;

import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.View.Duck;
import pl.michalboguski.View.DuckColor;

import java.util.HashSet;
import java.util.Set;

public class GameControler implements Runnable {
    public int lives;
    public int points;
    public Set<Duck> ducks = new HashSet<>();
    public int Points = 1;
    boolean gameOver;
    int minutes;
    int seconds;


    public GameControler(GameConstants.Levels gameLevel) {
        if (gameLevel == GameConstants.Levels.EASY) Duck.speed = 3;
        if (gameLevel == GameConstants.Levels.NORMAL) Duck.speed = 5;
        if (gameLevel == GameConstants.Levels.HARD) Duck.speed = 7;
        this.seconds = 0;
        this.minutes = 0;
    }


    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int levelPoints = 5;
        while (!gameOver) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                ///////////////////

                checkDucks(ducks);


                ///////////////////
                delta--;
            }
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                seconds++;
                if (seconds % 5 == 0) {
                    createDucksByPoints(++levelPoints);
                }
            }
            if (seconds >= 60) {
                minutes++;
                seconds = 0;
            }
            timer += 1000;
            System.out.println("FPS: " + frames);
            frames = 0;
        }
    }

    public void createDucksByPoints(int duckPoints) {
        while (duckPoints > 0) {
            if ((duckPoints / 25) >= 1) {
                ducks.add(new Duck(DuckColor.GREY));
                duckPoints -= 5;
            }
            if ((duckPoints / 16) >= 1) {
                ducks.add(new Duck(DuckColor.BLUE));
                duckPoints -= 4;
            }
            if ((duckPoints / 15) >= 1) {
                ducks.add(new Duck(DuckColor.GREEN));
                duckPoints -= 3;
            }
            if ((duckPoints / 10) >= 1) {
                ducks.add(new Duck(DuckColor.RED));
                duckPoints -= 2;
            } else {
                ducks.add(new Duck(DuckColor.YELLOW));
                duckPoints -= 1;
                duckPoints -= 1;
            }
        }
    }


    public void checkDucks(Set<Duck> ducks) {
        for (Duck duck : ducks) {
            if ((duck.getX() > 1200) || (duck.getX() < -80)) duck.setFlyAway(true);
            if ((!duck.isAlaive()) && (duck.isFlyAway())) lives--;
        }
        ducks.removeIf(d -> !d.isAlaive() || d.isFlyAway());

    }
}

