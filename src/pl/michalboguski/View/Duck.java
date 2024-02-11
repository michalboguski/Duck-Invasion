package pl.michalboguski.View;

import pl.michalboguski.Model.DuckColors;
import pl.michalboguski.Model.DuckImages;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;
import java.util.Random;

public class Duck extends JButton {
boolean rightDirection;
boolean flyAway = false;
DuckColors color;
public static int speed = 1;
int hp;
boolean isAlaive = true;
Random r = new Random();
    public Duck(DuckColors color){
        this.color = color;
        this.rightDirection = randomDirection();
        this.setFocusable(false);
        this.setSize(79,64);
        this.setOpaque(false);
        this.setContentAreaFilled(false);
        this.setBorderPainted(false);
        if (color == DuckColors.YELLOW) hp = 1;
        if (color == DuckColors.RED) hp = 2;
        if (color == DuckColors.GREEN) hp = 3;
        if (color == DuckColors.BLUE) hp = 4;
        if (color == DuckColors.GREY) hp = 5;

        int y = r.nextInt(500);
        int x = 0;
        if (!getDirection()) {
            x = GamePanel.screenWidth - 100 ;//+ duck.getWidth() * r.nextInt(3);
            setIcon(DuckImages.yellowLeftUp);
        } else if (getDirection()) {
            x = getWidth();// - (r.nextInt(3) * 75);
            setIcon(DuckImages.yellowRightDown);
        }
        setLocation(new Point(x, y));
    }

    public boolean isAlaive() {
        return isAlaive;
    }

    public void setAlaive(boolean alaive) {
        isAlaive = alaive;
    }

    public boolean randomDirection(){
        return r.nextBoolean();
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
        this.speed = speed;
    }

    public boolean getDirection() {
        return rightDirection;
    }

    public void setDirection(boolean direction) {
        this.rightDirection = direction;
    }

    public DuckColors getColor() {
        return color;
    }

    public void setColor(DuckColors color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Duck)) return false;
        Duck duck = (Duck) o;
        return rightDirection == duck.rightDirection && getColor() == duck.getColor();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDirection());
    }
}
