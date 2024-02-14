package pl.michalboguski.View;

import javax.swing.*;
import java.awt.*;

public class UpPanel extends JPanel {
    public JLabel livesLabel;
    public JLabel timeLabel;
    public JLabel pointsLabel;


    public UpPanel() {
        Dimension d = new Dimension(100, 40);
        setLayout(new FlowLayout());
        setBackground(Color.yellow);
        livesLabel = new JLabel();
        timeLabel = new JLabel();
        pointsLabel = new JLabel();
        livesLabel.setPreferredSize(d);
        timeLabel.setPreferredSize(d);
        pointsLabel.setPreferredSize(d);

        livesLabel.setOpaque(true);
        timeLabel.setOpaque(true);
        pointsLabel.setOpaque(true);

        add(livesLabel);
        add(timeLabel);
        add(pointsLabel);

        JLabel test = new JLabel("TEST");
        test.setOpaque(true);
        test.setSize(40, 40);
        add(test);
    }

    public void setLives(int newLives) {
        livesLabel.setText(String.valueOf(newLives));
    }

    public void setTime(int minutes, int seconds){
        timeLabel.setText(minutes+":"+seconds);
    }

    public void setPoints(int newPoints){
        pointsLabel.setText(String.valueOf(newPoints));
    }
}
