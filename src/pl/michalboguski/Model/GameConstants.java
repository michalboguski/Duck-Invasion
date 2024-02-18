package pl.michalboguski.Model;

import java.awt.*;

public class GameConstants {
    public static final int screenWidth = 1280;
    public static final int screenHeight = 720;
    public static final int buttonWidth = 200;
    public static final int buttonHeight = 60;

    public static final Dimension gameSize = new Dimension(screenWidth,screenHeight);
    public static final Dimension startSize = new Dimension(screenWidth -300,screenHeight);
    public enum Levels {
        EASY,
        NORMAL,
        HARD
    }

}
