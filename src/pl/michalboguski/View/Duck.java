package pl.michalboguski.View;

import pl.michalboguski.Model.DuckAnimationSet;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import static pl.michalboguski.Model.GameConstants.*;

public class Duck extends JButton {
    public static int speed = 1;
    String direction;
    boolean flyAway;
    int hp;
    int valuePoints;
    boolean isAlaive;
    DuckAnimationSet animationSet;
    ImageIcon currentImage;
    int quee;


    public Duck(DuckColor color) {
        super();
        this.isAlaive = true;
        this.flyAway = false;
        this.direction = randomDirection();
        this.hp = initHP(color);
        this.valuePoints = this.hp * speed;
        this.animationSet = new DuckAnimationSet(color, direction);
        initDuck();
        this.quee = 0;
    }

    private void initDuck() {
        this.setVisible(true);
        this.setFocusable(false);
        this.setSize(79, 64);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        initLocation();
        this.currentImage = animationSet.center;
        addActionListenerToDuck(this);
        System.out.println("duck "+ getHp()+" HP");
    }

    private void addActionListenerToDuck(Duck duck){
        this.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == duck) {
                    hp--;
                    if (getHp() <= 0) {
                        setVisible(false);
                        setAlaive(false);
                    }
                }
            }
        });
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

    public void initLocation() {
        Random r = new Random();
        int y = r.nextInt(500);
        int x = -50;
        if ("Left".equals(getDirection())) {
            x = screenWidth +50;

        }
        setLocation(x - 50  + r.nextInt(100), y);
    }

    public int initHP(DuckColor c) {
        if (DuckColor.YELLOW.equals(c)) return 1;
        else if (DuckColor.RED.equals(c)) return 2;
        else if (DuckColor.GREEN.equals(c)) return 3;
        else if (DuckColor.BLUE.equals(c)) return 4;
        else return 5;
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


    public int getValuePoints() {
        return valuePoints;
    }

    public String getDirection() {
        return direction;
    }


    public void move() {
        if ("Right".equals(getDirection()))
            setLocation(getX() + Duck.speed, getY());
        else
            setLocation(getX() - Duck.speed, getY());
    }


    public void animate() {
        switch (quee) {
            case 0 -> {
                setIcon(animationSet.up);
                quee = 1;
            }
            case 1 -> {
                setIcon(animationSet.center);
                quee = 2;
            }
            case 2 -> {
                setIcon(animationSet.down);
                quee = 3;
            }
            case 3 -> {
                setIcon(animationSet.center);
                quee = 0;
            }
        }
    }
}
