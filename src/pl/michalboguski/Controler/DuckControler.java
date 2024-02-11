package pl.michalboguski.Controler;

import pl.michalboguski.Model.DificulyLevel;
import pl.michalboguski.Model.GameConstants;
import pl.michalboguski.View.Duck;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DuckControler {
    public static java.util.List<Duck> ducks = new ArrayList<Duck>();
    public static java.util.List<Duck> next = new ArrayList<Duck>();
    public static int Points = 1;
    Random r = new Random();

    public DuckControler() {
    }

    public void createDucksByPoints() {
        int duckPoints = DificulyLevel.level + 5;
        while (duckPoints > 0) {
            if ((duckPoints / 25) >= 1) {
                next.add(new Duck(Duck.DuckColor.GREY));
                duckPoints -= 5;
            }
            if ((duckPoints / 16) >= 1) {
                next.add(new Duck(Duck.DuckColor.BLUE));
                duckPoints -= 4;
            }
            if ((duckPoints / 15) >= 1) {
                next.add(new Duck(Duck.DuckColor.GREEN));
                duckPoints -= 3;
            }
            if ((duckPoints / 10) >= 1) {
                next.add(new Duck(Duck.DuckColor.RED));
                duckPoints -= 2;
            } else {
                next.add(new Duck(Duck.DuckColor.YELLOW));
                duckPoints -= 1;
                duckPoints -= 1;
            }
        }
    }




    public void checkColision(List<Duck> ducks) {
        for (Duck duck : ducks) {
            if (((duck.isAlaive()) && (("Right".equals(duck.getDirection())) && (duck.getX() > GameConstants.screenWigth))) ||
                    ((duck.isAlaive()) && (("Left".equals(duck.getDirection())) && (duck.getX() < (0 - duck.getWidth()))))) {
                duck.setFlyAway(true);
                GameControler.lives--;
            }
        }
        ducks.removeIf(duck -> duck.isFlyAway());
    }





}
