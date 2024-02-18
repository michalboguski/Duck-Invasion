package pl.michalboguski.View;

import pl.michalboguski.Model.GameConstants;
import javax.swing.*;
import java.awt.*;

public class StartWindow extends JFrame {
    public StartWindow() {
        setPreferredSize(GameConstants.startSize);
        setDefaultCloseOperation(GameWindow.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new StartPanel());
        pack();

        setVisible(true);
        setResizable(false);
    }
}

