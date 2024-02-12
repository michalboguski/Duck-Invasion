package pl.michalboguski.Model;

import pl.michalboguski.View.DuckColor;
import javax.swing.*;

public class DuckAnimationSet {
    public ImageIcon up;
    public ImageIcon center;
    public ImageIcon down;

    public DuckAnimationSet(DuckColor color, String direction) {
        switch (color) {
            case GREY -> {
                if ("Right".equals(direction)) {
                    up = new ImageIcon("ducks/grey/right_up.png");
                    center = new ImageIcon("ducks/grey/right_center.png");
                    down = new ImageIcon("ducks/grey/right_down.png");
                } else {
                    up = new ImageIcon("ducks/grey/left_up.png");
                    center = new ImageIcon("ducks/grey/left_center.png");
                    down = new ImageIcon("ducks/grey/left_down.png");
                }
            }
            case BLUE -> {
                if ("Right".equals(direction)) {
                    up = new ImageIcon("ducks/blue/right_up.png");
                    center = new ImageIcon("ducks/blue/right_center.png");
                    down = new ImageIcon("ducks/blue/right_down.png");
                } else {
                    up = new ImageIcon("ducks/blue/left_up.png");
                    center = new ImageIcon("ducks/blue/left_center.png");
                    down = new ImageIcon("ducks/blue/left_down.png");
                }
            }
            case GREEN -> {
                if ("Right".equals(direction)) {
                    up = new ImageIcon("ducks/green/right_up.png");
                    center = new ImageIcon("ducks/green/right_center.png");
                    down = new ImageIcon("ducks/green/right_down.png");
                } else {
                    up = new ImageIcon("ducks/green/left_up.png");
                    center = new ImageIcon("ducks/green/left_center.png");
                    down = new ImageIcon("ducks/green/left_down.png");
                }
            }
            case YELLOW -> {
                if ("Right".equals(direction)) {
                    up = new ImageIcon("ducks/yellow/right_up.png");
                    center = new ImageIcon("ducks/yellow/right_center.png");
                    down = new ImageIcon("ducks/yellow/right_down.png");
                } else {
                    up = new ImageIcon("ducks/yellow/left_up.png");
                    center = new ImageIcon("ducks/yellow/left_center.png");
                    down = new ImageIcon("ducks/yellow/left_down.png");
                }
            }
            case RED -> {
                if ("Right".equals(direction)) {
                    up = new ImageIcon("ducks/brown/right_up.png");
                    center = new ImageIcon("ducks/brown/right_center.png");
                    down = new ImageIcon("ducks/brown/right_down.png");
                } else {
                    up = new ImageIcon("ducks/brown/left_up.png");
                    center = new ImageIcon("ducks/brown/left_center.png");
                    down = new ImageIcon("ducks/brown/left_down.png");
                }
            }
        }
    }
}
