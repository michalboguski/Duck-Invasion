package pl.michalboguski.View;

import pl.michalboguski.Controler.DuckControler;
import pl.michalboguski.Controler.GameControler;
import pl.michalboguski.Model.DificulyLevel;
import pl.michalboguski.Model.GameConstants;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

public class PlayPanel extends JPanel {

    BufferedImage backgroundImage;
    DuckControler DC = new DuckControler();
    DificulyLevel level = new DificulyLevel(1, GameConstants.Levels.EASY);

    public PlayPanel()  {
        super();
        setLayout(null);
        setVisible(true);
        GameControler gameControler = new GameControler(GameConstants.Levels.NORMAL);

        {
            try {
                backgroundImage = ImageIO.read(new File("sky.jpeg"));
            } catch (IOException e) {
                System.out.println("Błąd przy ładowaniu tła gry");
            }
        }


        Timer timer = new Timer(GameConstants.delay, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                GameConstants.counter += 40;
                if (GameConstants.counter >= 4000) {
                    GameConstants.counter = 0;
                    addDuck();
                    DC.createDucksByPoints();
                }

                addDuck();
                DC.move();
                DC.checkColision(DuckControler.ducks);
                UpPanel.updateUp();
                revalidate();
                repaint();
            }
        });
        timer.start();
    }
    public void addDuck(){
        for (Duck duck : DuckControler.next) {
            DuckControler.ducks.add(duck);
            add(duck);
            DC.setPosition(duck);
        }
        DuckControler.next.clear();
    }






            public void paintComponent(Graphics g){
        g.drawImage(backgroundImage,0,0,null);
    }

}
