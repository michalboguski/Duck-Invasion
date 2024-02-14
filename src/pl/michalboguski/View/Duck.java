package pl.michalboguski.View;

import pl.michalboguski.Model.DuckAnimationSet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Duck extends JButton implements Runnable {
    public static int speed = 1;
    String direction;
    boolean flyAway;
    int hp;
    int voluePoints;
    boolean isAlaive;
    DuckAnimationSet animationSet;
    ImageIcon currentImage;
    int quee;


    public Duck(DuckColor color) {
        super();
        this.flyAway = false;
        this.direction = randomDirection();
        this.hp = initHP(color);
        this.voluePoints = this.hp * speed;
        this.animationSet = new DuckAnimationSet(color, direction);
        initDuck();
        this.quee = 0;

        new Thread(this).start();
        System.out.println("Duck Created");
    }

    public void initDuck() {
        this.setVisible(true);
        this.setFocusable(false);
        this.setSize(79, 64);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        initLocation();
        this.currentImage = animationSet.center;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == this) {
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
        int x = 0;
        if ("Left".equals(getDirection())) {
            x = GamePanel.screenWidth - 100;
        }
        setLocation(new Point(x, y));
    }

    public int initHP(DuckColor c) {
        if (DuckColor.YELLOW.equals(c)) return 1;
        if (DuckColor.RED.equals(c)) return 2;
        if (DuckColor.GREEN.equals(c)) return 3;
        if (DuckColor.BLUE.equals(c)) return 4;
        if (DuckColor.GREY.equals(c)) return 5;

        return 0;
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


    public String getDirection() {
        return direction;
    }

    public void move() {
        if ("Right".equals(getDirection()))
            setLocation(new Point(getX() - Duck.speed, getY()));
        else
            setLocation(new Point(getX() + Duck.speed, getY()));
    }


    @Override
    public void run() {
        Random r = new Random();
        int animateDeley;
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        int updates = 0;
        int frames = 0;
        long timer = System.currentTimeMillis();

        while (isAlaive) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                move();

                updates++;
                delta--;
            }

            frames++;
            animateDeley = r.nextInt(20) + 20;
            if (frames % animateDeley == 0) {
                animate();
            }

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println(updates + " Ticks, Fps " + frames);
                updates = 0;
                frames = 0;
            }

        }
    }

    private void animate() {
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
