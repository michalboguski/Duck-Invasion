package pl.michalboguski.View;

import pl.michalboguski.Controler.GameControler;
import pl.michalboguski.Model.DuckImages;
import pl.michalboguski.Model.GameConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Duck extends JButton implements Runnable {
    public static int speed = 1;
    String direction;
    boolean flyAway = false;
    DuckColor color;
    int hp;
    boolean isAlaive;


    public Duck(DuckColor color) {
        super();
        this.setFocusable(false);
        this.setSize(79, 64);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);

        this.direction = randomDirection();
        initColor(color);
        initLocation();
    }

    public enum DuckColor {
        GREY, BLUE, GREEN, YELLOW, RED
    }

    public boolean isAlaive() {
        return isAlaive;
    }

    public void setAlaive(boolean alaive) {
        isAlaive = alaive;
    }

    public String randomDirection() {
        Random r = new Random();
        return r.nextBoolean() ? "Right" : "Left";
    }

    public void initLocation(){
        Random r = new Random();
        int y = r.nextInt(500);
        int x = 0;
        if ("Left".equals(getDirection())) {
            x = GamePanel.screenWidth - 100;
            setIcon(DuckImages.yellowLeftUp);
        } else if ("Right".equals(getDirection())) {
            setIcon(DuckImages.yellowRightDown);
        }
        setLocation(new Point(x, y));
    }

    public void initColor(DuckColor c){
        if (DuckColor.YELLOW.equals(c)) this.hp = 1;
        if (DuckColor.RED.equals(c)) this.hp = 2;
        if (DuckColor.GREEN.equals(c)) this.hp = 3;
        if (DuckColor.BLUE.equals(c)) this.hp = 4;
        if (DuckColor.GREY.equals(c)) this.hp = 5;
    }

    public boolean isFlyAway() {
        return flyAway;
    }

    public void setFlyAway(boolean flyAway) {
        this.flyAway = flyAway;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        Duck.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public DuckColor getColor() {
        return color;
    }

    public void setColor(DuckColor color) {
        this.color = color;
    }

    public void setPosition(Duck duck) {
        Random r = new Random();
        int y = r.nextInt(500);
        int x = 0;
        if ("True".equals(duck.getDirection())) {
            x = GamePanel.screenWidth + duck.getWidth() * (r.nextInt(2));
            duck.setIcon(DuckImages.yellowLeftUp);
        } else {
            x = duck.getWidth() - ((r.nextInt(2)) * 75);
            duck.setIcon(DuckImages.yellowRightDown);
        }
        duck.setLocation(new Point(x, y));
        duck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == duck) {
                    duck.setHp(duck.getHp() - 1);
                    if (duck.getHp() <= 0) {
                        duck.setVisible(false);
                        duck.setAlaive(false);
                        if (duck.getColor() == Duck.DuckColor.YELLOW) GameControler.points += duck.getSpeed();
                        if (duck.getColor() == Duck.DuckColor.RED) GameControler.points += duck.getSpeed() * 2;
                        if (duck.getColor() == Duck.DuckColor.GREEN) GameControler.points += duck.getSpeed() * 3;
                        if (duck.getColor() == Duck.DuckColor.BLUE) GameControler.points += duck.getSpeed() * 4;
                        if (duck.getColor() == Duck.DuckColor.GREY) GameControler.points += duck.getSpeed() * 5;

                    }
                }
            }
        });
    }

    public void move() {

        for (Duck duck : ducks) {
            if (ducks.isEmpty()) break;

            if ("Left".equals(duck.getDirection()))
                duck.setLocation(new Point(duck.getX() - Duck.speed, duck.getY()));
            else
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

        if ((tmp > 0) && (tmp < (w / 4))) {
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
        if (duck.getColor() == DuckColor.YELLOW) {
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
            if (duck.getColor() == DuckColor.RED) {
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
                if (duck.getColor() == DuckColor.GREEN) {
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
                    if (duck.getColor() == DuckColor.BLUE) {
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
                        if (duck.getColor() == DuckColor.GREY) {
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

    @Override
    public void run() {
        //todo instead of DuckController
    }
}
