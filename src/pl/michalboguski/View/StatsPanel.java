package pl.michalboguski.View;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {
    public JLabel livesLabel;
    public JLabel timeLabel;
    public JLabel pointsLabel;


    public StatsPanel() {
        Dimension d = new Dimension(100, 40);
        setLayout(new FlowLayout());
        setBackground(Color.yellow);
        livesLabel = new JLabel("10");
        timeLabel = new JLabel("00:00");
        pointsLabel = new JLabel("0");

        livesLabel.setPreferredSize(d);
        timeLabel.setPreferredSize(d);
        pointsLabel.setPreferredSize(d);


        livesLabel.setOpaque(true);
        timeLabel.setOpaque(true);
        pointsLabel.setOpaque(true);

        add(livesLabel);
        add(timeLabel);
        add(pointsLabel);

    }

    public void setLives(int newLives) {
        livesLabel.setText(String.valueOf(newLives));
    }

    public void setTime(int minutes, int seconds) {
        timeLabel.setText(minutes + ":" + seconds);
    }

    public void setPoints(int newPoints) {
        pointsLabel.setText(String.valueOf(newPoints));
    }
}
