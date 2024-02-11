package pl.michalboguski.Controler;

import com.sun.tools.javac.Main;
import pl.michalboguski.Model.*;
import pl.michalboguski.Model.DuckImages;
import pl.michalboguski.View.Duck;
import pl.michalboguski.View.GamePanel;
import pl.michalboguski.View.PlayPanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        int duckPoints = DificulyLevel.level+5;
        while (duckPoints > 0){
            if ((duckPoints / 25) >= 1) {
                next.add(new Duck(DuckColors.GREY));
                duckPoints -= 5;


            }
        if ((duckPoints / 16) >= 1) {
            next.add(new Duck(DuckColors.BLUE));
            duckPoints -= 4;

        }
        if ((duckPoints / 15) >= 1) {
            next.add(new Duck(DuckColors.GREEN));
            duckPoints -= 3;

        }
        if ((duckPoints / 10) >= 1) {
            next.add(new Duck(DuckColors.RED));
            duckPoints -= 2;
        }
else {
            next.add(new Duck(DuckColors.YELLOW));
            duckPoints -= 1;

        duckPoints -= 1;
    }
        }
    }


    public void setPosition(Duck duck){
        Random r = new Random();
            int y = r.nextInt(500);
            int x = 0;
            if (!duck.getDirection()) {
                x = GamePanel.screenWidth + duck.getWidth() * (r.nextInt(2));
                duck.setIcon(DuckImages.yellowLeftUp);
            } else if (duck.getDirection()) {
                x = duck.getWidth() - ((r.nextInt(2)) * 75);
                duck.setIcon(DuckImages.yellowRightDown);
            }
            duck.setLocation(new Point(x, y));
            duck.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (e.getSource() == duck) {
                        duck.setHp(duck.getHp()-1);
                        if (duck.getHp() <= 0 ) {
                            duck.setVisible(false);
                            duck.setAlaive(false);
                            if (duck.getColor() == DuckColors.YELLOW) GameControler.points += duck.getSpeed();
                            if (duck.getColor() == DuckColors.RED) GameControler.points += duck.getSpeed() * 2;
                            if (duck.getColor() == DuckColors.GREEN) GameControler.points += duck.getSpeed()*3;
                            if (duck.getColor() == DuckColors.BLUE) GameControler.points += duck.getSpeed()*4;
                            if (duck.getColor() == DuckColors.GREY) GameControler.points += duck.getSpeed()*5;

                        }
                    }
                }
            });
    }

    public void checkColision(List<Duck> ducks){
        for (Duck duck : ducks) {
             if (((duck.isAlaive()) &&(((duck.getDirection() == true) && (duck.getX() > GameConstants.screenWigth)))) ||
            ((duck.isAlaive()) && (duck.getDirection() == false) && (duck.getX() < (0-duck.getWidth())))) {
                 duck.setFlyAway(true);
                 GameControler.lives--;
             }
    }
        ducks.removeIf(duck -> duck.isFlyAway() == true);
    }

    public void move() {

        for  (Duck duck : ducks) {
            if (ducks.isEmpty() ) break;

            if (duck.getDirection() == false)
                duck.setLocation(new Point(duck.getX() - Duck.speed, duck.getY()));

            if (duck.getDirection() == true)
                duck.setLocation(new Point(duck.getX() + Duck.speed, duck.getY()));

            animate(duck);

        }

    }

    public void animate(Duck duck) {
        new DuckImages();
        int tmp = GameConstants.counter;
        int w = 1000;
        boolean isUp = true;
        boolean isDown = false;

        if ((tmp > 0) && (tmp <  (w / 4))) {
            isUp = true;
            isDown = false;
        } else if ((tmp > (w / 2)) && (tmp < (w * 3 / 4))) {
            isDown = true;
            isUp = false;
        } else {
            isDown = false;
            isUp = false;
        }
//YELLOW
        if (duck.getColor() == DuckColors.YELLOW){
        if (duck.getDirection() == false) {
            if (isUp && !isDown)
                duck.setIcon(DuckImages.yellowLeftUp);
            if (isDown && !isUp)
                duck.setIcon(DuckImages.yellowLeftDown);
            if (!isDown && !isUp)
            duck.setIcon(DuckImages.yellowLeftCenter);
        }

            if (duck.getDirection() == true) {
                if (isUp && !isDown)
                    duck.setIcon(DuckImages.yellowRightUp);
                if (isDown && !isUp)
                    duck.setIcon(DuckImages.yellowRightDown);
                if (!isDown && !isUp)
                    duck.setIcon(DuckImages.yellowRightCenter);
            }

        } else
            //RED
        if (duck.getColor() == DuckColors.RED){
            if (duck.getDirection() == false) {
                if (isUp && !isDown)
                    duck.setIcon(DuckImages.redLeftUp);
                else if (isDown && !isUp) duck.setIcon(DuckImages.redLeftDown);
                else duck.setIcon(DuckImages.redLeftCenter);

                if (duck.getDirection() == true) {
                    if (isUp) duck.setIcon(DuckImages.redRightUp);
                    else if (isDown) duck.setIcon(DuckImages.redRightDown);
                    else duck.setIcon(DuckImages.redRightCenter);
                }
            }
        } else
            //GREEN
        if (duck.getColor() == DuckColors.GREEN){
            if (duck.getDirection() == false) {
                if (isUp && !isDown)
                    duck.setIcon(DuckImages.greenLeftUp);
                else if (isDown && !isUp) duck.setIcon(DuckImages.greenLeftDown);
                else duck.setIcon(DuckImages.greenLeftCenter);

                if (duck.getDirection() == true) {
                    if (isUp) duck.setIcon(DuckImages.greenRightUp);
                    else if (isDown) duck.setIcon(DuckImages.greenRightDown);
                    else duck.setIcon(DuckImages.greenRightCenter);
                }
            }
        } else
            //BLUE
        if (duck.getColor() == DuckColors.BLUE){
            if (duck.getDirection() == false) {
                if (isUp && !isDown)
                    duck.setIcon(DuckImages.blueLeftUp);
                else if (isDown && !isUp) duck.setIcon(DuckImages.blueLeftDown);
                else duck.setIcon(DuckImages.blueLeftCenter);

                if (duck.getDirection() == true) {
                    if (isUp) duck.setIcon(DuckImages.blueRightUp);
                    else if (isDown) duck.setIcon(DuckImages.blueRightDown);
                    else duck.setIcon(DuckImages.blueRightCenter);
                }
            }
        } else
            //GREY
        if (duck.getColor() == DuckColors.GREY){
            if (duck.getDirection() == false) {
                if (isUp && !isDown)
                    duck.setIcon(DuckImages.greyLeftUp);
                else if (isDown && !isUp) duck.setIcon(DuckImages.greyLeftDown);
                else duck.setIcon(DuckImages.greyLeftCenter);

                if (duck.getDirection() == true) {
                    if (isUp) duck.setIcon(DuckImages.greyRightUp);
                    else if (isDown) duck.setIcon(DuckImages.greyRightDown);
                    else duck.setIcon(DuckImages.greyRightCenter);
                }
            }
        }



    }
    ///NOWE


}
