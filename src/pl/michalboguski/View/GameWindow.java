package pl.michalboguski.View;

import pl.michalboguski.Controler.GameControler;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    public GameWindow()  {


        setDefaultCloseOperation(GameWindow.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setPreferredSize(new Dimension(GamePanel.screenWidth,GamePanel.screenHeight));

        add(new GamePanel());
        pack();
        setResizable(false);
        setVisible(true);


    }
}
