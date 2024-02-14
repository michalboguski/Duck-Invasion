package pl.michalboguski.View;

import pl.michalboguski.Controler.GameControler;
import pl.michalboguski.Model.DificulyLevel;
import pl.michalboguski.Model.GameConstants;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayPanel extends JPanel {

    BufferedImage backgroundImage;
    DificulyLevel level = new DificulyLevel(GameConstants.Levels.EASY);

    public PlayPanel() {
        super();
        setLayout(null);
        setVisible(true);

        try {
            backgroundImage = ImageIO.read(new File("sky.jpeg"));
        } catch (IOException e) {
            System.out.println("Błąd przy ładowaniu tła gry");
        }
    }

    public void paintComponent(Graphics g) {
        g.drawImage(backgroundImage, 0, 0, null);
    }

}
