package pl.michalboguski.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static pl.michalboguski.Model.GameConstants.*;

public final class LevelPanel extends JPanel implements ActionListener {

    private final JButton easy;
    private final JButton normal;
    private final JButton hard;
    JButton back;

    public LevelPanel() {
        super();
        setSize(startSize);
        setBackground(Color.BLACK);
        setLayout(null);
        JLabel lLabel = new JLabel("Wybierz poziom trudności");
        this.easy = new JButton("EASY");
        this.normal = new JButton("NORMAL");
        this.hard = new JButton("HARD");
        this.back = new JButton("Back");

        easy.addActionListener(this);
        normal.addActionListener(this);
        hard.addActionListener(this);
        back.addActionListener(this);

        lLabel.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 50, buttonWidth, buttonHeight);
        easy.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 150, buttonWidth, buttonHeight);
        normal.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 300, buttonWidth, buttonHeight);
        hard.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 450, buttonWidth, buttonHeight);
        back.setBounds((screenWidth - 300) / 2 - buttonWidth / 2, 600, buttonWidth, buttonHeight);

        lLabel.setHorizontalTextPosition(SwingConstants.CENTER);

        add(lLabel);
        add(easy);
        add(normal);
        add(hard);
        add(back);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == easy) {
            new GameWindow(Levels.EASY);
        }
        if (e.getSource() == normal) {
            new GameWindow(Levels.NORMAL);
        }
        if  (e.getSource() == hard) {
            new GameWindow(Levels.HARD);
        }
        if (e.getSource() == back) {
            removeAll();
            add(new StartPanel());
            repaint();
            revalidate();
        }
    }
}
