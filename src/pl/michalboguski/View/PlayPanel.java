package pl.michalboguski.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PlayPanel extends JPanel {
    BufferedImage backgroundImage;

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
