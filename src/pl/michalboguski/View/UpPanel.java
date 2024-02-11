package pl.michalboguski.View;

import pl.michalboguski.Controler.GameControler;
import pl.michalboguski.Model.TimeLapse;

import javax.swing.*;
import java.awt.*;

public class UpPanel extends JPanel {
    public static JLabel lives;
    public static JLabel seconds;
    public static JLabel points;

    public UpPanel() {
        Dimension d = new Dimension(100, 40);
        setLayout(new FlowLayout());
        setBackground(Color.yellow);
        lives = new JLabel();
        seconds = new JLabel();
        points = new JLabel();
        lives.setPreferredSize(d);
        seconds.setPreferredSize(d);
        points.setPreferredSize(d);

        lives.setOpaque(true);
        seconds.setOpaque(true);
        points.setOpaque(true);

        add(lives);
        add(seconds);
        add(points);

        JLabel test = new JLabel("TEST");
        test.setOpaque(true);
        test.setSize(40, 40);
        add(test);
    }

    public static void updateUp() {
        if (GameControler.lives > 0) {
            lives.setText(String.valueOf(GameControler.lives));
            seconds.setText(String.valueOf(TimeLapse.seconds));
            points.setText(String.valueOf(GameControler.points));

        }
    }


}
