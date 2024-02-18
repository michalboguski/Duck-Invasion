package pl.michalboguski.View;

import pl.michalboguski.Controler.GameControler;
import pl.michalboguski.Model.GameConstants;
import javax.swing.*;

public class GameWindow extends JFrame {
       public GameWindow(GameConstants.Levels level) {

        setDefaultCloseOperation(GameWindow.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setPreferredSize(GameConstants.gameSize);
        GamePanel gamePanel = new GamePanel();

        new GameControler(level,gamePanel.getTopPanel() , gamePanel.getPlayPanel());



        add(new GamePanel());
        pack();
        setResizable(false);
        setVisible(true);


    }
}
