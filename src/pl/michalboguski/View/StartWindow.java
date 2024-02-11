package pl.michalboguski.View;

import pl.michalboguski.Model.GameConstants;

import javax.swing.*;
import java.awt.*;


public class StartWindow extends JFrame {

    public StartWindow() {
        setPreferredSize(new Dimension(GameConstants.screenWigth - 300, GameConstants.screenHeight));
        setDefaultCloseOperation(GameWindow.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        add(new StartPanel());
        pack();

        setVisible(true);
        setResizable(false);
    }


}

